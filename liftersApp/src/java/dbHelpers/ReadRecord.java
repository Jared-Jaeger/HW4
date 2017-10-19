/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lifters;

/**
 *
 * @author itzjs
 */
public class ReadRecord {
     private Connection conn;
    private ResultSet results;
    
    private Lifters lifter = new Lifters();
    private int lifterID;
    
    public ReadRecord(int lifterID){
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.lifterID = lifterID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url,username,passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void doRead(){
        try {
            String query = "SELECT * FROM Lifters WHERE lifterID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1,lifterID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            lifter.setLifterID(this.results.getInt("lifterID"));
            lifter.setLifterName(this.results.getString("lifterName"));
            lifter.setLifterAge(this.results.getInt("lifterAge"));
            lifter.setLifterWeight(this.results.getInt("lifterWeight"));
            lifter.setLifterHeight(this.results.getString("lifterHeight"));
            lifter.setLifterClass(this.results.getString("lifterClass"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Lifters getLifter(){
        return this.lifter;
    }
}
