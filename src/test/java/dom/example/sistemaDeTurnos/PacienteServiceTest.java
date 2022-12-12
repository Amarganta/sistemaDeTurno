package dom.example.sistemaDeTurnos;
import dom.example.sistemaDeTurnos.dto.PacienteDTO;
import dom.example.sistemaDeTurnos.service.IPacienteService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;
    private Object MethodSorters;

    @Test
    public void testCrearPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Ariana");
        pacienteDTO.setApellido("Grande");
        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO paciente02 = pacienteService.leerPaciente(1L);

        assertTrue(paciente02 != null);
    }

}