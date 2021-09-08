package miniproject.Services;

import java.util.List;

import miniproject.Entity.Category;

public interface CategoryService {

	List<Category> findAll();

	Category findById(String id);

	Category create(Category category);

	Category update(Category category);

	void delete(String id);

}
