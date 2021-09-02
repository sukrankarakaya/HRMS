package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="technologies")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class Technologies {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="technology_name")
    private String technologyName;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;



}
