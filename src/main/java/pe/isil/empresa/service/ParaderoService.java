package pe.isil.empresa.service;

import org.springframework.stereotype.Service;
import pe.isil.empresa.model.Paradero;

import java.util.List;

@Service
public interface ParaderoService{
    Paradero createParadero(Paradero paradero);
    Paradero updateParadero(Paradero paradero);
    List<Paradero> getAllParadero();
    Paradero getParaderoById(Integer paraderoId);
    void deleteParadero(Integer paraderoId);
}
