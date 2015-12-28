package ro.ghasachi.bt.web.middleware;

import java.util.List;

import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.web.vo.UserVO;

public interface AdminService {

	void createNewUser(UserVO uservo);

	User updateUser(UserVO userVO);

	List<User> getAllUsers();
	
}
