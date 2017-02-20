package org.neosoft.com.JHU.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.neosoft.com.JHU.R;

public class LoginFragment extends Fragment {
    EditText txtUID;
    EditText password;
    Button register;
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login, container, false);

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
        return view;
    }
}
