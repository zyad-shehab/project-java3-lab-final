/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.AdminFXML;

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
public class PatientsaddController implements Initializable {

    @FXML
    private Button BookedappointmentBTN;
    @FXML
    private Button FreeappointmentBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private Button saveBTN;
    @FXML
    private RadioButton FmaleRB;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton maleRB;
    @FXML
    private TextField ageFT;
    @FXML
    private TextField PhoneTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField FirstnameTF;
    @FXML
    private Button cancelBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Bookedappointment(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToBookedAppointment();

    }

    @FXML
    private void Freeappointment(ActionEvent event) {
                        ViewManager.AdminDashboard.changeSceneToFreeAppointment();

    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
         ViewManager.openAdminLoginPage();
        ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void saveBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
        String firstname= FirstnameTF.getText();
        String lastname=lastNameTF.getText();
        String email = emailTF.getText();
        String username = userNameTF.getText();
        String password = passwordTF.getText();
        int phone=Integer.parseInt(PhoneTF.getText());
        int age=Integer.parseInt(ageFT.getText());
        String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        String role = "patient";
        // make an user object having this data
        User user = new User(username, password, firstname, lastname, age, email, phone, gender, role);
        // save the user in database by save method
        user.save();
        
        
        ViewManager.AdminDashboard.changeSceneToAdminDashboardPage();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }
    

    @FXML
    private void cancelBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToAdminDashboardPage();

    }

    @FXML
    private void actionFmaleRB(ActionEvent event) {
    }

    @FXML
    private void actionmaleRB(ActionEvent event) {
    }
    
}
