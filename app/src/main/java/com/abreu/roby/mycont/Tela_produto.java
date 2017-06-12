package com.abreu.roby.mycont;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class Tela_produto extends AppCompatActivity implements View.OnClickListener {

    ListView lvLista_de_produtos;
    Button btCadastrar_produto;
    List lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_produto);
        btCadastrar_produto = (Button)findViewById(R.id.button_novoProduto);
        btCadastrar_produto.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Cadastro_produto.class);
        startActivity(intent);

    }

    public void listarProd(View view){
        Intent intent = new Intent(this, Listar_Produto.class);
        startActivity(intent);
    }

}
