package com.abreu.roby.mycont;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abreu.roby.mycont.R;

public class Login extends AppCompatActivity{

    EditText etLogin, etsenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText)findViewById(R.id.editText_login);
        etsenha = (EditText)findViewById(R.id.editText_senha);

    }

    public void cadastrarUsuario(View view){
        Intent intent = new Intent(this,Cadastro_usuario.class);
        startActivity(intent);
    }
    public void entrar(View view) {
        String l = etLogin.getText().toString();
        String s = etsenha.getText().toString();
        bdHelper banco = new bdHelper(this);
        String r = banco.validarUsuario(l, s);
        if (r == "Usuario valido") {
            Bundle bundle = new Bundle();
            bundle.putString("log", l);
            bundle.putString("pass", s);
            Intent intent = new Intent(this, TelaPrincipal.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Usuario/Senha Invalidos", Toast.LENGTH_SHORT).show();
        }
    }
}
