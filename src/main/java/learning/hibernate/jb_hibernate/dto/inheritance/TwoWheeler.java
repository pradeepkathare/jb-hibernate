package learning.hibernate.jb_hibernate.dto.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="TwoWheeler")
@Table(name="FourWheeler")
public class TwoWheeler extends Vehicle {

	String handling;

	public String getHandling() {
		return handling;
	}

	public void setHandling(String handling) {
		this.handling = handling;
	}

	@Override
	public String toString() {
		return "TwoWheeler [handling=" + handling + "]";
	}
	
}
