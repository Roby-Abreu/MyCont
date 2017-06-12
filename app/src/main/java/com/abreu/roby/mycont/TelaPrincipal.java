package com.abreu.roby.mycont;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class TelaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String srt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_principal, menu);
        TextView tvNomeHeader = (TextView)findViewById(R.id.nome_header);
        Intent intent = getIntent();
        Bundle B = new Bundle();
        B = intent.getExtras();
        String Ulog = B.getString("log").toString();
        tvNomeHeader.setText(Ulog);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_novaFeira) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("NOME DA FEIRA");
            final EditText input = new EditText(this);
            dialogo.setView(input);
            dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    srt = input.getEditableText().toString();
                    String dataAtual = DateFormat.getDateInstance().format(new Date());
                    Feira feira = new Feira();
                    feira.setNomeDafeira(srt);
                    feira.setDataAfeira(dataAtual);
                    feira.setStatus("Em aberto");
                    bdHelper banco = new bdHelper(getApplicationContext());
                    banco.inserirNovaFeira(feira);
                    finish();
                    Bundle bundle = new Bundle();
                    bundle.putString("nome feira", srt);
                    bundle.putInt("id_feira", feira.getId_feira());
                    Intent intent = new Intent(getApplicationContext(), Tela_NovaFeira.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                }
            });dialogo.show();
        } else if (id == R.id.nav_produtos) {
            Intent intent = new Intent(this, Tela_produto.class);
            startActivity(intent);
        } else if (id == R.id.nav_vendas) {
            Intent intent = new Intent(this, Listar_Venda.class);
            startActivity(intent);
        } else if (id == R.id.nav_gastos) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
