package task.security;

/**
 * Created by aleksandr on 22.10.2017.
 */
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import task.db.enums.EmployeeRank;
import task.db.tables.pojos.User;

import java.util.ArrayList;

public class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        GrantedAuthority authority = getGrantedAuthority(user.getRank());
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                authorities,
                user.getEnabled()
        );
    }

    private static GrantedAuthority getGrantedAuthority(EmployeeRank rank) {
        return new SimpleGrantedAuthority(rank.getName());
    }
}
