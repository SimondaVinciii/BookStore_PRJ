/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ANDIM
 */
public class MyContextServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("When......");//duoc goi khi ung dung deploy
        //1. Get Context Scope
        ServletContext context = sce.getServletContext();
        //2. Get siteMaps Path
        String siteMapsPath = context.getInitParameter("SITEMAP_FILE_PATH");
        //3. Load site Mas into attribut of context scope
        Properties siteMaps = null;
        InputStream is = null;
        try {
            siteMaps = new Properties();
            is = context.getResourceAsStream(siteMapsPath);
            siteMaps.load(is);
            context.setAttribute("SITEMAPS", siteMaps);
        } catch (IOException ex) {
            context.log("MyCContextServletListener _ IO" + ex.getMessage());
        }
        finally {
            if (is != null) {
            try {
                is.close();
            } catch (IOException ex) {
                context.log("MyCContextServletListener _ IO" + ex.getMessage());
            }
        }
    }
}

@Override
        public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("......When");//ung dung dang huy 
    }
}
