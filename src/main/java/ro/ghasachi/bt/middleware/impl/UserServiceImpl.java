package ro.ghasachi.bt.middleware.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.middleware.UserService;
import ro.ghasachi.bt.persistence.tables.daos.UserDao;
import ro.ghasachi.bt.persistence.tables.daos.VerificationtokenDao;
import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken;
import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private VerificationtokenDao verificationtokenDao;

    @Override
    @Transactional
    public void createPassword(UserVO userVO) {

        List<Verificationtoken> verificationTokens = verificationtokenDao.fetchByToken(userVO.getToken());
        if (verificationTokens == null || verificationTokens.isEmpty()) {
            throw new MyArgumentIllegalException("invalid token");
        }

        Verificationtoken verificationToken = verificationTokens.get(0);
        Calendar cal = Calendar.getInstance();
        // token verified or expired
        if (verificationToken.getVerified().equals((byte) 1) ||
                (verificationToken.getExpiredate().getTime() - cal.getTime().getTime()) <= 0) {
            throw new MyArgumentIllegalException("token expired");
        }
        Integer userId = verificationToken.getUserid();

        User user = userDao.fetchOne(ro.ghasachi.bt.persistence.tables.User.USER.ID, userId);
        user.setPassword(userVO.getPassword());
        user.setEnabled((byte) 1);
        userDao.update(user);
        verificationToken.setVerified((byte) 1);
        verificationtokenDao.update(verificationToken);
    }
}
