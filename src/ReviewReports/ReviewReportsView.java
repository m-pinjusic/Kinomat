package ReviewReports;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.util.List;
import DefineShowtime.MainModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ReviewReportsView {
	
	MainModel mainModel = new MainModel();
	private List<MainModel> mainList;
	
	ReviewReportsCTRL reviewReportsCTRL= new ReviewReportsCTRL();
	TableItem[] tableItemIndex;

	protected Shell shlPregledavanjeIzvijestaja;
	private Table tableReview;
	private TableColumn tblclmnImeFilma;
	private TableColumn tblclmnanr;
	private TableColumn tblclmnGodinaFilma;
	private TableColumn tblclmnDrava;
	private TableColumn tblclmnTrajanje;
	private TableColumn tblclmnDvorana;
	private TableColumn tblclmnTermin;
	private TableItem tableItem;
	private TableColumn tblclmnBrojSjedala;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ReviewReportsView window = new ReviewReportsView();
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
		shlPregledavanjeIzvijestaja.open();
		shlPregledavanjeIzvijestaja.layout();
		while (!shlPregledavanjeIzvijestaja.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPregledavanjeIzvijestaja = new Shell();
		shlPregledavanjeIzvijestaja.setSize(804, 455);
		shlPregledavanjeIzvijestaja.setText("Pregled izvje\u0161taja");
		
	
		
		Button btnZatvori = new Button(shlPregledavanjeIzvijestaja, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPregledavanjeIzvijestaja.close();
			}
		});
		
		
		
		btnZatvori.setBounds(616, 341, 79, 27);
		btnZatvori.setText("Zatvori");
		
		tableReview = new Table(shlPregledavanjeIzvijestaja, SWT.BORDER | SWT.FULL_SELECTION);
		tableReview.addSelectionListener(new SelectionAdapter() {
		});
		
		tableReview.setBounds(7, 27, 771, 221);
		tableReview.setHeaderVisible(true);
		tableReview.setLinesVisible(true);
		
		tblclmnImeFilma = new TableColumn(tableReview, SWT.NONE);
		tblclmnImeFilma.setWidth(100);
		tblclmnImeFilma.setText("Ime filma");
		
		tblclmnanr = new TableColumn(tableReview, SWT.NONE);
		tblclmnanr.setWidth(154);
		tblclmnanr.setText("\u017Danr");
		
		tblclmnGodinaFilma = new TableColumn(tableReview, SWT.NONE);
		tblclmnGodinaFilma.setWidth(86);
		tblclmnGodinaFilma.setText("Godina filma");
		
		tblclmnDrava = new TableColumn(tableReview, SWT.NONE);
		tblclmnDrava.setWidth(92);
		tblclmnDrava.setText("Dr\u017Eava");
		
		tblclmnTrajanje = new TableColumn(tableReview, SWT.NONE);
		tblclmnTrajanje.setWidth(60);
		tblclmnTrajanje.setText("Trajanje");
		
		tblclmnDvorana = new TableColumn(tableReview, SWT.NONE);
		tblclmnDvorana.setWidth(100);
		tblclmnDvorana.setText("Dvorana");
		
		tblclmnTermin = new TableColumn(tableReview, SWT.NONE);
		tblclmnTermin.setWidth(70);
		tblclmnTermin.setText("Termin");
		
		
		tblclmnBrojSjedala = new TableColumn(tableReview, SWT.NONE);
		tblclmnBrojSjedala.setWidth(100);
		tblclmnBrojSjedala.setText("Broj slobodnih sjedala");
		
		mainList = reviewReportsCTRL.reachListMainModel();
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
		
			

	}
}
