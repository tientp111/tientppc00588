package miniproject.Services;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import miniproject.Entity.Account;

public interface AccountService {
	public Account finById(String username);

	public List<Account> getAdministrators();

	public List<Account> findAll();

	public Account create(JsonNode accountData);

	public Account findById(String id);

	public Account update(Account acc);

	public void delete(String id);

	public Account add(Account accountData);
}
