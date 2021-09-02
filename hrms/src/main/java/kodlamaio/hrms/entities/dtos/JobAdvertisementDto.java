package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementDto {

	private String companyName;
	private String position;
	private String phoneNumber;
	private String cityName;
	private int numberOfPosition;
	private Date createDate;
	private Date deadLine;
	private String wayOfWorkingName;
	private String workingTimeName;
	private String jobDesciription;
	private int minSalary;
	private int maxSalary;

}
