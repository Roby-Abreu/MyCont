package com.abreu.roby.mycont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RealizarVenda extends AppCompatActivity {
    String NF, DF, FP;  TextView total;
    List lista;        EditText ETdes,ETqtd;
    Spinner prodVenda;  int idf, q;
    double conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_venda);
        prodVenda = (Spinner)findViewById(R.id.spinner_lista_prodvenda);
        ETqtd = (EditText) findViewById(R.id.editText_qtd);
        ETdes = (EditText)findViewById(R.id.editText_desconto);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        NF = b.getString("nome feira").toString();
        DF = b.getString("data feira").toString();
        idf = b.getInt("id_feira");

        bdHelper banco = new bdHelper(this);
        lista = banco.selecionarTodosProdutosSpinnner();

        ArrayAdapter<Produto_Spinner>adapter = new ArrayAdapter<Produto_Spinner>(this, android.R.layout.simple_list_item_1,
                lista);
        prodVenda.setAdapter(adapter);

    }

    public void finalizarVenda(View view){
        String n = ((Produto_Spinner)prodVenda.getSelectedItem()).getNome_produto();
        double va = ((Produto_Spinner)prodVenda.getSelectedItem()).getValorDEvenda();
        q = Integer.parseInt(ETqtd.getText().toString());
        double d = Double.parseDouble(ETdes.getText().toString());
        conta = 0;
        conta = (va*q)-d;

        RadioGroup rgVenda = (RadioGroup)findViewById(R.id.rg_opcoes);
        switch (rgVenda.getCheckedRadioButtonId()){
            case R.id.radioButton_debito:
                FP = "Débito";
                break;
            case R.id.radioButton_credito:
                FP = "Crédito";
                break;
            case R.id.radioButton_dinheiro:
                FP = "Dinheiro";
                break;
        }

        ValorTotal valor_total = (ValorTotal)getApplication();
        valor_total.valorTotalVendaFeira = conta;

        Venda venda = new Venda();
        venda.setId_feira(idf);
        venda.setNome_produto(n);
        venda.setQuantidade(q);
        venda.setValorDAvenda(conta);
        venda.setFormaDEpagamento(FP);
        venda.setNomeDAfeira(NF);
        venda.setDataDAfeira(DF);
        bdHelper banco = new bdHelper(this);
        banco.inserirNovaVenda(venda);
        finish();

        Toast.makeText(this, "Venda realizada com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
