package kodlamaio.hrms.entities.concrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_schools")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class CandidateSchool {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "school_name")
    private String SchoolName;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name = "department")
    private String department;


    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy="candidate")
    private List<CandidateSchool> candidateSchools;




}
