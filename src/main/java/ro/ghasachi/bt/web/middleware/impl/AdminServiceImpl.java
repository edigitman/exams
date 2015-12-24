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
	public void createNewUser(final UserVO userVO) {
		EUser user = parseVO(userVO);
		user.setToken(String.valueOf(UUID.randomUUID()));

		// TODO send email
		iUserServce.create(user);
	}

	@Override
	public EUser updateUser(final UserVO userVO) {

		EUser dbUser = iUserServce.findByEmail(userVO.getEmail());
		if (dbUser != null) {
			// update properties

			iUserServce.update(dbUser);
			return dbUser;
		}

		return null;
	}

	// Local methods

	private EUser parseVO(UserVO userVO) {
		return new EUser.Builder().name(userVO.getName()).lastname(userVO.getLastName()).email(userVO.getEmail())
				.role(userVO.getRole()).build();
	}
}
