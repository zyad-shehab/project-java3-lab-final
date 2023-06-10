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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class AdminDashboardpageController implements Initializable {
    public static User selectedUserToUpdate;
    public static Stage updateStage;
    
    
    @FXML
    private Button BookedappointmentBTN;
    @FXML
    private Button FreeappointmentBTN;
    @FXML
    private Button LogoutBTN;
    @FXML
    private TextField searchTF;
    @FXML
    private Button searchBTN;
    @FXML
    private Button DeleteBTN;
    @FXML
    private Button UpdateBTN;
    @FXML
    private Button AddNewBTN;
    @FXML
    private Button ShowAllPatientsBTN;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> firstNameCV;
    @FXML
    private TableColumn<User, String> lastNameCV;
    @FXML
    private TableColumn<User, Integer> ageCV;
    @FXML
    private TableColumn<User, String> emailCV;
    @FXML
    private TableColumn<User, Integer> phoneCV;
    @FXML
    private TableColumn<User, String> genderCV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        firstNameCV.setCellValueFactory(new PropertyValueFactory("firstname"));        
        lastNameCV.setCellValueFactory(new PropertyValueFactory("lastname"));       
        ageCV.setCellValueFactory(new PropertyValueFactory("age"));       
        emailCV.setCellValueFactory(new PropertyValueFactory("email"));        
        phoneCV.setCellValueFactory(new PropertyValueFactory("phone"));        
        genderCV.setCellValueFactory(new PropertyValueFactory("gender"));
    }    

    @FXML
    private void actionBookedappointment(ActionEvent event) {
            ViewManager.AdminDashboard.changeSceneToBookedAppointment();
    }

    @FXML
    private void actionFreeappointment(ActionEvent event) {
            ViewManager.AdminDashboard.changeSceneToFreeAppointment();
    }

    @FXML
    private void actionLogout(ActionEvent event) throws IOException {
               ViewManager.openAdminLoginPage();
               ViewManager.closeAdminDashboardPage();
    }

    @FXML
    private void actionsearchBTN(ActionEvent event) throws SQLException, ClassNotFoundException {
      String sarch=searchTF.getText();
      ObservableList<User> usersList =
      FXCollections.observableArrayList(User.getAllUsersbyfname(sarch));      
      tableView.setItems(usersList);
    }

    @FXML
    private void actionDeleteBTN(ActionEvent event) {
         if(tableView.getSelectionModel().getSelectedItem() != null){
            //store the selected user from the TableView in new user object
            User selectedUser = tableView.getSelectionModel().getSelectedItem();
            
            //show an confirmation alert and make the deletion on confirm event
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("User delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this user ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    //delete the selected user from database table using delete method in our User model
                    selectedUser.delete();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDashboardpageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminDashboardpageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
            deletedSuccessAlert.setTitle("User deleted");
            deletedSuccessAlert.setContentText("User deleted");
            deletedSuccessAlert.show();  
            }
            });
        
        }else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an user");
        warnAlert.setContentText("Please select an user from the table view");
        warnAlert.show();  
        }
    }

    @FXML
    private void actionUpdateBTN(ActionEvent event) throws IOException {
        if(tableView.getSelectionModel().getSelectedItem() != null){
        //store the selected user from the TableView in our global var user selectedUserToUpdate   
        selectedUserToUpdate = tableView.getSelectionModel().getSelectedItem();
        //load update page fxml
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/Patientsupdate.fxml"));
        Parent rootUpdate = loaderUpdate.load();     
        Scene updateUserScene = new Scene(rootUpdate); 
        //store loaded fxml in our global stage updateStage and show it
        updateStage = new Stage();
        updateStage.setScene(updateUserScene);
        updateStage.setTitle("Update user " + selectedUserToUpdate.getUsername() );
        updateStage.show();
        }
        else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an user");
        warnAlert.setContentText("Please select an user from the table view");
        warnAlert.show();
    }
    }

    @FXML
    private void actionAddNewBTN(ActionEvent event) {
                ViewManager.AdminDashboard.changeSceneToPatientsAdd();
    }

    @FXML
    private void ShowAllPatients(ActionEvent event) throws SQLException, ClassNotFoundException {
      ObservableList<User> usersList =
      FXCollections.observableArrayList(User.getAllUsers());      
      tableView.setItems(usersList);
    }
}

    
