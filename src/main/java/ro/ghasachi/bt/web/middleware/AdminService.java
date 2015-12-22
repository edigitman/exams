package ro.ghasachi.bt.web.middleware;

import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.web.vo.UserVO;

public interface AdminService {

	void createNewUser(UserVO uservo);

	EUser updateUser(UserVO userVO);
	
}
