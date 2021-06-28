package kodlamaio.hrms.entities.concrate;


import java.util.Date;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="experiences")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate"})

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class Experience {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="workplace")
	private String workPlace;
	
	@Column(name="position")
	private String position;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	 
	 
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	


}
