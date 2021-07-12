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
@Table(name="cities")
@AllArgsConstructor
@NoArgsConstructor 

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")


public class Cities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_name")
	private String cityName;

	@JsonIgnore
	@OneToMany(mappedBy="cities")
	private List<JobAdvertisements> JobAdvertisements;

	@JsonIgnore
	@OneToMany(mappedBy="cities")
	private List<University> university;
	
	

}
