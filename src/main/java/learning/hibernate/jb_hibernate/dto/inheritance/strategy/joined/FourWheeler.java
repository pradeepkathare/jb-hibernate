package learning.hibernate.jb_hibernate.dto.inheritance.strategy.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="FourWheeler")
@Table(name="FourWheeler_inherit_joined")
@DiscriminatorValue(value="FourWheeler_class")
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
