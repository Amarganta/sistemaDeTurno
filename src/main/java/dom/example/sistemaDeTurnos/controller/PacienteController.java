package dom.example.sistemaDeTurnos.controller;

import dom.example.sistemaDeTurnos.dto.PacienteDTO;
import dom.example.sistemaDeTurnos.exception.BadRequestException;
import dom.example.sistemaDeTurnos.exception.EntityNotFoundException;
import dom.example.sistemaDeTurnos.service.IPacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.crearPaciente(pacienteDTO);
        LOGGER.info("El paciente " + pacienteDTO.getNombre() + " " + pacienteDTO.getApellido() + " ha sido creado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id) throws EntityNotFoundException {
        return pacienteService.leerPaciente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws EntityNotFoundException, BadRequestException{
        pacienteService.modificarPaciente(pacienteDTO);
        LOGGER.info("El paciente " + pacienteDTO.getNombre() + " " + pacienteDTO.getApellido() + " ha sido actualizado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws EntityNotFoundException{
        pacienteService.eliminarPaciente(id);
        LOGGER.info("El paciente con id: " + id + " ha sido eliminado correctamente.");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> getTodosLosPacientes() throws EntityNotFoundException{
        LOGGER.info("Estos son todos los pacientes de la base de datos");
        return  pacienteService.getTodos();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> buscarPacientePorNombre(String nombre){
        pacienteService.buscarPacientePorNombre(nombre);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
