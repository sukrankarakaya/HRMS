package kodlamaio.hrms.entities.concrate;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPosition","cities","employer","wayOfWorking","workingTime"})

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

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

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	@Column(name="dead_line")
	private Date deadLine;
	
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


	@ManyToOne
	@JoinColumn(name = "way_of_working_id")
	private WayOfWorking wayOfWorking;


	@ManyToOne
	@JoinColumn(name = "working_time_id")
	private WorkingTime workingTime;

	@JsonIgnore
	@OneToMany(mappedBy = "jobAdvertisements")
	private List<Favorites> favorites;




}
