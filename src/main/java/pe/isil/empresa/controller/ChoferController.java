package pe.isil.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.service.ChoferService;
import pe.isil.empresa.service.ChoferServiceImpl;
import pe.isil.empresa.service.MotoService;
import pe.isil.empresa.service.MotoServiceImpl;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ChoferController {

    //chofer
    @Autowired
    private ChoferServiceImpl choferServiceImpl;

    @Autowired
    private MotoServiceImpl motoServiceImpl;

    @GetMapping("/chofer")
    public String getAllChofer(Model model){
        model.addAttribute("chofer", choferServiceImpl.getAllChofer());
        model.addAttribute("chofer1", new Chofer());
        return "chofer";
    }
    @GetMapping("/chofer/add")
    public String loanAdd(Model model){
        model.addAttribute("chofer", new Chofer());
        return "chofer-add";
    }
    @PostMapping("/chofer/save")
    public String choferSave(Chofer chofer){
        choferServiceImpl.createChofer(chofer);
        return "redirect:/chofer";
    }
    @GetMapping("/chofer/edit/{id}")
    public String EditChofer(@PathVariable Integer id,Model model){
        Chofer currentChofer = choferServiceImpl.getChoferById(id);
        model.addAttribute("chofer",currentChofer);
        return "chofer-edit";
    }

    @PostMapping("/chofer/update/{id}")
    public String updatechofer(@PathVariable Integer id, Chofer chofer){
        chofer.setChofer_id(id);
        choferServiceImpl.updateChofer(chofer);
        return "redirect:/chofer";
    }
    @GetMapping("chofer/delete/{id}")
    public String deletechofer(@PathVariable Integer id){
        this.choferServiceImpl.deleteChofer(id);
        return "redirect:/chofer";
    }

    //chofer + Moto
    @GetMapping("/chofer/{id}/motos")
    public String motoList(Model model, @PathVariable Integer id){
        model.addAttribute("id",id);
        Chofer current = choferServiceImpl.getChoferById(id);
        model.addAttribute("motolist",motoServiceImpl.getMotoByIdChofer(current));
        //model.addAttribute("motolist",motoServiceImpl.getAllMoto());
        model.addAttribute("moto1",new Moto());
        return "motos";
    }


    @GetMapping("/chofer/{id}/motos/add")
    public String motoAdd(Model model, @PathVariable Integer id){
        model.addAttribute("id",id);
        model.addAttribute("moto",new Moto());
        return "moto-add";
    }

    @PostMapping("/chofer/{id}/motos/save")
    public String motosave(Moto moto, @PathVariable Integer id){
        Chofer currentChofer = choferServiceImpl.getChoferById(id);
        Set<Chofer> listchofer = new HashSet<>();
        listchofer.add(currentChofer);
        if(currentChofer != null){
            moto.setChofer(listchofer);
            motoServiceImpl.createMoto(moto);
        }
        return "redirect:/chofer/"+id+"/motos";
    }





//    @GetMapping("/chofers/{id}")
//    public ResponseEntity<Chofer> getByIdChofer(@PathVariable Integer id){
//        return ResponseEntity.ok().body(choferServiceImpl.getChoferById(id));
//    }








//
//    @GetMapping("/chofer/delete/{id}")
//    public String deleteChofer(@PathVariable Integer id){
//        Chofer currentChofer = choferServiceImpl.deleteChofer(id);
//        if(currentChofer != null){
//            choferServiceImpl.deleteChofer(currentChofer);
//        }
//        return "redirect:/chofers";
//    }
//    @DeleteMapping("/chofers/{id}")
//    public HttpStatus deletechofer(@PathVariable Integer id){
//        choferServiceImpl.deleteChofer(id);
//        return "redirect:/chofers";
//
//    }
//    @PostMapping("/chofers")
//    public ResponseEntity<Chofer> createChofer(@RequestBody Chofer chofer){
//        return  ResponseEntity.ok().body(this.choferServiceImpl.createChofer(chofer));
//
//    }



//    @PutMapping("/chofers/{id}")
//    public ResponseEntity<Chofer> updatechofer(@PathVariable Integer id, @RequestBody Chofer chofer){
//        chofer.setChofer_id(id);
//        return  ResponseEntity.ok().body(this.choferServiceImpl.updateChofer(chofer));
//    }
//
//    @DeleteMapping("/chofers/{id}")
//    public HttpStatus deletechofer(@PathVariable Integer id){
//        this.choferServiceImpl.deleteChofer(id);
//        return HttpStatus.OK;
//    }
}
