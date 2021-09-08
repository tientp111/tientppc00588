package miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.Dao.RoleDAO;
import miniproject.Entity.Role;
import miniproject.Services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO dao;

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

}
