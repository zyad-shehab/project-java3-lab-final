/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.PatientFXML;

import Model.appointment;
import Model.bookedappointment;
import static View.AdminFXML.BookedappointmentController.selectedbookToUpdate;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class BookedfinishedappointmentsController implements Initializable {
    private static bookedappointment selecteditem;
    
    @FXML
    private Button BookedwaitingBTN;
    @FXML
    private Button FreeappointmentBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private Label DRcommentLabel;
    @FXML
    private Button ShowcommentBTN;
    @FXML
    private Button ShowallfreeappointmentBTN;
    @FXML
    private TableView<bookedappointment> TableView;
    @FXML
    private TableColumn<bookedappointment, Date> AppointmentDateCV;
    @FXML
    private TableColumn<bookedappointment, String> AppointmentDayCV;
    @FXML
    private TableColumn<bookedappointment, Time> AppointmentTimeCV;

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
    private void BookedwaitingBTN(ActionEvent event) {
     ViewManager.PatientDashboard.changeSceneToBookedWaitingAppointment();

    }

    @FXML
    private void FreeappointmentBTN(ActionEvent event) {
        ViewManager.PatientDashboard.changeSceneToPatientDashboard();

    }

    @FXML
    private void LogoutBTN(ActionEvent event) throws IOException {
         ViewManager.openPatientLoginPage();
        ViewManager.closePatientDashboardPage();
    }

    @FXML
    private void ShowcommentBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(TableView.getSelectionModel().getSelectedItem() != null){
            
           selecteditem = TableView.getSelectionModel().getSelectedItem();        
           
           DRcommentLabel.setText(selecteditem.getDoctorcommnet());  
        }else{
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setTitle("Select an appointment");
            warnAlert.setContentText("Please select an appointment from the table view");
            warnAlert.show();
        }
    }
    @FXML
    private void Showallfreeappointment(ActionEvent event) throws SQLException, ClassNotFoundException {
      ObservableList<bookedappointment> usersList =
      FXCollections.observableArrayList(bookedappointment.getAllUsersfinished(PatientLoginpageController.identer));    
      TableView.setItems(usersList);
    }
    
}
