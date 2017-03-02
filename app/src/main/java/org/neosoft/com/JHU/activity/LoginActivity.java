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
import org.neosoft.com.JHU.service.LocalRepository;
import org.neosoft.com.JHU.service.NetworRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText txtUName,txtPassword;
    Button register,login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUName=(EditText) findViewById(R.id.edTxtUName);
        txtPassword=(EditText) findViewById(R.id.edTxtPwd);

        //TODO = remove later.
        txtUName.setText("b1");
        txtPassword.setText("c1");

        register =(Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new RegistrationFragment());
                ft.commit();*/
                //Toast.makeText(getApplicationContext(),"Registration Form",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

        login =(Button) findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user = txtUName.getText().toString();
                String pwd=   txtPassword.getText().toString();

                userLogin(user,pwd);
                login.setEnabled(false);
                //findViewById(R.id.txt)
                //Toast.makeText(getActivity(),"Login",Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void userLogin(final String sUNa, final String sPw) {
        NetworRepository.getApiService().loginUser(sUNa, sPw)
        //NetworRepository.getApiService().loginUser("b1", "c1")
                .enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.i("Response", response.body().toString());
                        //Toast.makeText()
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                Log.i("onSuccessLogin", response.body().toString());
                                Toast.makeText(getApplicationContext(),"Login successfull", Toast.LENGTH_LONG).show();
                                LocalRepository.getInstance().saveUser(sUNa,sPw, true);
                                startActivity(new Intent(getApplicationContext(),MainDashboardActivity.class));
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
                        Toast.makeText(getApplicationContext(),"Invalid login", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
