package org.neosoft.com.JHU.activity;


import android.app.Dialog;
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
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
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
    CoordinatorLayout coordinatorLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUName=(EditText) findViewById(R.id.edTxtUName);
        txtPassword=(EditText) findViewById(R.id.edTxtPwd);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .lCoordinatorLayout);

        //TODO = remove later.
        //txtUName.setText("neo");
        //txtPassword.setText("rncp");



        register =(Button) findViewById(R.id.btnRegister);

        Log.i("User Name :", LocalRepository.getInstance().getUserName());
        Log.i("User Auth Status :", String.valueOf(LocalRepository.getInstance().isAuthenticated()));


        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new RegistrationFragment());
                ft.commit();*/
                //Toast.makeText(getApplicationContext(),"Registration Form",Toast.LENGTH_SHORT).show();

                txtUName.setText("");
                txtPassword.setText("");
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

        login =(Button) findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //findViewById(R.id.progressBar).setVisibility(View.VISIBLE);

                String user = txtUName.getText().toString();
                String pwd=   txtPassword.getText().toString();

                if(TextUtils.isEmpty(txtUName.getText())){
                    txtUName.setError("User name can't be empty");
                }
                else if(TextUtils.isEmpty(txtPassword.getText())){
                    txtPassword.setError("Password can't be empty");
                }else {
                    userLogin(user,pwd);
                    //login.setEnabled(false);
                }
                //findViewById(R.id.txt)
                //Toast.makeText(getActivity(),"Login",Toast.LENGTH_SHORT).show();
            }
        });

        TextView pwdReset=(TextView) findViewById(R.id.reset);
        pwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Password reset in progress",Toast.LENGTH_SHORT).show();

                final Dialog dialog = new Dialog(LoginActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog_resetpwd);
                //dialog.setTitle("Reset Password");

                //findViewById(R.id.progressBar2).setVisibility(View.GONE);

                ImageButton dialogButtonExit = (ImageButton) dialog.findViewById(R.id.btnExit);
                // if button is clicked, close the custom dialog
                dialogButtonExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                Button dialogBtnReset=(Button) dialog.findViewById(R.id.btnReset);
                dialogBtnReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView txtNic=(TextView) dialog.findViewById(R.id.edTxtUName);
                        String strNic= txtNic.getText().toString().trim();
                        TextView txtPwd=(TextView) dialog.findViewById(R.id.edTxtPwd);
                        String strPwd=txtPwd.getText().toString().trim();

                       // dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                        /*duak.hideSoftInputFromWindow(getWindow().getDecorView()
                                .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);*/

                        if(TextUtils.isEmpty(txtNic.getText())){
                            txtNic.setError("NIC can't be empty");
                        }
                        else if(TextUtils.isEmpty(txtPwd.getText())){
                            txtPwd.setError("Password can't be empty");
                        }else {
                            txtNic.setError(null);
                            txtPwd.setError(null);

                            resetPassword(strNic,strPwd,dialog);
                            //Toast.makeText(getApplicationContext(),"Updating password",Toast.LENGTH_LONG).show();
                            //login.setEnabled(false);
                        }

                        //dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }


    private void userLogin(final String sUNa, final String sPw) {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);

        NetworRepository.getApiService().loginUser(sUNa, sPw)
        //NetworRepository.getApiService().loginUser("b1", "c1")
                .enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        //findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                        Log.i("Response", response.body().toString());
                        //Toast.makeText()
                        if (response.isSuccessful()) {
                            //findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                            if (response.body().equals("Success!")) {
                                Log.i("onSuccessLogin", response.body().toString());
                                Log.i("onSuccessUserName", sUNa);
                                Log.i("onSuccessPwd", sPw);
                                //Toast.makeText(getApplicationContext(),"Login successfull", Toast.LENGTH_LONG).show();
                                //snackBarMessage("Login successfull");
                                LocalRepository.getInstance().saveUser(sUNa,sPw, true);
                                startActivity(new Intent(getApplicationContext(),MainDashboardActivity.class));
                                finish();
                            } else {
                                Log.i("onInvalidLogin", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                                login.setEnabled(true);
                                findViewById(R.id.progressBar).setVisibility(View.GONE);
                                snackBarMessage("Invalid user login");
                                //Toast.makeText(getApplicationContext(),"Invalid Login", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.i("onFailure", t.toString());
                        t.printStackTrace();
                        snackBarMessage("No internet connection");
                        //Toast.makeText(getApplicationContext(),"Unable to connect to internet", Toast.LENGTH_LONG).show();
                        login.setEnabled(true);
                        findViewById(R.id.progressBar).setVisibility(View.GONE);
                    }
                });
    }

    private void resetPassword(final String sUNa, final String sPw, final Dialog dialog) {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        dialog.findViewById(R.id.progressBar2).setVisibility(View.VISIBLE);


        //InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        //inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        NetworRepository.getApiService().resetPassword(sUNa, sPw)
                //NetworRepository.getApiService().loginUser("b1", "c1")
                .enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        //findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                        Log.i("Response", response.body().toString());
                        //Toast.makeText()
                        if (response.isSuccessful()) {
                            //findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                            if (response.body().equals("successfully updated")) {
                                Log.i("onSuccessUpdate", response.body().toString());
                                Log.i("onSuccessUpdateUserName", sUNa);
                                Log.i("onSuccessUpdatePwd", sPw);
                                LocalRepository.getInstance().clearSession();
                                dialog.dismiss();
                                //Toast.makeText(getApplicationContext(),"Login successfull", Toast.LENGTH_LONG).show();
                                snackBarMessage("Password reset successfull");
                                //LocalRepository.getInstance().saveUser(sUNa,sPw, true);
                                //startActivity(new Intent(getApplicationContext(),MainDashboardActivity.class));
                                //finish();
                            } else {
                                Log.i("onInvalidLogin", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                                login.setEnabled(true);
                                findViewById(R.id.progressBar).setVisibility(View.GONE);
                                snackBarMessage("Invalid NIC");
                                //Toast.makeText(getApplicationContext(),"Invalid Login", Toast.LENGTH_LONG).show();

                                dialog.findViewById(R.id.progressBar2).setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.i("onFailure", t.toString());
                        t.printStackTrace();
                        snackBarMessage("No internet connection");
                        //Toast.makeText(getApplicationContext(),"Unable to connect to internet", Toast.LENGTH_LONG).show();
                        login.setEnabled(true);
                        findViewById(R.id.progressBar).setVisibility(View.GONE);

                        dialog.findViewById(R.id.progressBar2).setVisibility(View.GONE);
                    }
                });
    }

    public void snackBarMessage(String message){
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message , Snackbar.LENGTH_LONG);
        View mView = snackbar.getView();
        mView.setBackgroundColor(Color.RED);
        //mView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        TextView tv = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(ContextCompat.getColor(LoginActivity.this, android.R.color.white));

        // set text to center
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            tv.setGravity(Gravity.CENTER_HORIZONTAL);

        snackbar.show();
    }
}
