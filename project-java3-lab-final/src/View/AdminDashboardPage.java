/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author zyad shehab
 */
public class AdminDashboardPage extends Stage{
     private Scene AdminDashboardPage;
     private Scene BookedAppointment;
     private Scene FreeAppointment;
     private Scene FreeAppointmentAdd;
     private Scene FreeAppointmentUpdate;
     private Scene PatientsAdd;
     private Scene PatientsUpdate;
    
    public AdminDashboardPage() throws IOException {
        
        FXMLLoader AdminDashboard = new FXMLLoader(getClass().getResource("AdminFXML/AdminDashboardpage.fxml"));
        Parent AdminDashboardPageRoot = AdminDashboard.load();     
        AdminDashboardPage = new Scene(AdminDashboardPageRoot);
        
        FXMLLoader BookedAppointmentPage = new FXMLLoader(getClass().getResource("AdminFXML/Bookedappointment.fxml"));
        Parent BookedAppointmentRoot = BookedAppointmentPage.load();     
        BookedAppointment = new Scene(BookedAppointmentRoot);
        
        FXMLLoader FreeAppointmentPage = new FXMLLoader(getClass().getResource("AdminFXML/Freeappointment.fxml"));
        Parent FreeAppointmentRoot = FreeAppointmentPage.load();     
        FreeAppointment = new Scene(FreeAppointmentRoot);
        
        
        FXMLLoader FreeAppointmentAddPage = new FXMLLoader(getClass().getResource("AdminFXML/Freeappointmentadd.fxml"));
        Parent FreeAppointmentAddRoot = FreeAppointmentAddPage.load();     
        FreeAppointmentAdd = new Scene(FreeAppointmentAddRoot);
        
        
        FXMLLoader FreeAppointmentUpdatePage = new FXMLLoader(getClass().getResource("AdminFXML/Freeappointmentupdate.fxml"));
        Parent FreeAppointmentUpdateRoot = FreeAppointmentUpdatePage.load();     
        FreeAppointmentUpdate = new Scene(FreeAppointmentUpdateRoot);
        
        
        FXMLLoader PatientsAddPage = new FXMLLoader(getClass().getResource("AdminFXML/Patientsadd.fxml"));
        Parent PatientsAddRoot = PatientsAddPage.load();     
        PatientsAdd = new Scene(PatientsAddRoot);
        
        
        FXMLLoader PatientsUpdatePage = new FXMLLoader(getClass().getResource("AdminFXML/Patientsupdate.fxml"));
        Parent PatientsUpdateRoot = PatientsUpdatePage.load();     
        PatientsUpdate = new Scene(PatientsUpdateRoot);
        
        this.setScene(AdminDashboardPage);
        this.setTitle("Admin Dashboard");   
    }
    public void changeSceneToAdminDashboardPage(){
        this.setScene(AdminDashboardPage);
    }
    public void changeSceneToBookedAppointment(){
        this.setScene(BookedAppointment);
    }
    public void changeSceneToFreeAppointment(){
        this.setScene(FreeAppointment);
    }
    public void changeSceneToFreeAppointmentAdd(){
        this.setScene(FreeAppointmentAdd);
    }
    public void changeSceneToFreeAppointmentUpdate(){
        this.setScene(FreeAppointmentUpdate);
    }
    public void changeSceneToPatientsAdd(){
        this.setScene(PatientsAdd);
    }
    public void changeSceneToPatientsUpdate(){
        this.setScene(PatientsUpdate);
    }

}
