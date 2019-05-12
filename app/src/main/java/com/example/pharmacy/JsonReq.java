package com.example.pharmacy;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReq extends AppCompatActivity {
    private TextView mytext;
    private RequestQueue myqueue;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_req);
        mytext=(TextView)findViewById(R.id.text_view_result);
        button=(Button)findViewById(R.id.button_parse);
        myqueue=Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              jsonParse();
            }
        });
    }
    private  void jsonParse(){
        String url="";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("user");
                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject user=jsonArray.getJSONObject(i);
                        String name=user.getString("name");
                        String username=user.getString("username");
                        int age=user.getInt("age");
                        String password=user.getString("password");
                        mytext.append(name + ", " + username + "," + password+", " + String.valueOf(age)+ "\n" +
                                "\n");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  error.printStackTrace();
            }
        });
          myqueue.add(request);
    }
}
