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
public class PatientDashboardPage extends Stage {
     private Scene PatientDashboard;
     private Scene BookedFinishedAppointment;
     private Scene BookedWaitingAppointment;
     public PatientDashboardPage() throws IOException {
        
        FXMLLoader PatientDashboardpage = new FXMLLoader(getClass().getResource("PatientFXML/PatientDashboardpage.fxml"));
        Parent PatientDashboardRoot = PatientDashboardpage.load();     
        PatientDashboard = new Scene(PatientDashboardRoot);
        
        
        FXMLLoader BookedFinishedAppointmentpage = new FXMLLoader(getClass().getResource("PatientFXML/bookedfinishedappointments.fxml"));
        Parent BookedFinishedAppointmentRoot = BookedFinishedAppointmentpage.load();     
        BookedFinishedAppointment = new Scene(BookedFinishedAppointmentRoot);
        
        
        FXMLLoader BookedWaitingAppointmentpage = new FXMLLoader(getClass().getResource("PatientFXML/bookedwaitingappointments.fxml"));
        Parent BookedWaitingAppointmentRoot = BookedWaitingAppointmentpage.load();     
        BookedWaitingAppointment = new Scene(BookedWaitingAppointmentRoot);
        
         this.setScene(PatientDashboard);
        this.setTitle("Patient Dashboard");
}
        public void changeSceneToPatientDashboard(){
        this.setScene(PatientDashboard);
        }
         
        public void changeSceneToBookedFinishedAppointment(){
        this.setScene(BookedFinishedAppointment);
        }
         
        public void changeSceneToBookedWaitingAppointment(){
        this.setScene(BookedWaitingAppointment);
        }
}
