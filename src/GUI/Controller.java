package GUI;



//TODO vedi register -> verify-Field


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.ArticoloDAO;
import Database.CassaDAO;
import Database.CommessoDAO;
import Database.MagazzinoDAO;
import Entita.Articolo;
import Entita.Cassa;
import Entita.Commesso;
import Entita.Magazzino;
import GUI.ComponetArticolo;

public class Controller {
	private static LoginFrame loginFrame;
	private  RegisterFrame registerFrame;
	private static  MainFrame mainFrame;
	public Cassa cassa;
	private MagazzinoFrame magazzinoFrame;	
	private  ArticoloDAO articoloDao; 
	private   Magazzino magazzino;
	private   MagazzinoDAO magazzinoDao;
	private  CommessoDAO commessoDao;
	private CassaDAO cassaDao;
	public Commesso commesso;
	private ArrayList<Articolo> articoliList; 
	public ArrayList<ComponetArticolo> componetList;
	public ArrayList<ComponetArticolo> cassaList;
	
	private String selectItem ;
	private  DefaultTableModel tableMagazzino;
	private  DefaultTableModel tableCassa;
	
	
	
	public static void main (String[] args) {
		Controller controller = new Controller ();


		
		
		

		
		loginFrame = new LoginFrame(controller);	
		loginFrame.setVisible(true);

		
	}
	
	public Controller() {
		selectItem = "all";
		articoliList = new ArrayList<Articolo>();
		componetList = new ArrayList<ComponetArticolo>();
		cassaList = new ArrayList<ComponetArticolo>();
		articoloDao = new ArticoloDAO();
		commessoDao = new CommessoDAO();
		
		magazzino = new Magazzino();
		magazzinoDao = new MagazzinoDAO();
		magazzinoDao.fillMagazzino(magazzino.getArticolo());
		cassaDao = new CassaDAO();
		
		
		tableMagazzino = new DefaultTableModel( ) {
			@Override
			public Class<?> getColumnClass (int column){
				switch (column) {
				case 10 : return ImageIcon.class;
				default : return String.class;
				}
			}
		};
		
		tableCassa = new DefaultTableModel( );
		
		
		

	}
	
	public void goToMainFrame (JFrame frame) {
		frame.dispose();
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	}
	
	public void fromRegisterToLoginFrame() {
		registerFrame.dispose();
		loginFrame= new LoginFrame(this);
		loginFrame.setVisible(true);
		
	}
	public void fromMainToLoginFrame() {
		for(ComponetArticolo c : cassaList)
			magazzinoDao.addToMagazzino(c.getId(), c.getQuantita());
		
		mainFrame.dispose();
		loginFrame= new LoginFrame(this);
		loginFrame.setVisible(true);
		
	}
	
	
	public void goToRegisterFrame() {
		loginFrame.dispose();
		registerFrame= new RegisterFrame(this);
		registerFrame.setVisible(true);
		
	}
	
	public void goToProfilePanel() {
		mainFrame.showProfile();
	}
	
	public void goToHomePanel() {
		mainFrame.showHome();
	}
	public void goToCassaPanel() {
		mainFrame.showCassa();
	}
	

	
	public void search(String id) {
		
		selectItem=id;
		mainFrame.aggiornaHome();

	
		

	}
	
	public void goToAddArticolo() {
		magazzinoFrame = new MagazzinoFrame(this);
		magazzinoFrame.setVisible(true);
	
	}

	
	public void resizeComponet(boolean isMax) {

		
		
		mainFrame.aggiornaSizeCassa(isMax,1,2);
		mainFrame.aggiornaSizeHome(isMax, 4, 6);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void createUser(String nome,String cognome,String username,String password, 
							Date dataNascita, Image foto,String email) {
		commesso = new Commesso(nome,cognome,username,password,dataNascita,foto,email);
		
	}
	
	public boolean usernameAlredyExists(String username) {
		
		return commessoDao.CheckUsername(username);
	}

	public DefaultTableModel fillTableMagazzinoModel(String id) {
		tableMagazzino.setRowCount(0);
		articoliList.clear();
	
		
		String headers[] = {"Nome","id","Produttore","Taglia","Colore","Collezione","Disponibili","Prezzo","Genere","Categoria","Foto"};
		

		tableMagazzino.setColumnIdentifiers(headers);
		
		
		
		for (Articolo a : magazzinoDao.searchByID(id))
			articoliList.add(a);
		
	    for (int i = 0 ; i< articoliList.size();i++) {
	  
	    
	    	ImageIcon img = new ImageIcon (articoliList.get(i).getFoto().getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH));
	    	tableMagazzino.addRow(new Object[] {articoliList.get(i).getNome() ,
	    									articoliList.get(i).getId(),
	    									articoliList.get(i).getProduttore(),
	    									articoliList.get(i).getTaglia(),
	    									articoliList.get(i).getColore(),
	    									articoliList.get(i).getCollezione(),
	    									articoliList.get(i).getQuantita(),
	    									articoliList.get(i).getPrezzo(),
	    									articoliList.get(i).getGenere(),
	    									articoliList.get(i).getCategoria(),									
	    									img
	    									});
	    }
	    selectItem= "all";
	    return tableMagazzino;
	    
	}
	
