package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concrate.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    //public Candidate candidate;
    public Candidate candidate;
    public List<CandidateSchool> candidateSchool;
    public List<Technologies> technologies;
    public List<SocialMedia> socialMedia;
    public List<CandidateLanguage> candidateLanguages;
    public List<Experience> experiences;
    public List<CandidateImage> candidateImage;
    public List<CandidateCoverLetter> candidateCoverLetter;


//    private String firstName;
//    private String lastName;
//    private String eMail;
//    private Date birthDate;
//    private String workPlace;
//    private String expPosition;
//    private Date expStartDate;
//    private Date expEndDate;
//    private String imageUrl;
//    private String language;
//   // private int languageLevel;
//    private String schoolName;
//    private String schoolDepartment;
//    private Date schoolStartDate;
//    private Date schoolEndDate;
//    private String githubLink;
//    private String linkedinLink;
//    private String technologyName;
//    private String coverLetter;



}
