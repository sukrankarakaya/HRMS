package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.dtos.JobAdventisamentFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import lombok.Data;
import org.springframework.data.repository.query.Param;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisements,Integer> {

	JobAdvertisements getById(int id);


	@Query("From JobAdvertisements where active=true")
	List<JobAdvertisements> getByActiveTrue();

	@Query("From JobAdvertisements where active=true Order By createDate Desc ")
	List<JobAdvertisements> getByActiveAndByCreateDateDesc(Data createDate);

	@Query("From JobAdvertisements where active=true and employer.id=:id")
	List<JobAdvertisements> getByActiveAndEmployer_EmployerId(int id);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "( e.companyName,p.position,e.phoneNumber,c.cityName ,j.numberOfPosition,j.createDate, j.deadLine, w.wayOfWorkingName, t.workingTimeName ,j.jobDesciription,j.minSalary,j.maxSalary) "
			+ "From JobAdvertisements j Inner Join j.cities c Inner Join j.employer e Inner Join j.jobPosition p Inner Join j.wayOfWorking w Inner Join j.workingTime t")
	List<JobAdvertisementDto> getJobAdvertisementDetails();


	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "( e.companyName,p.position,e.phoneNumber,c.cityName ,j.numberOfPosition,j.createDate, j.deadLine, w.wayOfWorkingName, t.workingTimeName ,j.jobDesciription,j.minSalary,j.maxSalary) "
			+ "From JobAdvertisements j Inner Join j.cities c Inner Join j.employer e Inner Join j.jobPosition p Inner Join j.wayOfWorking w Inner Join j.workingTime t where j.id=:id ")
	JobAdvertisementDto getJobAdvertisementDetailsById(int id);


	@Query(
			"From JobAdvertisements  where cities.id=:cityId and jobPosition.id=:positionId and workingTime.id=:workingTimeId and wayOfWorking.id=:wayOfWorkingId ")
	List<JobAdvertisements> getFilter(int cityId, int positionId, int workingTimeId, int wayOfWorkingId);


	@Query("from JobAdvertisements j where"
			+ "((:#{#filter.jobPositionIds}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionIds})) "
			+ "and ((:#{#filter.cityIds}) IS NULL OR j.cities.id IN (:#{#filter.cityIds})) "
			+ "and ((:#{#filter.wayOfWorkIds}) IS NULL OR j.wayOfWorking.id IN (:#{#filter.wayOfWorkIds})) "
			+ "and ((:#{#filter.workTimeIds}) IS NULL OR j.workingTime.id IN (:#{#filter.workTimeIds})) "
			+ "and j.active = true  ")
	Page<JobAdvertisements> getByFilter(@Param("filter")JobAdventisamentFilterDto jobAdventisamentFilterDto, Pageable pageable);


}
