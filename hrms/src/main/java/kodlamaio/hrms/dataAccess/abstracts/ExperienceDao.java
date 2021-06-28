package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.Experience;

public interface ExperienceDao extends JpaRepository<Experience,Integer>{

}
