package Kinomat_App;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import DefineHall.HallView;
import DefineMovies.MoviesView;
import DefineShowtime.ShowtimeView;
import ReviewReports.ReviewReportsView;
import SelectMovieShowtime.SelectMovieShowtimeView;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class KinomatApp {

	protected Shell shlKinomat;
	private Text txtMovieManager;
	private Text txtPass;
	private Text txtStatus;
	private String status="";
	private String managerName="marin";
	private String password="11";

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			KinomatApp window = new KinomatApp();
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
		shlKinomat.open();
		shlKinomat.layout();
		while (!shlKinomat.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlKinomat = new Shell();
		shlKinomat.setSize(700, 430);
		shlKinomat.setText("Kinomat");
		
		Button btnSelectMovie = new Button(shlKinomat, SWT.NONE);
		btnSelectMovie.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			SelectMovieShowtimeView selectMovieShowtimeView = new SelectMovieShowtimeView();
			selectMovieShowtimeView.open();
			
			}
		});
		btnSelectMovie.setBounds(54, 58, 219, 120);
		btnSelectMovie.setText("Odaberi film");
		
		txtMovieManager = new Text(shlKinomat, SWT.BORDER);
		txtMovieManager.setBounds(381, 53, 117, 23);
		
		txtPass = new Text(shlKinomat, SWT.BORDER);
		txtPass.setBounds(527, 53, 117, 23);
		
		Button btnDefinineMovies = new Button(shlKinomat, SWT.NONE);
		btnDefinineMovies.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(txtMovieManager.getText().equals(managerName) && txtPass.getText().equals(password)){
					status="Ispravno uneseni podaci.";
					txtStatus.setText(status);
					MoviesView moviesView = new MoviesView();
					moviesView.open();
				}
				else{
				status="Greška:\nNeispravno uneseno ime menađera ili zaporke.";
				txtStatus.setText(status);
				}
				
			}
		});
		btnDefinineMovies.setBounds(433, 151, 169, 27);
		btnDefinineMovies.setText("Definiranje filmova");
		
		Button btnDefineHall = new Button(shlKinomat, SWT.NONE);
		btnDefineHall.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(txtMovieManager.getText().equals(managerName) && txtPass.getText().equals(password)){
					status="Ispravno uneseni podaci.";
					txtStatus.setText(status);
					HallView hallView = new HallView();
					hallView.open();
					
				}
				else{
				status="Greška:\nNeispravno uneseno ime menađera ili zaporke.";
				txtStatus.setText(status);
				}
				
			}
		});
		btnDefineHall.setBounds(433, 195, 169, 27);
		btnDefineHall.setText("Definiranje dvorane");
		
		Button btnDefineShowtime = new Button(shlKinomat, SWT.NONE);
		btnDefineShowtime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(txtMovieManager.getText().equals(managerName) && txtPass.getText().equals(password)){
					status="Ispravno uneseni podaci.";
					txtStatus.setText(status);
					ShowtimeView showtimeView = new ShowtimeView();
					showtimeView.open();
					
				}
				else{
				status="Greška:\nNeispravno uneseno ime menađera ili zaporke.";
				txtStatus.setText(status);
				}
				
			}
		});
		btnDefineShowtime.setBounds(433, 240, 169, 27);
		btnDefineShowtime.setText("Definiranje termina filma");
		
		Button btnReviewReports = new Button(shlKinomat, SWT.NONE);
		btnReviewReports.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(txtMovieManager.getText().equals(managerName) && txtPass.getText().equals(password)){
					status="Ispravno uneseni podaci.";
					txtStatus.setText(status);
					ReviewReportsView reviewReportsView = new ReviewReportsView();
					reviewReportsView.open();
				}
				else{
				status="Greška:\nNeispravno uneseno ime menađera ili zaporke.";
				txtStatus.setText(status);
				}
				
			}
		});
		btnReviewReports.setBounds(433, 288, 169, 27);
		btnReviewReports.setText("Pregled izvje\u0161taja");
		
		Label lblImeMenaeraKina = new Label(shlKinomat, SWT.NONE);
		lblImeMenaeraKina.setBounds(381, 30, 117, 17);
		lblImeMenaeraKina.setText("Ime menadžera kina :");
		
		Label lblSifra = new Label(shlKinomat, SWT.NONE);
		lblSifra.setBounds(527, 30, 61, 17);
		lblSifra.setText("Zaporka :");
		
		Label label = new Label(shlKinomat, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(340, 0, 2, 389);
		
		txtStatus = new Text(shlKinomat, SWT.WRAP);
		txtStatus.setEnabled(false);
		txtStatus.setEditable(false);
		txtStatus.setBounds(360, 90, 302, 55);
		
		Button btnZatvori = new Button(shlKinomat, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlKinomat.close();
			}
		});
		btnZatvori.setBounds(565, 352, 79, 27);
		btnZatvori.setText("Zatvori");

	}
}
