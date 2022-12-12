package dom.example.sistemaDeTurnos;

import dom.example.sistemaDeTurnos.dto.OdontologoDTO;
import dom.example.sistemaDeTurnos.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    @Autowired
    private IOdontologoService odontologoService;
    private Object MethodSorters;

    @Test
    public void testCrearOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Helena");
        odontologoDTO.setApellido("De Lima");
        odontologoDTO.setMatricula(12547);
        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologo01 = odontologoService.leerOdontologo(1L);

        assertTrue(odontologo01 != null);
    }
}