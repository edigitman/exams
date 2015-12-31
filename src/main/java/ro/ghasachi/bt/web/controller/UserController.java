package ro.ghasachi.bt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.ghasachi.bt.middleware.UserService;
import ro.ghasachi.bt.persistence.tables.daos.VerificationtokenDao;
import ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken;
import ro.ghasachi.bt.web.util.ControllerInputValidator;
import ro.ghasachi.bt.web.vo.UserVO;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    /**
     * Just a model how to set a cookie
     *
     * @param token
     * @return
     */
//	@SuppressWarnings("unused")
//	private ResponseEntity<UserVO> getAuth(@PathVariable("token") String token) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Set-Cookie", "heroku-nav-data=");
//		return new ResponseEntity<UserVO>(new UserVO(), headers, HttpStatus.OK);
//	}

    /**
     * Create a password for user, given the token and email
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "pass",consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public UserVO createPassword(@RequestBody UserVO userVO) {
        log.debug("createPassword: " + userVO);

        ControllerInputValidator.validateUserCreatePassword(userVO);

        service.createPassword(userVO);

        userVO.setPassword(null);

        return userVO;
    }

    @RequestMapping(value = "account",consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public void requestAccount(@RequestBody UserVO userVO){
        // todo send email to admin requesting account
    }

    @RequestMapping(value = "renew",consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public void requestNewPassword(@RequestBody UserVO userVO){
        // todo send email to admin reset password, add new token
    }
}
