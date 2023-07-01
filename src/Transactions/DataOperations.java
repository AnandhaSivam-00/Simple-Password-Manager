package Transactions;

import java.sql.*;
//import Transactions.Authentication;

import javax.swing.DefaultListModel;

public class DataOperations{
    final private String database_url = "jdbc:mysql://localhost:3306/first_database";  //Important ------- Your database name
    final private String mysql_Username = "root";
    final private String mysql_Password = "";  //Important --------- Your database Password
    //UserDataStore data = new UserDataStore();
    public boolean addData(UserDataStore data, String user){
        if(checkData(data)){
            try{
                Connection conn = DriverManager.getConnection(database_url, mysql_Username, mysql_Password);
                System.out.println(user);

                String sql = "INSERT INTO "+ user +" VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, data.currentUser);
                stat.setString(2, data.webName);
                stat.setString(3, data.userName);
                stat.setString(4, data.password);
                stat.setString(5, data.link);
                stat.setString(6, data.despdata);
                stat.executeUpdate();
                stat.close();
                conn.close();
                String close = conn.isClosed() ? "Connection is close" : "Connection is open";
                System.out.println(close);
            }
            catch(SQLException e){
                System.out.println("DataOperations Class : DataBase Access Fails...");
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean createNewUser(UserDataStore data, String username, String password){
        try{
            Connection conn = DriverManager.getConnection(database_url, mysql_Username, mysql_Password);
            //System.out.println("DataOperations Class : DataBase Access Success...");
            String sql1 = "INSERT INTO user_data VALUES (?, ?);";
            PreparedStatement stat1 = conn.prepareStatement(sql1);
            stat1.setString(1, username);
            stat1.setString(2, password);
            stat1.executeUpdate();
            stat1.close();

            Statement stat2 = conn.createStatement();
            String sql2 = "CREATE TABLE "+ username +" (PersonIDs VARCHAR(35) NOT NULL," +
             "Prefered_Name VARCHAR(35) NOT NULL, UserID VARCHAR(35) NOT NULL," +
             "Password VARCHAR(40) NOT NULL, Links VARCHAR(75), Descriptions VARCHAR(150));";

            stat2.execute(sql2);
            conn.close();
            String close = conn.isClosed() ? "Connection is close" : "Connection is open";
            System.out.println(close);
            return true;
        }
        catch(Exception e){
            System.out.println("DataOperations Class : DataBase Access Fails...");
            return false;
        }
    }

    /*public DefaultListModel retrieveData(UserDataStore data, String username){
        DefaultListModel listModel = new DefaultListModel();
        try{

        }
        catch(Exception e){

        }
    }*/
    private boolean checkData(UserDataStore data){
        if(data.link.length() == 0){
            data.link = "Nil";
        }
        if(data.despdata.length() == 0){
            data.despdata = "Nil";
        }
        if(data.webName.length()!=0 && data.userName.length()!=0 && data.password.length()!=0){
            return true;
        }
        return false;
    }

}

