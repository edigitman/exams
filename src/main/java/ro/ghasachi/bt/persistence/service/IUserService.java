package ro.ghasachi.bt.persistence.service;

import ro.ghasachi.bt.persistence.IOperations;
import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.web.vo.UserVO;

/**
 * Created by edi on 12/19/2015.
 */
public interface IUserService extends IOperations<EUser> {

    EUser retrieveByEmail(String email);
    
    void createNewUser(UserVO userVO);
    EUser updateUser(UserVO userVO);
    
}
