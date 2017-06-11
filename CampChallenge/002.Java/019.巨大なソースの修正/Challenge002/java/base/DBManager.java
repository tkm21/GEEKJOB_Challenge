
package base;

import java.sql.*;

public class DBManager {
    
    public static Connection getConnection(){
        Connection con = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/challenge_db","tkm21","root");
            return con;
            
        }catch(ClassNotFoundException e){
            
            throw new IllegalMonitorStateException();
            
        } catch (SQLException e) {
            
            throw new IllegalMonitorStateException();
            
        }
        
    }
    
}
