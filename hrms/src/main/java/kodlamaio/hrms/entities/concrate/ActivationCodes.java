package kodlamaio.hrms.entities.concrate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="activation_codes")
@Data
public class ActivationCodes {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="avctivation_codes")
	private String activationCode;
	
	@Column(name="is_confirimed")
	private boolean isConfirimed;

	
	public ActivationCodes(int id, String activationCode, boolean isConfirimed) {
		super();
		this.id = id;
		this.activationCode = activationCode;
		this.isConfirimed = isConfirimed;
	}

}
