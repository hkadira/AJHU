package org.neosoft.com.JHU.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.service.NetworRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtEmail;
    private EditText txtPhone;
    private EditText txtAddress;
    private Spinner txtDistrict;

    CoordinatorLayout coordinatorLayout;

    String ROOT_URL = "http://localhost/JHU";
    //public static final String BASE_URL = "http://192.168.1.3:80/JHU";
    public static final String BASE_URL = "https://eguru.000webhostapp.com/";

    Button membership, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtName = (EditText) findViewById(R.id.edTxtName);
        txtUsername = (EditText) findViewById(R.id.edTxtUName);
        txtPassword = (EditText) findViewById(R.id.edTxtPwd);
        txtEmail = (EditText) findViewById(R.id.edTxtEmail);
        txtPhone = (EditText) findViewById(R.id.edTxtPhone);
        txtAddress = (EditText) findViewById(R.id.edTxtAdd);
        txtDistrict = (Spinner) findViewById(R.id.district);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.rCoordinatorLayout);

        //TODO- Dummy data
        /*txtName.setText("SNa1");
        txtUsername.setText("UNa1");
        txtPassword.setText("Pw1");
        txtPhone.setText("Phone1");
        txtEmail.setText("Emali1");
        txtAddress.setText("Add1");
        txtDistrict.setText("Dis1");*/

        // Inflate the layout for this fragment
        membership = (Button) findViewById(R.id.btnMembership);
        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.valueOf(validateData()), Toast.LENGTH_LONG).show();

                if (validateData()){
                    snackBarMessage("User registered successfully");
                    registerUser(txtName.getText().toString().trim(), txtUsername.getText().toString().trim(),
                            txtPassword.getText().toString().trim(), txtPhone.getText().toString().trim(),
                            txtEmail.getText().toString().trim(), txtAddress.getText().toString().trim(),
                            txtDistrict.getSelectedItem().toString().trim());
                }/*else{
                    snackBarMessage("Fill all the informations");
                }*/

            }
        });

        cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

    private void registerUser(String sNa, String sUNa, String sPw, String sPo, String sEml, String sAdd, String sDisc) {
        //NetworRepository.getApiService().registerUser("RTestName","RTestUserName","RTestPassword","RTestPhone","RTestEmail","RTestAddress","RTestDistrict")
        NetworRepository.getApiService().registerUser(sNa, sUNa, sPw, sPo, sEml, sAdd, sDisc)
                .enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.i("Response", response.body().toString());
                        //Toast.makeText()
                        if (response.isSuccessful()) {
                            if (response.body().equals("successfully registered")) {
                                Log.i("onSuccessRegistration", response.body().toString());
                                Toast.makeText(getApplicationContext(),"You have successfully registered.",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                finish();
                            } else {
                                Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.i("onFailure", t.toString());
                        t.printStackTrace();
                    }
                });
    }

    public boolean validateData() {
        if ((TextUtils.isEmpty(txtName.getText()) ||
                (TextUtils.isEmpty(txtUsername.getText())) ||
                (TextUtils.isEmpty(txtPassword.getText())) ||
                (TextUtils.isEmpty(txtEmail.getText())) ||
                (TextUtils.isEmpty(txtPhone.getText())) ||
                (TextUtils.isEmpty(txtAddress.getText())))) {
                snackBarMessage("Fill all the informations");
                return false;
        }else if(txtDistrict.getSelectedItem().equals("- Select District -")){
                snackBarMessage("Select a valid district");
                return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText()).matches()) {
                txtEmail.setError("Invalid Email");
                return false;
        }else {
                return true;
        }
    }

    public void snackBarMessage(String message){
        Snackbar snackbar = Snackbar.make(coordinatorLayout, message , Snackbar.LENGTH_LONG);
        View mView = snackbar.getView();
        mView.setBackgroundColor(Color.RED);
        //mView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        TextView tv = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(ContextCompat.getColor(RegistrationActivity.this, android.R.color.white));

        // set text to center
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();
    }
}
