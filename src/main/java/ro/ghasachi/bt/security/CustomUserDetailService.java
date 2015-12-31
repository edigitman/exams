package ro.ghasachi.bt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ro.ghasachi.bt.persistence.tables.daos.UserDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by edi on 12/19/2015.
 */
@Component("customUserDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        ro.ghasachi.bt.persistence.tables.pojos.User user = userDao.fetchOne(ro.ghasachi.bt.persistence.tables.User.USER.EMAIL, s);

        if (user != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole()));

            return new User(user.getEmail(), user.getPassword(), user.getEnabled().equals((byte) 1), true, true, true, authorities);
        }
        return null;
    }
}
