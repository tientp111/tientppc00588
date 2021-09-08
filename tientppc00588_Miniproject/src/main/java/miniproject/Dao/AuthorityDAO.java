package miniproject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import miniproject.Entity.Account;
import miniproject.Entity.Authority;

@Repository
public interface AuthorityDAO extends JpaRepository<Authority, Integer>{

	@Query("select distinct a from Authority a where a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}
