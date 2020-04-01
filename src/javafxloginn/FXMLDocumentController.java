/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxloginn;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilitez.MyConnection;
import utilitez.SHA;

/**
 *
 * @author Rafaa
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label status;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Hyperlink linkCreateAccount;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private final String adminpass = "0c02cad8b24ed02448abbbd71ee51cb0166e641b3e557353829fd517803a8f5c2f8d6a8ce15aa280ec1b2b1f8f915a607ab0bdadfab3116ee580a50a4ec30850";
    User utilisateur = null;

    /**
     *
     */
    public void Login(ActionEvent event) throws Exception {
        if (validateFields()) {
            try {
                Connection cnx2 = MyConnection.getInstance().getCnx();
                String p = pass.getText();

                String query = "select * from user where nom=? and password=?";

                pst = cnx2.prepareStatement(query);
                pst.setString(1, user.getText());
                pst.setString(2, SHA.encrypt(p));
                rs = pst.executeQuery();

                if (rs.next()) {
                    if (SHA.encrypt(p).equals(adminpass)) {
                        status.setText("login success");
                        Stage stage = new Stage();
                        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TGT.fxml"));
                        fxmlLoader.getNamespace().put("labelText", user.getText());
                        //System.out.println("labelText"+"--" + "External Text");
                        final Parent root = fxmlLoader.load();
                        stage.setTitle("ADMIN Tunisain Got Talent");
                        Scene scene = new Scene(root, 1250, 550);
                        //stage.setFullScreen(true);
                        stage.setScene(scene);
                        stage.show();
                        ((Node) (event.getSource())).getScene().getWindow().hide();

                    }
                    status.setText("login success");
                    // User utilasateur = new User();

                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("menubar.fxml"));
                    stage.setTitle("Tunisain Got Talent");
                    Scene scene = new Scene(root, 1280, 720);

                    //stage.initOwner(stage);
                    stage.setScene(scene);
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();

                } else {
                    status.setText("login failed");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("login failed");
                    alert.setHeaderText(null);
                    alert.setContentText("login ou mot de pass invalide");
                    alert.showAndWait();

                }
                user.clear();
                pass.clear();
                pst.close();
                rs.close();
            } catch (IOException | SQLException e1) {
                status.setText("SQL Error");
                System.err.println(e1);
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void linkCreatAccountAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("SignupScence.fxml"));

            stage.setTitle("Noveau Compte");

            Scene scene = new Scene(parent, 450, 400);
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean validateFields() {
        if (user.getText().isEmpty() || pass.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Fields");
            alert.setHeaderText(null);
            alert.setContentText(" Fields empty");
            alert.showAndWait();

            return false;
        }

        return true;
    }

}
