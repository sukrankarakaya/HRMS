package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import lombok.Data;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisements,Integer>{

	@Query("From JobAdvertisements where active=true")
	List<JobAdvertisements> getByActiveTrue();
	
	@Query("From JobAdvertisements where active=true Order By createDate Desc ")

	List<JobAdvertisements> getByActiveAndByCreateDateDesc(Data createDate);
	
	@Query("From JobAdvertisements where active=true and employer.id=:id")
	List<JobAdvertisements> getByActiveAndEmployer_EmployerId(int id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
	  		+ "(c.cityName , e.companyName,e.phoneNumber,p.position,j.numberOfPosition,j.createDate, j.deadLine) "
	  		+ "From JobAdvertisements j Inner Join j.cities c Inner Join j.employer e Inner Join j.jobPosition p")
	List<JobAdvertisementDto> getJobAdvertisementDetails();





}
