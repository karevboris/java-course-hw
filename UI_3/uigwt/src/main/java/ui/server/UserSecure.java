package ui.server;

import com.netcracker.Service.UserService.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSecure implements UserDetailsService {

    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private UserService userService = (UserService)context.getBean("userBean");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }
}
