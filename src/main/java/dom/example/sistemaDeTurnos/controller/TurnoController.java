package dom.example.sistemaDeTurnos.controller;

import dom.example.sistemaDeTurnos.dto.TurnoDTO;
import dom.example.sistemaDeTurnos.exception.BadRequestException;
import dom.example.sistemaDeTurnos.exception.EntityNotFoundException;
import dom.example.sistemaDeTurnos.service.ITurnoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    ITurnoService turnoService;


    public ResponseEntity<?> crearEstudiante(@RequestBody TurnoDTO turnoDTO)  throws BadRequestException  {
        turnoService.crearTurno(turnoDTO);
        LOGGER.info("El turno con el odontólogo con id:  " + turnoDTO.getOdontologo().getId() + " para el paciente con id: " + turnoDTO.getPaciente().getId() +" en la fecha: " + turnoDTO.getFechaYHora() + " ha sido registrado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id) throws EntityNotFoundException {
        return turnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) throws EntityNotFoundException, BadRequestException{
        turnoService.modificarTurno(turnoDTO);
        LOGGER.info("El turno con el id:  " + turnoDTO.getId() + " ha sido actualizado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws EntityNotFoundException{
        turnoService.eliminarTurno(id);
        LOGGER.info("El turno con id: " + id + " ha sido eliminado correctamente.");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> getTodosLosTurnos() throws EntityNotFoundException{
        return  turnoService.getTodos();
    }

}
