package dom.example.sistemaDeTurnos.controller;

import dom.example.sistemaDeTurnos.dto.OdontologoDTO;
import dom.example.sistemaDeTurnos.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.*;
import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        logger.info("El odontologo " + odontologoDTO.getNombre() + " " + odontologoDTO.getApellido() + " ha sido creado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id){
        return odontologoService.leerOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        logger.info("El odontologo " + odontologoDTO.getNombre() + " " + odontologoDTO.getApellido() + " ha sido actualizado correctamente en la base de datos");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> getTodosLosOdontologos(){
        logger.info("Estos son todos los odontologos de la base de datos");
        return  odontologoService.getTodos();
    }

}
