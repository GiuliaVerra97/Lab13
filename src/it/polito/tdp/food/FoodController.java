package it.polito.tdp.food;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCalorie;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private ComboBox<Condiment> boxIngrediente;

    @FXML
    private Button btnDietaEquilibrata;

    @FXML
    private TextArea txtResult;

	private Model model;

    @FXML
    void doCalcolaDieta(ActionEvent event) {

    }

    @FXML
    void doCreaGrafo(ActionEvent event) {

    	
    	if(txtCalorie.getText()==null) {
    		txtResult.setText("Inserire il numero di calorie deiderato");
    		return;
    	}
    	
    	int calorie=0;
    	
    	try {
    		calorie=Integer.parseInt(txtCalorie.getText());
    	}catch(NumberFormatException e) {
    		txtResult.setText("Inserire un numero intero, non una stringa"); 
    	}
    	
    	model.creaGrafo(calorie);
    	
    	String s=model.ordinaCalorie();
    	
    	txtResult.appendText("CREATO\n");
    	
    	if(s!="") {
    		txtResult.appendText(" "+s);
    	}else {
    		txtResult.setText("ERRORE");
    	}

    	
    	boxIngrediente.getItems().addAll(model.getCondimentiLista());
    	
    	btnDietaEquilibrata.setDisable(false);
    	
    }

    @FXML
    void initialize() {
        assert txtCalorie != null : "fx:id=\"txtCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxIngrediente != null : "fx:id=\"boxIngrediente\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnDietaEquilibrata != null : "fx:id=\"btnDietaEquilibrata\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";

    }
    
    
    public void setModel(Model model) {
    	this.model=model;
    }
    
    
    
}


