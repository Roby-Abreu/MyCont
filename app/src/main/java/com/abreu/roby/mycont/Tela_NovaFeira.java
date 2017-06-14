package com.abreu.roby.mycont;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Tela_NovaFeira extends AppCompatActivity {
    TextView tvNF, tvDF, lucro;
    String NF, data;
    int idFeira, i;
    Button vender, fechar;
    double tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__nova_feira);
        tvNF = (TextView) findViewById(R.id.textView_nomeFeira);
        tvDF = (TextView) findViewById(R.id.textVie_dataFeira);
        lucro = (TextView) findViewById(R.id.textView14);
        lucro.setText("");
        vender = (Button) findViewById(R.id.button_fazerVenda);
        fechar = (Button) findViewById(R.id.button_fecharFeira);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();

        NF = b.getString("nome feira").toString();
        tvNF.setText(NF);
        idFeira = b.getInt("id_fera");

        data = DateFormat.getDateInstance().format(new Date());
        tvDF.setText(data);



        fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

     public void vender(View view){
         AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
         dialogo.setTitle("Opções");
         dialogo.setPositiveButton("NOVA VENDA", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {
                 Bundle bundle = new Bundle();
                 bundle.putString("nome feira", NF);
                 bundle.putInt("id_feira", idFeira);
                 bundle.putString("data feira", data);
                 Intent intent = new Intent(getApplicationContext(), RealizarVenda.class);
                 intent.putExtras(bundle);
                 startActivity(intent);
             }
         });
         dialogo.setNegativeButton("LISTAR", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Bundle bundle = new Bundle();
                 bundle.putString("dataFeira", data);
                 Intent intent = new Intent(getApplicationContext(), Listar_Venda.class);
                 intent.putExtras(bundle);
                 startActivity(intent);
             }
         });dialogo.show();
     }

    public void gastar(View view){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Opções");
        dialogo.setPositiveButton("NOVO GASTO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Bundle bundle = new Bundle();
                bundle.putString("nome feira", NF);
                bundle.putInt("id_feira", idFeira);
                bundle.putString("data feira", data);
                Intent intent = new Intent(getApplicationContext(), RealizarGasto.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        dialogo.setNegativeButton("LISTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFeira", data);
                Intent intent = new Intent(getApplicationContext(), Listar_Gasto.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });dialogo.show();
    }

    @Override
    public void finish(){
        Feira feira = new Feira();
        feira.setLucro_total(tt);
        super.finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ValorTotal application = (ValorTotal) getApplication();
        double vv = application.valorTotalVendaFeira;
        double vg = application.valorTotalGastoFeira;

        tt = vv-vg;
        lucro.setText(String.valueOf(tt));
    }

}
