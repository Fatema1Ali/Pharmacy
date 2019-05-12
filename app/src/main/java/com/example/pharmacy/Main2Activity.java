/*package com.example.pharmacy;
import android.util.Log;

import android.app.ProgressDialog;
import android.nfc.Tag;
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
public class Main2Activity extends AppCompatActivity {
    ProgressDialog progressDialog;
    String url="https://raw.githubusercontent.com/ianbar20/JSON-Volley-Tutorial/master/Example-JSON-Files/Example-Object.JSON";
     RequestQueue Queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        public void volleyStringRequest(String url){

            //String  REQUEST_TAG = "com.androidtutorialpoint.volleyStringRequest";
            progressDialog.setMessage("Loading...");
            progressDialog.show();

            StringRequest strReq = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(, response.toString());

                    LayoutInflater li = LayoutInflater.from(Main2Activity.this);
                    showDialogView = li.inflate(R.layout.show_dialog, null);
                    outputTextView = (TextView)showDialogView.findViewById(R.id.text_view_dialog);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Main2Activity.this);
                    alertDialogBuilder.setView(showDialogView);
                    alertDialogBuilder
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            })
                            .setCancelable(false)
                            .create();
                    outputTextView.setText(response.toString());
                    alertDialogBuilder.show();
                    progressDialog.hide();
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                    progressDialog.hide();
                }
            });
            // Adding String request to request queue
            AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq, REQUEST_TAG);
            public void volleyJsonObjectRequest(String url){

                String  REQUEST_TAG = "com.androidtutorialpoint.volleyJsonObjectRequest";
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                JsonObjectRequest jsonObjectReq = new JsonObjectRequest(url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d(TAG, response.toString());

                                LayoutInflater li = LayoutInflater.from(Main2Activity.this);
                                showDialogView = li.inflate(R.layout.show_dialog, null);
                                outputTextView = (TextView)showDialogView.findViewById(R.id.text_view_dialog);
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Main2Activity.this);
                                alertDialogBuilder.setView(showDialogView);
                                alertDialogBuilder
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                            }
                                        })
                                        .setCancelable(false)
                                        .create();
                                outputTextView.setText(response.toString());
                                alertDialogBuilder.show();
                                progressDialog.hide();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        progressDialog.hide();
                    }
                });

                // Adding JsonObject request to request queue
                AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectReq,REQUEST_TAG);
            }
            public void volleyImageLoader(String url){
                ImageLoader imageLoader = AppSingleton.getInstance(getApplicationContext()).getImageLoader();

                imageLoader.get(url, new ImageLoader.ImageListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Image Load Error: " + error.getMessage());
                    }

                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                        if (response.getBitmap() != null) {

                            LayoutInflater li = LayoutInflater.from(MainActivity.this);
                            showDialogView = li.inflate(R.layout.show_dialog, null);
                            outputImageView = (ImageView)showDialogView.findViewById(R.id.image_view_dialog);
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                            alertDialogBuilder.setView(showDialogView);
                            alertDialogBuilder
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                        }
                                    })
                                    .setCancelable(false)
                                    .create();
                            outputImageView.setImageBitmap(response.getBitmap());
                            alertDialogBuilder.show();
                        }
                    }
                });
            }
            public void volleyCacheRequest(String url){
                Cache cache = AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache();
                Cache.Entry reqEntry = cache.get(url);
                if(reqEntry != null){
                    try {
                        String data = new String(reqEntry.data, "UTF-8");
                        //Handle the Data here.
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                else{

                    //Request Not present in cache, launch a network request instead.
                }
            }

            public void volleyInvalidateCache(String url){
                AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache().invalidate(url, true);
            }

            public void volleyDeleteCache(String url){
                AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache().remove(url);
            }

            public void volleyClearCache(){
                AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache().clear();
            }
    }
}}
*/