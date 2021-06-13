package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import lombok.Data;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisements,Integer>{

	@Query("From JobAdvertisements where Active=true")
	List<JobAdvertisements> getByActiveTrue();
	
	@Query("From JobAdvertisements where Active=true Order By CreateDate Desc ")
	List<JobAdvertisements> getByActiveAndByCreateDateDesc(Data createDate);
	
	@Query("From JobAdvertisements where Active=true and employer.id=:id")
	List<JobAdvertisements> getByActiveAndEmployer_EmployerId(int id);
	
	
	

}
