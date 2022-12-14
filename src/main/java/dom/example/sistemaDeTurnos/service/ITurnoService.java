package dom.example.sistemaDeTurnos.service;


import dom.example.sistemaDeTurnos.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDTO turnoDTO);

    TurnoDTO leerTurno(Long id);

    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);

    Set<TurnoDTO> getTodos();

}
