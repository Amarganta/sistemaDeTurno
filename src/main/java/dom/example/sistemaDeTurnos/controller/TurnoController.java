package dom.example.sistemaDeTurnos.controller;

import dom.example.sistemaDeTurnos.dto.TurnoDTO;
import dom.example.sistemaDeTurnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.*;
import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    ITurnoService turnoService;


    public ResponseEntity<?> crearEstudiante(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        logger.info("El turno con el odontólogo con id:  " + turnoDTO.getOdontologo().getId() + " para el paciente con id: " + turnoDTO.getPaciente().getId() +" en la fecha: " + turnoDTO.getFechaYHora() + " ha sido registrado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id){
        return turnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        logger.info("El turno con el id:  " + turnoDTO.getId() + " ha sido actualizado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        logger.info("El turno con id: " + id + " ha sido eliminado correctamente.");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> getTodosLosTurnos(){
        return  turnoService.getTodos();
    }

}
