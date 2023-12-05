/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.model;

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
public class tblProductDAO {
    private List<tblProductDTO> allproductList;

    public List<tblProductDTO> getAllproductList() {
        return allproductList;
    }
    private List<tblProductDTO> searchList;

    public List<tblProductDTO> getSearchList() {
        return searchList;
    }

   
    public void searchProDuct(String searchKey) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select sku, quantity, price, status,name "
                        + " From tblProdcut"
                        + " Where name like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchKey + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    boolean status = rs.getBoolean("status");
                    tblProductDTO pro = new tblProductDTO(sku, name, quantity, price, status);
                    if (this.searchList == null) {
                        this.searchList = new ArrayList<>();
                    }
                    this.searchList.add(pro);
                }

            }
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

    }
public void allProDuct() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select sku, quantity, price, status,name "
                        + " From tblProdcut"
                        ;
                stm = con.prepareStatement(sql);
                

                rs = stm.executeQuery();
                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    boolean status = rs.getBoolean("status");
                    tblProductDTO pro = new tblProductDTO(sku, name, quantity, price, status);
                    if (this.allproductList == null) {
                        this.allproductList = new ArrayList<>();
                    }
                    this.allproductList.add(pro);
                }

            }
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

    }
}
