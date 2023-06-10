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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class BookedwaitingappointmentsController implements Initializable {

    @FXML
    private Button FreeappointmentBTN;
    @FXML
    private Button BookedfinishedBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private TableView<bookedappointment> TableView;
    @FXML
    private TableColumn<bookedappointment, Date> AppointmentDateCV;
    @FXML
    private TableColumn<bookedappointment, String> AppointmentDayCV;
    @FXML
    private TableColumn<bookedappointment, Time> AppointmentTimeCV;
    @FXML
    private Button ShowallfreeappointmentBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AppointmentDateCV.setCellValueFactory(new PropertyValueFactory("date"));        
        AppointmentDayCV.setCellValueFactory(new PropertyValueFactory("day"));       
        AppointmentTimeCV.setCellValueFactory(new PropertyValueFactory("time"));
    }    

    @FXML
    private void FreeappointmentBTN(ActionEvent event) {
                ViewManager.PatientDashboard.changeSceneToPatientDashboard();

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
    private void Showallfreeappointment(ActionEvent event) throws SQLException, ClassNotFoundException {
      ObservableList<bookedappointment> usersList =
      FXCollections.observableArrayList(bookedappointment.getAllUserswaiting(PatientLoginpageController.identer));    
      TableView.setItems(usersList);
    }
    
}
