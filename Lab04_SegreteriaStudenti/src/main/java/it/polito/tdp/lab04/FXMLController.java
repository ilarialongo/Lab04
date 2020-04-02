package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> bxChoice;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;
    
    @FXML
    private Button btnCheck;


    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;
    
    

    @FXML
    void cercaCorsi(ActionEvent event) {
    	Integer matricola;
    	try {
    	matricola= Integer.parseInt(txtMatricola.getText());
    	}
    	catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero!\n");
    		return;	
    	}
    	if(this.model.getStudente(matricola)==null) {
    		txtRisultato.setText("Inserire matricola valida");
    		return;
    	}
   
    	txtRisultato.setText(this.model.getCorsiStudente(matricola));
    	

    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	Corso c= bxChoice.getValue();
    	if(c.getCodins().compareTo("")==0) {
    		txtRisultato.setText("Selezionare un corso esistente");
    		return;
    	}
 
    	txtRisultato.setText(this.model.getStudentiIscrittiAlCorso(c));
    	
    	//ListView <Studente>

    }

    @FXML
    void completaInfo(ActionEvent event) {
    	Integer matricola;
    	try {
    	matricola= Integer.parseInt(txtMatricola.getText());
    	}
    	catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero!\n");
    		return;	
    	}
    	if(this.model.getStudente(matricola)==null) {
    		txtRisultato.setText("Inserire matricola valida");
    		return;
    	}
    	txtNome.setText(this.model.getStudente(matricola).getNome());
    	txtCognome.setText(this.model.getStudente(matricola).getCognome());
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtRisultato.clear();
    }

    @FXML
    void iscriviStudente(ActionEvent event) {
    	Integer matricola;
    	Corso c= bxChoice.getValue();
    	if(c.getCodins().compareTo("")==0) {
    		txtRisultato.setText("Selezionare un corso esistente");
    		return;
    	}
    	
    	try {
    	matricola= Integer.parseInt(txtMatricola.getText());
    	}
    	catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero!\n");
    		return;	
    	}
    	if(this.model.getStudente(matricola)==null) {
    		txtRisultato.setText("Inserire matricola valida");
    		return;
    	}
    	
    	if(this.model.isIscritto(c, matricola)==false) {
    		txtRisultato.setText("Studente non esistente");
    		return;
    	}
    	txtRisultato.setText("Studente iscritto al corso");

    }

    @FXML
    void initialize() {
        assert bxChoice != null : "fx:id=\"bxChoice\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
      //  bxChoice.setValue(new Corso("",null,"",null));
      //  bxChoice.getItems().addAll(model.getTuttiICorsi());
        
    }
    
    public void setModel(Model model) {
		this.model=model;
		bxChoice.getItems().add(new Corso("",null,"",null));
	    bxChoice.getItems().addAll(model.getTuttiICorsi());   
	}
    
}








