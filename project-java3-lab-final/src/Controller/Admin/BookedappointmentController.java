/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.AdminFXML;

import Model.BookedappointmentforAdmin;
import Model.User;
import Model.appointment;
import Model.bookedappointment;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class BookedappointmentController implements Initializable {
    private bookedappointment oldUser;

    public static bookedappointment selectedbookToUpdate;

    public static Stage updateStage;

    @FXML
    private Button PatientsBTN;
    @FXML
    private Button FreeappointmentBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private TextField SearchTF;
    @FXML
    private Button searchBTN;
    @FXML
    private TextArea DrCommnetTF;
    @FXML
    private Button SaveBTN;
    @FXML
    private Button ShowBookedappointmentBTN;
    @FXML
    private TableView<bookedappointment> Tableview;
    @FXML
    private TableColumn<bookedappointment, String> DateCV;
    @FXML
    private TableColumn<bookedappointment, String> DayCV;
    @FXML
    private TableColumn<bookedappointment, String> TimeCV;
    @FXML
    private TableColumn<bookedappointment, String> patientnameCV;
    @FXML
    private TableColumn<bookedappointment, String> StatusCV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldUser = BookedappointmentController.selectedbookToUpdate;

        DateCV.setCellValueFactory(new PropertyValueFactory("date"));        
        DayCV.setCellValueFactory(new PropertyValueFactory("day"));       
        TimeCV.setCellValueFactory(new PropertyValueFactory("time"));
        patientnameCV.setCellValueFactory(new PropertyValueFactory("patientname"));
        StatusCV.setCellValueFactory(new PropertyValueFactory("statusbook"));
        
    }    

    @FXML
    private void actionPatientsBTN(ActionEvent event) throws IOException {
                 ViewManager.AdminDashboard.changeSceneToAdminDashboardPage();

    }

    @FXML
    private void actionFreeappointmentBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToFreeAppointment();

        
    }

    @FXML
    private void actionLogoutBTN(ActionEvent event) throws IOException {
         ViewManager.openAdminLoginPage();
        ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void actionSearchBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
      String search=SearchTF.getText();
      ObservableList<bookedappointment> usersList =
      FXCollections.observableArrayList(bookedappointment.getAllUsersbyfname(search));      
      Tableview.setItems(usersList);
    }

    @FXML
    private void actionSaveBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
       
       if(Tableview.getSelectionModel().getSelectedItem() != null){
           
        oldUser = Tableview.getSelectionModel().getSelectedItem();
        
        String DrCommnet =DrCommnetTF.getText();
        int id=oldUser.getId(); 
        String finsh="finished";
        
        bookedappointment Bookedappo = new bookedappointment(finsh, DrCommnet);
        Bookedappo.setId(id);
        Bookedappo.update2();  
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Saved successfully");
        alert.setContentText("DrCommnet Saveed");
        alert.showAndWait();
        }else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an appointment");
        warnAlert.setContentText("Please select an appointment from the table view");
        warnAlert.show();  
        }
        
        
        
          
        
    }

    @FXML
    private void ShowBookedappointmentBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
      ObservableList<bookedappointment> usersList =
      FXCollections.observableArrayList(bookedappointment.getAllUsers());
      
      Tableview.setItems(usersList);
    }
    
}
