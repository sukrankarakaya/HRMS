package kodlamaio.hrms.entities.concrate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="activation_code_employers")

@AllArgsConstructor
@NoArgsConstructor

public class ActivationCodeEmployers {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employers_user_id")
	private int employersUserId;
	
	
	

}
