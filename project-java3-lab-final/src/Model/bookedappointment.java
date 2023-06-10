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
public class bookedappointment {
    private int id;
    private int appointmentid;
    private int userid;
    private String statusbook;
    private String doctorcommnet;
    
    private String date;
    private String day;
    private String time;
    private String patientname;

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

    public String getStatusappo() {
        return statusappo;
    }

    public void setStatusappo(String statusappo) {
        this.statusappo = statusappo;
    }
    private String statusappo;

    public bookedappointment(int appointmentid, int userid, String statusbook) {
        this.appointmentid = appointmentid;
        this.userid = userid;
        this.statusbook = statusbook;
    }
    

    public bookedappointment(String doctorcommnet, String date, String day, String time) {
        this.doctorcommnet = doctorcommnet;
        this.date = date;
        this.day = day;
        this.time = time;
    }

    public bookedappointment(String date, String day, String time) {
        this.date = date;
        this.day = day;
        this.time = time;
    }
    
    
    
    public bookedappointment(String statusbook, String date, String day, String time, String patientname) {
        this.statusbook = statusbook;
        this.date = date;
        this.day = day;
        this.time = time;
        this.patientname = patientname;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStatusbook() {
        return statusbook;
    }

    public void setStatus(String status) {
        this.statusbook = status;
    }

    public String getDoctorcommnet() {
        return doctorcommnet;
    }

    public void setDoctorcommnet(String doctorcommnet) {
        this.doctorcommnet = doctorcommnet;
    }

    public bookedappointment(int appointmentid, int userid, String statusbook, String doctorcommnet) {
        this.appointmentid = appointmentid;
        this.userid = userid;
        this.statusbook = statusbook;
        this.doctorcommnet = doctorcommnet;
    }
    
    public bookedappointment(String drc){
        this.doctorcommnet=drc;
    }
    public bookedappointment(String statusbook,String doctorcommnet){
        this.statusbook = statusbook;
        this.doctorcommnet = doctorcommnet;
    }
    
    public int save() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "INSERT INTO booked_appointments (id,appointmentid,userid,status,doctorcommnet) VALUES (?, ?, ?, ?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setInt(2,this.getAppointmentid());
        ps.setInt(3, this.getUserid());
        ps.setString(4, this.getStatusbook());
        ps.setString(5, this.getDoctorcommnet());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getAppointmentid()
                    +" booked appointments was added successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
   
     public static ArrayList<bookedappointment> getAllUsers() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<bookedappointment> booked = new ArrayList<>();
        String sql = 
        "SELECT booked_appointments.id, appointmentdate , appointmentday  , appointmenttime  ,"+ 
        "CONCAT(firstname,' ',lastname) , booked_appointments.status as status\n" +
        "FROM booked_appointments \n" +
        "INNER JOIN appointments  ON booked_appointments.appointmentid=appointments.id\n" +
        "INNER JOIN users  ON booked_appointments.userid=users.id WHERE appointments.status='booked' ;";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
        bookedappointment bookeds = new bookedappointment(rs.getString(6), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5));
        bookeds.setId(rs.getInt(1));
        booked.add(bookeds);   
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
//     public static String getdrCommnet(int id) throws SQLException, ClassNotFoundException{
//        Connection c = DB.getInstance().getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT booked_appointments.doctorcommnet\n" +
//        "FROM booked_appointments WHERE booked_appointments.id=4 ;";
//        
//        ps = c.prepareStatement(sql);
//        rs = ps.executeQuery();
//        
//            bookedappointment bookeds = new bookedappointment(rs.getString(1));
//            String comm=bookeds.getDoctorcommnet();
//            
//        if (ps != null){
//            ps.close();
//        }
//        c.close();
//        return comm;
//    }
    
//     public int Bookthis() throws SQLException, ClassNotFoundException{
//        Connection c = DB.getInstance().getConnection();
//        PreparedStatement ps = null;
//        int recordCounter =0;
//        String sql = "INSERT INTO booked_appointments(appointmentid, userid, status) VALUES(?,?, ?) ;";
//        ps = c.prepareStatement(sql);
//        
//        ps.setInt(1, this.getAppointmentid());
//        ps.setInt(2, this.getUserid());
//        ps.setString(3, this.getStatusbook());
//        
//        
//        recordCounter = ps.executeUpdate();
//        if (recordCounter > 0) {
//            System.out.println(this.getId()
//                    +"appointments  was booked successfully!");
//        }
//        if (ps != null){
//            ps.close();
//        }
//        c.close();
//        return recordCounter;  
//    }
     
