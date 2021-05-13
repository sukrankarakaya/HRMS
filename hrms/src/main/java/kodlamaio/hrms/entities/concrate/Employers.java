package kodlamaio.hrms.entities.concrate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employers")
@Data
public class Employers {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="comğpany_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String wbAdress;
	
	@Column(name="phone_number")
	private int phoneNumber;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	
	public Employers(int id, String companyName, String wbAdress, int phoneNumber, boolean isActivated) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.wbAdress = wbAdress;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}
	

}
