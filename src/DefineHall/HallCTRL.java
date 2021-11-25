package DefineHall;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class HallCTRL {
	private List<HallModel> listHallModel = new ArrayList<HallModel>();
	
	public List<HallModel> reachListHallModel() {
		readFromData();
		
		return listHallModel;
			
	}
	
	public void saveHall(HallModel newHall){		
		
		int index = listHallModel.indexOf(newHall);
		
		if (index >= 0) {
			
			listHallModel.set(index, newHall);
			saveToData();
	
		}
	}
	
	public void change(HallModel newHall, int index){
		
			
			listHallModel.set(index, newHall);
			saveToData();
		
	}
	
	public void delete (HallModel newHall) {
		
		int index = listHallModel.indexOf(newHall);
		//index=index + 1;
		if(index >=0){
			
			listHallModel.remove(index);
			saveToData();
			System.out.println(listHallModel.size());
			
		}
	}
	
	public void putHall(HallModel newHall){
		listHallModel.add(newHall);
		saveToData();
		
	}
	
	@SuppressWarnings("resource")
	private void saveToData(){
		try {
			FileOutputStream putInData = new FileOutputStream("hall.dat");
			ObjectOutput putObject = new ObjectOutputStream(putInData);
			putObject.writeObject (listHallModel);
		} catch (IOException e){
			//e.printStackTrace();
		}
		System.out.println(listHallModel.size());

	}
	
	@SuppressWarnings("unchecked")
	private void readFromData() {
		
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
	
}
