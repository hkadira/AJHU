package org.neosoft.com.JHU.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.fragments.GalleryFragment;

public class MainDashboardActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        GalleryFragment mainFragment = new GalleryFragment();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.gallery) {
            return true;
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
