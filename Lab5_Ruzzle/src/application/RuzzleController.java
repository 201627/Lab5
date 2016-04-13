package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import it.polito.tdp.Ruzzle.model.Casella;
import it.polito.tdp.Ruzzle.model.ParolaRisultato;
import it.polito.tdp.Ruzzle.model.Ruzzle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RuzzleController {

    private List<TextField> caselle;
    private Ruzzle model;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt0x0;

    @FXML
    private TextField txt0x1;

    @FXML
    private TextField txt0x2;

    @FXML
    private TextField txt0x3;

    @FXML
    private TextField txt1x0;

    @FXML
    private TextField txt1x1;

    @FXML
    private TextField txt1x2;

    @FXML
    private TextField txt1x3;

    @FXML
    private TextField txt2x0;

    @FXML
    private TextField txt2x1;

    @FXML
    private TextField txt2x2;

    @FXML
    private TextField txt2x3;

    @FXML
    private TextField txt3x0;

    @FXML
    private TextField txt3x1;

    @FXML
    private TextField txt3x2;

    @FXML
    private TextField txt3x3;

    @FXML
    private Button btnGenera;

    @FXML
    private ListView<ParolaRisultato> listRisultato;
    
    public void setModel(Ruzzle model){
    	this.model = model;
    }

    @FXML
    void doGenera(ActionEvent event) {
    	// genera lettere a caso
    	
    	Random r = new Random();
    	char c;
    	List<Casella> lettere = new ArrayList<>();
    	int i = 0;
    	int j = 0;
    	
    	for(int index = 1; index <= 16; index++){
    		c = (char)(r.nextInt(26) + 'a');
    		caselle.get(index -1).setText(""+c);
    		if (index <=4)
    			lettere.add(new Casella(0, index-1 , caselle.get(index -1).getText().charAt(0)));
    		else if(index <=8)
    			lettere.add(new Casella(1, index-5 , caselle.get(index -1).getText().charAt(0)));
    		else if(index <=12)
    			lettere.add(new Casella(2, index-9 , caselle.get(index -1).getText().charAt(0)));
    		else 
    			lettere.add(new Casella(3, index-13 , caselle.get(index -1 ).getText().charAt(0)));
    	}
    	System.out.println(lettere.toString());
    	// trova soluzioni
    	
    	List<ParolaRisultato> res = model.trovaParole(lettere);
    	
    	//aggiungile alla list view
    	
    	System.out.println("Aggiungo i risultati alla list view!");
    	
    	ObservableList<ParolaRisultato> items =FXCollections.observableArrayList (res);
    	listRisultato.setItems(items);
    	
    	
    }
    
    @FXML
    void doRosso(MouseEvent event) {

    	ParolaRisultato p = listRisultato.getSelectionModel().getSelectedItem();
    	
    	for(TextField tf : caselle)
    		tf.setStyle("-fx-background-color : green;");
    	
    	for(int i = 0; i<=3 ; i++)
    		for (int j = 0; j<= 3; j++)
    			if (p.getPosizioni()[i][j]==true){
    				System.out.println(p.getParola());
    				caselle.get(i*4+j).setStyle("-fx-background-color : red;");
    		    }
    }
    				

    @FXML
    void initialize() {
        assert txt0x0 != null : "fx:id=\"txt0x0\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt0x1 != null : "fx:id=\"txt0x1\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt0x2 != null : "fx:id=\"txt0x2\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt0x3 != null : "fx:id=\"txt0x3\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt1x0 != null : "fx:id=\"txt1x0\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt1x1 != null : "fx:id=\"txt1x1\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt1x2 != null : "fx:id=\"txt1x2\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt1x3 != null : "fx:id=\"txt1x3\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt2x0 != null : "fx:id=\"txt2x0\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt2x1 != null : "fx:id=\"txt2x1\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt2x2 != null : "fx:id=\"txt2x2\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt2x3 != null : "fx:id=\"txt2x3\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt3x0 != null : "fx:id=\"txt3x0\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt3x1 != null : "fx:id=\"txt3x1\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt3x2 != null : "fx:id=\"txt3x2\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert txt3x3 != null : "fx:id=\"txt3x3\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert listRisultato != null : "fx:id=\"listRisultato\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        
        caselle = new ArrayList<>();
        caselle.add(txt0x0);
        caselle.add(txt0x1);
        caselle.add(txt0x2);
        caselle.add(txt0x3);
        caselle.add(txt1x0);
        caselle.add(txt1x1);
        caselle.add(txt1x2);
        caselle.add(txt1x3);
        caselle.add(txt2x0);
        caselle.add(txt2x1);
        caselle.add(txt2x2);
        caselle.add(txt2x3);
        caselle.add(txt3x0);
        caselle.add(txt3x1);
        caselle.add(txt3x2);
        caselle.add(txt3x3);
    }
}

