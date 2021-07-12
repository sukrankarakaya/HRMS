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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor 
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employer extends User{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
		
	@Column(name="is_activated")
	private boolean isActivated;
	

	private String isChackPassword;

	@JsonIgnore
	@OneToMany(mappedBy="employer")
	private List<JobAdvertisements> jobAdvertisements;
	
	
	
	

}
