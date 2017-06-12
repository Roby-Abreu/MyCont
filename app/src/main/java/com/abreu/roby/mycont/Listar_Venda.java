package com.abreu.roby.mycont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Listar_Venda extends AppCompatActivity {

    ListView lvLista_de_venda_dia;
    List lista;
    String DF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__venda);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        DF = b.getString("dataFeira").toString();

        bdHelper banco = new bdHelper(this);
        lvLista_de_venda_dia = (ListView)findViewById(R.id.lista_vendas_dia);
        lista = banco.selecionarTodasVenddas();
        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, lista);
        lvLista_de_venda_dia.setAdapter(adapter);
    }
}
