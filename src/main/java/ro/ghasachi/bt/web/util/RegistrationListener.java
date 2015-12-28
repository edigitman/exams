package ro.ghasachi.bt.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;

public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
//    @Autowired
//    private IVerificationTokenService service;
    @Autowired
    private MessageSource messages;
    
    //@Autowired
    //private JavaMailSender mailSender;
 
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
 
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
//        User user = event.getUser();
//        String token = UUID.randomUUID().toString();
//        service.createVerificationToken(user, token);
//         
//        String recipientAddress = user.getEmail();
//        String subject = "Registration Confirmation";
//        String confirmationUrl = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
//        String message = messages.getMessage("message.regSucc", null, event.getLocale());
        
        // TODO implement email service
//        SimpleMailMessage email = new SimpleMailMessage();
//        email.setTo(recipientAddress);
//        email.setSubject(subject);
//        email.setText(message + " rn" + "http://localhost:8080" + confirmationUrl);
//        mailSender.send(email);
    }


}
