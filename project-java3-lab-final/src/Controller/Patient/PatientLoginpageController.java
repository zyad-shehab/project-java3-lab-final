/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.PatientFXML;

import Model.DB;
import Model.User;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zyad shehab
 */
public class PatientLoginpageController implements Initializable {
    public static int  identer;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button loginBTN;
    @FXML
    private Button RegisterBTN;
    @FXML
    private Button adminBTN;
    @FXML
    private Label IncorrectLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginBTN(ActionEvent event) throws IOException, SQLException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS WHERE role='patient' ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            if(rs.getString(2).matches(userNameTF.getText()) && rs.getString(3).matches(passwordTF.getText())){
               identer =rs.getInt(1);
               ViewManager.openPatientDashboardPage();
               ViewManager.closePatientLoginPage();
            }            
        }
        IncorrectLabel.setText("Incorrect username or password");
        if (ps != null){
            ps.close();
        }
        c.close();
        
    }

    @FXML
    private void RegisterBTN(ActionEvent event) throws IOException {
        ViewManager.openPatientRegisterPage();
            ViewManager.closePatientLoginPage();
    }

    @FXML
    private void adminBTN(ActionEvent event) throws IOException {
        ViewManager.openAdminLoginPage();
        ViewManager.closePatientLoginPage();
    }
    
}
