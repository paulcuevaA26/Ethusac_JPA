package pe.isil.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.empresa.exception.ResourceNotFoundException;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.model.Paradero;
import pe.isil.empresa.repository.ChoferRepository;
import pe.isil.empresa.repository.MotoRepository;
import pe.isil.empresa.repository.ParaderoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MotoServiceImpl implements MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private ChoferRepository choferRepository;

    @Autowired
    private ParaderoRepository paraderoRepository;

    @Override
    public Moto createMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public Moto updateMoto(Moto moto) {

        Optional<Moto> motoDB =
                this.motoRepository.findById(moto.getMoto_id());
        if(motoDB.isPresent()){
            Moto motoUpdate = motoDB.get();
            motoUpdate.setMoto_id(moto.getMoto_id());
            motoUpdate.setChasis(moto.getChasis());
            motoUpdate.setColor(moto.getColor());
            motoUpdate.setMarca(moto.getMarca());
            motoUpdate.setSoat(moto.getSoat());
            return motoUpdate;
        }else {
            throw  new ResourceNotFoundException("error" + moto.getMoto_id());
        }
    }

    @Override
    public List<Moto> getAllMoto() {
        return this.motoRepository.findAll();
    }

    @Override
    public Moto getMotoById(Integer motoid) {
        Optional<Moto> motoDB = this.motoRepository.findById(motoid);
        if(motoDB.isPresent()){
            return motoDB.get();
        }else {
            throw  new ResourceNotFoundException("Error" + motoid);
        }
    }

    @Override
    public void deleteMotor(Integer motoid) {
        Optional<Moto> motoDB = this.motoRepository.findById(motoid);
        if (motoDB.isPresent()) {
            this.motoRepository.delete(motoDB.get());
        }else {
            throw new ResourceNotFoundException("Error" + motoid);
        }
    }

    @Override
    public List<Moto> getMotoByIdChofer(Chofer chofer) {
        Optional<Chofer> chofer1 = choferRepository.findById(chofer.getChofer_id());
        List<Moto> motoList = motoRepository.findAll();
        Moto moto = motoList.stream().filter(a -> a.getChofer().equals(chofer1)).findFirst().orElse(null);
        List<Moto> motoList1 =  motoList.stream().filter(a -> a.getChofer().equals(chofer1)).collect(Collectors.toList());

        return motoList1;
    }

    @Override
    public List<Paradero> getParaderoByIdMoto(Moto moto) {
        Optional<Moto> moto1 = motoRepository.findById(moto.getMoto_id());
        List<Paradero> paraderolist = paraderoRepository.findAll();
        //Moto moto = motoList.stream().filter(a -> a.getParadero().equals(paradero1)).findFirst().orElse(null);
        List<Paradero> paraderoList =  paraderolist.stream().filter(p -> p.getMoto().equals(moto1)).collect(Collectors.toList());

        return paraderoList;
    }




}
