package org.neosoft.com.JHU.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText txtDistrict;


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
        txtDistrict = (EditText) findViewById(R.id.edTxtDistrict);

        //TODO- Dummy data
        txtName.setText("SNa1");
        txtUsername.setText("UNa1");
        txtPassword.setText("Pw1");
        txtPhone.setText("Phone1");
        txtEmail.setText("Emali1");
        txtAddress.setText("Add1");
        txtDistrict.setText("Dis1");

        // Inflate the layout for this fragment
        membership = (Button) findViewById(R.id.btnMembership);
        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Test Registration", Toast.LENGTH_LONG).show();
                registerUser(txtName.getText().toString().trim(), txtUsername.getText().toString().trim(),
                        txtPassword.getText().toString().trim(), txtPhone.getText().toString().trim(),
                        txtEmail.getText().toString().trim(), txtAddress.getText().toString().trim(), txtDistrict.getText().toString().trim());
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
                            if (response.body() != null) {
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
}
