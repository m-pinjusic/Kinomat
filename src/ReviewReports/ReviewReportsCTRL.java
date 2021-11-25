package ReviewReports;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import DefineShowtime.MainModel;

public class ReviewReportsCTRL {
	
	MainModel mainModel = new MainModel();
	private List<MainModel> listMainModel = new ArrayList<MainModel>();
	
	public List<MainModel> reachListMainModel() {
		readFromDataMainModel();
		
		return listMainModel;
			
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
	
}
