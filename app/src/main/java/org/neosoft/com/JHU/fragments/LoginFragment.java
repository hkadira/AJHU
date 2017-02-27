package org.neosoft.com.JHU.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.service.NetworRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    EditText txtUName,txtPassword;
    Button register,login;
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login, container, false);
        txtUName=(EditText) view.findViewById(R.id.edTxtUName);
        txtPassword=(EditText) view.findViewById(R.id.edTxtPwd);

        //TODO = remove later.
        txtUName.setText("b1");
        txtPassword.setText("c1");

        register =(Button) view.findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new RegistrationFragment());
                ft.commit();
                //Toast.makeText(getActivity(),"Registration Form",Toast.LENGTH_SHORT).show();
            }
        });

        login =(Button) view.findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user = txtUName.getText().toString();
                String pwd=   txtPassword.getText().toString();

                userLogin(user,pwd);
                //Toast.makeText(getActivity(),"Login",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void userLogin(String sUNa, String sPw) {
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
