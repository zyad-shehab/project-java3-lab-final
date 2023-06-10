/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.PatientFXML;

import Model.User;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class PatientRegisterpageController implements Initializable {

    @FXML
    private TextField firstNameTF;
    @FXML
    private Button RegisterBTN;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField ageTF;
    @FXML
    private RadioButton maleRB;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton femaleRB;
    @FXML
    private Button LoginBTN;
    @FXML
    private Button AdminBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RegisterBTN(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String firstname= firstNameTF.getText();
        String lastname=lastNameTF.getText();
        String email = emailTF.getText();
        String username = userNameTF.getText();
        String password = passwordTF.getText();
        int phone=Integer.parseInt(phoneTF.getText());
        int age=Integer.parseInt(ageTF.getText());
        String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        String role = "patient";
        // make an user object having this data
        User user = new User(username, password, firstname, lastname, age, email, phone, gender, role);
        // save the user in database by save method
        user.save();
        
        ViewManager.openPatientLoginPage();
        ViewManager.closePatientRegisterPage();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }

    @FXML
    private void maleRB(ActionEvent event) {
    }

    @FXML
    private void femaleRB(ActionEvent event) {
    }

    @FXML
    private void LoginBTN(ActionEvent event) throws IOException {
        ViewManager.openPatientLoginPage();
       ViewManager.closePatientRegisterPage();
    }

    @FXML
    private void AdminBTN(ActionEvent event) throws IOException {
         ViewManager.openAdminLoginPage();
        ViewManager.closePatientRegisterPage();
    }
    
}
