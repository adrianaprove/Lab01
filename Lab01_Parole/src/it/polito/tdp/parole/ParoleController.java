package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtTempo;

    @FXML
    void doCancella(ActionEvent event) {
    	double start=System.nanoTime();
    	String s=txtParola.getText().trim(); 
    	elenco.cancella(s);
    	double end=System.nanoTime(); 
    	double diff=System.nanoTime(); 
  
    	List <String> e= elenco.getElenco(); 
    	txtResult.clear();
    	for(int i=0; i<e.size(); i++)
    		txtResult.appendText(e.get(i)+"\n");
    	
    	txtTempo.clear();
    	txtTempo.setText("[CANCEL]: "+diff/1e9+" seconds"); 
    	txtParola.clear(); 
    	
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	//prendo tempo iniziale
    	double start=System.nanoTime(); 
  
    	String parola=txtParola.getText().trim(); 
    	//ho assunto che venga inserita solo una parola alla volta
    	elenco.addParola(parola);
    	
    	//prendo tempo finale
    	double end=System.nanoTime(); 
    	double diff=end-start; 
    	
    	txtResult.clear();
    	List <String> e=elenco.getElenco(); 
    	for(int i=0; i<e.size(); i++)
    		txtResult.appendText(e.get(i)+"\n");
    	
    	txtTempo.clear();
    	txtTempo.setText("[INSERT]: "+diff/1e9+" seconds"); 
    	txtParola.clear(); 
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	double start=System.nanoTime(); 
    	elenco.reset();
    	double end=System.nanoTime(); 
    	double diff=end-start; 
    	
    	txtResult.clear();
    	
    	txtTempo.clear();
    	txtTempo.setText("[RESET]: "+diff/1e9+" seconds"); 
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Parole.fxml'.";
        elenco = new Parole() ;
        
    }
}
