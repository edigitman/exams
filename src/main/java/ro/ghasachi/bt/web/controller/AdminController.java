package ro.ghasachi.bt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.service.IUserService;
import ro.ghasachi.bt.web.vo.UserVO;


/**
 * Created by edi on 12/19/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createUser(@RequestBody UserVO userVO){
        userService.createNewUser(userVO);
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public EUser editUser(@RequestBody UserVO userVO){
        return userService.updateUser(userVO);
    }
    
}