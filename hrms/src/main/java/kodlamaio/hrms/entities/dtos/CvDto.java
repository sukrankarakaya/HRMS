package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.api.Controllers.CandidateImageControllers;
import kodlamaio.hrms.entities.concrate.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

public class CvDto {
    public Candidate candidate;

    public List<CandidateSchool> candidateSchool;
    public List<Technologies> technologies;
    public List<SocialMedia> socialMedia;
    public List<CandidateLanguage> candidateLanguages;
    public List<Experience> experiences;
    public List<CandidateImage> candidateImage;
}
