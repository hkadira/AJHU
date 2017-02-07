package org.neosoft.com.JHU.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import org.neosoft.com.JHU.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imgEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgEnglish=(ImageButton)findViewById(R.id.btnEnglish);
        imgEnglish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnEnglish:
                startActivity(new Intent(getApplicationContext(),MainDashboardActivity.class));
                finish();
                break;
        }
    }
}