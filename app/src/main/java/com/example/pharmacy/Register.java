package com.example.pharmacy;

import android.nfc.Tag;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "RegisterActivity";
    private static final String URL_FOR_REGISTRATION ="AndroidManifest.xml";
    ProgressDialog progressDialog;
    Button bRegister;
  EditText etName,etPassword,etAge,etUsername;
  RequestQueue Queue;
  String URLHTTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Progress dialog
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);

        Queue= Volley.newRequestQueue(this);
        URLHTTP=getResources().getString(R.string.httphost);
    etName=(EditText)findViewById(R.id.etName);
    etPassword  =(EditText)findViewById(R.id.etPassword);
    etAge=(EditText)findViewById(R.id.etAge);
        etUsername=(EditText)findViewById(R.id.etUsername);
            bRegister=(Button)findViewById(R.id.bRegister);
            bRegister.setOnClickListener(this);
    }

    @Override
   /*public void onClick(View view) {
        submitForm();
    }*/
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bRegister:


               String name=etName.getText().toString();
               String username=etUsername.getText().toString();
               String password=etPassword.getText().toString();
               int age=Integer.parseInt(etAge.getText().toString());
               User registeredData=new User(name,password,username,age);
                break;}}}
            /*private void submitForm(){
                 ( etName.getText().toString(),
                        etUsername.getText().toString(),
                        etPassword.getText().toString(),
                        etAge.getText().toString());
            }

            private void registerUser(name,username,password,
            ,age) {
                // Tag used to cancel the request
                String cancel_req_tag = "register";

                progressDialog.setMessage("Adding you ...");
                showDialog();

                StringRequest strReq = new StringRequest(Request.Method.POST,
                        URL_FOR_REGISTRATION, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Register Response: " + response.toString());
                        hideDialog();

                        try {
                            JSONObject jObj = new JSONObject(response);
                            boolean error = jObj.getBoolean("error");

                            if (!error) {
                                String user = jObj.getJSONObject("user").getString("name");
                                Toast.makeText(getApplicationContext(), "Hi " + user +", You are successfully Added!", Toast.LENGTH_SHORT).show();

                                // Launch login activity
                                Intent intent = new Intent(
                                        Register.this,
                                        LogIn.class);
                                startActivity(intent);
                                finish();
                            } else {

                                String errorMsg = jObj.getString("error_msg");
                                Toast.makeText(getApplicationContext(),
                                        errorMsg, Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Registration Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_LONG).show();
                        hideDialog();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        // Posting params to register url
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", name);
                        params.put("email", email);
                        params.put("password", password);
                        params.put("gender", gender);
                        params.put("age", dob);
                        return params;
                    }
                };
                // Adding request to request queue
                AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq, cancel_req_tag);
            }

            private void showDialog() {
                if (!progressDialog.isShowing())
                    progressDialog.show();
            }

            private void hideDialog() {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }}}*/////