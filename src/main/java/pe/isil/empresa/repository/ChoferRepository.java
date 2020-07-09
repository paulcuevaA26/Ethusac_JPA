package pe.isil.empresa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.empresa.model.Chofer;

@Repository
public interface ChoferRepository extends JpaRepository<Chofer, Integer> {
}
