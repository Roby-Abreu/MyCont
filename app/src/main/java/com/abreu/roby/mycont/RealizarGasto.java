package com.abreu.roby.mycont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class RealizarGasto extends AppCompatActivity {

    EditText val_gasto;
    String NF, DF, FP;
    int idf;
    List lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_gasto);

        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = intent.getExtras();
        NF = b.getString("nome feira").toString();
        DF = b.getString("data feira").toString();
        idf = b.getInt("id_feira");


    }

    public void finalizarGasto(View view){
        val_gasto = (EditText)findViewById(R.id.editTextValorGasto);
        double valor = Double.parseDouble(val_gasto.getText().toString());

        RadioGroup rgGasto = (RadioGroup)findViewById(R.id.rg_gasto);
        switch (rgGasto.getCheckedRadioButtonId()) {
            case R.id.radioButtonAlimenticio:
                FP = "Alimenticio";
                break;
            case R.id.radioButtonVestuario:
                FP = "Vestuario";
                break;
            case R.id.radioButtonMedicamentos:
                FP = "Medicamentos";
                break;
            case R.id.radioButtonOutros:
                FP = "oUTROS";
        }
        ValorTotal valor_total = (ValorTotal)getApplication();
        valor_total.valorTotalGastoFeira = valor;

        Gasto gasto = new Gasto();
        gasto.setId_feira(idf);
        gasto.setTipo(FP);
        gasto.setValorGasto(Double.parseDouble(val_gasto.getText().toString()));
        gasto.setNomeFeira(NF);
        gasto.setDataGasto(DF);
        bdHelper banco = new bdHelper(this);
        banco.inserirNovoGasto(gasto);
        finish();

        Toast.makeText(this, "Gasto registrado!", Toast.LENGTH_SHORT).show();
    }
}
