package kodlamaio.hrms.entities.concrate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="activation_code_candidates")
@AllArgsConstructor
@NoArgsConstructor

@Inheritance(strategy = InheritanceType.JOINED)


public class ActivationCodeCandidates {
	

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_user_id")
	private int candidateUserId;
	
	
}
