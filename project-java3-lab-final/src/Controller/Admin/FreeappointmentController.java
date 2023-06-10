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
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class FreeappointmentController implements Initializable {
    public static appointment selectedappToUpdate;
    public static Stage updateStageapp;
    
    @FXML
    private Button BookedappointmentBTN;
    @FXML
    private Button PatientsBTN;
    @FXML
    private Button FreeappointmentBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private Button AddnewappointmentBTN;
    @FXML
    private Button DeleteappointmentBTN;
    @FXML
    private Button UpdateappointmentBTN;
    @FXML
    private Button ShowappointmentBTN;
    @FXML
    private TableView<appointment> TableView;
    @FXML
    private TableColumn<appointment, Date> DateCV;
    @FXML
    private TableColumn<appointment, String> DayCV;
    @FXML
    private TableColumn<appointment, Time> TimeCV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateCV.setCellValueFactory(new PropertyValueFactory("appointmentdate"));        
        DayCV.setCellValueFactory(new PropertyValueFactory("appointmentday"));       
        TimeCV.setCellValueFactory(new PropertyValueFactory("appointmenttime"));       
        // TODO
    }    

    @FXML
    private void BookedappointmentBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToBookedAppointment();

    }

    @FXML
    private void PatientsBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToAdminDashboardPage();

    }

    @FXML
    private void FreeappointmentBTN(ActionEvent event) {
    }

    @FXML
    private void LogoutBTN(ActionEvent event) throws IOException {
        ViewManager.openAdminLoginPage();
        ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void AddnewappointmentBTN(ActionEvent event) {
        ViewManager.AdminDashboard.changeSceneToFreeAppointmentAdd();
    }

    @FXML
    private void DeleteappointmentBTN(ActionEvent event) {
         if(TableView.getSelectionModel().getSelectedItem() != null){
            //store the selected user from the TableView in new user object
            appointment selectedappo = TableView.getSelectionModel().getSelectedItem();
            
            //show an confirmation alert and make the deletion on confirm event
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("appointment delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this appointment ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    //delete the selected user from database table using delete method in our User model
                    selectedappo.delete();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDashboardpageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminDashboardpageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
            deletedSuccessAlert.setTitle("appointment deleted");
            deletedSuccessAlert.setContentText("appointment deleted");
            deletedSuccessAlert.show();  
            }
            });
        
        }else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an appointment");
        warnAlert.setContentText("Please select an appointment from the table view");
        warnAlert.show();  
        }
    }

    @FXML
    private void UpdateappointmentBTN(ActionEvent event) throws IOException {
         if(TableView.getSelectionModel().getSelectedItem() != null){
        //store the selected user from the TableView in our global var user selectedUserToUpdate   
        selectedappToUpdate = TableView.getSelectionModel().getSelectedItem();
        //load update page fxml
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/Freeappointmentupdate.fxml"));
        Parent rootUpdate = loaderUpdate.load();     
        Scene updateUserScene = new Scene(rootUpdate); 
        //store loaded fxml in our global stage updateStage and show it
        updateStageapp = new Stage();
        updateStageapp.setScene(updateUserScene);
        updateStageapp.setTitle("Update appointment " + selectedappToUpdate.getId() );
        updateStageapp.show();
        }
        else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an appointment");
        warnAlert.setContentText("Please select an appointment from the table view");
        warnAlert.show();
    }
    }

    @FXML
    private void ShowappointmentBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
      ObservableList<appointment> usersList =
      FXCollections.observableArrayList(appointment.getAllUsers());
      
      TableView.setItems(usersList);
    }
    
}
