package ro.ghasachi.bt.web.util;

import java.util.UUID;

import com.google.common.base.Strings;

import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.vo.UserVO;

public class ControllerInputValidator {

	/**
	 * Validate a token that might be attached to a user.
	 * 
	 * @param token
	 */
	public static void validateToken(String token) {
		if (Strings.isNullOrEmpty(token)) {
			throw new MyArgumentIllegalException("Invalid token");
		}

		try {
			UUID.fromString(token);
		} catch (IllegalArgumentException ex) {
			throw new MyArgumentIllegalException("Invalid token", ex);
		}
	}

	public static void validateUserCreatePassword(UserVO user) {

		if (Strings.isNullOrEmpty(user.getToken()) || Strings.isNullOrEmpty(user.getEmail())
				|| Strings.isNullOrEmpty(user.getPassword())) {
			throw new MyArgumentIllegalException("Invalid user credentials");
		}
	}

	public static void validateCreateUser(UserVO user) {
		if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getName())
				|| Strings.isNullOrEmpty(user.getLastName()) || Strings.isNullOrEmpty(user.getRole())) {
			throw new MyArgumentIllegalException("Invalid user credentials");
		}
	}

}
