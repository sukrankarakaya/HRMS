package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concrate.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer getByEmail(String email);

	Employer getById(int id);

}