        public int update() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE booked_appointments SET booked_appointments.status=? , "
                                                  + "doctorcommnet=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getStatusbook());
        ps.setString(2, this.getDoctorcommnet());
        ps.setInt(3, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("booked with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
       public int update2() throws SQLException, ClassNotFoundException{

        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE booked_appointments SET status=? , doctorcommnet=? WHERE id=? ;";
        ps = c.prepareStatement(sql);
        ps.setString(1,this.getStatusbook());
        ps.setString(2, this.getDoctorcommnet());
        ps.setInt(3, this.getId());
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
        String sql = "DELETE FROM booked_appointments WHERE ID=? ";
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
    public static ArrayList<bookedappointment> getAllUsersbyfname(String s) throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<bookedappointment> booked = new ArrayList<>();
        String sql = 
        "SELECT booked_appointments.id, appointmentdate , appointmentday  , appointmenttime  ,"+ 
        "CONCAT(firstname,' ',lastname) , booked_appointments.status as status\n" +
        "FROM booked_appointments \n" +
        "INNER JOIN appointments  ON booked_appointments.appointmentid=appointments.id\n" +
        "INNER JOIN users  ON booked_appointments.userid=users.id WHERE appointments.status='booked' and firstname LIKE  '%"+s+"%';  ;";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
        bookedappointment bookeds = new bookedappointment(rs.getString(6), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5));
        bookeds.setId(rs.getInt(1));
        booked.add(bookeds);   
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    public static ArrayList<bookedappointment> getAllbookedappointment() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<bookedappointment> booked = new ArrayList<>();
        String sql = 
        "SELECT appointmentdate , appointmentday  , appointmenttime  ,"+ 
        "CONCAT(firstname,' ',lastname) , appointments.status as status\n" +
        "FROM booked_appointments \n" +
        "INNER JOIN appointments  ON booked_appointments.appointmentid=appointments.id\n" +
        "INNER JOIN users  ON booked_appointments.userid=users.id WHERE booked_appointments.status='waiting'  and appointments.status='booked' ;";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
        bookedappointment bookedss = new bookedappointment(rs.getString(5), rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4));
        booked.add(bookedss);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    
    public static ArrayList<bookedappointment> getAllUsersfinished(int id) throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<bookedappointment> booked = new ArrayList<>();
        String sql = "SELECT booked_appointments.id, appointments.appointmentdate"
                + " ,appointments.appointmentday ,appointments.appointmenttime,booked_appointments.doctorcommnet \n" 
                + "FROM appointments JOIN booked_appointments on"
                + " appointments.id=booked_appointments.appointmentid WHERE"
                + " booked_appointments.userid="+id+" AND booked_appointments.status='finished';";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            bookedappointment bookeds = new bookedappointment(rs.getString(2),rs.getString(3), rs.getString(4));
            bookeds.setDoctorcommnet(rs.getString(5));
            bookeds.setId(rs.getInt(1));
            booked.add(bookeds);    
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    
    
    
    public static ArrayList<bookedappointment> getAllUserswaiting(int id) throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<bookedappointment> booked = new ArrayList<>();
        String sql = "SELECT booked_appointments.id, appointments.appointmentdate"
                + " ,appointments.appointmentday ,appointments.appointmenttime,booked_appointments.doctorcommnet \n" 
                + "FROM appointments JOIN booked_appointments on"
                + " appointments.id=booked_appointments.appointmentid WHERE"
                + " booked_appointments.userid="+id+" AND booked_appointments.status='waiting';";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            bookedappointment bookeds = new bookedappointment(rs.getString(2),rs.getString(3), rs.getString(4));
            bookeds.setDoctorcommnet(rs.getString(5));
            bookeds.setId(rs.getInt(1));
            booked.add(bookeds);    
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return booked;
    }
    
}
