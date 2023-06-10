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
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zyad shehab
 */
public class appointment {
    private int id;
    private String appointmentdate;
    private String appointmentday;
    private String appointmenttime;
    private String ststus;//enum("free","booked")

    public appointment(String appointmentdate, String appointmentday, String appointmenttime, String ststus) {
        
        this.appointmentdate = appointmentdate;
        this.appointmentday = appointmentday;
        this.appointmenttime = appointmenttime;
        this.ststus = ststus;
    }

    public appointment(int id, String ststus) {
        this.id = id;
        this.ststus = ststus;
    }
    public appointment(String appointmentdate, String appointmentday, String appointmenttime) {
 
        this.appointmentdate = appointmentdate;
        this.appointmentday = appointmentday;
        this.appointmenttime = appointmenttime;
    }
    
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public String getAppointmentday() {
        return appointmentday;
    }

    public void setAppointmentday(String appointmentday) {
        this.appointmentday = appointmentday;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    public String getStstus() {
        return ststus;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }
    public int save() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "INSERT INTO appointments (id,appointmentdate, appointmentday, appointmenttime, status) VALUES(?, ?, ?, ?,?)";
        ps = c.prepareStatement(sql);
        
        ps.setInt(1, this.getId());
        ps.setString(2, this.getAppointmentdate());
        ps.setString(3, this.getAppointmentday());
        ps.setString(4, this.getAppointmenttime());
        ps.setString(5, this.getStstus());
        
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getId()
                    +"appointments  was added successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
    
    
    
    public static ArrayList<appointment> getAllUsers() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE status='free' ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            appointment appo;
            appo = new appointment(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            appo.setId(rs.getInt(1));
            appointments.add(appo);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return appointments;
    }
    public static ArrayList<appointment> getAllUserswaiting() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<appointment> booked = new ArrayList<>();
        String sql = "SELECT appointmentdate ,appointmentday, appointmenttime FROM"
                + " booked_appointments ,appointments WHERE "
                + "booked_appointments.appointmentid=appointments.id "
                + "AND booked_appointments.status='waiting' AND ;";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            appointment bookeds = new appointment(rs.getString(1), rs.getString(2), rs.getString(3));
            booked.add(bookeds);    
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    public static ArrayList<appointment> getAllUsersfinished() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<appointment> booked = new ArrayList<>();
        String sql = "SELECT appointmentdate ,appointmentday, appointmenttime , doctorcommnet FROM"
                + " booked_appointments ,appointments WHERE "
                + "booked_appointments.appointmentid=appointments.id "
                + "AND booked_appointments.status='finished';";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            appointment bookeds = new appointment(rs.getString(1), rs.getString(2), rs.getString(3));
            booked.add(bookeds);    
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    
    
    public int update() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE appointments SET appointmentdate=?, appointmentday=?, appointmenttime=? , status=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setString(1,  this.getAppointmentdate());
        ps.setString(2, this.getAppointmentday());
        ps.setString(3, this.getAppointmenttime());
        ps.setString(4, this.getStstus());
        ps.setInt(5, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("appointments with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
     public int updatemakebooked() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE appointments SET  status=? WHERE ID=?";
        ps = c.prepareStatement(sql); 
        
        ps.setString(1, this.getStstus());
        ps.setInt(2, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("appointments with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
    
    
    
    public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "DELETE FROM appointments WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The appointments with id : "+this.getId()+" was deleted successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
}
