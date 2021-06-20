package kodlamaio.hrms.entities.concrate;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor


public class JobAdvertisements {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_description")
	private String jobDesciription;

	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	@Column(name="dead_line")
	private LocalDate deadLine;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="number_of_position")
	private int numberOfPosition; 
	
	

	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	
	@JoinColumn(name="city_id")
	private Cities cities;
	
	@ManyToOne 
	
	@JoinColumn(name="employer_id")
	private Employer employer;
}
