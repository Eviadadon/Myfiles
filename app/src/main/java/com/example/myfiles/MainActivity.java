package com.example.myfiles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
    TextView count;
    int x=0;
    int y;
    EditText etna;
    String name;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count=(TextView) findViewById(R.id.count);
        etna=(EditText) findViewById(R.id.etna);

        SharedPreferences settings= getSharedPreferences("prefs_name", MODE_PRIVATE);
        y=settings.getInt("y", -10);
        name=settings.getString("name", "");
        etna.setText(name);
        if(y==-10)
            Toast.makeText(this, "an error was found in the shared files", Toast.LENGTH_SHORT).show();
        else {
            count.setText(" click number:"+y);
            x=y;
        }
    }

    /**
     * set the options menu
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     *  credit activity
     * @param menu
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if ((st.equals("CREDITS"))) {
            Intent si = new Intent(this, CREDITS.class);
            startActivity(si);
        }
        return true;
    }

    public void count(View view) {
        x++;
        count.setText("this is click number:"+x);
    }

    public void reset(View view) {
        x=0;
        count.setText("click's count");
    }

    public void exit(View view) {
        String name=etna.getText().toString();
        SharedPreferences settings= getSharedPreferences("prefs_name", MODE_PRIVATE);
        SharedPreferences.Editor editor= settings.edit();
        editor.putInt("y", x);
        editor.putString("name",name);
        editor.commit();
        finish();
    }
}
