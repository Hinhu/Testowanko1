/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionTest;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class connectionTest {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/testowanie1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "testowanieRowery";
        String password = "testowanieRowery";
        
        try {
            System.out.println("Connecting to: " + url);
            Connection conn = DriverManager.getConnection(url, user, password);
            
            System.out.println("Connected");
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
