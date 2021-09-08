package miniproject.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import miniproject.Entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.category.id=?1")
	Page<Product> findByCategoryId(String cid, Pageable pageable);

	List<Product> findByNameContaining(String keyword, Pageable pageable);

}
