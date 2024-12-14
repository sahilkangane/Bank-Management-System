package bank.management.system;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;
    public Conn(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","S@hil.619");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



