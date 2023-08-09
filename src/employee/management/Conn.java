package employee.management;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // in the following statment where it is asking for password, put the password
            // of MYSQL Command Line which is I have already given
            // here in the following line code we are building the connection with the database which is
            // having our table present in and for a project we should have a separate database according to
            // the project and for our this project we have 'employeemanagement' database which is holding
            // our tables but for this project we have 2 tables one is login and other is employee
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagement","root","Aniket&1");
            s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
