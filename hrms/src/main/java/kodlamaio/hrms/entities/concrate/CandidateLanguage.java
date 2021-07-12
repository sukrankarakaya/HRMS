package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


    @Column(name="lnguage_level_id")
    private int languageLevel;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;




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
