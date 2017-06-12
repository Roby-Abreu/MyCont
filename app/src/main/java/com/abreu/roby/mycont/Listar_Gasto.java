package com.abreu.roby.mycont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Listar_Gasto extends AppCompatActivity {

    String DF;
    ListView lvLista_de_gastos;
    List lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__gasto);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        DF = b.getString("dataFeira").toString();

        bdHelper banco = new bdHelper(this);
        lvLista_de_gastos = (ListView)findViewById(R.id.lista_de_gastos);
        lista = banco.selecionarTodosGastos();
        ArrayAdapter<Gasto> adapter = new ArrayAdapter<Gasto>(this, android.R.layout.simple_list_item_1, lista);
        lvLista_de_gastos.setAdapter(adapter);
    }
}
