package miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import miniproject.Dao.ProductDAO;
import miniproject.Entity.Product;
import miniproject.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Product findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Page<Product> findByCategoryId(String cid, Pageable pageable) {
		return dao.findByCategoryId(cid, pageable);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product create(Product product) {
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		return dao.save(product);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Product> findByNameContaining(String keyword, Pageable pageable) {
		return dao.findByNameContaining(keyword, pageable);
	}
}
