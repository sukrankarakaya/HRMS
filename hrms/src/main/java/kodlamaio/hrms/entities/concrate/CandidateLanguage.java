package kodlamaio.hrms.entities.concrate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name="candidate_languages")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate","languageLevel"})

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class CandidateLanguage {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="language")
    private String language;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name="lnguage_level_id")
    private LanguageLevel languageLevel;






}
