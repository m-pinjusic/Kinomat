package DefineMovies;

import java.io.Serializable;

public class MoviesModel implements Serializable{
	private String name;
	private String genres1;
	private String genres2;
	private String genres3;
	private int year;
	private String country;
	private int duration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenres1() {
		return genres1;
	}
	public void setGenres1(String genres1) {
		this.genres1 = genres1;
	}
	public String getGenres2() {
		return genres2;
	}
	public void setGenres2(String genres2) {
		this.genres2 = genres2;
	}
	public String getGenres3() {
		return genres3;
	}
	public void setGenres3(String genres3) {
		this.genres3 = genres3;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
