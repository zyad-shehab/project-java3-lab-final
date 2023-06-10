/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.PatientFXML;

import Model.appointment;
import Model.bookedappointment;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class PatientDashboardpageController implements Initializable {
    private static appointment selectitem;

    @FXML
    private Button BookedwaitingBTN;
    @FXML
    private Button BookedfinishedBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private Button BookthisappointmentBTN;
    @FXML
    private TableView<appointment> TableView;
    @FXML
    private TableColumn<appointment, Date> AppointmentDateCV;
    @FXML
    private TableColumn<appointment, String> AppointmentDayCV;
    @FXML
    private TableColumn<appointment, Time> AppointmentTimeCV;
    @FXML
    private Button ShowallfreeappointmentBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AppointmentDateCV.setCellValueFactory(new PropertyValueFactory("appointmentdate"));        
        AppointmentDayCV.setCellValueFactory(new PropertyValueFactory("appointmentday"));       
        AppointmentTimeCV.setCellValueFactory(new PropertyValueFactory("appointmenttime"));
    }    

    @FXML
    private void BookedwaitingBTN(ActionEvent event) {
                ViewManager.PatientDashboard.changeSceneToBookedWaitingAppointment();

    }

    @FXML
    private void BookedfinishedBTN(ActionEvent event) {
                ViewManager.PatientDashboard.changeSceneToBookedFinishedAppointment();

    }

    @FXML
    private void LogoutBTN(ActionEvent event) throws IOException {
         ViewManager.openPatientLoginPage();
        ViewManager.closePatientDashboardPage();
    }

    @FXML
    private void BookthisappointmentBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(TableView.getSelectionModel().getSelectedItem() != null){
            
           selectitem = TableView.getSelectionModel().getSelectedItem();
           int id = selectitem.getId();
           int useridinter=PatientLoginpageController.identer;
           String status="waiting";
           
           bookedappointment bookappo=new bookedappointment(id, useridinter, status,"");
           appointment appo=new appointment(id, "booked");
           appo.updatemakebooked();
           bookappo.save();
           
        }else{
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setTitle("Select an appointment");
            warnAlert.setContentText("Please select an appointment from the table view");
            warnAlert.show();
        }
        
    }

    @FXML
    private void Showallfreeappointment(ActionEvent event) throws SQLException, ClassNotFoundException {
      ObservableList<appointment> usersList =
      FXCollections.observableArrayList(appointment.getAllUsers());    
      TableView.setItems(usersList);
    }
    
}
