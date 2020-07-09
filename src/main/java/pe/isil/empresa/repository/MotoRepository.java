package pe.isil.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.empresa.model.Moto;

@Repository
public interface MotoRepository  extends JpaRepository<Moto, Integer> {
}
