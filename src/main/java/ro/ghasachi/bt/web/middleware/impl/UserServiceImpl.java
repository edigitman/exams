package ro.ghasachi.bt.web.middleware.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.persistence.tables.daos.UserDao;
import ro.ghasachi.bt.persistence.tables.daos.VerificationtokenDao;
import ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken;
import ro.ghasachi.bt.web.middleware.UserService;
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
			// throw error
		}

		Verificationtoken verificationToken = verificationTokens.get(0);
		Long userId = verificationToken.getUserId();
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpirydate().getTime() - cal.getTime().getTime()) <= 0) {
			// throw error
		}
			
		User user = userDao.fetchOneById(userId);
		user.setEnabled(true);
		userDao.update(user);
		// return ok
	}
}
