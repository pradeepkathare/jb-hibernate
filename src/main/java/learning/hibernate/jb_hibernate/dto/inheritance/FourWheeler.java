package learning.hibernate.jb_hibernate.dto.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="FourWheeler")
@Table(name="FourWheeler")
public class FourWheeler extends Vehicle{

	String Sterring;

	public String getSterring() {
		return Sterring;
	}

	public void setSterring(String sterring) {
		Sterring = sterring;
	}

	@Override
	public String toString() {
		return "FourWheeler [Sterring=" + Sterring + "]";
	}
	
	
}
