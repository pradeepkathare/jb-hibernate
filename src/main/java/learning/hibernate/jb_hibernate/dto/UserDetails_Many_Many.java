package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="user_many_many")
@Table(name="user_many_many")
public class UserDetails_Many_Many {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	@ManyToMany(mappedBy="user")
	Collection<Vehicle_Many_Many> vehicles = new ArrayList<Vehicle_Many_Many>();

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

	public Collection<Vehicle_Many_Many> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle_Many_Many> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "UserDetails_Many_Many [id=" + id + ", name=" + name + ", vehicles=" + vehicles + "]";
	}
	

	
}
