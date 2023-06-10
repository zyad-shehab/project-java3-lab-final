/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;

/**
 *
 * @author zyad shehab
 */
public class ViewManager {
    public static AdminDashboardPage AdminDashboard;
    public static AdminLoginPage AdminLogin;
    public static PatientDashboardPage PatientDashboard;
    public static PatientLoginPage PatientLogin;
    public static PatientRegisterPage PatientRegister;
    
    
    private ViewManager(){   
    }
    
    public static void openAdminDashboardPage() throws IOException{
        if (AdminDashboard == null) {
            AdminDashboard = new AdminDashboardPage();
            AdminDashboard.show();
        } else {
            AdminDashboard.show();
        }
        
    }
    public static void closeAdminDashboardPage(){
        if(AdminDashboard != null)
            AdminDashboard.close();
    }
    
    
    public static void openAdminLoginPage() throws IOException{
        if (AdminLogin == null) {
            AdminLogin = new AdminLoginPage();
            AdminLogin.show();
        } else {
            AdminLogin.show();
        }
        
    }
    public static void closeAdminLoginPage(){
        if(AdminLogin != null)
            AdminLogin.close();
    }
    
    public static void openPatientDashboardPage() throws IOException{
        if (PatientDashboard == null) {
            PatientDashboard = new PatientDashboardPage();
            PatientDashboard.show();
        } else {
            PatientDashboard.show();
        }
        
    }
    public static void closePatientDashboardPage(){
        if(PatientDashboard != null)
            PatientDashboard.close();
    }
    
    public static void openPatientLoginPage() throws IOException{
        if (PatientLogin == null) {
            PatientLogin = new PatientLoginPage();
            PatientLogin.show();
        } else {
            PatientLogin.show();
        }
        
    }
    public static void closePatientLoginPage(){
        if(PatientLogin != null)
            PatientLogin.close();
    }
    public static void openPatientRegisterPage() throws IOException{
        if (PatientRegister == null) {
            PatientRegister = new PatientRegisterPage();
            PatientRegister.show();
        } else {
            PatientRegister.show();
        }
        
    }
    public static void closePatientRegisterPage(){
        if(PatientRegister != null)
            PatientRegister.close();
    }
    
}
