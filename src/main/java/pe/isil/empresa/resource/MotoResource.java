package pe.isil.empresa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.repository.MotoRepository;
import pe.isil.empresa.service.ChoferService;
import pe.isil.empresa.service.MotoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MotoResource {


    @Autowired
    MotoService motoService;

    @Autowired
    MotoRepository motoRepository;

    @GetMapping("/motos")
    public ResponseEntity listmoto(){
        List<Moto> motoList = motoService.getAllMoto();
        if(motoList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(motoList, HttpStatus.OK);
    }

    @PostMapping("/motos")
    public ResponseEntity savemoto(@RequestBody Moto moto){
        motoRepository.save(moto);
        return new ResponseEntity(moto,HttpStatus.CREATED);
    }

    @PutMapping("/motos/{id}")
    public ResponseEntity updatemoto(@PathVariable Integer id,
                                     @RequestBody Moto moto){
        Optional<Moto> motoOptional = motoRepository.findById(id);
        if(!motoOptional.isPresent()){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Moto currentMoto = motoOptional.get();
        currentMoto.setPlaca(moto.getPlaca());
        currentMoto.setChasis(moto.getChasis());
        currentMoto.setColor(moto.getColor());
        currentMoto.setMarca(moto.getMarca());
        currentMoto.setSoat(moto.getSoat());

        motoRepository.save(currentMoto);

        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/motos/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        Optional<Moto> motoOptional = motoRepository.findById(id);
        if(!motoOptional.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Moto currentMotos = motoOptional.get();

        motoRepository.delete(currentMotos);

        return new ResponseEntity(HttpStatus.OK);
    }


}
