package learning.hibernate.jb_hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="C_16_Vehicle_Cascade")
@Table(name="vehicle_NotFound")
public class C_16_Vehicle_Cascade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;

	@ManyToOne
	C_16_UserDetails_Cascade user ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public C_16_UserDetails_Cascade getUser() {
		return user;
	}

	public void setUser(C_16_UserDetails_Cascade user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "C_16_Vehicle_Cascade [id=" + id + ", name=" + name + ", user=" + user + "]";
	}

	
	
}
