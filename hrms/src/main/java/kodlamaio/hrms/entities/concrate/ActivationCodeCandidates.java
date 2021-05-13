package kodlamaio.hrms.entities.concrate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="activation_code_candidates")
@Data
public class ActivationCodeCandidates {
	

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_user_id")
	private int candidateUserId;
	
	
	public ActivationCodeCandidates(int id, int candidateUserId) {
		super();
		this.id = id;
		this.candidateUserId = candidateUserId;
	}
}
