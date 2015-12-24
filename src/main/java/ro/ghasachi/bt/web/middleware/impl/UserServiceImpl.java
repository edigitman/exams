package ro.ghasachi.bt.web.middleware.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.service.IUserService;
import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.middleware.UserService;
import ro.ghasachi.bt.web.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserService iUserService;

	@Override
	public UserVO getByToken(String token) {

		EUser user = iUserService.findByToken(token);

		return new UserVO(user);
	}

	@Override
	@Transactional
	public void createPassword(UserVO userVO) {

		EUser user = iUserService.findByEmail(userVO.getEmail());
		if (user.getToken() != null && user.getToken().equals(userVO.getToken())) {
			user.setPassword(userVO.getPassword());
			user.setToken(null);
			iUserService.update(user);
		}else {
			throw new MyArgumentIllegalException("User already modified");
		}
	}
}
