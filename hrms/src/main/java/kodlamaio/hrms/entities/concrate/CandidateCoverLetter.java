package kodlamaio.hrms.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidate_cover_letter")
@AllArgsConstructor
@NoArgsConstructor

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")



public class CandidateCoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;



}
