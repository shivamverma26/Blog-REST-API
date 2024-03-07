package blogapi.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blogapi.crud.model.role.Role;
import blogapi.crud.model.role.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);
}
