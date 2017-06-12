package com.abreu.roby.mycont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro_usuario extends AppCompatActivity implements View.OnClickListener{

    EditText etGetNome, etGetLogin, etGetSenha, etGetEmail;
    Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        etGetNome = (EditText)findViewById(R.id.editText_getNomeUsuario);
        etGetLogin = (EditText)findViewById(R.id.editText_getLogin);
        etGetSenha = (EditText)findViewById(R.id.editText_getSenha);
        etGetEmail = (EditText)findViewById(R.id.editText_getEmail);
        btSalvar = (Button)findViewById(R.id.button_salvarUsuario);

        btSalvar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Usuario usuario = new Usuario();
        usuario.setNome_usuario(etGetNome.getText().toString());
        usuario.setLogin(etGetLogin.getText().toString());
        usuario.setSenha(etGetSenha.getText().toString());
        usuario.setEmail(etGetEmail.getText().toString());

        bdHelper banco = new bdHelper(this);
        banco.inserirNovoUsuario(usuario);

        finish();
        Toast.makeText(this, "Usuario salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
