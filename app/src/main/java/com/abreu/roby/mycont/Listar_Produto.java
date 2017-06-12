package com.abreu.roby.mycont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Listar_Produto extends AppCompatActivity {

    ListView lvLista_de_produtos;
    List lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__produto);

        bdHelper banco = new bdHelper(this);

        lvLista_de_produtos = (ListView)findViewById(R.id.lista_de_produtos);
        lista = banco.selecionarTodosProdutos();
        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, lista);
        lvLista_de_produtos.setAdapter(adapter);
    }
}
