package miniproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import miniproject.Entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
