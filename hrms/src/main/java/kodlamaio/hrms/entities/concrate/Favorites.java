package kodlamaio.hrms.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorites {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "favorite_id")
        public int favoriteId;

        @ManyToOne()
        @JoinColumn(name = "candidate_id")
        private Candidate candidate;

        @ManyToOne()
        @JoinColumn(name = "job_advertisament_id")
        private JobAdvertisements jobAdvertisements;
    }


