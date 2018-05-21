package tech.mangosoft.ro3d.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.mangosoft.ro3d.client.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);

}
