package dom.example.sistemaDeTurnos.service;

import dom.example.sistemaDeTurnos.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Long id);

    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);

    Set<PacienteDTO> getTodos();

    PacienteDTO buscarPacientePorNombre(String nombre);
}
