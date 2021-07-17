package learning.hibernate.jb_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Vehicle_Many_One")
@Table(name="Vehicle_Many_One")
public class Vehicle_Many_One_MappedBy {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column
	String vehicleName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	UserDetails_One_Many_Mappings_MappedBy userDetails_One_Many_Mappings;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public UserDetails_One_Many_Mappings_MappedBy getUserDetails_One_Many_Mappings() {
		return userDetails_One_Many_Mappings;
	}
	
	public void setUserDetails_One_Many_Mappings(UserDetails_One_Many_Mappings_MappedBy userDetails_One_Many_Mappings) {
		this.userDetails_One_Many_Mappings = userDetails_One_Many_Mappings;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleName=" + vehicleName + "]";
	}
	
	
}
