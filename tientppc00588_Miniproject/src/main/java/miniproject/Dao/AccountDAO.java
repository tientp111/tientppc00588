package miniproject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import miniproject.Entity.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, String>{

	@Query("select distinct a.account from Authority a where a.role.id IN ('ADMIN', 'PM')")
	List<Account> getAdministrators();

}
