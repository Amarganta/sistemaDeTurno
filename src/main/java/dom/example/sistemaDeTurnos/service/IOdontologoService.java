package dom.example.sistemaDeTurnos.service;

import dom.example.sistemaDeTurnos.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService{
    void crearOdontologo(OdontologoDTO odontologoDTO);

    OdontologoDTO leerOdontologo(Long id);

    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);

    Set<OdontologoDTO> getTodos();
}
