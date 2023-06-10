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
public class AdminLoginPage extends Stage{
         private Scene AdminLogin;
        public AdminLoginPage() throws IOException {

        FXMLLoader AdminLoginpage = new FXMLLoader(getClass().getResource("AdminFXML/AdminLoginpage.fxml"));
        Parent AdminLoginRoot = AdminLoginpage.load();     
        AdminLogin = new Scene(AdminLoginRoot);
        
        this.setScene(AdminLogin);
        this.setTitle("Admin Login");
        }
         public void changeSceneToAdminLogin(){
        this.setScene(AdminLogin);
    }
}
