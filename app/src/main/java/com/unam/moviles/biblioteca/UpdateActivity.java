package com.unam.moviles.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    boolean flag = false;
    Spinner sp_id;
    List<String> list_id_sp;
    ArrayAdapter data_id_sp;
    int Array[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Array = new int[20];
        sp_id = (Spinner) findViewById(R.id.sp_id);
        list_id_sp = new ArrayList<String>();

        list_id_sp.add("ELIGE UNA OPCIÓN...");
        list_id_sp.add("1");
        list_id_sp.add("2");
        list_id_sp.add("3");
        list_id_sp.add("4");
        list_id_sp.add("5");
        list_id_sp.add("6");
        list_id_sp.add("7");
        list_id_sp.add("8");
        list_id_sp.add("9");
        list_id_sp.add("10");
        list_id_sp.add("11");
        list_id_sp.add("12");
        list_id_sp.add("13");
        list_id_sp.add("14");
        list_id_sp.add("15");
        list_id_sp.add("16");
        list_id_sp.add("17");
        list_id_sp.add("18");
        list_id_sp.add("19");
        list_id_sp.add("20");

        data_id_sp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list_id_sp);
        data_id_sp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_id.setAdapter(data_id_sp);
        sp_id.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) //crea un menu de opciones
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu); //recursos de carpeta menu, archivo xml menu
        menu.getItem(3).setVisible(false);
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

            case R.id.itmHome:
                Intent home_intent = new Intent(this,MainActivity.class);
                startActivity(home_intent);
                break;

            case R.id.itmAdd:
                Intent fourth_intent = new Intent(this,AddActivity.class);
                startActivity(fourth_intent);
                break;

        }
        return true;
    }

    @Override
    public void onPause()
    {
        super.onPause();
        flag = true;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(flag == true)
            finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
