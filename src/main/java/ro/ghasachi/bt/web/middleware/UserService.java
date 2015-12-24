package ro.ghasachi.bt.web.middleware;

import ro.ghasachi.bt.web.vo.UserVO;

public interface UserService {

	UserVO getByToken(String token);

	void createPassword(UserVO userVO);

}
