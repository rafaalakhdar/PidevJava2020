/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxloginn;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Rafaa
 */
public class FXMLController implements Initializable {
    @FXML
    private RadioButton tel;
        @FXML
    private RadioButton email;
            @FXML
    private Label lbl;
    
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private ListView listefile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addonefile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("images,Pdf", "*.png", "*.jpg", "*.pdf"));
        File selctedFile = fc.showOpenDialog(null);

        if (selctedFile != null) {
            listefile.getItems().add(selctedFile.getAbsoluteFile());

        } else {
            System.out.println("file is not valid");
        }
    }

    public void addmultifile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("images", "*.png", "*.jpg"));
        List<File> selctedFiles = fc.showOpenMultipleDialog(null);

        if (selctedFiles != null) {
            for (int i = 0; i < selctedFiles.size(); i++) {
                listefile.getItems().add(selctedFiles.get(i).getAbsolutePath());
            }
        } else {
            System.out.println("file is not valid");
        }
    }
    
    public void boxselect(ActionEvent event){
        String val="";
        if (tel.isSelected()){
        val+= tel.getText() + "\n";
        }
        
        if (email.isSelected()){
        val+= email.getText() + "\n";
        }
        lbl.setText(val);
    }
    
}
