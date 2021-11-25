package SelectMovieShowtime;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import DefineMovies.MoviesModel;
import DefineShowtime.MainModel;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class SelectMovieShowtimeView {

	MainModel mainModel = new MainModel();
	MoviesModel movieModels = new MoviesModel();
	private List<MainModel> mainList;
	private List<MoviesModel> moviesList;
	String nameOfMovie;
	private int IndexOfMainList;
	SelectMovieShowtimeCTRL selectMovieShowtimeCTRL= new SelectMovieShowtimeCTRL();
	Group[] GroupIndex;
	
	protected Shell shlOdabirFilma;
	private Combo cmbMovie;
	private Label lblOdaberiFilm;
	private Combo cmbShowtime;
	private Label lblTermin;
	private Text txtStatus;
	private Text txtMovieName;
	private Text txtYear;
	private Text txtDuration;
	private Text txtGenre;
	private Text txtCounry;
	private Text txtShowtime;
	private Text txtHall;
	private Text txtSeatNum;
	private Button btnReserev;
	private Label lblGodina;
	private Label lblTrajanje;
	private Label lblDrava;
	private Label lblanr;
	private Label lblTermin_1;
	private Label lblDvorana;
	private Label lblBrojSjedala;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SelectMovieShowtimeView window = new SelectMovieShowtimeView();
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
		shlOdabirFilma.open();
		shlOdabirFilma.layout();
		while (!shlOdabirFilma.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlOdabirFilma = new Shell();
		shlOdabirFilma.setSize(804, 455);
		shlOdabirFilma.setText("Odaberi film");
		
	
		
		Button btnZatvori = new Button(shlOdabirFilma, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlOdabirFilma.close();
			}
		});
		
		
		
		btnZatvori.setBounds(616, 341, 79, 27);
		btnZatvori.setText("Zatvori");
		
		cmbMovie = new Combo(shlOdabirFilma, SWT.READ_ONLY);
		cmbMovie.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cmbShowtime.removeAll();
				nameOfMovie=cmbMovie.getText();
				
				mainList = selectMovieShowtimeCTRL.reachListMainModel();
				
				for (int index = 0; index < mainList.size(); index++) {
					if(mainList.get(index).getMoviesModel().getName().equals(nameOfMovie)){
						
					cmbShowtime.add(mainList.get(index).getShowtimeModel().getHour()+":"+mainList.get(index).getShowtimeModel().getMin());
					}
					}
			}
		});
		cmbMovie.setBounds(28, 60, 226, 25);
		
		lblOdaberiFilm = new Label(shlOdabirFilma, SWT.NONE);
		lblOdaberiFilm.setBounds(28, 27, 113, 17);
		lblOdaberiFilm.setText("Odaberi film :");
		
		cmbShowtime = new Combo(shlOdabirFilma, SWT.READ_ONLY);
		cmbShowtime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mainList = selectMovieShowtimeCTRL.reachListMainModel();
				int random=0;
				int [] broj = new int [mainList.size()];
				for (int index = 0; index < mainList.size(); index++) {
					if(mainList.get(index).getMoviesModel().getName().equals(nameOfMovie)){
						broj[random]=index;
						random=random+1;
					//cmbShowtime.add(mainList.get(index).getShowtimeModel().getHour()+":"+mainList.get(index).getShowtimeModel().getMin());
					}
				}
				int select=cmbShowtime.getSelectionIndex();
				txtStatus.setText(String.valueOf(broj[select]));
				IndexOfMainList=broj[select];
				txtMovieName.setText(mainList.get(broj[select]).getMoviesModel().getName());
				txtYear.setText(String.valueOf(mainList.get(broj[select]).getMoviesModel().getYear()));
				txtDuration.setText(String.valueOf(mainList.get(broj[select]).getMoviesModel().getDuration()));
				txtCounry.setText(mainList.get(broj[select]).getMoviesModel().getCountry());
				txtGenre.setText(mainList.get(broj[select]).getMoviesModel().getGenres1()+"  "+mainList.get(broj[select]).getMoviesModel().getGenres2()+" "+mainList.get(broj[select]).getMoviesModel().getGenres3());
				txtShowtime.setText(String.valueOf(mainList.get(broj[select]).getShowtimeModel().getHour())+":"+String.valueOf(mainList.get(broj[select]).getShowtimeModel().getMin()));
				txtHall.setText(mainList.get(broj[select]).getHallModel().getName());
				txtSeatNum.setText(String.valueOf(mainList.get(broj[select]).getHallModel().getSeatNum()));
				
			}
		});
		cmbShowtime.setBounds(28, 140, 226, 25);
		
		lblTermin = new Label(shlOdabirFilma, SWT.NONE);
		lblTermin.setBounds(27, 117, 61, 17);
		lblTermin.setText("Termin :");
		
		txtStatus = new Text(shlOdabirFilma, SWT.READ_ONLY);
		txtStatus.setBounds(28, 203, 226, 23);
		
		txtMovieName = new Text(shlOdabirFilma, SWT.READ_ONLY);
		txtMovieName.setFont(SWTResourceManager.getFont("Segoe UI", 17, SWT.BOLD | SWT.ITALIC));
		txtMovieName.setBounds(339, 10, 399, 54);
		
		txtYear = new Text(shlOdabirFilma, SWT.NONE);
		txtYear.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtYear.setEditable(false);
		txtYear.setBounds(339, 85, 76, 23);
		
		txtDuration = new Text(shlOdabirFilma, SWT.NONE);
		txtDuration.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtDuration.setEditable(false);
		txtDuration.setBounds(438, 85, 50, 23);
		
		txtGenre = new Text(shlOdabirFilma, SWT.NONE);
		txtGenre.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtGenre.setEditable(false);
		txtGenre.setBounds(339, 140, 253, 23);
		
		txtCounry = new Text(shlOdabirFilma, SWT.NONE);
		txtCounry.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtCounry.setEditable(false);
		txtCounry.setBounds(532, 85, 76, 23);
		
		txtShowtime = new Text(shlOdabirFilma, SWT.NONE);
		txtShowtime.setEditable(false);
		txtShowtime.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		txtShowtime.setBounds(339, 203, 123, 37);
		
		txtHall = new Text(shlOdabirFilma, SWT.NONE);
		txtHall.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		txtHall.setEditable(false);
		txtHall.setBounds(510, 203, 123, 37);
		
		txtSeatNum = new Text(shlOdabirFilma, SWT.NONE);
		txtSeatNum.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtSeatNum.setEditable(false);
		txtSeatNum.setBounds(662, 197, 76, 23);
		
		btnReserev = new Button(shlOdabirFilma, SWT.NONE);
		btnReserev.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//mainList = selectMovieShowtimeCTRL.reachListMainModel();
				if(mainList.get(IndexOfMainList).getHallModel().getSeatNum()==0){
					txtStatus.setText("Dvorana je puna.");
				}
				else{
				int taken=mainList.get(IndexOfMainList).getHallModel().getSeatNum()-1;
				mainList.get(IndexOfMainList).getHallModel().setSeatNum(taken);
				txtMovieName.setText("");
				txtYear.setText("");
				txtDuration.setText("");
				txtCounry.setText("");
				txtGenre.setText("");
				txtShowtime.setText("");
				txtHall.setText("");
				txtSeatNum.setText("");
				txtStatus.setText("Karta je rezervirana");
				selectMovieShowtimeCTRL.change(mainList.get(IndexOfMainList), IndexOfMainList);
				}
			}
				
			
		});
		btnReserev.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnReserev.setBounds(336, 289, 189, 79);
		btnReserev.setText("REZERVIRAJ");
		
		lblGodina = new Label(shlOdabirFilma, SWT.NONE);
		lblGodina.setBounds(338, 68, 61, 17);
		lblGodina.setText("Godina");
		
		lblTrajanje = new Label(shlOdabirFilma, SWT.NONE);
		lblTrajanje.setBounds(438, 68, 61, 17);
		lblTrajanje.setText("Trajanje");
		
		lblDrava = new Label(shlOdabirFilma, SWT.NONE);
		lblDrava.setBounds(532, 68, 61, 17);
		lblDrava.setText("Dr\u017Eava");
		
		lblanr = new Label(shlOdabirFilma, SWT.NONE);
		lblanr.setBounds(339, 117, 61, 17);
		lblanr.setText("\u017Danr");
		
		lblTermin_1 = new Label(shlOdabirFilma, SWT.NONE);
		lblTermin_1.setBounds(338, 182, 61, 17);
		lblTermin_1.setText("Termin");
		
		lblDvorana = new Label(shlOdabirFilma, SWT.NONE);
		lblDvorana.setBounds(510, 180, 61, 17);
		lblDvorana.setText("Dvorana");
		
		lblBrojSjedala = new Label(shlOdabirFilma, SWT.NONE);
		lblBrojSjedala.setBounds(662, 180, 76, 17);
		lblBrojSjedala.setText("Broj sjedala");
		
		moviesList = selectMovieShowtimeCTRL.reachListMoviesModel();
		
		for (int index = 0; index < moviesList.size(); index++) {
			cmbMovie.add(moviesList.get(index).getName(), index);
		}
		
		

		/*
		int size=mainList.size();
		for(int index=0;index<size;index++){
			tableItem = new TableItem(tableReview, SWT.NONE);
			tableItem.setText(mainList.get(index).getMoviesModel().getName());
			tableItem.setText(1, mainList.get(index).getMoviesModel().getGenres1()+" "+mainList.get(index).getMoviesModel().getGenres2()+" "+mainList.get(index).getMoviesModel().getGenres3());
			tableItem.setText(2, String.valueOf(mainList.get(index).getMoviesModel().getYear()));
			tableItem.setText(3, mainList.get(index).getMoviesModel().getCountry());
			tableItem.setText(4, String.valueOf(mainList.get(index).getMoviesModel().getDuration())+" min");
			tableItem.setText(5, mainList.get(index).getHallModel().getName());
			tableItem.setText(6, String.valueOf(mainList.get(index).getShowtimeModel().getHour())+":"+String.valueOf(mainList.get(index).getShowtimeModel().getMin()));
			tableItem.setText(7, String.valueOf(mainList.get(index).getHallModel().getSeatNum()));
		}
		*/
			

	}
}
