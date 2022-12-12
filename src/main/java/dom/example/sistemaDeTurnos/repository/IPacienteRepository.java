package dom.example.sistemaDeTurnos.repository;

import dom.example.sistemaDeTurnos.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("SELECT p FROM Paciente p WHERE p.nombre = ?1")
    Optional<Paciente> buscarPacientePorNombre(String nombre);
}
