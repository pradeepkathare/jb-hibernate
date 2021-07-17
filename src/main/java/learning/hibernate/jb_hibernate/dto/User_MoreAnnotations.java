package learning.hibernate.jb_hibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/*
 * Table name with user cannot be created check by removing attribute name:in mysql still works but not best pratices
 * 
 */
@Entity
@Table(name="user_info")
public class User_MoreAnnotations {

	 //defines as primary key
	private int userId;
	private  String userName;
	private Date joinedDate;
	private String address;
	private String description;
	
	
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
		return userName +" FROM GETTER 	";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column
	@Temporal(TemporalType.DATE) 
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	@Column(name = "address" ,length=500) //to increase length of the field in table by default : 255 : Not working as of now
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column
	@Transient
	@Lob //for large object when length varies
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "User_MoreAnnotations [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate
				+ ", address=" + address + ", description=" + description + "]";
	}
	
	
}
