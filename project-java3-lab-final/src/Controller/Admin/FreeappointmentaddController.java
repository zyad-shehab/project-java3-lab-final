/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.AdminFXML;

import Model.User;
import Model.appointment;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class FreeappointmentaddController implements Initializable {

    @FXML
    private Button BookedappointmentBTN;
    @FXML
    private Button PatientsBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private Button CancelBTN;
    @FXML
    private TextField AppointmentDayTF;
    @FXML
    private TextField AppointmentTimeTF;
    @FXML
    private Button saveBTN;
    
    @FXML
    private TextField AppointmentDateTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionBookedappointmentBTN(ActionEvent event) {
            ViewManager.AdminDashboard.changeSceneToBookedAppointment();

    }

    @FXML
    private void actionPatientsBTN(ActionEvent event) {
            ViewManager.AdminDashboard.changeSceneToAdminDashboardPage();

    }

    @FXML
    private void actionLogoutBTN(ActionEvent event) throws IOException {
         ViewManager.openAdminLoginPage();
        ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void actionCancelBTN(ActionEvent event) {
       ViewManager.AdminDashboard.changeSceneToFreeAppointment();

    }

    @FXML
    private void actionsaveBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
        String appointmentdate= AppointmentDateTF.getText();
        String appointmentday= AppointmentDayTF.getText();
        String appointmentTime=AppointmentTimeTF.getText();
        String status="free";
        
        // make an user object having this data
        appointment appo = new appointment(appointmentdate, appointmentday,appointmentTime, status);
        // save the user in database by save method
        appo.save();
        
        
        ViewManager.AdminDashboard.changeSceneToFreeAppointment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }
    
}
