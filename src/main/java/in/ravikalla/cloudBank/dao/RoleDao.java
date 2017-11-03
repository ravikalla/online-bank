package in.ravikalla.cloudBank.dao;

import org.springframework.data.repository.CrudRepository;

import in.ravikalla.cloudBank.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
    
    Role findByName(String name);
}
