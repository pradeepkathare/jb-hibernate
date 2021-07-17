package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "vehicle_many_many")
@Table(name = "vehicle_many_many")
public class Vehicle_Many_Many {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	String vehicleName;

	@ManyToMany
	@JoinTable(name="user_vehicle_many_many")
	@JoinColumns(value=@JoinColumn(name="vehicle_id",referencedColumnName="user_id"))
	Collection<UserDetails_Many_Many> user = new ArrayList<UserDetails_Many_Many>();
	
	public Collection<UserDetails_Many_Many> getUser() {
		return user;
	}

	public void setUser(Collection<UserDetails_Many_Many> user) {
		this.user = user;
	}

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

	@Override
	public String toString() {
		return "Vehicle_Many_Many [id=" + id + ", vehicleName=" + vehicleName + "]";
	}

}
