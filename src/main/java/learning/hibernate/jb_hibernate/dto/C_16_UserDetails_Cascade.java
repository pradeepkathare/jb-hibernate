package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_details_notFound")
public class C_16_UserDetails_Cascade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String userName;
	//mappedBy= "user",
	@OneToMany(cascade=CascadeType.PERSIST)
	List<C_16_Vehicle_Cascade> vehicle = new ArrayList() ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<C_16_Vehicle_Cascade> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<C_16_Vehicle_Cascade> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "C_16_UserDetails_Cascade [id=" + id + ", userName=" + userName + ", vehicle=" + vehicle
				+ "]";
	}
	
	
	
	
}
