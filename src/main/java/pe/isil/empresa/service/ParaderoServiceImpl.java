package pe.isil.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.empresa.exception.ResourceNotFoundException;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Paradero;
import pe.isil.empresa.repository.ParaderoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParaderoServiceImpl implements ParaderoService{

    @Autowired
    ParaderoRepository paraderoRepository;

    @Override
    public Paradero createParadero(Paradero paradero) {
        return paraderoRepository.save(paradero);
    }

    @Override
    public Paradero updateParadero(Paradero paradero) {
        return paraderoRepository.save(paradero);
    }

    @Override
    public List<Paradero> getAllParadero() {
        return paraderoRepository.findAll();
    }

    @Override
    public Paradero getParaderoById(Integer paraderoId) {
        Optional<Paradero> paradero = paraderoRepository.findById(paraderoId);
        if (paradero.isPresent()) {
            return paradero.get();
        } else {
            throw new ResourceNotFoundException("ERROR PS WON que esa wdb de id not found " + paraderoId);
        }
    }

    @Override
    public void deleteParadero(Integer paraderoId) {
        Optional<Paradero> paradero = this.paraderoRepository.findById(paraderoId);
        if (paradero.isPresent()) {
            this.paraderoRepository.delete(paradero.get());
        }else {
            throw new ResourceNotFoundException("ERROR PS WON que esa wdb de id not found " + paraderoId);
        }
    }
}
