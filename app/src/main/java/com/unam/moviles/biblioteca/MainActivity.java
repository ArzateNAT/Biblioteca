package com.unam.moviles.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) //crea un menu de opciones
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu); //recursos de carpeta menu, archivo xml menu
        menu.getItem(0).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item )//manjea los elementos sobre el menu
    {
        switch(item.getItemId())
        {
            case R.id.itmConsult:
                Intent first_intent = new Intent(this, ConsultActivity.class);
                startActivity(first_intent);
                break;

            case R.id.itmDelete:
                Intent second_intent = new Intent(this,DeleteActivity.class);
                startActivity(second_intent);
                break;

            case R.id.itmUpdate:
                Intent third_intent = new Intent(this,UpdateActivity.class);
                startActivity(third_intent);
                break;

            case R.id.itmAdd:
                Intent fourth_intent = new Intent(this,AddActivity.class);
                startActivity(fourth_intent);
                break;

        }
        return true;
    }
}
