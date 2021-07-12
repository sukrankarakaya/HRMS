package kodlamaio.hrms.entities.concrate;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	@NotNull
	@Column(name="position")
	private String position;
	
	
	@OneToMany(mappedBy="jobPosition")
	private List<JobAdvertisements> jobAdvertisements;
	

	
	
}