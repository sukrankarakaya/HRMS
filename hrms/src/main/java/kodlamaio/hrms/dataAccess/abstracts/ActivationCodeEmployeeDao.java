package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.ActivationCodeEmployee;


public interface ActivationCodeEmployeeDao extends JpaRepository<ActivationCodeEmployee, Integer>{

}
