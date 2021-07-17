package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Table name with user cannot be created check by removing attribute name
 * 
 * table name : user_collections_example_address (setters methdname is considered)
 * User_Collections_Example_userId column considered as foriegn key
 * 
 * User_Collections_Example_userId, area,        city,     pincode, state
 * 1	                           kalisipalya	 Hospet	    583201	karnataka
   1	 						   Pavan  office bangalore	583205	karnataka

 *userId, userName
 *	1	  First UserFROM GETTER  FROM GETTER  
 */

@Entity
@Table(name="user_collections_example")
public class User_Collections_Example {

	 //defines as primary key
	private int userId;
	private String userName;
	List<Address_Embeddable_Annotation> listOfAddress;
	
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
	
	
	public void setAddress(List<Address_Embeddable_Annotation> listOfAddress) {
		
		this.listOfAddress = listOfAddress;
	}
	
	//instead of column annotation-we are using emmbeded.so all columns in address table will be embedded
	//in User class
	@ElementCollection 
	public List<Address_Embeddable_Annotation> getAddress() {
		if(listOfAddress == null) {
			listOfAddress = new ArrayList<Address_Embeddable_Annotation>();
		}
		return listOfAddress;
	}
	
	@Override
	public String toString() {
		return "User_AttributeOverrides_Annotation [userId=" + userId + ", userName=" + userName + ", address=" + listOfAddress + "]";
	}
	
	
}
