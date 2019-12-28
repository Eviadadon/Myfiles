package com.example.myfiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CREDITS extends AppCompatActivity {

    /**
     * Jump to main activity
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * check that you move to the right activity,  like controller
     * @param menu
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if ((st.equals("main activity"))) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
}
