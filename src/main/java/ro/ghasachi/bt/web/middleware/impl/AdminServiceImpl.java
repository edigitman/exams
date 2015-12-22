package ro.ghasachi.bt.web.middleware.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.service.IUserService;
import ro.ghasachi.bt.web.middleware.AdminService;
import ro.ghasachi.bt.web.vo.UserVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private IUserService iUserServce;

	@Override
	public void createNewUser(UserVO userVO) {
		EUser user = parseVO(userVO);
		user.setToken(String.valueOf(UUID.randomUUID().getMostSignificantBits()));

		// TODO send email
		iUserServce.create(user);
	}

	@Override
	public EUser updateUser(UserVO userVO) {

		EUser dbUser = iUserServce.retrieveByEmail(userVO.getEmail());
		if (dbUser != null) {
			// update properties

			iUserServce.update(dbUser);
			return dbUser;
		}

		return null;
	}

	// Local methods
	
	private EUser parseVO(UserVO userVO) {
		EUser user = new EUser();
		user.setName(userVO.getName());
		user.setLastname(userVO.getLastName());
		user.setEmail(userVO.getEmail());
		user.setRole(userVO.getRole());
		return user;
	}
}
