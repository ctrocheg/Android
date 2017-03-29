package com.example.cooper.mobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText Usuario;
    private TextView Layer;
    private Spinner ListaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Layer=(TextView) findViewById(R.id.textView);
        this.Usuario=(EditText) findViewById(R.id.editText2);
        this.ListaUsuarios=(Spinner) findViewById(R.id.spinner);
    }

    public void EveIngresar(View view){
        this.Usuario.getText().toString();
        String Comando="";
        String Usu="solano.arsenio";

       // ListaUsuarios.addView();"Hola");

        DB db = new DB();
        try {

            ResultSet resultSet = db.select("Select * from usuarios");

            if (resultSet != null) {

                //this.ListaUsuarios()

//                SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item,resultSet,new String[] {"nombre"},new int[] {android.R.id..text1});

                ArrayList<String> data = new ArrayList<String>();

                while (resultSet.next()) {
                    String id = resultSet.getString("usrcod");
                    data.add(id);
                }



                String[] array = data.toArray(new String[0]);
                ArrayAdapter NoCoreAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
                ListaUsuarios.setAdapter(NoCoreAdapter);


                //String[] valores = resultSet.getArray("ss");//.getInt(;
               // ListaUsuarios.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));

                this.Layer.setText("bIEN");//.toString());

                //Intent intent = new Intent(this, ListarActivity.class);
                //startActivity(intent);
            } else {

            }
        }
        catch (Exception ex){
            this.Layer.setText("HOla");//.toString());
        }



    }
}
