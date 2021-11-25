package DefineHall;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;

public class HallView {
	
	HallCTRL hallCTRL = new HallCTRL();
	HallModel hallModel = new HallModel();
	private List<HallModel> hallList;

	protected Shell shlDefiniranjeDvorane;
	private Text txtHallName;
	private Text txtSeatNumber;
	private Text txtStatus;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HallView window = new HallView();
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
		shlDefiniranjeDvorane.open();
		shlDefiniranjeDvorane.layout();
		while (!shlDefiniranjeDvorane.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDefiniranjeDvorane = new Shell();
		shlDefiniranjeDvorane.setSize(527, 394);
		shlDefiniranjeDvorane.setText("Definiranje dvorane");
		
		txtHallName = new Text(shlDefiniranjeDvorane, SWT.BORDER);
		txtHallName.setBounds(10, 50, 132, 23);
		
		txtSeatNumber = new Text(shlDefiniranjeDvorane, SWT.BORDER);
		txtSeatNumber.setBounds(10, 124, 114, 23);
		
		Group grpIzmijenaIBrisanje = new Group(shlDefiniranjeDvorane, SWT.NONE);
		grpIzmijenaIBrisanje.setText("Izmijena i brisanje dvorane");
		grpIzmijenaIBrisanje.setBounds(189, 108, 298, 156);
		
		Combo cmbIzmijeni = new Combo(grpIzmijenaIBrisanje, SWT.READ_ONLY);
		cmbIzmijeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = cmbIzmijeni.getSelectionIndex();
				txtStatus.setText(String.valueOf(index));
				hallModel = hallList.get(cmbIzmijeni.getSelectionIndex());
				
				txtHallName.setText(hallList.get(index).getName());
				txtSeatNumber.setText(String.valueOf(hallList.get(index).getSeatNum()));
			}
		});
		
		Label lblNewLabel = new Label(shlDefiniranjeDvorane, SWT.NONE);
		lblNewLabel.setBounds(10, 27, 79, 17);
		lblNewLabel.setText("Ime dvorane");
		
		Label lblBrojSjedala = new Label(shlDefiniranjeDvorane, SWT.NONE);
		lblBrojSjedala.setBounds(10, 96, 85, 17);
		lblBrojSjedala.setText("Broj sjedala");
		
		Group grpDodajDvoranu = new Group(shlDefiniranjeDvorane, SWT.NONE);
		grpDodajDvoranu.setText("Dodaj dvoranu");
		grpDodajDvoranu.setBounds(189, 23, 298, 79);
		
		

		cmbIzmijeni.setBounds(10, 49, 189, 25);
		
		Button btnSpremiIzmjenu = new Button(grpIzmijenaIBrisanje, SWT.NONE);
		btnSpremiIzmjenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				HallModel korisnickiUnos = new HallModel();
				boolean sameMovie=false;
				for(int index=0;index<hallList.size();index++){
					if(txtHallName.getText().equals(hallList.get(index).getName())){
						if(!txtHallName.getText().equals(cmbIzmijeni.getText())){
							sameMovie=true;	
						}
				}
				}
				
				if(txtHallName.getText().equals("")){
					txtStatus.setText("Ime dvorane nije uneseno.");
				}
				else if(txtSeatNumber.getText().equals("")){
					txtStatus.setText("Broj sjedala nije unesen.");
				}
				else if(sameMovie==true){
					txtStatus.setText("Ime dvorane vec postoji.");	
				}
				else if(Integer.valueOf(txtSeatNumber.getText())<=0 || Integer.valueOf(txtSeatNumber.getText())>999){
					txtStatus.setText("Broj sjedala mora biti u intervalu 1-999.");
				}
				else{
				korisnickiUnos.setName(txtHallName.getText());
				korisnickiUnos.setSeatNum(Integer.valueOf( txtSeatNumber.getText()));
				
				hallCTRL.change(korisnickiUnos, cmbIzmijeni.getSelectionIndex());
				txtHallName.setText("");
				txtSeatNumber.setText("");
				
				cmbIzmijeni.setText(hallModel.getName());
				cmbIzmijeni.setItem(cmbIzmijeni.getSelectionIndex(), hallModel.getName());
				
				}
			}
		});
		btnSpremiIzmjenu.setText("Spremi izmjenu");
		btnSpremiIzmjenu.setBounds(10, 89, 109, 27);
		
		Label lblOdaberiDvoranu = new Label(grpIzmijenaIBrisanje, SWT.NONE);
		lblOdaberiDvoranu.setText("Odaberi dvoranu :");
		lblOdaberiDvoranu.setBounds(10, 26, 119, 17);
		
		
		
		Button btnObrii = new Button(grpIzmijenaIBrisanje, SWT.NONE);
		btnObrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hallCTRL.delete(hallModel);
				cmbIzmijeni.setText("");
				cmbIzmijeni.remove(cmbIzmijeni.getSelectionIndex());
				txtHallName.setText("");
				txtSeatNumber.setText("");
				
			}
		});
		btnObrii.setText("Obri\u0161i");
		btnObrii.setBounds(165, 89, 79, 27);
		
		
		Button btnNewHall = new Button(grpDodajDvoranu, SWT.NONE);
		btnNewHall.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				HallModel korisnickiUnos = new HallModel();
				
				boolean sameMovie=false;
				for(int index=0;index<hallList.size();index++){
					if(txtHallName.getText().equals(hallList.get(index).getName())){
						sameMovie=true;
						}
				}
				
				if(txtHallName.getText().equals("") && !txtHallName.getText().matches("[a-zA-Z_]+")){
					txtStatus.setText("Ime dvorane nije uneseno.");
				}
				else if(txtSeatNumber.getText().equals("") && !txtSeatNumber.getText().matches("[0-9]+")){
					txtStatus.setText("Broj sjedala nije unesen.");
				}
				else if(sameMovie==true){
					txtStatus.setText("Ime dvorane vec postoji.");	
				}
				else if(Integer.valueOf(txtSeatNumber.getText())<=0 || Integer.valueOf(txtSeatNumber.getText())>999){
					txtStatus.setText("Broj sjedala mora biti u intervalu 1-999.");
				}
				else{
				korisnickiUnos.setName(txtHallName.getText());
				korisnickiUnos.setSeatNum(Integer.valueOf( txtSeatNumber.getText()));
				
				hallCTRL.putHall(korisnickiUnos);
				
				cmbIzmijeni.setText(korisnickiUnos.getName());
				cmbIzmijeni.add(korisnickiUnos.getName());
				cmbIzmijeni.select(cmbIzmijeni.getItemCount() - 1);
				
				
				txtHallName.setText("");
				txtSeatNumber.setText("");
				}
			}
		});
		hallList = hallCTRL.reachListHallModel();
		
		for (int index = 0; index < hallList.size(); index++) {
			cmbIzmijeni.add(hallList.get(index).getName(), index);
		}
		
		btnNewHall.setText("Dodaj novu dvoranu");
		btnNewHall.setBounds(85, 30, 141, 27);
		
		txtStatus = new Text(shlDefiniranjeDvorane, SWT.WRAP);
		txtStatus.setEditable(false);
		txtStatus.setBounds(13, 166, 154, 85);
		
		Button btnClose = new Button(shlDefiniranjeDvorane, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDefiniranjeDvorane.close();
			}
		});
		btnClose.setBounds(393, 294, 79, 27);
		btnClose.setText("Zatvori");

	}
}
