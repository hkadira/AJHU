package org.neosoft.com.JHU.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.service.NetworRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFragment extends Fragment {
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

    View view;
    Button membership, cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_registration, container, false);

        txtName = (EditText) view.findViewById(R.id.edTxtName);
        txtUsername = (EditText) view.findViewById(R.id.edTxtUName);
        txtPassword = (EditText) view.findViewById(R.id.edTxtPwd);
        txtEmail = (EditText) view.findViewById(R.id.edTxtEmail);
        txtPhone = (EditText) view.findViewById(R.id.edTxtPhone);
        txtAddress = (EditText) view.findViewById(R.id.edTxtAdd);
        txtDistrict = (EditText) view.findViewById(R.id.district);

        //TODO- Dummy data
        txtName.setText("SNa1");
        txtUsername.setText("UNa1");
        txtPassword.setText("Pw1");
        txtPhone.setText("Phone1");
        txtEmail.setText("Emali1");
        txtAddress.setText("Add1");
        txtDistrict.setText("Dis1");

        // Inflate the layout for this fragment
        membership = (Button) view.findViewById(R.id.btnMembership);
        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(validateData()){
                    //Toast.makeText(getActivity(), "Test Registration", Toast.LENGTH_LONG).show();
                    registerUser(txtName.getText().toString().trim(), txtUsername.getText().toString().trim(),
                            txtPassword.getText().toString().trim(), txtPhone.getText().toString().trim(),
                            txtEmail.getText().toString().trim(), txtAddress.getText().toString().trim(),
                            txtDistrict.getText().toString().trim());
                }else {

                }*/
            }
        });

        cancel = (Button) view.findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
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
