package DefineMovies;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class MoviesView {

	MoviesCTRL moviesCTRL = new MoviesCTRL();
	MoviesModel moviesModel = new MoviesModel();
	private List<MoviesModel> moviesList;
	
	protected Shell shlDefiniranjeFilmova;
	private Text txtName;
	private Text txtGenre1;
	private Text txtGenre2;
	private Text txtGenre3;
	private Text txtYear;
	private Text txtCountry;
	private Text txtDuration;
	private Text txtStatus;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MoviesView window = new MoviesView();
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
		shlDefiniranjeFilmova.open();
		shlDefiniranjeFilmova.layout();
		while (!shlDefiniranjeFilmova.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlDefiniranjeFilmova = new Shell();
		shlDefiniranjeFilmova.setSize(775, 546);
		shlDefiniranjeFilmova.setText("Definiranje filmova");
		
		Group grpIzmijeniFilm = new Group(shlDefiniranjeFilmova, SWT.NONE);
		grpIzmijeniFilm.setText("Izmijena i brisanje filma");
		grpIzmijeniFilm.setBounds(419, 201, 298, 120);
		
		Combo cmbIzmijeni = new Combo(grpIzmijeniFilm, SWT.READ_ONLY);
		cmbIzmijeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = cmbIzmijeni.getSelectionIndex();
				txtStatus.setText(String.valueOf(index));
				moviesModel = moviesList.get(cmbIzmijeni.getSelectionIndex());
				
				txtName.setText(moviesList.get(index).getName());
				txtGenre1.setText(moviesList.get(index).getGenres1());
				txtGenre2.setText(moviesList.get(index).getGenres2());
				txtGenre3.setText(moviesList.get(index).getGenres3());
				txtYear.setText(String.valueOf(moviesList.get(index).getYear()));
				txtCountry.setText(moviesList.get(index).getCountry());
				txtDuration.setText(String.valueOf(moviesList.get(index).getDuration()));
			}
		});
		cmbIzmijeni.setBounds(99, 23, 189, 25);
	
		
		Label lblIzmijeniFilm = new Label(grpIzmijeniFilm, SWT.NONE);
		lblIzmijeniFilm.setBounds(10, 26, 88, 17);
		lblIzmijeniFilm.setText("Odaberi film :");
		
		Button btnSpremiIzmjenu = new Button(grpIzmijeniFilm, SWT.NONE);
		btnSpremiIzmjenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MoviesModel moviesModel = new MoviesModel();
				boolean sameMovie=false;
				for(int index=0;index<moviesList.size();index++){
					if(txtName.getText().equals(moviesList.get(index).getName())){
						if(!txtName.getText().equals(cmbIzmijeni.getText())){
							sameMovie=true;	
						}
						}
				}
				if(txtName.getText().equals("")){
					txtStatus.setText("Ime filma nije uneseno.");
				}
				else if(txtGenre1.getText().equals("")){
					txtStatus.setText("Žanr filma nije unesen.");
				}
				else if(txtYear.getText().equals("")){
					txtStatus.setText("Godina filma nije unesena.");
				}
				else if(txtCountry.getText().equals("")){
					txtStatus.setText("Država filma nije unesena.");
				}
				else if(txtDuration.getText().equals("")){
					txtStatus.setText("Trajanje filma nije uneseno.");
				}
				else if(Integer.valueOf(txtDuration.getText())<=0 || Integer.valueOf(txtDuration.getText())>240){
					txtStatus.setText("Trajanje filma mora biti u intervalu od 0-240.");
				}
				else if(Integer.valueOf(txtYear.getText())<1878){
					txtStatus.setText("Godina filma mora biti veca od 1878.");
				}
				else if(sameMovie==true){
					txtStatus.setText("Ime filma vec postoji.");	
				}
				else{
					moviesModel.setName(txtName.getText());
					moviesModel.setGenres1(txtGenre1.getText());
					moviesModel.setGenres2(txtGenre2.getText());
					moviesModel.setGenres3(txtGenre3.getText());
					moviesModel.setYear(Integer.valueOf( txtYear.getText()));
					moviesModel.setCountry(txtCountry.getText());
					moviesModel.setDuration(Integer.valueOf(txtDuration.getText()));
				moviesCTRL.change(moviesModel, cmbIzmijeni.getSelectionIndex());
				txtName.setText("");
				txtGenre1.setText("");
				txtGenre2.setText("");
				txtGenre3.setText("");
				txtYear.setText("");
				txtCountry.setText("");
				txtDuration.setText("");
				
				cmbIzmijeni.setText(moviesModel.getName());
				cmbIzmijeni.setItem(cmbIzmijeni.getSelectionIndex(), moviesModel.getName());
				
				
			}
			}
		});
		btnSpremiIzmjenu.setBounds(48, 70, 109, 27);
		btnSpremiIzmjenu.setText("Spremi izmjenu");
		
		Button btnObrisi = new Button(grpIzmijeniFilm, SWT.NONE);
		btnObrisi.setBounds(209, 70, 79, 27);
		btnObrisi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moviesCTRL.delete(moviesModel);
				cmbIzmijeni.setText("");
				cmbIzmijeni.remove(cmbIzmijeni.getSelectionIndex());
				txtName.setText("");
				txtGenre1.setText("");
				txtGenre2.setText("");
				txtGenre3.setText("");
				txtYear.setText("");
				txtCountry.setText("");
				txtDuration.setText("");
			}
		});
		btnObrisi.setText("Obri\u0161i");
		
		txtName = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtName.setBounds(111, 20, 271, 23);
		
		Label lblImeFilma = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblImeFilma.setBounds(24, 23, 61, 17);
		lblImeFilma.setText("Ime filma :");
		
		txtGenre1 = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtGenre1.setBounds(111, 73, 171, 23);
		
		txtGenre2 = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtGenre2.setBounds(111, 118, 171, 23);
		
		txtGenre3 = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtGenre3.setBounds(111, 157, 171, 23);
		
		Label lblanr = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblanr.setBounds(24, 73, 61, 17);
		lblanr.setText("\u017Danr 1 :");
		
		Label lblanr_2 = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblanr_2.setText("\u017Danr 2 :");
		lblanr_2.setBounds(24, 118, 61, 17);
		
		Label lblanr_1 = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblanr_1.setText("\u017Danr 3 :");
		lblanr_1.setBounds(24, 157, 61, 17);
		
		txtYear = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtYear.setBounds(111, 200, 76, 23);
		
		Label lblGodina = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblGodina.setBounds(24, 200, 61, 17);
		lblGodina.setText("Godina :");
		
		txtCountry = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtCountry.setBounds(111, 246, 171, 23);
		
		Label lblDrava = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblDrava.setBounds(24, 246, 61, 17);
		lblDrava.setText("Dr\u017Eava :");
		
		txtDuration = new Text(shlDefiniranjeFilmova, SWT.BORDER);
		txtDuration.setBounds(111, 287, 76, 23);
		
		Label lblMin = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblMin.setBounds(193, 290, 61, 17);
		lblMin.setText("minuta");
		
		Label lblTrajanje = new Label(shlDefiniranjeFilmova, SWT.NONE);
		lblTrajanje.setBounds(24, 290, 61, 17);
		lblTrajanje.setText("Trajanje :");
		
		Button btnZatvori = new Button(shlDefiniranjeFilmova, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDefiniranjeFilmova.close();
			}
		});
		btnZatvori.setBounds(638, 440, 79, 27);
		btnZatvori.setText("Zatvori");
		
		Group grpDodajFilm = new Group(shlDefiniranjeFilmova, SWT.NONE);
		grpDodajFilm.setText("Dodaj film");
		grpDodajFilm.setBounds(419, 21, 298, 120);
		
		Button btnDodajNoviFilm = new Button(grpDodajFilm, SWT.NONE);
		btnDodajNoviFilm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MoviesModel korisnickiUnos = new MoviesModel();
				boolean sameMovie=false;
				for(int index=0;index<moviesList.size();index++){
					if(txtName.getText().equals(moviesList.get(index).getName())){
						sameMovie=true;
						}
				}
				
				if(txtName.getText().equals("")){
					txtStatus.setText("Ime filma nije uneseno.");
				}
				else if(txtGenre1.getText().equals("")){
					txtStatus.setText("Žanr filma nije unesen.");
				}
				else if(txtYear.getText().equals("")){
					txtStatus.setText("Godina filma nije unesena.");
				}
				else if(txtCountry.getText().equals("")){
					txtStatus.setText("Država filma nije unesena.");
				}
				else if(txtDuration.getText().equals("")){
					txtStatus.setText("Trajanje filma nije uneseno.");
				}
				else if(Integer.valueOf(txtDuration.getText())<=0 || Integer.valueOf(txtDuration.getText())>240){
					txtStatus.setText("Trajanje filma mora biti u intervalu od 0-240.");
				}
				else if(Integer.valueOf(txtYear.getText())<1878){
					txtStatus.setText("Godina filma mora biti veca od 1878.");
				}
				else if(sameMovie==true){
					txtStatus.setText("Ime filma vec postoji.");
				}
				else{
				korisnickiUnos.setName(txtName.getText());
				korisnickiUnos.setGenres1(txtGenre1.getText());
				korisnickiUnos.setGenres2(txtGenre2.getText());
				korisnickiUnos.setGenres3(txtGenre3.getText());
				korisnickiUnos.setYear(Integer.valueOf( txtYear.getText()));
				korisnickiUnos.setCountry(txtCountry.getText());
				korisnickiUnos.setDuration(Integer.valueOf(txtDuration.getText()));
				
				moviesCTRL.putMovie(korisnickiUnos);
				
				cmbIzmijeni.setText(korisnickiUnos.getName());
				cmbIzmijeni.add(korisnickiUnos.getName());
				cmbIzmijeni.select(cmbIzmijeni.getItemCount() - 1);
				
				
				txtName.setText("");
				txtGenre1.setText("");
				txtGenre2.setText("");
				txtGenre3.setText("");
				txtYear.setText("");
				txtCountry.setText("");
				txtDuration.setText("");
				}
			}
		});
		moviesList = moviesCTRL.reachListMoviesModel();
		
		for (int index = 0; index < moviesList.size(); index++) {
			cmbIzmijeni.add(moviesList.get(index).getName(), index);
		}
	
		btnDodajNoviFilm.setText("Dodaj novi film");
		btnDodajNoviFilm.setBounds(95, 44, 116, 27);
		
		txtStatus = new Text(shlDefiniranjeFilmova, SWT.NONE);
		txtStatus.setEditable(false);
		txtStatus.setBounds(24, 335, 358, 23);

	}
}
