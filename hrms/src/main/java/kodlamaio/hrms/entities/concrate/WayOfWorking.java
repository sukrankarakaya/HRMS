package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "way_of_working")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "way_of_working_id", referencedColumnName = "id")


public class WayOfWorking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String wayOfWorkingName;

    @JsonIgnore
    @OneToMany(mappedBy="wayOfWorking")
    private List<JobAdvertisements> jobAdvertisements;


}
