package DefineShowtime;

import java.io.Serializable;

public class ShowtimeModel implements Serializable{
	private int hour;
	private int min;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
}
