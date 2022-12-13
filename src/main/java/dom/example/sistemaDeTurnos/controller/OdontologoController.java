package dom.example.sistemaDeTurnos.controller;

import dom.example.sistemaDeTurnos.dto.OdontologoDTO;
import dom.example.sistemaDeTurnos.exception.BadRequestException;
import dom.example.sistemaDeTurnos.exception.EntityNotFoundException;
import dom.example.sistemaDeTurnos.service.IOdontologoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger LOGGER = LogManager.getLogger();


    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        odontologoService.crearOdontologo(odontologoDTO);
        LOGGER.info("El odontologo " + odontologoDTO.getNombre() + " " + odontologoDTO.getApellido() + " ha sido creado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id) throws EntityNotFoundException {
        return odontologoService.leerOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws EntityNotFoundException, BadRequestException{
        odontologoService.modificarOdontologo(odontologoDTO);
        LOGGER.info("El odontologo " + odontologoDTO.getNombre() + " " + odontologoDTO.getApellido() + " ha sido actualizado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws EntityNotFoundException{
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> getTodosLosOdontologos() throws EntityNotFoundException{
        LOGGER.info("Estos son todos los odontologos de la base de datos");
        return  odontologoService.getTodos();
    }

}
