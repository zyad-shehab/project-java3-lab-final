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
public class PatientRegisterPage extends Stage{
        private Scene PatientRegister;
         
        public PatientRegisterPage() throws IOException {

        FXMLLoader PatientRegisterPage = new FXMLLoader(getClass().getResource("PatientFXML/PatientRegisterpage.fxml"));
        Parent PatientRegisterRoot = PatientRegisterPage.load();     
        PatientRegister = new Scene(PatientRegisterRoot);
        
        this.setScene(PatientRegister);
        this.setTitle("Patient Register");
        }
        
         public void changeSceneToPatientRegister(){
        this.setScene(PatientRegister);
    }
}
