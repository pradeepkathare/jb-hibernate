package learning.hibernate.jb_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Table name with user cannot be created check by removing attribute name
 */
@Entity
@Table(name="user_embedded_annotation")
public class User_Embedded_Annotation {

	 //defines as primary key
	private int userId;
	private String userName;
	Address_Embeddable_Annotation address;
	
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
	
	
	public void setAddress(Address_Embeddable_Annotation address) {
		this.address = address;
	}
	
	//instead of column annotation-we are using emmbeded.so all columns in address table will be embedded
	//in User class
	@Embedded 
	public Address_Embeddable_Annotation getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "User_AttributeOverrides_Annotation [userId=" + userId + ", userName=" + userName + ", address=" + address + "]";
	}
	
	
}
