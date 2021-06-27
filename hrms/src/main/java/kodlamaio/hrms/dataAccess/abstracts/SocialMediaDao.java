package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
}
