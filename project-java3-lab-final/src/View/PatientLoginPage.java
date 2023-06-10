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
public class PatientLoginPage extends Stage{
    
        private Scene PatientLogin;
         
        public PatientLoginPage() throws IOException {

        FXMLLoader PatientLoginPage = new FXMLLoader(getClass().getResource("PatientFXML/PatientLoginpage.fxml"));
        Parent PatientLoginRoot = PatientLoginPage.load();     
        PatientLogin = new Scene(PatientLoginRoot);
        
        this.setScene(PatientLogin);
        this.setTitle("Patient Login");
        }
        
         public void changeSceneToPatientLogin(){
        this.setScene(PatientLogin);
    }
}
