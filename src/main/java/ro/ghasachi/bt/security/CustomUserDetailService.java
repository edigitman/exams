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

		List<ro.ghasachi.bt.persistence.tables.pojos.User> users = userDao.fetchByEmail(s);
		ro.ghasachi.bt.persistence.tables.pojos.User user = null;
		if (users != null && !users.isEmpty()) {
			user = users.get(0);
		}

		if (user != null) {
			authorities.add(new SimpleGrantedAuthority(user.getRole()));

			return new User(user.getEmail(), user.getPassword(), authorities);
		}
		return null;
	}
}
