/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zyad shehab
 */
public class BookedappointmentforAdmin {
    private int id;
    private String date;
    private String day;
    private String time;
    private String patientname;
    private String status;
    private String drcoment;

    public BookedappointmentforAdmin(String date, String day, String time, String patientname, String status ,String drcoment) {
        this.date = date;
        this.day = day;
        this.time = time;
        this.patientname = patientname;
        this.status = status;
        this.drcoment=drcoment;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public static ArrayList<BookedappointmentforAdmin> getAllUsers() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedappointmentforAdmin> booked = new ArrayList<>();
        String sql = 
        "SELECT appointmentdate , appointmentday  , appointmenttime  ,"+ 
        "CONCAT(firstname,' ',lastname) , appointments.status as status\n" +
        "FROM booked_appointments \n" +
        "INNER JOIN appointments  ON booked_appointments.appointmentid=appointments.id\n" +
        "INNER JOIN users  ON booked_appointments.userid=users.id WHERE booked_appointments.status='waiting'  and appointments.status='booked' ;";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            BookedappointmentforAdmin bookeds = new BookedappointmentforAdmin
        (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),null);
            booked.add(bookeds);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    
     
}
