package dom.example.sistemaDeTurnos.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserService implements UserDetailsService {
    @Autowired
    private final IUserRepository userRepository;

    public AppUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return (UserDetails) userRepository.findByEmail(email).orElseThrow((() -> new UsernameNotFoundException("User email not found")));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
