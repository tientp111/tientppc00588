package miniproject.Services;

import java.util.List;

import miniproject.Entity.Authority;

public interface AuthorityServive {

	List<Authority> findAll();

	Authority create(Authority auth);

	void delete(Integer id);

}
