package kodlamaio.hrms.dataAccess.abstracts;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concrate.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
	List<User> findByEmail(String email);
	User getByEmail(String email);
	

}
