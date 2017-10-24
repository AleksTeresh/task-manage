package task.security.service;

/**
 * Created by aleksandr on 22.10.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import task.dao.ExUserDao;
import task.db.tables.pojos.User;
import task.security.JwtUserFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    private final ExUserDao userDao;

    @Autowired
    public JwtUserDetailsServiceImpl(ExUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.fetchOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
