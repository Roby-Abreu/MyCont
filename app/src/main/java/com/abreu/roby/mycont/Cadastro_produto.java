package com.abreu.roby.mycont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro_produto extends AppCompatActivity implements View.OnClickListener{

    EditText etNomeProd, etQTD, etPP, etPV;
    Button btSalvarProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        etNomeProd = (EditText)findViewById(R.id.editTextGetNomeProd);
        etQTD = (EditText)findViewById(R.id.editTextGetQTD);
        etPP = (EditText)findViewById(R.id.editTextGetValorProd);
        etPV = (EditText)findViewById(R.id.editText_getValorVenda);
        btSalvarProd = (Button)findViewById(R.id.buttonSalvarProduto);

        btSalvarProd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Produto produto = new Produto();
        produto.setNome_produto(etNomeProd.getText().toString());
        produto.setQuantidade(Integer.parseInt(etQTD.getText().toString()));
        produto.setValorDEproducao(Double.parseDouble(etPP.getText().toString()));
        produto.setValorDEvenda(Double.parseDouble(etPV.getText().toString()));

        bdHelper banco = new bdHelper(this);
        banco.inserirNovoProduto(produto);
        finish();
        Toast.makeText(this, "Produto cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }
}
