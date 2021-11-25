package DefineMovies;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MoviesCTRL {
	
	private List<MoviesModel> listMoviesModel = new ArrayList<MoviesModel>();
	
	public List<MoviesModel> reachListMoviesModel() {
		readFromData();
		
		return listMoviesModel;
			
	}
	
	public void saveMovie(MoviesModel newMovie){		
		
		int index = listMoviesModel.indexOf(newMovie);
		
		if (index >= 0) {
			
			listMoviesModel.set(index, newMovie);
			saveToData();
	
		}
	}
	
	public void change(MoviesModel newMovie, int index){
		
			
			listMoviesModel.set(index, newMovie);
			saveToData();
		
	}
	
	public void delete (MoviesModel newMovie) {
		
		int index = listMoviesModel.indexOf(newMovie);
		//index=index + 1;
		if(index >=0){
			
			listMoviesModel.remove(index);
			saveToData();
			System.out.println(listMoviesModel.size());
			
		}
	}
	
	public void putMovie(MoviesModel newMovie){
		listMoviesModel.add(newMovie);
		saveToData();
		
	}
	
	@SuppressWarnings("resource")
	private void saveToData(){
		try {
			FileOutputStream putInData = new FileOutputStream("movies.dat");
			ObjectOutput putObject = new ObjectOutputStream(putInData);
			putObject.writeObject (listMoviesModel);
		} catch (IOException e){
			//e.printStackTrace();
		}
		System.out.println(listMoviesModel.size());

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
	

}

