package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="candidate_languages")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class CandidateLanguage {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="language")
    private String language;

    @ManyToOne
    @JoinColumn(name="lnguage_level_id")
    private LanguageLevel languageLevel;


    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;




   /* @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;
*/
/*

    @ManyToOne
    @JoinColumn(name="lnguage_level_id")
    private LanguageLevel languageLevel;
*/






}
