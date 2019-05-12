package com.example.pharmacy;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsLogger;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.appevents.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LogIn extends AppCompatActivity implements View.OnClickListener{
    private LoginButton loginButton;
    private TextView txtName,txtEmail;
     Button bLogin, bLogbook;
    EditText etUsername,etPassword;
     private TextView registering;
    UserLocalStore userLocalStore;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);
        //AppEventsLogger.activateApp(getApplication());
        setContentView(R.layout.activity_log_in);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);
         bLogin=(Button) findViewById(R.id.bLogin);
        bLogbook =(Button)findViewById(R.id.bLogbook);
        registering=(TextView)findViewById(R.id.tvRegisterLink);

        final String EMAIL = "email";
        userLocalStore=new UserLocalStore(this);
        callbackManager= CallbackManager.Factory.create();


        loginButton.setReadPermissions(Arrays.asList("email","public_profile"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accessToken=loginResult.getAccessToken();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        bLogin.setOnClickListener(this);
        bLogbook.setOnClickListener(this);
        registering.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker tokenTracker=new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            if(currentAccessToken==null){
               txtName.setText("");
               txtEmail.setText("");

                Toast.makeText(LogIn.this,"User Logged out",Toast.LENGTH_LONG).show();
            } else
                loaduserProfile(currentAccessToken);
        }
    };
    AccessToken accessToken = AccessToken.getCurrentAccessToken();
    boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
    private void loaduserProfile (AccessToken newAccessToken){

        GraphRequest request=GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String first_name=object.getString("first_name");
                    String last_name=object.getString("last_name");
                    String email=object.getString("email");
                    String id=object.getString("id");
                    txtEmail.setText(email);
                    txtName.setText(first_name+""+last_name);
                    RequestOptions requestOptions=new RequestOptions();
                    requestOptions.dontAnimate();
                    //String image_url="htt";


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters=new Bundle();
       parameters.putString("fiels","first_name,last_name,email,id");
       request.setParameters(parameters);
       request.executeAsync();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:

           User user=new User(null,null);
           userLocalStore.storeUserData(user);
           userLocalStore.setUserLoggedIn(true);

            break;
            case R.id.tvRegisterLink:

                startActivity(new Intent(this,Register.class));



                break;
        }

    }
}
