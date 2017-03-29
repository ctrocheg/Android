package com.example.cooper.mobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListarActivity extends AppCompatActivity {
    private ListView Listar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        this.Listar = (ListView) findViewById(R.id.ListViewDestinos);
    }
}
