package org.neosoft.com.JHU.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.fragments.GalleryFragment;
import org.neosoft.com.JHU.service.LocalRepository;

public class MainDashboardActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;
    private GalleryFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mainFragment = new GalleryFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mainFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            /*getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mainFragment).commit();*/
            getSupportFragmentManager().popBackStack();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.gallery) {
            return true;
        }
        if (id == R.id.signout) {
            /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, new LoginFragment());
            transaction.addToBackStack(null);
            transaction.commit();*/
            LocalRepository.getInstance().clearSession();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));

            finish();
        }
        if(id == R.id.about){
            Toast.makeText(MainDashboardActivity.this, "About menu", Toast.LENGTH_LONG).show();
        }

        if(id == R.id.exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
