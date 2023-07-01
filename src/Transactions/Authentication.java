package Transactions;

import java.sql.*;
//import java.util.*;

public class Authentication {
    final private String database_url = "jdbc:mysql://localhost:3306/first_database";
    final private String mysql_Username = "root";
    final private String mysql_Password = "";  //Important ---------
    boolean flag = false;

    public boolean getAuthenticatedUser(String UserID, String Password){
        try{
            Connection conn = DriverManager.getConnection(database_url, mysql_Username, mysql_Password);
            //System.out.println("DataBase Access Success...");

            String sql_stat = "SELECT * FROM user_data WHERE PersonIDs=? AND User_Passwords=?";
            PreparedStatement preparedStat = conn.prepareStatement(sql_stat);
            preparedStat.setString(1, UserID);
            preparedStat.setString(2, Password);

            ResultSet result = preparedStat.executeQuery();

            if(result.next()){
                flag = true;
            }

            preparedStat.close();
            conn.close();
            String close = conn.isClosed() ? "Connection is close" : "Connection is open";
            System.out.println(close);
        }
        catch(Exception e){
            System.out.println("DataBase Access Fails...");
        }
        return flag;
    }
    public boolean isExistsUser(String userid){
        try{
            Connection conn = DriverManager.getConnection(database_url, mysql_Username, mysql_Password);
            //System.out.println("DataBase Access Success...");

            String sql_stat = "SELECT * FROM user_data WHERE PersonIDs=? ORDER BY PersonIDs DESC";
            PreparedStatement preparedStat = conn.prepareStatement(sql_stat);
            preparedStat.setString(1, userid);

            ResultSet result = preparedStat.executeQuery();

            if(result.next()){
                flag = true;
            }
            if(userid == ""){
                flag = false;
            }

            preparedStat.close();
            conn.close();
            String close = conn.isClosed() ? "Connection is close" : "Connection is open";
            System.out.println(close);
        }
        catch(Exception e){
            System.out.println("DataBase Access fails...");
            //System.out.println(e);
        }
        return flag;
    }
    public boolean isExistsPass(String password){
        try{
            Connection conn = DriverManager.getConnection(database_url, mysql_Username, mysql_Password);
            //System.out.println("DataBase Access Success...");

            String sql_stat = "SELECT * FROM user_data WHERE User_Passwords=? ORDER BY User_Passwords DESC";
            PreparedStatement preparedStat = conn.prepareStatement(sql_stat);
            preparedStat.setString(1, password);

            ResultSet result = preparedStat.executeQuery();

            if(result.next()){
                flag = true;
            }
            if(password == ""){
                flag = false;
            }

            preparedStat.close();
            conn.close();
            String close = conn.isClosed() ? "Connection is close" : "Connection is open";
            System.out.println(close);
        }
        catch(Exception e){
            System.out.println("DataBase Access fails...");
        }
        return flag;
    }

}
