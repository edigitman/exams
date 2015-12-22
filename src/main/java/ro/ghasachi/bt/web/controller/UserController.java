package ro.ghasachi.bt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.ghasachi.bt.web.middleware.UserService;
import ro.ghasachi.bt.web.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	/**
	 * Just a model how to set a cookie
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unused")
	private ResponseEntity<UserVO> getAuth(@PathVariable("token") String token){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Set-Cookie","heroku-nav-data=");
        return new ResponseEntity<UserVO>(new UserVO(),headers,HttpStatus.OK);	
	}
	
	/**
	 * Get a user by token
	 * @return
	 */
	@RequestMapping(value = "t/{token}", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getByToken(@PathVariable("token") String token){
		log.debug("getByToken: " + token);
		return null;
	}
	
	/**
	 * Create a password for user, given the token and email
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value = "pass", method = RequestMethod.POST)
	@ResponseBody
	public UserVO createPassword(@RequestBody UserVO userVO){
		log.debug("createPassword: " + userVO);
		return null;
	}
	
}
