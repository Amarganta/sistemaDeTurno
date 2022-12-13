package dom.example.sistemaDeTurnos.repository;

import dom.example.sistemaDeTurnos.modelo.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository<AppUSer> extends JpaRepository<AppUSer, Long> {
    Optional<AppUser> findByEmail(String email);
}