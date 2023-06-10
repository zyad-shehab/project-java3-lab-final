/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.AdminFXML;

import Model.appointment;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class FreeappointmentupdateController implements Initializable {
    private appointment oldapp;
    
    @FXML
    private Button CancelBTN;
    @FXML
    private TextField AppointmentDateFT;
    @FXML
    private TextField AppointmentDayTF;
    @FXML
    private TextField AppointmentTimeTF;
    @FXML
    private Button UpdateBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldapp = FreeappointmentController.selectedappToUpdate;
        
//        AppointmentDateFT.setText(oldapp.getAppointmentdate());
//        AppointmentDayTF.setText(oldapp.getAppointmentday());
//        AppointmentTimeTF.setText(oldapp.getAppointmenttime());
        

    }    

    private void actionBookedappointmentBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToBookedAppointment();

    }

    private void actionPatientsBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToAdminDashboardPage();

    }

    private void actionLogoutBTN(ActionEvent event) throws IOException {
          ViewManager.openAdminLoginPage();
          ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void actionCancelBTN(ActionEvent event) {
       FreeappointmentController.updateStageapp.close();
    }

    @FXML
    private void actionUpdateBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
        String date=AppointmentDateFT.getText();
        String day=AppointmentDayTF.getText();
        String time = AppointmentTimeTF.getText();
        String ststus = "free";
        //make an new user object having this data
        appointment newapp = new appointment(date,day,time,ststus);       
        //set the new user id the same as the old user
        
        newapp.setId(oldapp.getId());     
        // update the user in database by update method
        newapp.update();
        
        //close the update stage using our global stage var in UsersManagmentController and show an alert
        FreeappointmentController.updateStageapp.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();       
    }
    }
    

