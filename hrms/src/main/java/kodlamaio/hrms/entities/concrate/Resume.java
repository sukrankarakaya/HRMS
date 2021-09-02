package kodlamaio.hrms.entities.concrate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="resumes")
@NoArgsConstructor
@AllArgsConstructor

public class Resume {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @OneToOne(mappedBy = "resume")
    private Candidate candidate;

    @OneToMany(mappedBy = "resume")
    private List<CandidateCoverLetter> coverLetter;

    @OneToMany(mappedBy = "resume")
    private List<CandidateLanguage> languages;

    @OneToMany(mappedBy = "resume")
    private List<CandidateSchool> schools;


    @OneToMany(mappedBy = "resume")
    private List<SocialMedia> socialMedia;

    @OneToMany(mappedBy = "resume")
    private List<Technologies> technologies;

    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "resume")
    private List<CandidateImage> images;


}

