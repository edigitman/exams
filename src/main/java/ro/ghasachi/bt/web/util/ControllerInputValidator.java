package ro.ghasachi.bt.web.util;

import java.util.UUID;

import com.google.common.base.Strings;

import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.vo.*;

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

        if (Strings.isNullOrEmpty(user.getToken()) || Strings.isNullOrEmpty(user.getPassword())) {
            throw new MyArgumentIllegalException("Invalid user credentials");
        }
    }

    public static void validateCreateUser(UserVO user) {
        if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getName())
                || Strings.isNullOrEmpty(user.getLastName()) || Strings.isNullOrEmpty(user.getRole())) {
            throw new MyArgumentIllegalException("Invalid user credentials");
        }
    }

    public static void validateCreateExam(ExamVO examVO) {
        if (Strings.isNullOrEmpty(examVO.getName()) || Strings.isNullOrEmpty(examVO.getDifficulty())) {
            throw new MyArgumentIllegalException("Invalid exam fields");
        }
    }

    public static void validateCreateExamItem(ExamItemVO itemVO) {
        if (Strings.isNullOrEmpty(itemVO.getAssertion()) ||
                itemVO.getExamId() == 0 || itemVO.getPoints() == 0 || itemVO.getType() == 0) {
            throw new MyArgumentIllegalException("Invalid item fields");
        }
    }

    public static void validateCreateexamGroup(ExamGroupVO examGroupVO) {
        if (Strings.isNullOrEmpty(examGroupVO.getName())) {
            throw new MyArgumentIllegalException("Invalid exam group");
        }
    }

    public static void validateAddStudToGroup(ExamGroupStudVO examGroupStudVO) {
        if (examGroupStudVO.getGroupId() <= 0 || examGroupStudVO.getStudId() <= 0) {
            throw new MyArgumentIllegalException("Invalid ids");
        }
    }

    public static void validateProfAnswer(ExamItemAnswerVO examItemAnswerVO) {
        if (examItemAnswerVO.getCorrect() == null || examItemAnswerVO.getItemId() <= 0
                || Strings.isNullOrEmpty(examItemAnswerVO.getValue())) {
            throw new MyArgumentIllegalException("Invalid info for answer");
        }
    }

    public static void validateStudAnswer(ExamItemAnswerVO examItemAnswerVO) {
        if (examItemAnswerVO.getItemId() <= 0 || examItemAnswerVO.getExamInstanceId() <= 0
                || Strings.isNullOrEmpty(examItemAnswerVO.getValue())) {
            throw new MyArgumentIllegalException("Invalid info for answer");
        }
    }
}
