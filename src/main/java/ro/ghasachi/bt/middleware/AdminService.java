package ro.ghasachi.bt.middleware;

import java.util.List;

import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.web.vo.UserVO;

public interface AdminService {

	void createNewUser(UserVO uservo, String appUrl);

	UserVO updateUser(UserVO userVO);

	List<UserVO> getAllUsers();
	
}
