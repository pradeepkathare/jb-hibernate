package learning.hibernate.jb_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*
 * Table name with user cannot be created check by removing attribute name
 */
@Entity(name="USER_DETAILS")
public class User {

	 //defines as primary key
	private int userId;
	private String userName;
	
	@Id
	@Column(name="userId") //as of now giving same name as field but we can change accordingly
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	@Column //if u dont specify name attribute,it will still considers fieldname as column-name but as getter injection
	public String getUserName() {
		return userName +"FROM GETTER 	";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
}
