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
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor


public class Candidate extends User{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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


	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Experience> experience;

	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateImage> candidateImage;


	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateLanguage> candidateLanguages;
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateSchool> candidateSchools;

	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<SocialMedia> socialMedia;

	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Technologies> technologies;


	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<CandidateCoverLetter> candidateCoverLetters;







}
