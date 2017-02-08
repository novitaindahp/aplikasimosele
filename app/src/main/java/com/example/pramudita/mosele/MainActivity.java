package com.example.pramudita.mosele;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    TextView errormsg;
    ProgressDialog loadingku;


    RestClient rest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rest = new RestClient(getApplicationContext());
        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        errormsg = (TextView)findViewById(R.id.txtErrorMsg);

        loadingku= new ProgressDialog(this);
        loadingku.setMessage("Loading data ...");
        loadingku.setCancelable(false);

        errormsg.setText("");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String simpanUser = username.getText().toString();
                final String simpanPass = password.getText().toString();

                if (simpanUser.equals("") && simpanPass.equals("")) {
                    errormsg.setText("Maaf. Username dan Password masih kosong");
                    errormsg.setTextColor(Color.RED);
                    username.setFocusable(true);
                    //username.requestFocus();

                } else if (simpanUser.equals("")){
                    errormsg.setText("Maaf. Username masih kosong");
                    errormsg.setTextColor(Color.RED);
                    username.setFocusable(true);
                }
                else if(simpanPass.equals("")){
                    errormsg.setText("Maaf. Password masih kosong");
                    errormsg.setTextColor(Color.RED);
                    username.setFocusable(true);
                }


                else {

                    loadingku.show();
                    StringRequest cekprofile = new StringRequest(Request.Method.POST, "http://mosele.esy.es/service/login", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            // prg.hide();

                            try {
                                JSONObject obj = new JSONObject(response);
                                Boolean status = obj.getBoolean("status");


                              //  Toast.makeText(getApplicationContext(), "status"+status.toString(), Toast.LENGTH_SHORT).show();


                                if (status) {

                                    JSONObject pesan = obj.getJSONObject("body");

                                    String namapetani= pesan.getString("peternak_nama");
                                //    Toast.makeText(getApplicationContext(),"Nama petani="+namapetani,Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(getApplicationContext(), Dashboard.class);

                                    i.putExtra("namapet", namapetani);
                                    startActivity(i);

                                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();


                                } else {
                                    //   String haspesan = obj.getString("pesan");

                                    errormsg.setText("Login Gagal. Username/Password salah");
                                    errormsg.setTextColor(Color.RED);
                                    username.setFocusable(true);

                          //          Toast.makeText(getApplicationContext(), "Login Gagal\n info:", Toast.LENGTH_SHORT).show();
//                                loginhint.setVisibility(View.VISIBLE);
//                                loginhint.setBackgroundColor(Color.TRANSPARENT);
//                                loginhint.setText("WRONG EMAIL OR PASSWORD");
//                                loginhint.setTextColor(Color.parseColor("#ffd33a26"));
//

                                }


                            } catch (JSONException e) {

                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //  prg.hide();
                            NetworkResponse response = error.networkResponse;
                            if (response != null && response.data != null) {

                                rest.statusCode(response.statusCode, response.data);

                            } else {


                                Toast.makeText(getApplicationContext(), "cek koneksi internet anda", Toast.LENGTH_LONG).show();

                            }
                        }
                    }
                    ) {
                        @Override
                        protected void onFinish() {

                            loadingku.hide();

                        }

                        @Override
                        protected void deliverResponse(String response) {
                            super.deliverResponse(response);
                        }
//
//                    @Override
//                    public Map<String, String> getHeaders() throws AuthFailureError {
//
//                        Map<String,String> params=new HashMap<>();
//                        String user_id = "ibnu";
//                        String pass_id = "ibnu";
//                        params.put("user_id", user_id);
//                        params.put("pass_id",pass_id);
//                        return params;
//                    }


                        @Override
                        protected Map<String, String> getParams() {

                            Map<String, String> params = new HashMap<String, String>();
                            params.put("user_id", simpanUser);
                            params.put("pass_id", simpanPass);
                            return params;
                        }


                    };
                    cekprofile.setRetryPolicy(new DefaultRetryPolicy(
                            3000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                    ));
                    Volley.newRequestQueue(getApplicationContext()).add(cekprofile);


                }



            }


        });

    }





}
