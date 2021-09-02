package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concrate.*;
import lombok.Data;

import java.util.List;

@Data
public class ResumeDto {

    public int id;
    public int candidateId;
    public String firstName;
    public  String lastName;
    public String eMil;
    public Data birthDate;
    public List<CandidateSchool> candidateSchool;
    public List<Technologies> technologies;
    public List<SocialMedia> socialMedia;
    public List<CandidateLanguage> candidateLanguages;
    public List<Experience> experiences;
    public List<CandidateImage> candidateImage;
    public List<CandidateCoverLetter> candidateCoverLetter;

}
