package kodlamaio.hrms.entities.concrate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class Users {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	public Users(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

}
