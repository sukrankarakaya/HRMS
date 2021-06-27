package kodlamaio.hrms.entities.concrate;


import java.util.Date;
import java.util.List;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor


public class Candidate extends User{
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;


	@Column(name="last_name")
	private String lastName;

	@Column(name="identity_number")
	private String identityNumber;


	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	private String isChackPassword;


	@OneToMany(mappedBy="candidate")
	private List<Experience> experience;


	@OneToMany(mappedBy="candidate")
	private List<CandidateImage> candidateImage;



	@OneToMany(mappedBy="candidate")
	private List<CandidateLanguage> candidateLanguages;


	@OneToMany(mappedBy="candidate")
	private List<CandidateSchool> candidateSchools;


	@OneToMany(mappedBy="candidate")
	private List<SocialMedia> socialMedia;


	@OneToMany(mappedBy="candidate")
	private List<Technologies> technologies;







}
