package dealtrocindiv;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author belkn
 */
public class MyConnection {
private static Connection conn; //DB Credations
    
String url = "jdbc:mysql://localhost:3306/dealtroc1";
String user = "root";
String pwd = "";
private static MyConnection instance;
    private MyConnection() {
        try {
            conn=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie!!!");
        } catch (SQLException ex) {
            System.out.println("Probleme de connexion"); 
        ex.printStackTrace();
        }
    }

    public static MyConnection getInstance() {
        if(instance==null){
            instance= new MyConnection();
        }
        return instance;
    }
 
    
    public Connection getConn(){
        return MyConnection.getInstance().conn;
    }
    
}

