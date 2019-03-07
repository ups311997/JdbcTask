package com.stackroute.jdbcdemo;

import java.sql.*;

public class UserManager {

    private Connection connection;


    public UserManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/userdb";
            connection = DriverManager.getConnection(url,"root","Root@123");
        }
        catch (Exception e){

        }

    }


    public  void displayAllUser() throws Exception{
        // Registers Driver with driverManager

       Statement statement =  connection.createStatement();
       ResultSet resultSet = statement.executeQuery("SELECT * FROM usertbl");

       while (resultSet.next()){
          int id =  resultSet.getInt(1);
          String name = resultSet.getString(2);
          int age = resultSet.getInt(3);
           System.out.println("id:"+id +" "+"name:"+name +"  "+"age:"+age);
       }
    }



    public void displayUserByName(String name) throws  Exception{

        PreparedStatement preparedStatement =  connection.prepareStatement("select  * from usertbl where name = ? ");
        preparedStatement.setString(1,name);
       ResultSet resultSet =  preparedStatement.executeQuery();

        while (resultSet.next()){

            String Name = resultSet.getString(2);

            System.out.println("name is :"+Name);
        }

    }

    // insert user

    public void insertUser() throws Exception {
        System.out.println("Inserting records into the table...");
        Statement statement =  connection.createStatement();


      statement.executeUpdate("INSERT INTO usertbl " + "VALUES (5,'Sonu',25)");


    }

    // Delete user by name
    public void deleteUserByName(String name) throws Exception {
        PreparedStatement preparedStatement =  connection.prepareStatement("delete  from usertbl where name = ? ");
        preparedStatement.setString(1,name);
        preparedStatement.executeUpdate();



    }

    // Update user age

    public void updateUserAge() throws Exception{
        String query1 =  "Update usertbl Set age = 23 Where id = '4'";
        Statement statement =  connection.createStatement();
        int count = statement.executeUpdate(query1);
        System.out.println("Number of rows updated by executing query1 =  " + count);




    }

    


}
