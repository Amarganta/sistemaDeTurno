package dom.example.sistemaDeTurnos.repository;

import dom.example.sistemaDeTurnos.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}
