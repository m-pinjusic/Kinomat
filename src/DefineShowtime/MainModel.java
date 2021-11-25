package DefineShowtime;

import java.io.Serializable;

import DefineHall.HallModel;
import DefineMovies.MoviesModel;

public class MainModel implements Serializable{
	private MoviesModel moviesModel;
	private HallModel hallModel;
	private ShowtimeModel showtimeModel;
	
	public MoviesModel getMoviesModel() {
		return moviesModel;
	}
	public void setMoviesModel(MoviesModel moviesModel) {
		this.moviesModel = moviesModel;
	}
	public HallModel getHallModel() {
		return hallModel;
	}
	public void setHallModel(HallModel hallModel) {
		this.hallModel = hallModel;
	}
	public ShowtimeModel getShowtimeModel() {
		return showtimeModel;
	}
	public void setShowtimeModel(ShowtimeModel showtimeModel) {
		this.showtimeModel = showtimeModel;
	}
}
