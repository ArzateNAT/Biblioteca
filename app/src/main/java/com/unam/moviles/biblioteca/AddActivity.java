package com.unam.moviles.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.unam.moviles.model.Book;
import com.unam.moviles.sqliteDB.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnClickListener{
    EditText title_et, author_et, id_et;

    boolean flag = false;
    Spinner sp_id;
    List<String> list_id_sp;
    ArrayAdapter data_id_sp;
    int Array[];
    Book userBook;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        author_et = (EditText)findViewById(R.id.edt_agregarAuthor);
        title_et = (EditText)findViewById(R.id.edt_agregarTitulo);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        sp_id = (Spinner)findViewById(R.id.sp_id);
        Array = new int [20];

        sp_id = (Spinner) findViewById(R.id.sp_id);
        list_id_sp = new ArrayList<String>();

        //SE AGREGAN LOS ELEMENTOS
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

        data_id_sp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list_id_sp);
        data_id_sp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_id.setAdapter(data_id_sp);
        sp_id.setOnItemSelectedListener(this);
        btnAdd.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) //crea un menu de opciones
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu); //recursos de carpeta menu, archivo xml menu
        menu.getItem(4).setVisible(false);
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

            case R.id.itmHome:
                Intent main_intent = new Intent(this,MainActivity.class);
                startActivity(main_intent);
                break;

            case R.id.itmUpdate:
                Intent third_intent = new Intent(this,UpdateActivity.class);
                startActivity(third_intent);
                break;

            case R.id.itmDelete:
                Intent second_intent = new Intent(this,DeleteActivity.class);
                startActivity(second_intent);
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

    @Override
    public void onClick(View v) {
        String title, author;
        int id;
        title = title_et.getText().toString();
        author = author_et.getText().toString();
        id = (int)sp_id.getSelectedItemId();
        userBook = new Book(id,title,author);
        SqliteHelper db = new SqliteHelper(this);
        long result = db.addBook(userBook);
        Log.d("result_book", String.valueOf(result));
        String msg = "";
        if (result != -1)
        {
            msg = "El libro ha sido registrado exitosamente";
            clean();
        }
        else
        {
            msg = "No se agregó el Libro";
        }

        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    private void clean()
    {
        title_et.setText("");
        author_et.setText("");
    }
}
