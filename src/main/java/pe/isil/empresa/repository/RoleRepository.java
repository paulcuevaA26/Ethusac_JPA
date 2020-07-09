package pe.isil.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.empresa.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
