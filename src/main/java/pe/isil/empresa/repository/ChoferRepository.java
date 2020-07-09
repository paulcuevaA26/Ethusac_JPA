package pe.isil.empresa.repository;


import org.h2.util.json.JSONTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.isil.empresa.dto.ChoferMoto;
import pe.isil.empresa.model.Chofer;

import java.util.List;

@Repository
public interface ChoferRepository extends JpaRepository<Chofer, Integer> {


    @Query("select new pe.isil.empresa.dto.ChoferMoto(c.nombres, c.apellidos,c.telefono, m.placa, m.color) from Chofer c JOIN c.motoSet m where m.chofer = c.motoSet")
    public List<ChoferMoto> getchofermoto();
}
