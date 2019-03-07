package com.stackroute.jdbcdemo;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        try {
            userManager.displayAllUser();
          //  userManager.displayUserByName("Upasana");
         //   userManager.insertUser();
          //  userManager.deleteUserByName("Sonu");
            userManager.updateUserAge();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
