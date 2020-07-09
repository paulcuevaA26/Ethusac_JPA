package pe.isil.empresa.service;

import pe.isil.empresa.model.Chofer;

import java.util.List;

public interface ChoferService {

    Chofer createChofer(Chofer chofer);
    Chofer updateChofer(Chofer chofer);
    List<Chofer> getAllChofer();
    Chofer getChoferById(Integer choferid);
    void deleteChofer(Integer choferid);

}
