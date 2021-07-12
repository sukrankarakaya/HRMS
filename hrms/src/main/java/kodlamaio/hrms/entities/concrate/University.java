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
@Table(name="universities")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class University {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private int ststus;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private Cities cities;

/*
	@OneToMany(mappedBy="universities")
	private List<CandidateSchool> candidateSchool;
*/

}
