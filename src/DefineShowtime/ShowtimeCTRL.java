package DefineShowtime;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DefineMovies.MoviesModel;
import DefineHall.HallModel;

public class ShowtimeCTRL {
	
	MainModel mainModel = new MainModel();
	private List<MainModel> listMainModel = new ArrayList<MainModel>();
	private List<ShowtimeModel> listShowtimeModel = new ArrayList<ShowtimeModel>();
	private List<HallModel> listHallModel = new ArrayList<HallModel>();
	private List<MoviesModel> listMoviesModel = new ArrayList<MoviesModel>();
	
	public List<MoviesModel> reachListMovieModel() {
		readFromDataMovies();
		
		return listMoviesModel;
			
	}
	public List<HallModel> reachListHallModel() {
		readFromDataHall();
		
		return listHallModel;
			
	}
	public List<MainModel> reachListMainModel() {
		readFromDataMainModel();
		
		return listMainModel;
			
	}
	
	public void saveMainModel(MainModel newMainModel){		
		
		int index = listShowtimeModel.indexOf(newMainModel);
		
		if (index >= 0) {
			listMainModel.set(index, newMainModel);
			saveToDataMainModel();
	
		}
	}
	
	public void change(MainModel newMainModel, int index){
		
			listMainModel.set(index, newMainModel);
			saveToDataMainModel();
		
	}
	
	public void delete (MainModel newMainModel) {
		
		int index = listMainModel.indexOf(newMainModel);
		//index=index + 1;
		if(index >=0){
			
			listMainModel.remove(index);
			saveToDataMainModel();
			System.out.println(listMainModel.size());
			
		}
	}
	
	
	public void putMainModel(MainModel newMainModel){
		listMainModel.add(newMainModel);
		saveToDataMainModel();
		
	}	
	
	@SuppressWarnings("resource")
	private void saveToDataMainModel(){
		try {
			FileOutputStream putInData = new FileOutputStream("mainmodel.dat");
			ObjectOutput putObject = new ObjectOutputStream(putInData);
			putObject.writeObject (listMainModel);
		} catch (IOException e){
			//e.printStackTrace();
		}
		System.out.println(listMainModel.size());

	}
	
	@SuppressWarnings("unchecked")
	private void readFromDataMainModel() {
		
		try {
			FileInputStream readData = new FileInputStream("mainmodel.dat");
			if (readData.available() > 0) {
				@SuppressWarnings("resource")
				ObjectInputStream readObject = new ObjectInputStream (readData);
				listMainModel = (List<MainModel>) readObject.readObject();
			}
		} catch (ClassNotFoundException e){
			//e.printStackTrace();
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	/*TERMINI*/
	
	
	/*  DVORANE*/
	
	@SuppressWarnings("unchecked")
	private void readFromDataHall() {
		
		try {
			FileInputStream readData = new FileInputStream("hall.dat");
			if (readData.available() > 0) {
				@SuppressWarnings("resource")
				ObjectInputStream readObject = new ObjectInputStream (readData);
				listHallModel = (List<HallModel>) readObject.readObject();
			}
		} catch (ClassNotFoundException e){
			//e.printStackTrace();
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	
	/*FILMOVI*/
	
	
	@SuppressWarnings("unchecked")
	private void readFromDataMovies() {
		
		try {
			FileInputStream readData = new FileInputStream("movies.dat");
			if (readData.available() > 0) {
				@SuppressWarnings("resource")
				ObjectInputStream readObject = new ObjectInputStream (readData);
				listMoviesModel = (List<MoviesModel>) readObject.readObject();
			}
		} catch (ClassNotFoundException e){
			//e.printStackTrace();
		} catch (IOException e){
			//e.printStackTrace();
		}
	}

	
	
	
}
