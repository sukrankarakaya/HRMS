package kodlamaio.hrms.entities.concrate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employers_activation_by_employees")
@Data

public class EmployersActivationByEmployees {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;

	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="is_confirmed")
	private boolean isCofimed;
	
	@Column(name="confirm_date")
	private Date confirmDate;
	
	
	public EmployersActivationByEmployees(int id, int employerId, int employeeId, boolean isCofimed, Date confirmDate) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.employeeId = employeeId;
		this.isCofimed = isCofimed;
		this.confirmDate = confirmDate;
	}
	

}
