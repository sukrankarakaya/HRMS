package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "working_times")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "working_time_id", referencedColumnName = "id")

public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String workingTimeName;

    @JsonIgnore
    @OneToMany(mappedBy="workingTime")
    private List<JobAdvertisements> jobAdvertisements;

}
