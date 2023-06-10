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
public class PatientsupdateController implements Initializable {
    private User oldUser;

    @FXML
    private Button cancelBTN;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField PasswordTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField ageTF;
    @FXML
    private RadioButton maleRB;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton fmaleRB;
    @FXML
    private Button updateBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldUser = AdminDashboardpageController.selectedUserToUpdate;
        
//        firstNameTF.setText(oldUser.getFirstname());
//        lastNameTF.setText(oldUser.getLastname());
//        emailTF.setText(oldUser.getEmail());
//        userNameTF.setText(oldUser.getUsername());
//        PasswordTF.setText(oldUser.getPassword());
//        phoneTF.setText(Integer.toString(oldUser.getPhone()));
//        ageTF.setText(Integer.toString(oldUser.getAge()));
//        
//        if (oldUser.getGender().equals("female")) {
//            genderGroup.selectToggle(fmaleRB);
//        } 
   
    }    

    private void BookedappointmentBTN(ActionEvent event) {
        ViewManager.AdminDashboard.changeSceneToBookedAppointment();

    }

    private void FreeappointmentBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToFreeAppointment();

    }

    private void LogoutBTN(ActionEvent event) throws IOException {
         ViewManager.openAdminLoginPage();
         ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void actioncancelBTN(ActionEvent event) {
    AdminDashboardpageController.updateStage.close();

    }

    
    

    @FXML
    private void actionupdateBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
        String firstname=firstNameTF.getText();
        String lastname=lastNameTF.getText();
        String email = emailTF.getText();
        String username = userNameTF.getText();
        String password = PasswordTF.getText();
        int phone =Integer.parseInt(phoneTF.getText());
        int age = Integer.parseInt(ageTF.getText());
        String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        String role = "patient";

        User newUser = new User(username,password,firstname,lastname,age,email,phone,gender,role);       
        
        newUser.setId(oldUser.getId());     

        newUser.update();
        
        AdminDashboardpageController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
        
    }

    @FXML
    private void actionmaleRB(ActionEvent event) {
    }

    @FXML
    private void actionfmaleRB(ActionEvent event) {
    }
    
       }





