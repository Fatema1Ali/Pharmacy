package com.example.pharmacy;
import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
    private static final  String SP_Name= "userDetails";
    private SharedPreferences userLocalDataBase;





    public UserLocalStore(MainActivity context){
     
    userLocalDataBase=context.getSharedPreferences(SP_Name,0);

}

    public UserLocalStore(LogIn logIn) {

    }

    public void storeUserData(User user) {
         SharedPreferences.Editor spEditor =userLocalDataBase.edit();
        spEditor.putString("name",user.name) ;
        spEditor.putString("password",user.password);
        spEditor.putString("username",user.username);
        spEditor.putInt("age",user.age);
        spEditor.apply();
      }
      public User getLoggedInUser(boolean b){
        String name= userLocalDataBase.getString("name","");
        String password= userLocalDataBase.getString("password","");
        String username= userLocalDataBase.getString("username","");
        int age=userLocalDataBase.getInt("age",-1);
         User storedUser = new User(name,password,username,age);
         return storedUser;
}
       public void setUserLoggedIn(boolean loggedIn){
       SharedPreferences.Editor spEditor =userLocalDataBase.edit();
       spEditor.putBoolean("loggedIn",loggedIn);
       spEditor.apply();
       }
       public boolean getUserLoggedIn(){
           if(userLocalDataBase.getBoolean("loggedIn", false))
           {return true;
       } else {return false;}}

       public void clearUserData(){
       SharedPreferences.Editor spEditor=userLocalDataBase.edit();
       spEditor.clear();
       spEditor.apply();


       }
}
