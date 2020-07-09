package pe.isil.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.empresa.model.Paradero;

@Repository
public interface ParaderoRepository extends JpaRepository<Paradero, Integer> {
}
