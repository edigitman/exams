package ro.ghasachi.bt.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.context.request.WebRequest;
import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.middleware.AdminService;
import ro.ghasachi.bt.web.util.ControllerInputValidator;
import ro.ghasachi.bt.web.vo.UserVO;


/**
 * Created by edi on 12/19/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	private final static Logger log = LoggerFactory.getLogger(AdminController.class);
	
    @Autowired
    private AdminService service;
    
    @RequestMapping(value="user",consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createUser(@RequestBody UserVO userVO, WebRequest request){
    	log.debug("createUser:" + userVO);
    	String appUrl = request.getContextPath();

    	ControllerInputValidator.validateCreateUser(userVO);
    	
    	service.createNewUser(userVO, appUrl);
    }

    @RequestMapping(value="user", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public UserVO editUser(@RequestBody UserVO userVO){
    	log.debug("editUser:" + userVO);
    	
    	ControllerInputValidator.validateCreateUser(userVO);
    	
        return service.updateUser(userVO);
    }
    
    @RequestMapping(value="user", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getAllUsers(){
    	log.debug("getAllUsers");
    	
    	
        return service.getAllUsers();
    }
}
