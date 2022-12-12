package dom.example.sistemaDeTurnos.repository;

import dom.example.sistemaDeTurnos.modelo.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
