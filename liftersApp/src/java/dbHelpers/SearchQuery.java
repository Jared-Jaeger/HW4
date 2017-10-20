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
public class SearchQuery {
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url,username,passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public void doSearch(String lifterName){
        
        try {
            String query = "SELECT * FROM lifters WHERE UPPER(lifterName) LIKE ? ORDER BY LIFTERID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + lifterName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getHTMLTable(){
       
       String table = "";
       
       table+= "<table border=1>";
       table+= "<thead>";
       table+= "<tr>";
       table+= "<th> Lifter ID </th>";
       table+= "<th> Lifter Name </th>";
       table+= "<th> Lifter Age </th>";
       table+= "<th> Lifter Weight </th>";
       table+= "<th> Lifter Height </th>";
       table+= "<th> Lifter Class </th>";
       table+= "<th> Delete </th>";
       table+= "</tr>";        
       table+= "</thead>";
        try {
            while(this.results.next()){
                
                Lifters lifter = new Lifters();
                
                lifter.setLifterID(this.results.getInt("lifterID"));
                lifter.setLifterName(this.results.getString("lifterName"));
                lifter.setLifterAge(this.results.getInt("lifterAge"));
                lifter.setLifterWeight(this.results.getInt("lifterWeight"));
                lifter.setLifterHeight(this.results.getString("lifterHeight"));
                lifter.setLifterClass(this.results.getString("lifterClass"));
                
                table += "<tr>";
                table += "<td>";
                table+= lifter.getLifterID();
                
                table += "</td>";
                
                table += "<td>";
                table+= lifter.getLifterName();
                
                table += "</td>";
                
                table += "<td>";
                table+= lifter.getLifterAge();
                
                table += "</td>";
                
                table += "<td>";
                table+= lifter.getLifterWeight();
                
                table += "</td>";
                
                table += "<td>";
                table+= lifter.getLifterHeight();
                
                table += "</td>";
                
                table += "<td>";
                table+= lifter.getLifterClass();
                
                table += "</td>";
                
                table += "<td>";
                table+= "<a href=update?lifterID=" + lifter.getLifterID() + "> Update </a>" + "<a href=delete?lifterID=" + lifter.getLifterID() + "> Delete </a>";
                
                table += "</td>";
                
                table += "</tr>";
                
                
                
            }} catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       table += "</table>";
       
       return table;
       
   }
}
