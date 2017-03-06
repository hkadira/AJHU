package org.neosoft.com.JHU.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.service.LocalRepository;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imgEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgEnglish=(ImageButton)findViewById(R.id.btnEnglish);
        imgEnglish.setOnClickListener(this);

        TextView myTextView = (TextView) findViewById(R.id.textView);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/iskpota.ttf");
        myTextView.setTypeface(typeface);

        Log.i("Token", FirebaseInstanceId.getInstance().getToken());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnEnglish:
                if(LocalRepository.getInstance().isAuthenticated()){
                    startActivity(new Intent(getApplicationContext(),MainDashboardActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
                break;
        }
    }
}
