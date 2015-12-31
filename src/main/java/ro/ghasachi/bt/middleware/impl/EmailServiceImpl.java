package ro.ghasachi.bt.middleware.impl;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ghasachi.bt.middleware.EmailService;
import ro.ghasachi.bt.persistence.tables.daos.VerificationtokenDao;
import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.persistence.tables.records.VerificationtokenRecord;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import static ro.ghasachi.bt.persistence.tables.Verificationtoken.VERIFICATIONTOKEN;

/**
 * Created by d-uu31cq on 31/12/2015.
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    private VerificationtokenDao verificationtokenDao;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendRegistrationEmail(User user, String appUrl) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24);

        DSLContext jooq = DSL.using(verificationtokenDao.configuration());
        VerificationtokenRecord token = jooq.insertInto(VERIFICATIONTOKEN, VERIFICATIONTOKEN.VERIFIED, VERIFICATIONTOKEN.EXPIREDATE, VERIFICATIONTOKEN.USERID, VERIFICATIONTOKEN.TOKEN)
                .values((byte) 0, new Timestamp(calendar.getTimeInMillis()), user.getId(), UUID.randomUUID().toString())
                .returning(VERIFICATIONTOKEN.TOKEN, VERIFICATIONTOKEN.EXPIREDATE)
                .fetchOne();


        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = appUrl + "/regitrationConfirm.html?token=" + token.getToken();

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText("Use this link to confirm you account: \nhttp://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
