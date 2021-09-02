package kodlamaio.hrms.entities.concrate;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name="candidate_image")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class CandidateImage {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image_url")
    private String imageUrl;



    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;


}
