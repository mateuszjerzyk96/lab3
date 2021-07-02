package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk FAB",
                        Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d("Lab3", "id: " + id);

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings: {
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk action_settings",
                        Toast.LENGTH_SHORT).show();
                return true;
            }

            case R.id.cont: {
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk cont",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.button: {
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk trzeci",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            default: {
                System.out.println("none");
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void kliknij(View view) {

        // create random object
       Random ran = new Random();

        // generating integer
        int nxt = 17301500+ran.nextInt(100);

        try {
            Drawable d = getResources().getDrawable(nxt, getTheme());

            ImageButton btn = (ImageButton) findViewById(R.id.button);
            btn.setImageDrawable(d);

            Toast.makeText(getApplicationContext(),
                    "Drawable numer: " + nxt,
                    Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),
                    "Nie ma takiego drawabla",
                    Toast.LENGTH_SHORT).show();
        }


    }

    public void loguj(View view) {
        Toast.makeText(getApplicationContext(),
                "Kliknięto przycisk loguj",
                Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    public void zrob_zdj(View view) {
        Toast.makeText(getApplicationContext(),
                "Kliknięto przycisk zrob zdjecie",
                Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intencja, REQUEST_IMAGE_CAPTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }
}
