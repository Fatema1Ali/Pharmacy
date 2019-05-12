package com.example.pharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bLogout;
    EditText etName,etAge,etUsername;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=(EditText)findViewById(R.id.etName);
        etAge=(EditText)findViewById(R.id.etAge);
        etUsername=(EditText)findViewById(R.id.etUsername);
        bLogout=(Button)findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);

        userLocalStore=new UserLocalStore(this);
    }
    protected void onStart(){
        super.onStart();
if (authenticate()){
        displayUserDetails();
}
    }
    private boolean authenticate(){

        return userLocalStore.getUserLoggedIn();
    }
    private void displayUserDetails(){
       User user =userLocalStore.getLoggedInUser(true);
        etUsername.setText(user.username);
        etName.setText(user.name);
        etAge.setText(user.age +"");


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
               break;


            case R.id.bLogin:
               startActivity(new Intent(this, LogIn.class));



                break;
        }
        }


}

