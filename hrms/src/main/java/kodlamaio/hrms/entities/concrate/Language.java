package kodlamaio.hrms.entities.concrate;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="language_name")
	private String name;



/*

	@JsonIgnore
	@OneToMany(mappedBy="language")
	private List<CandidateLanguage> candidateLanguage;
*/






}
