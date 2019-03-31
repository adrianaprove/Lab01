package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
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
    void doCancella(ActionEvent event) {
    	String s=txtParola.getText().trim(); 
    	elenco.cancella(s);
    	LinkedList <String> e=(LinkedList<String>) elenco.getElenco(); 
    	txtResult.clear();
    	for(int i=0; i<e.size(); i++)
    		txtResult.appendText(e.get(i)+"\n");
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	String parola=txtParola.getText().trim(); //ho assunto che venga inserita solo una parola alla volta
    	elenco.addParola(parola);
    	LinkedList <String> e=(LinkedList<String>) elenco.getElenco(); 
    	txtResult.clear();
    	for(int i=0; i<e.size(); i++)
    		txtResult.appendText(e.get(i)+"\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        elenco = new Parole() ;
        
    }
}
