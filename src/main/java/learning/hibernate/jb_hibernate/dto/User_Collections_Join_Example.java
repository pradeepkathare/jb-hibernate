package learning.hibernate.jb_hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
/*
 * Table name with user cannot be created check by removing attribute name
 * SELECT * FROM hibernatedb.user_address_joined;
USER_COLLECTION_ANNOTATION_ID	area			city		pincode		state
1								kalisipalya		Hospet		583201		karnataka
1								Pavan  office	bangalore	583205		karnataka

SELECT * FROM hibernatedb.user_collections_join_example;
 *userId, userName
 *	1	  First UserFROM GETTER  FROM GETTER
 *   
 */
import org.hibernate.annotations.Type;

@Entity
@Table(name="user_collections_join_example")
public class User_Collections_Join_Example {

	 //defines as primary key
	private int userId;
	private String userName;
	List<Address_Embeddable_Annotation2> listOfAddress;
	
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
	@Column(length=5)
	public String getUserName() {
		return userName +"FROM GETTER 	";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void setAddress(List<Address_Embeddable_Annotation2> listOfAddress) {
		
		this.listOfAddress = listOfAddress;
	}
	
	//instead of column annotation-we are using emmbeded.so all columns in address table will be embedded
	//in User class
	@ElementCollection(fetch=FetchType.EAGER) 
	@JoinTable(name="USER_ADDRESS_JOINED", joinColumns= @JoinColumn(name="USER_COLLECTION_ANNOTATION_ID" ,insertable=false, updatable=false))
	@CollectionId(columns = { @Column(name="addressID") }, generator = "sequence-gen", type = @Type(type="long"))
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	public List<Address_Embeddable_Annotation2> getAddress() {
		if(listOfAddress == null) {
			listOfAddress = new ArrayList<Address_Embeddable_Annotation2>();
		}
		return listOfAddress;
	}
	
	@Override
	public String toString() {
		return "User_AttributeOverrides_Annotation [userId=" + userId + ", userName=" + userName + ", address=" + listOfAddress.size() + "]";
	}
	
	
}
