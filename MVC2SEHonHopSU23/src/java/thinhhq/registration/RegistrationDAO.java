/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import thinhhq.util.DBHelper;

/**
 *
 * @author ANDIM
 */
public class RegistrationDAO implements Serializable {

//    public boolean checkLogin(String username, String password)
//            throws SQLException, NamingException {
   public RegistrationDTO checkLogin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
//        boolean result = null;
        RegistrationDTO result = null;
        try {
            //1. Make connection
            con = DBHelper.makeConnection();
            if (con != null) {

                //2. Create SQL String
                String sql = "SELECT lastname, isAdmin "
                        + "FROM Registration "
                        + "WHERE username = ? "
                        + "AND password = ? ";
//                String sql = "SELECT username FROM Registration WHERE username = ? AND password = ? ";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Exectute Query
                rs = stm.executeQuery();
                //5. Process
                if (rs.next()) {
                    //map: get data from resultset & set data to properties of DTO
                    String fullname  = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    result = new RegistrationDTO(username, null, fullname, role);
                } // end username and password has existed in DB
            } // end connection had existed 

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;

    }
    private List<RegistrationDTO> accountList;

    public List<RegistrationDTO> getAccountList() {
        return accountList;
    }

    public void searchLastName(String searchValue)
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Make connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT username, password, lastname, isAdmin "
                        + "FROM Registration "
                        + "WHERE lastname Like ? ";

//                String sql = "SELECT username FROM Registration WHERE username = ? AND password = ? ";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                //3.1 Set value
                stm.setString(1, "%" + searchValue + "%");

                //4. Exectute Query
                rs = stm.executeQuery();

                //5. Process
                while (rs.next()) {
                    //5.1 map
                    //5.1.1 get data from Result Set
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    //5.1.2 set data to properties of DTO (use constuctor or setter)
                    RegistrationDTO dto = new RegistrationDTO(username, password, fullname, role);
                    //5.2 add to list
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    } // end account list has not exited
                    this.accountList.add(dto);
                } // end map data to store

            } // end connection had existed 

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
//        return result;

    }
    public boolean deleteAccount(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
      
       
        try {
            //1. Make connection
            con = DBHelper.makeConnection();
            if (con != null) {

                //2. Create SQL String
              String sql = "DELETE FROM Registration "
                      + "WHERE username = ?"
                      ;

                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Exectute Query
               int effectRows = stm.executeUpdate();
                //5. Process
               if(effectRows > 0){
                   result = true;
               }
                
            } // end connection had existed 

        } finally {
            
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
       public boolean updateAccount(String username, String password, boolean role) 
               throws SQLException, NamingException{
           
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
      
       
        try {
            //1. Make connection
            con = DBHelper.makeConnection();
            if (con != null) {

                //2. Create SQL String
              String sql = "UPDATE Registration "
                      + "SET password = ?, isAdmin = ? "
                      + "WHERE username = ?" ;
                      
//            String sql = "Update Registration Set password = ?, isAdmin = ? Where username = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);
                //4. Exectute Query
               int effectRows = stm.executeUpdate();
                //5. Process
               if(effectRows > 0){
                   result= true;
               }
                
            } // end connection had existed 

        } finally {
            
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
           
       } 
   public boolean createNewAccount(RegistrationDTO account) 
           throws NamingException, SQLException{
       Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
      
       
        try {
            //1. Make connection
            con = DBHelper.makeConnection();
            if (con != null) {

                //2. Create SQL String
              String sql = "INSERT INTO Registration("
                      + "username, password, lastname, isAdmin"
                      + ") Values("
                      + "?, ?, ?, ?"
                      + ")";
                      

                //3. Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, account.getUsername());
                stm.setString(2, account.getPassword());
                stm.setString(3, account.getFullname());
                stm.setBoolean(4, account.isRole());
                //4. Exectute Query
               int effectRows = stm.executeUpdate();
                //5. Process
               if(effectRows > 0){
                   result = true;
               }
                
            } // end connection had existed 

        } finally {
            
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
   }
}
