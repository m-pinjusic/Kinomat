package DefineHall;

import java.io.Serializable;

public class HallModel implements Serializable {
	private String name;
	private int seatNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
}
