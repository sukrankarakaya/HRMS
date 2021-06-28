package kodlamaio.hrms.dataAccess.abstracts;


import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.Experience;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Integer>{

    @Query("From Experience order by endDate DESC ")
    List<Experience> getByEndDateDesc(Data endDate);



}
