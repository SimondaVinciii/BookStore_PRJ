/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.sql.DataSource;

/**
 *
 * @author ANDIM
 */
public class DBHelper {

    public static Connection makeConnection()
            throws /* ClassNotFoundException */ SQLException, NamingException {
//        //HARD CODE
//        //nen su throws that vi trycatch
//        //0. bo driver vao thu muc Libraries trong netbeans (add Jar/Folder)
//        //1.Load Driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2. Create Connection String
//        String url = "jdbc:sqlserver://"
//                + "localhost:1433;"
//                + "databaseName=SE1721";
//        //3. Open Connection
//        Connection con = DriverManager.getConnection(url,"sa","123456");
//        //4. Return Connection to caller
//        return con;
//    }

        //1.Get current context
        Context currentContext = new InitialDirContext();
        //2.Get web app context
        Context tomcatContext = (Context) currentContext.lookup("java:comp/env");
        //3. Look up datasource from web app contexxt
        DataSource ds = (DataSource) tomcatContext.lookup("DS_SE1721");
        //4.Get connection
        Connection con = ds.getConnection();
        return con;

    }
}
