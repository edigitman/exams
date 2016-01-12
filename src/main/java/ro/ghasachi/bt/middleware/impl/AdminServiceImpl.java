package ro.ghasachi.bt.middleware.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.middleware.AdminService;
import ro.ghasachi.bt.persistence.tables.daos.UserDao;
import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.persistence.tables.records.UserRecord;
import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.hateoas.event.OnRegistrationCompleteEvent;
import ro.ghasachi.bt.web.vo.UserVO;

import static ro.ghasachi.bt.persistence.tables.User.USER;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<UserVO> getAllUsers() {
        List<UserVO> result = new ArrayList<>();

        List<User> users = userDao.findAll();
        for(User user : users){
            result.add(new UserVO(user));
        }
        return result;
    }

    @Override
    public void createNewUser(final UserVO userVO, final String appUrl) {

        DSLContext jooq = DSL.using(userDao.configuration());
        UserRecord userRecord = jooq.insertInto(USER, USER.NAME, USER.LASTNAME, USER.EMAIL, USER.ENABLED, USER.ROLE)
                .values(userVO.getName(), userVO.getLastName(), userVO.getEmail(), (byte) 0, userVO.getRole())
                .returning(USER.ID, USER.EMAIL)
                .fetchOne();

        try {
            User user = new User();
            user.setEmail(userRecord.getEmail());
            user.setId(userRecord.getId());
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, null, appUrl));
        } catch (Exception me) {
            throw new MyArgumentIllegalException("Exception sending email");
        }
    }

    @Override
    public UserVO updateUser(final UserVO userVO) {

        List<User> users = userDao.fetchByEmail(userVO.getEmail());
        if (users != null && !users.isEmpty()) {
            // update properties
            User user = users.get(0);
            userDao.update(user);
            return new UserVO(user);
        }
        return null;
    }

    // Local methods

    private User parseVO(UserVO userVO) {
        return new User(null, userVO.getEmail(), userVO.getName(), userVO.getLastName(), null, (byte) 0, userVO.getRole(), null);
    }

}
