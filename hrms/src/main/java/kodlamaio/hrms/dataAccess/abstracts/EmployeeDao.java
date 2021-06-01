package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	

}
