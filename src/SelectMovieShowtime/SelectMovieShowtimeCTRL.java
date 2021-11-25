package SelectMovieShowtime;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DefineMovies.MoviesModel;
import DefineShowtime.MainModel;

public class SelectMovieShowtimeCTRL {

	MainModel mainModel = new MainModel();
	private List<MainModel> listMainModel = new ArrayList<MainModel>();
	private List<MoviesModel> listMoviesModel = new ArrayList<MoviesModel>();
	
	public List<MoviesModel> reachListMoviesModel() {
		readFromData();
		
		return listMoviesModel;
			
	}
	
	public List<MainModel> reachListMainModel() {
		readFromDataMainModel();
		
		return listMainModel;
			
		
	}
	
	public void change(MainModel newMainModel, int index){
		
		listMainModel.set(index, newMainModel);
		saveToDataMainModel();
	
}
	
	@SuppressWarnings("unchecked")
	private void readFromData() {
		
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
}
