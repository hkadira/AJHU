/*
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.data.api.servicesAPI;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class copy_RegistrationFragment extends Fragment{
    private EditText txtName;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtEmail;
    private EditText txtPhone;
    private EditText txtAddress;
    private EditText txtDistrict;


    String ROOT_URL="http://localhost/JHU";
    //public static final String BASE_URL = "http://192.168.1.3:80/JHU";
    public static final String BASE_URL = "https://eguru.000webhostapp.com/";

    View view;
    Button membership,cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_registration, container, false);

        txtName=(EditText) view.findViewById(R.id.edTxtName);
        txtUsername=(EditText) view.findViewById(R.id.edTxtUName);
        txtPassword=(EditText) view.findViewById(R.id.edTxtPwd);
        txtEmail=(EditText) view.findViewById(R.id.edTxtEmail);
        txtPhone=(EditText) view.findViewById(R.id.edTxtPhone);
        txtAddress=(EditText) view.findViewById(R.id.edTxtAdd);
        txtDistrict=(EditText) view.findViewById(R.id.edTxtDistrict);

        //TODO- Dummy data
        txtName.setText("SNa1");txtUsername.setText("UNa1"); txtPassword.setText("Pw1");txtPhone.setText("Phone1");
        txtEmail.setText("Emali1");txtAddress.setText("Add1");txtDistrict.setText("Dis1");

        // Inflate the layout for this fragment
        membership = (Button) view.findViewById(R.id.btnMembership);
        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Test Registration", Toast.LENGTH_LONG).show();
                registerUser(txtName.getText().toString().trim(),txtUsername.getText().toString().trim(),
                        txtPassword.getText().toString().trim(),txtPhone.getText().toString().trim(),
                        txtEmail.getText().toString().trim(),txtAddress.getText().toString().trim(),txtDistrict.getText().toString().trim());
            }
        });

        cancel =(Button) view.findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    */
/*private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        servicesAPI api = adapter.create(servicesAPI.class);

        //Defining the method insertuser of our interface
        api.insertUser(

                //Passing the values by getting it from editTexts
                editTextName.getText().toString(),
                editTextUsername.getText().toString(),
                editTextPassword.getText().toString(),
                editTextEmail.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*//*



    void registerUser(String sNa, String sUNa, String sPw, String sPo,String sEml,String sAdd,String sDisc) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        servicesAPI service = retrofit.create(servicesAPI.class);
        */
/*Call<User> call = service.registerUser("TestName","TestUserName","TestPassword","TestEmail");
        call.enqueue(new Callback<User>() {*//*


        Call<String> call = service.registerUser("RTestName","RTestUserName","RTestPassword","RTestPhone","RTestEmail","RTestAddress","RTestDistrict");
        //Call<String> call = service.registerUser(sNa, sUNa, sPw, sPo, sEml, sAdd, sDisc);
        call.enqueue(new Callback<String>() {
            */
/*@Override
            public void onResponse(Response<User> response, Retrofit retrofit) {

                try {
                    //Displaying the output as a toast
                    Toast.makeText(getActivity(), response.body().toString(), Toast.LENGTH_LONG).show();
                    ;

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }*//*


            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
            //public void onResponse(Call<String> call, Response<String> response) {
                Log.i("onResponse",  response.toString());
                try {
                    //Displaying the output as a toast
                    Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG).show();
                    Log.i("onSuccess", "User registered successfully");
                    Log.i("onSuccess",  response.toString());
                } catch (Exception e) {
                    Log.i("onResponseException", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("onFailure", t.toString());
                //t.printStackTrace();
            }
        });
    }

    */
/*private void registerProcess(String name, String email,String password){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        ServerRequest request = new ServerRequest();
        request.setOperation(Constants.REGISTER_OPERATION);
        request.setUser(user);
        Call<ServerResponse> response = requestInterface.operation(request);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {

                ServerResponse resp = response.body();
                Snackbar.make(getView(), resp.getMessage(), Snackbar.LENGTH_LONG).show();
                progress.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                progress.setVisibility(View.INVISIBLE);
                Log.d(Constants.TAG,"failed");
                Snackbar.make(getView(), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();

            }
        });
    }



    */
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

            final servicesAPI loginReq = new servicesAPI();
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
    }*//*


    */
/*private void insertUser(){
        //Here we will handle the http request to insert User to mysql db
        //Creating a RestAdapter
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        servicesAPI api = adapter.create(servicesAPI.class);


        );
    }*//*



}
*/
