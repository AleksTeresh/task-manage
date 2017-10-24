package task.controllers.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import task.db.enums.EmployeeRank;
import task.db.tables.pojos.User;
import task.security.JwtTokenUtil;
import task.security.JwtUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by aleksandr on 22.10.2017.
 */
@Component
public class UserUtils {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public User getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        Optional<GrantedAuthority> authority = jwtUser.getAuthorities().stream().findFirst().map(p -> p);
        EmployeeRank rank = EmployeeRank.worker;
        if (authority.isPresent()) {
            rank = authority.get().getAuthority() == "worker"
            ? EmployeeRank.worker
            : EmployeeRank.manager;
        }

        return new User(
                jwtUser.getUsername(),
                jwtUser.getPassword(),
                rank,
                jwtUser.isEnabled()
        );
    }
}
