package pe.isil.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.model.Paradero;
import pe.isil.empresa.service.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MotoController {

    //chofer
    @Autowired
    private MotoServiceImpl motoServiceImpl;

    @Autowired
    private MotoService motoService;

    @Autowired
    private ParaderoService paraderoService ;

    @GetMapping("/moto/edit/{id}")
    public String editMoto(@PathVariable Integer id,Model model){
        Moto currentMoto = motoServiceImpl.getMotoById(id);
        model.addAttribute("moto",currentMoto);
        return "moto-edit";
    }

    @PostMapping("/moto/update/{id}")
    public String updateMoto(@PathVariable Integer id, Moto moto){
        System.out.println(moto);
        moto.setMoto_id(id);
        motoServiceImpl.updateMoto(moto);

        return "redirect:/motos";
    }

    @GetMapping("moto/delete/{id}")
    public String deleteMoto(@PathVariable Integer id){
        this.motoServiceImpl.deleteMotor(id);
        return "redirect:/motos";
    }

    @GetMapping("/motos")
    public String getAllMoto(Model model){
        model.addAttribute("motolist", motoServiceImpl.getAllMoto());
        model.addAttribute("moto1", new Moto());
        return "motos";
    }
    @GetMapping("/moto/add")
    public String motoAdd(Model model){
        model.addAttribute("moto", new Moto());
        return "moto-add";
    }
    @PostMapping("/moto/save")
    public String motoSave(Moto moto){
        motoServiceImpl.createMoto(moto);
        return "redirect:/motos";
    }
    //Moto + Paradero
    @GetMapping("/motos/{id}/paradero")
    public String findParaderobyIdMoto(Model model, @PathVariable Integer id){
        model.addAttribute("id",id);
        Moto currentMoto = motoService.getMotoById(id);
        model.addAttribute("motolist",motoServiceImpl.getParaderoByIdMoto(currentMoto));
        //model.addAttribute("motolist",motoServiceImpl.getAllMoto());
        model.addAttribute("paradero", paraderoService.getAllParadero());
        model.addAttribute("paraderos", new Paradero());
        return "paradero-man";
    }




}

