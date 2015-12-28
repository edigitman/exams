package ro.ghasachi.bt.web.middleware.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.tables.daos.UserDao;
import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.web.middleware.AdminService;
import ro.ghasachi.bt.web.util.OnRegistrationCompleteEvent;
import ro.ghasachi.bt.web.vo.UserVO;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Override
	public List<User> getAllUsers() {

		return userDao.findAll();
	}

	@Override
	public void createNewUser(final UserVO userVO) {
		User user = parseVO(userVO);
		userDao.insert(user);

		try {
			// String appUrl = request.getContextPath();

			// TODO send email
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, null, null));
		} catch (Exception me) {

		}

	}

	@Override
	public User updateUser(final UserVO userVO) {

		List<User> users = userDao.fetchByEmail(userVO.getEmail());
		if (users != null && !users.isEmpty()) {
			// update properties
			User user = users.get(0);
			userDao.update(user);
			return user;
		}
		return null;
	}

	// Local methods

	private User parseVO(UserVO userVO) {

		return new User(null, userVO.getEmail(), false, userVO.getLastName(), userVO.getName(), null, userVO.getRole());
	}

}
