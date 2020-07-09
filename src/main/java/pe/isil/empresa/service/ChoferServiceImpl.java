package pe.isil.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.empresa.exception.ResourceNotFoundException;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.repository.ChoferRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChoferServiceImpl implements ChoferService {

    @Autowired
    private ChoferRepository choferRepository;

    @Override
    public Chofer createChofer(Chofer chofer) {
        return choferRepository.save(chofer);
    }

    @Override
    public Chofer updateChofer(Chofer chofer) {
        Optional<Chofer> choferDB = this.choferRepository.findById(chofer.getChofer_id());
        if(choferDB.isPresent()){
            Chofer choferUpdate = choferDB.get();
            choferUpdate.setChofer_id(chofer.getChofer_id());
            choferUpdate.setNombres(chofer.getNombres());
            choferUpdate.setApellidos(chofer.getApellidos());
            choferUpdate.setDireccion(chofer.getDireccion());
            choferUpdate.setFec_ingreso(chofer.getFec_ingreso());
            choferUpdate.setTelefono(chofer.getTelefono());
            return choferUpdate;
        }else {
            throw new ResourceNotFoundException("ERROR PS WON que esa wdb de id not found "  + chofer.getChofer_id());

        }
    }

    @Override
    public List<Chofer> getAllChofer() {
        return this.choferRepository.findAll();
    }

    @Override
    public Chofer getChoferById(Integer choferid) {
        Optional<Chofer> choferDB = this.choferRepository.findById(choferid);
        if (choferDB.isPresent()) {
            return choferDB.get();
        } else {
            throw new ResourceNotFoundException("ERROR PS WON que esa wdb de id not found " + choferid);
        }
    }

    @Override
    public void deleteChofer(Integer choferid) {
        Optional<Chofer> choferDB = this.choferRepository.findById(choferid);
        if (choferDB.isPresent()) {
            this.choferRepository.delete(choferDB.get());
        }else {
            throw new ResourceNotFoundException("ERROR PS WON que esa wdb de id not found " + choferid);
        }

    }
}
