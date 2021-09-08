package miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import miniproject.Dao.AccountDAO;
import miniproject.Entity.Account;
import miniproject.Services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO dao;

	@Override
	public Account finById(String username) {
		return dao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		return dao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Account add(Account accountData) {		
			return dao.save(accountData);
	}

	@Override
	public Account findById(String id) {
		return dao.findById(id).get();
	}
	
	@Override
	public void delete(String id) {
		dao.deleteById(id);
	}

	@Override
	public Account update(Account acc) {
		return dao.save(acc);
	}

	@Override
	public Account create(JsonNode accountData) {
		// TODO Auto-generated method stub
		return null;
	}

}
