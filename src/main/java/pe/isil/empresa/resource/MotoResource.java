package pe.isil.empresa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.service.ChoferService;
import pe.isil.empresa.service.MotoService;

@RestController
@RequestMapping("/api")
public class MotoResource {


    @Autowired
    MotoService motoService;

    @GetMapping("/motos")
    public ResponseEntity listmoto(){
        List<Moto> motoList
    }
}
