package org.neosoft.com.JHU.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.neosoft.com.JHU.R;

public class RegistrationFragment extends Fragment {
    private EditText name;
    private EditText username;
    private EditText password;
    private EditText email;

    String ROOT_URL="http://localhost/JHU";

    View v;
    Button btnMembership;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_registration, container, false);

        name=(EditText) v.findViewById(R.id.edTxtName);
        username=(EditText) v.findViewById(R.id.edTxtNIC);
        password=(EditText) v.findViewById(R.id.edTxtPwd);
        email=(EditText) v.findViewById(R.id.edTxtEmail);

        // Inflate the layout for this fragment
        btnMembership = (Button) v.findViewById(R.id.btnRegister);
        btnMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserDetails();
            }
        });

        return v;
    }

    private void getUserDetails() {

    }


    /*private void loginApp() {
        //String userName = mBinding.edTxtULEmail.getText().toString().trim();

        //Passing the values by getting it from editTexts
        String nm = name.getText().toString();
        String uNm=username.getText().toString();
        String pwd =password.getText().toString();
        String eml= email.getText().toString();

        if (TextUtils.isEmpty(nm)) {
            //mBinding.edTxtULEmail.setError("Email is required");
            name.setError("Email is required");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()) {
            email.setError("Invalid Email");
            return;
        }

       // String password = mBinding.edTxtULPwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            password.setError("Invalid password");
            return;
        }

            final RegisterAPI loginReq = new RegisterAPI();
            loginReq.userAuth = new LoginRequest.UserAuth();
            loginReq.userAuth.provider = "direct";
            loginReq.userAuth.User = new LoginRequest.User();
            loginReq.userAuth.User.email = userName;
            loginReq.userAuth.User.password = password;

            NetworRepository.getApiService().login(loginReq).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful() && response.body() != null && response.body().User != null) {
                        Log.d(TAG, response.body().toString());
                        LocalRepository.getInstance().saveUser(response.body().User);
                        //finish();

                        Intent iNActivity = new Intent(getApplicationContext(), NavigationActivity.class);
                        startActivity(iNActivity);
                        overridePendingTransition(0, 0);
                        finish();
                    } else {
                        //Toast.makeText(getApplicationContext(), "Invalid login attempt" , Toast.LENGTH_SHORT).show();
                        showMessage("User Login", "Invalid login credentials.");
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    t.printStackTrace();
                    if (t instanceof UnknownHostException) {
                        Toast.makeText(getApplicationContext(), "No Internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }*/

    /*private void insertUser(){
        //Here we will handle the http request to insert User to mysql db
        //Creating a RestAdapter
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RegisterAPI api = adapter.create(RegisterAPI.class);


        );
    }*/


}
