package learning.hibernate.jb_hibernate.dto.criteriaApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details_crud")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String Address; //try this with collection and Address class itself
	
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
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + "]";
	}
	
	
}
