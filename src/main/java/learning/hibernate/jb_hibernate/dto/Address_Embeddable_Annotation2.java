package learning.hibernate.jb_hibernate.dto;

import javax.persistence.Embeddable;
/*
 * separate table will not be created and mapping is not required in hibernate-cfg.xml
 * after 
 */
@Embeddable
public class Address_Embeddable_Annotation2 {

	long addressID;
	String area;
	String city;
	String state;
	String pincode;
	
	public void setId(long id) {
		this.addressID = id;
	}
	
	public long getId() {
		return addressID;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address_Embeddable_Annotation [area=" + area + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	
	
}
