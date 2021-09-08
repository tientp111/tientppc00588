package miniproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miniproject.Entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, String>{

}
