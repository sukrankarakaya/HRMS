package kodlamaio.hrms.entities.concrate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="activation_code_employers")
@Data

public class ActivationCodeEmployers {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employers_user_id")
	private int employersUserId;
	
	
	public ActivationCodeEmployers(int id, int employersUserId) {
		super();
		this.id = id;
		this.employersUserId = employersUserId;
	}
	

}
