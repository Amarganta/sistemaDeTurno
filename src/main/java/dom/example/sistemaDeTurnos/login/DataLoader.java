package dom.example.sistemaDeTurnos.login;


import dom.example.sistemaDeTurnos.modelo.AppUser;
import dom.example.sistemaDeTurnos.modelo.AppUsuarioRoles;
import dom.example.sistemaDeTurnos.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("usuario", "usuario01", password, AppUsuarioRoles.USER));
        userRepository.save(new AppUser("administrador", "admin01", password2, AppUsuarioRoles.ADMIN));


    }
}