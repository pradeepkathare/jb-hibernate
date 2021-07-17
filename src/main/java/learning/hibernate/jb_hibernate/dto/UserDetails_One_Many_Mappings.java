package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class UserDetails_One_Many_Mappings {

	@Id //defines as primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@OneToMany
	@JoinTable(name="user_vehicle_one_many" ,joinColumns=@JoinColumn(name="user_details_user_id"),
	inverseJoinColumns=@JoinColumn(name="vehicle_vechile_id"))
	private List<Vehicle> vehicle;
	
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
	public List<Vehicle> getVehicle() {
		if(vehicle == null) {
			vehicle = new ArrayList<Vehicle>();
		}
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "UserDetails_One_One_Mappings [userId=" + userId + ", userName=" + userName + ", vehicle=" + vehicle + "]";
	}
	
	
}
