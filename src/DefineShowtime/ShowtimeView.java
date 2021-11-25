package DefineShowtime;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import DefineHall.HallCTRL;
import DefineHall.HallModel;
import DefineMovies.MoviesCTRL;
import DefineMovies.MoviesModel;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;

public class ShowtimeView {
	
	ShowtimeCTRL showtimeCTRL = new ShowtimeCTRL();
	ShowtimeModel showtimeModel = new ShowtimeModel();
	HallCTRL hallCTRL = new HallCTRL();
	HallModel hallModel = new HallModel();
	MoviesCTRL moviesCTRL = new MoviesCTRL();
	MoviesModel moviesModel = new MoviesModel();
	
	MainModel mainModel = new MainModel();
	
	
	private List<MoviesModel> moviesList;
	private List<HallModel> hallList;
	private List<MainModel> mainList;

	protected Shell shlDefiniranjeTermina;
	private Text txtShowtimeHour;
	private Text txtShowtimeMin;
	private Text txtStatus;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ShowtimeView window = new ShowtimeView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDefiniranjeTermina.open();
		shlDefiniranjeTermina.layout();
		while (!shlDefiniranjeTermina.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDefiniranjeTermina = new Shell();
		shlDefiniranjeTermina.setSize(527, 394);
		shlDefiniranjeTermina.setText("Definiranje termina");
		
		
		
		Combo cmbHall = new Combo(shlDefiniranjeTermina, SWT.READ_ONLY);
		cmbHall.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if(cmbHall.getItemCount() != 0){
					txtShowtimeHour.setEnabled(true);
					txtShowtimeMin.setEnabled(true);
				 }
			}
		});
		
		hallList = showtimeCTRL.reachListHallModel();
		
		for (int index = 0; index < hallList.size(); index++) {
			cmbHall.add(hallList.get(index).getName(), index);
		}
		
		cmbHall.setEnabled(false);
		cmbHall.setBounds(10, 98, 173, 25);
		
		Combo cmbMovie = new Combo(shlDefiniranjeTermina, SWT.READ_ONLY);
		cmbMovie.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				if(cmbMovie.getItemCount() != 0){
					cmbHall.setEnabled(true);
				 }
			}
		});
		
		moviesList = showtimeCTRL.reachListMovieModel();
		
		for (int index = 0; index < moviesList.size(); index++) {
			cmbMovie.add(moviesList.get(index).getName(), index);
		}
		
		
		cmbMovie.setBounds(10, 40, 173, 25);
		
		Group grpIzmijenaIBrisanje = new Group(shlDefiniranjeTermina, SWT.NONE);
		grpIzmijenaIBrisanje.setText("Izmijena i brisanje termina");
		grpIzmijenaIBrisanje.setBounds(189, 108, 298, 156);
		
		Combo cmbIzmijeni = new Combo(grpIzmijenaIBrisanje, SWT.READ_ONLY);
		cmbIzmijeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = cmbIzmijeni.getSelectionIndex();
				txtStatus.setText(String.valueOf(index));
				mainModel = mainList.get(cmbIzmijeni.getSelectionIndex());
				txtShowtimeHour.setText("");
				txtShowtimeMin.setText("");
			}
		});
		
		Label lblOdaberiFilm = new Label(shlDefiniranjeTermina, SWT.NONE);
		lblOdaberiFilm.setBounds(10, 17, 85, 17);
		lblOdaberiFilm.setText("Odaberi film :");
		
		Label lblNewLabel = new Label(shlDefiniranjeTermina, SWT.NONE);
		lblNewLabel.setBounds(10, 160, 85, 17);
		lblNewLabel.setText("Termin filma");
		
		txtShowtimeHour = new Text(shlDefiniranjeTermina, SWT.BORDER);
		txtShowtimeHour.setEnabled(false);
		txtShowtimeHour.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		txtShowtimeHour.setBounds(10, 193, 40, 23);
		
		txtShowtimeMin = new Text(shlDefiniranjeTermina, SWT.BORDER);
		txtShowtimeMin.setEnabled(false);
		txtShowtimeMin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		txtShowtimeMin.setBounds(76, 193, 40, 23);
		
		Group grpDodajTermin = new Group(shlDefiniranjeTermina, SWT.NONE);
		grpDodajTermin.setText("Dodaj termin");
		grpDodajTermin.setBounds(189, 23, 298, 79);
		
		

		cmbIzmijeni.setBounds(10, 49, 189, 25);
		
		Button btnSpremiIzmjenu = new Button(grpIzmijenaIBrisanje, SWT.NONE);
		btnSpremiIzmjenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				HallModel hallModel = new HallModel();
				MoviesModel moviesModel = new MoviesModel();
				ShowtimeModel korisnickiUnos = new ShowtimeModel();
				
				moviesModel = moviesList.get(cmbMovie.getSelectionIndex());
				mainModel.setMoviesModel(moviesModel);
				
				hallModel = hallList.get(cmbHall.getSelectionIndex());
				mainModel.setHallModel(hallModel);
				
				int sameShowtime=0;
				for(int index=0;index<mainList.size();index++){
				
					if(mainList.get(index).getHallModel().getName().equals(cmbHall.getText())){
						if(Integer.valueOf(txtShowtimeHour.getText())==mainList.get(index).getShowtimeModel().getHour()){
							sameShowtime=1;	
						}
						
				}
				
				}
				
				if(txtShowtimeHour.getText().equals("")){
					txtStatus.setText("Sat termina nije unesen.");
				}
				else if(txtShowtimeMin.getText().equals("")){
					txtStatus.setText("Minuta termina nije unesena.");
				}
				else if(Integer.valueOf(txtShowtimeMin.getText())<0 ||Integer.valueOf(txtShowtimeHour.getText())>23){
					txtStatus.setText("Sati moraju biti u intervalu od 0-24.");
				}
				else if(Integer.valueOf(txtShowtimeMin.getText())<0 || Integer.valueOf(txtShowtimeMin.getText())>59){
					txtStatus.setText("Minute moraju biti u intervalu od 0-60");
				}
				else if(sameShowtime==1){
					txtStatus.setText("Termin u toj dvorani vec postoji");
				}
				else{
				korisnickiUnos.setHour(Integer.valueOf( txtShowtimeHour.getText()));
				korisnickiUnos.setMin(Integer.valueOf( txtShowtimeMin.getText()));
				mainModel.setShowtimeModel(korisnickiUnos);
				showtimeCTRL.change(mainModel, cmbIzmijeni.getSelectionIndex());
				
				cmbIzmijeni.setText(moviesModel.getName() +","+ String.valueOf(korisnickiUnos.getHour()+":"+ String.valueOf(korisnickiUnos.getMin() +"-"+ hallModel.getName())));
				cmbIzmijeni.setItem(cmbIzmijeni.getSelectionIndex(), moviesModel.getName() +","+ String.valueOf(korisnickiUnos.getHour()+":"+ String.valueOf(korisnickiUnos.getMin()+"-"+ hallModel.getName())));
				
				cmbIzmijeni.setText("");
				cmbMovie.setText("");
				cmbHall.setText("");
				txtShowtimeHour.setText("");
				txtShowtimeMin.setText("");
				}
			}
		});
		btnSpremiIzmjenu.setText("Spremi izmjenu");
		btnSpremiIzmjenu.setBounds(10, 89, 109, 27);
		
		Label lblOdaberiDvoranu = new Label(grpIzmijenaIBrisanje, SWT.NONE);
		lblOdaberiDvoranu.setText("Odaberi termin :");
		lblOdaberiDvoranu.setBounds(10, 26, 119, 17);
		
		
		
		Button btnObrii = new Button(grpIzmijenaIBrisanje, SWT.NONE);
		btnObrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showtimeCTRL.delete(mainModel);
				cmbIzmijeni.setText("");
				cmbIzmijeni.remove(cmbIzmijeni.getSelectionIndex());
				
				cmbMovie.setText("");
				cmbHall.setText("");
				txtShowtimeHour.setText("");
				txtShowtimeMin.setText("");
				
			}
		});
		btnObrii.setText("Obri\u0161i");
		btnObrii.setBounds(165, 89, 79, 27);
		
		
		Button btnNewShowtime = new Button(grpDodajTermin, SWT.NONE);
		btnNewShowtime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				HallModel hallModel = new HallModel();
				MoviesModel moviesModel = new MoviesModel();
				ShowtimeModel korisnickiUnos = new ShowtimeModel();
				
				moviesModel = moviesList.get(cmbMovie.getSelectionIndex());
				mainModel.setMoviesModel(moviesModel);
				
				hallModel = hallList.get(cmbHall.getSelectionIndex());
				mainModel.setHallModel(hallModel);
				
				int sameShowtime=0;
				for(int index=0;index<mainList.size();index++){
				
					if(mainList.get(index).getHallModel().getName().equals(cmbHall.getText())){
						if(Integer.valueOf(txtShowtimeHour.getText())==mainList.get(index).getShowtimeModel().getHour()){
							sameShowtime=1;	
						}
						
				}
				
				}
				if(txtShowtimeHour.getText().equals("")){
					txtStatus.setText("Sat termina nije unesen.");
				}
				else if(txtShowtimeMin.getText().equals("")){
					txtStatus.setText("Minuta termina nije unesena.");
				}
				
				else if(Integer.valueOf(txtShowtimeHour.getText())<0 ||Integer.valueOf(txtShowtimeHour.getText())>23){
					txtStatus.setText("Sati moraju biti u intervalu od 0-24.");
				}
				else if(Integer.valueOf(txtShowtimeMin.getText())<0 || Integer.valueOf(txtShowtimeMin.getText())>59){
					txtStatus.setText("Minute moraju biti u intervalu od 0-60");
				}
				else if(sameShowtime==1){
					txtStatus.setText("Termin u toj dvorani vec postoji");
				}
				else{
				korisnickiUnos.setHour(Integer.valueOf( txtShowtimeHour.getText()));
				korisnickiUnos.setMin(Integer.valueOf( txtShowtimeMin.getText()));
				mainModel.setShowtimeModel(korisnickiUnos);
				showtimeCTRL.putMainModel(mainModel);
				
				
				cmbIzmijeni.setText(moviesModel.getName() +","+ String.valueOf(korisnickiUnos.getHour()+":"+ String.valueOf(korisnickiUnos.getMin()+"-"+ hallModel.getName())));
				cmbIzmijeni.add(moviesModel.getName() +","+ String.valueOf(korisnickiUnos.getHour()+":"+ String.valueOf(korisnickiUnos.getMin()+"-"+ hallModel.getName())));
				cmbIzmijeni.select(cmbIzmijeni.getItemCount() - 1);
				
				cmbMovie.setText("");
				cmbHall.setText("");
				txtStatus.setText("");
				txtShowtimeHour.setText("");
				txtShowtimeMin.setText("");
				}
			}
		});
		mainList = showtimeCTRL.reachListMainModel();
		
		
		for (int index = 0; index < mainList.size(); index++) {
			cmbIzmijeni.add(mainList.get(index).getMoviesModel().getName() +","+ String.valueOf(mainList.get(index).getShowtimeModel().getHour())+":"+ String.valueOf(mainList.get(index).getShowtimeModel().getMin())+"-"+ mainList.get(index).getHallModel().getName(), index);
		}
		cmbIzmijeni.setText("");
		
		btnNewShowtime.setText("Dodaj novi termin");
		btnNewShowtime.setBounds(85, 30, 141, 27);
		
		txtStatus = new Text(shlDefiniranjeTermina, SWT.WRAP);
		txtStatus.setEditable(false);
		txtStatus.setBounds(10, 258, 154, 85);
		
		Label lblH = new Label(shlDefiniranjeTermina, SWT.NONE);
		lblH.setBounds(56, 196, 14, 17);
		lblH.setText("h :");
		
		Label lblNpr = new Label(shlDefiniranjeTermina, SWT.WRAP);
		lblNpr.setBounds(10, 222, 95, 23);
		lblNpr.setText("Npr. 16 : 40");
		
		Label lblMin = new Label(shlDefiniranjeTermina, SWT.NONE);
		lblMin.setText("min");
		lblMin.setBounds(122, 196, 27, 17);
		
		
		
		Label lblOdaberiDvoranu_1 = new Label(shlDefiniranjeTermina, SWT.NONE);
		lblOdaberiDvoranu_1.setBounds(10, 75, 123, 17);
		lblOdaberiDvoranu_1.setText("Odaberi dvoranu :");
		
		Button btnClose = new Button(shlDefiniranjeTermina, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDefiniranjeTermina.close();
			}
		});
		btnClose.setBounds(393, 294, 79, 27);
		btnClose.setText("Zatvori");

	}
}
