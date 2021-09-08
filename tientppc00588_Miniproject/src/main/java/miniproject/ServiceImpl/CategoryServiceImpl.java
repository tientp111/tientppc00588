package miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.Dao.CategoryDAO;
import miniproject.Entity.Category;
import miniproject.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO dao;
	
	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public Category findById(String id) {
		return dao.findById(id).get();
	}

	@Override
	public Category create(Category category) {
		return dao.save(category);
	}

	@Override
	public Category update(Category category) {
		return dao.save(category);
	}

	@Override
	public void delete(String id) {
		dao.deleteById(id);
	}

	
}
