package learning.hibernate.jb_hibernate.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Table name with user cannot be created check by removing attribute name
 * usecase : 2 address type fields,conflicts to create column only once.so use attribute-override to rename fields and
 * columns wll be created
 */
@Entity
@Table(name="user_attribute_overrides_annotation")
public class User_AttributeOverrides_Annotation {

	//User_Embedded_Annotation
	 //defines as primary key
	private int userId;
	private String userName;
	private Address_Embeddable_Annotation homeAddress;
	
	private Address_Embeddable_Annotation officeAddress;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId") //as of now giving same name as field but we can change accordingly
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	//if u dont specify name attribute,it will still considers fieldname as column-name but as getter injection
	@Column 
	public String getUserName() {
		return userName +"FROM GETTER 	";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//overrides all column names for home address and for office keep as usual/override
	@AttributeOverrides({
		@AttributeOverride(name="area" ,column=@Column(name="home_area")),
		@AttributeOverride(name="city" ,column=@Column(name="home_city")),
		@AttributeOverride(name="state" ,column=@Column(name="home_state")),
		@AttributeOverride(name="pincode" ,column=@Column(name="home_pincode")),
		
	})
	public Address_Embeddable_Annotation getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address_Embeddable_Annotation homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@AttributeOverrides({
		@AttributeOverride(name="area" ,column=@Column(name="office_area")),
		@AttributeOverride(name="city" ,column=@Column(name="office_city")),
		@AttributeOverride(name="state" ,column=@Column(name="office_state")),
		@AttributeOverride(name="pincode" ,column=@Column(name="office_pincode")),
		
	})
	public Address_Embeddable_Annotation getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address_Embeddable_Annotation officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
