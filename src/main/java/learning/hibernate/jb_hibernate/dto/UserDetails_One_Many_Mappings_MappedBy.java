package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails_One_Many_Mappings_MappedBy {

	@Id //defines as primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	//instead of creating new table,it will map to vehicle table field
	@OneToMany(mappedBy="userDetails_One_Many_Mappings")
	private List<Vehicle_Many_One_MappedBy> vehicle;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Vehicle_Many_One_MappedBy> getVehicle() {
		if(vehicle == null) {
			vehicle = new ArrayList<Vehicle_Many_One_MappedBy>();
		}
		return vehicle;
	}
	public void setVehicle(List<Vehicle_Many_One_MappedBy> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "UserDetails_One_One_Mappings [userId=" + userId + ", userName=" + userName + ", vehicle=" + vehicle + "]";
	}
	
	
}
