package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="candidate_cover_letter")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class CandidateCoverLetter {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="cover_letter")
    private String coverLetter;



    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;



}
