package miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.Dao.AuthorityDAO;
import miniproject.Entity.Authority;
import miniproject.Services.AuthorityServive;

@Service
public class AuthorityServiceImpl implements AuthorityServive{
	
	@Autowired
	AuthorityDAO dao;	

	@Override
	public List<Authority> findAll() {
		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

}