	public DefaultTableModel fillTableRecentiModel() {
		
		tableCassa.setRowCount(0);
		articoliList.clear();
	
		
		String headers[] = {"Codice Ordine","Commesso","Tipo pagamento","Pagamento dovuto","Pagamento versato","Resto"};

		tableCassa.setColumnIdentifiers(headers);
		
		ArrayList<Cassa> recentiList = new ArrayList<Cassa>();
		
		recentiList= cassaDao.getOrdini();
		
			
		
	    for (int i = 0 ; i< recentiList.size();i++) {
	    	
	    	
	    	tableCassa.addRow(new Object[] {
	    									recentiList.get(i).getNumeroOrdine(),
	    									recentiList.get(i).getUsernameCommesso(),
	    									recentiList.get(i).getPagamentoType(),
	    									recentiList.get(i).getPagamentoDovuto(),
	    									recentiList.get(i).getPagamentoVersato(),
	    									recentiList.get(i).getResto()
	    									
	    									});
	    }
	    return tableCassa;
		
	}
	
	//DATABASE
	public void createAccount(String nome,String cognome,String username,char[] password,Calendar date,File fotoFile,String email) throws FileNotFoundException {
		
		String s = String.copyValueOf(password);
		commessoDao.addUser(nome, cognome,username, s, date, fotoFile, email);
		
	}

	
	public boolean logIn(String username, char[] password) throws SQLException, IOException  {
		
		String s = String.copyValueOf(password);
		return commessoDao.logInUser(username, s,this);
	}
	
	
	
	public DefaultTableModel  addArticolo(String nome,String id, String produttore, String taglia, String colore, String collezione, int quantita, float prezzo,String genere,String categoria,File foto) throws FileNotFoundException, SQLException {
		
		articoloDao.insertArticolo(nome,id, produttore, taglia, colore, collezione, quantita, prezzo, genere,categoria,foto);
		tableMagazzino = fillTableMagazzinoModel(selectItem);
		
		
		selectItem="all";
		
	
			mainFrame.aggiornaHome();
			mainFrame.revalidate();
			mainFrame.repaint();

		
	
		
		return tableMagazzino;
		
		
	}
	

	public DefaultTableModel removeArticolo(String id) {
		
		articoloDao.deleteArticolo(id);
	
		tableMagazzino = fillTableMagazzinoModel(selectItem);
		selectItem="all";
		mainFrame.aggiornaHome();
		mainFrame.revalidate();
		mainFrame.repaint();
		return tableMagazzino;
	}
	
	
	public void aggiungiOrdine(String pagamentoType, float pagamentoDovuto, float pagamentoVersato,float resto) throws SQLException {
		cassaDao.insertOrdine(pagamentoType, pagamentoDovuto, pagamentoVersato, resto,commesso.getUsername());
		cassaList.clear();
		
		mainFrame.aggiornaCassa();
		mainFrame.revalidate();
		mainFrame.repaint();
		
	}



	public void removeFromCassa(String id,int quantita) {
		
	
		 
		
		 for (int i = 0 ;  i<cassaList.size() ; i++) {

			 if (cassaList.get(i).getId().equals(id)) {
				 magazzinoDao.addToMagazzino(id, quantita);
				 if (cassaList.get(i).getQuantita() == quantita)
					 cassaList.remove(i);
				 else {
					 cassaList.get(i).setQuantita( cassaList.get(i).getQuantita()-quantita);
					 
				 }
			 }
			
			
			 
		 }
		 mainFrame.aggiornaCassa();
		 mainFrame.aggiornaHome();
		 mainFrame.revalidate();
		 mainFrame.repaint();

	}
	
	
	public void closeAll() {
		for(ComponetArticolo c : cassaList)
			magazzinoDao.addToMagazzino(c.getId(), c.getQuantita());
		System.exit(0);
	}
	
	public ArrayList<ComponetArticolo> FillComponentList(){
		 componetList.clear();
		
		 
		 for (Articolo a : magazzinoDao.searchByID(selectItem))
			 	componetList.add(new ComponetArticolo(a.getFoto(),a.getNome(),a.getId(),a.getPrezzo(),a.getQuantita(),this,0));
		 return componetList;
	}
	
	
	
	
	public void fillCassaList(String id , int quantita){
		
		magazzinoDao.fillMagazzino(magazzino.getArticolo());
		if ( !findInCassaList(id, quantita)) { 
			for (int i = 0; i < magazzino.getArticolo().size(); i++) {

				if (magazzino.getArticolo().get(i).getId().equals(id)) {

					cassaList.add(new ComponetArticolo(magazzino.getArticolo().get(i).getFoto(),
							magazzino.getArticolo().get(i).getNome(), magazzino.getArticolo().get(i).getId(),
							magazzino.getArticolo().get(i).getPrezzo(), quantita, this, 1));

					

				}

			} 
		}
		magazzinoDao.removeFromMagazzino(id, quantita);
		mainFrame.aggiornaHome();
		mainFrame.aggiornaCassa();
		mainFrame.revalidate();
		mainFrame.repaint();
		
	}
	

	
	public float totaleCassa() {
		float totale = 0;
		
		 for (ComponetArticolo c : cassaList) {
			totale+=c.getPrezzo()*c.getQuantita();
		}
		return totale;
	}
	

	
	private boolean  findInCassaList(String id, int quantita) {
		for (ComponetArticolo c : cassaList)
			if(c.getId().equals(id)) {
				c.setQuantita( c.getQuantita() + quantita);

				return true;
			}
		return false;
	}
	


}

