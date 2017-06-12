package com.abreu.roby.mycont;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 17/05/2017.
 */

public class bdHelper extends SQLiteOpenHelper{
    private static final String nome_bd = "Mybank";
    private static final int versao_bd = 9;

    public bdHelper(Context context) {
        super(context, nome_bd,null, versao_bd );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCriarTabelaUsuario = "CREATE TABLE usuario("
                + "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome_usuario TEXT,"
                + "login TEXT,"
                + "senha TEXT,"
                + "email TEXT"
                + ")";
        String sqlCriarTabelaProduto = "CREATE TABLE produto("
                + "id_produto INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome_produto TEXT,"
                + "quantidade INTEGER,"
                + "valorDEproducao DOUBLE,"
                + "valorDEvenda DOUBLE"
                + ")";
        String sqlCriarTabelaVenda = "CREATE TABLE venda("
                + "id_venda INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id_feira INTEGER,"
                + "nome_produto TEXT,"
                + "quantidade INTEGER,"
                + "valorDAvenda DOUBLE,"
                + "formaDEpagamento TEXT,"
                + "nomeDAfeira TEXT,"
                + "dataDAfeira TEXT"
                + ")";
        String sqlCriarTabelaGasto = "CREATE TABLE gasto("
                + "id_gasto INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id_feira INTEGER,"
                + "tipo_gasto TEXT,"
                + "valorGasto DOUBLE,"
                + "nomeDAfeira TEXT,"
                + "dataDAfeira TEXT"
                + ")";
        String sqlCriarTabelaFeira = "CREATE TABLE feira("
                + "id_feira INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nomeDafeira TEXT,"
                + "dataAfeira INTEGER,"
                + "status TEXT"
                + ")";
        db.execSQL(sqlCriarTabelaUsuario);
        db.execSQL(sqlCriarTabelaProduto);
        db.execSQL(sqlCriarTabelaVenda);
        db.execSQL(sqlCriarTabelaGasto);
        db.execSQL(sqlCriarTabelaFeira);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDeletarTabelaUsuario = "DROP TABLE usuario";
        String sqlDeletarTabelaProduto = "DROP TABLE produto";
        String sqlDeletarTabelaVenda = "DROP TABLE venda";
        String sqlDeletarTabelaGasto = "DROP TABLE gasto";
        String sqlDeletarTabelaFeira = "DROP TABLE feira";
        db.execSQL(sqlDeletarTabelaUsuario);
        db.execSQL(sqlDeletarTabelaProduto);
        db.execSQL(sqlDeletarTabelaVenda);
        db.execSQL(sqlDeletarTabelaGasto);
        db.execSQL(sqlDeletarTabelaFeira);
        onCreate(db);
    }

    public void inserirNovoUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_usuario", usuario.getNome_usuario());
        cv.put("login", usuario.getLogin());
        cv.put("senha", usuario.getSenha());
        cv.put("email", usuario.getEmail());
        db.insert("usuario", null, cv);
        db.close();
    }
    public void inserirNovoProduto(Produto produto){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_produto", produto.getNome_produto());
        cv.put("quantidade", produto.getQuantidade());
        cv.put("valorDEproducao", produto.getValorDEproducao());
        cv.put("valorDEvenda", produto.getValorDEvenda());
        db.insert("produto", null, cv);
        db.close();
    }
    public void inserirNovaVenda(Venda venda){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id_feira", venda.getId_feira());
        cv.put("nome_produto", venda.getNome_produto());
        cv.put("quantidade", venda.getQuantidade());
        cv.put("valorDAvenda", venda.getValorDAvenda());
        cv.put("formaDEpagamento", venda.getFormaDEpagamento());
        cv.put("nomeDAfeira", venda.getNomeDAfeira());
        cv.put("dataDAfeira", venda.getDataDAfeira());
        db.insert("venda", null, cv);
        db.close();
    }
    public void inserirNovaFeira(Feira feira){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nomeDafeira", feira.getNomeDafeira());
        cv.put("dataAfeira", feira.getDataAfeira());
        cv.put("status", feira.getStatus());
        db.insert("feira", null, cv);
        db.close();
    }
    public void inserirNovoGasto(Gasto gasto){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id_feira", gasto.getId_feira());
        cv.put("tipo_gasto", gasto.getTipo());
        cv.put("valorGasto", gasto.getValorGasto());
        cv.put("nomeDAfeira", gasto.getNomeFeira());
        cv.put("dataDAfeira", gasto.getDataGasto());
        db.insert("gasto", null, cv);
        db.close();
    }

    public List<Produto>selecionarTodosProdutos(){
        List<Produto>lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectProdutos = "SELECT * FROM produto";
        Cursor c = db.rawQuery(sqlSelectProdutos, null);
        if (c.moveToFirst()){
           do {
               Produto produto = new Produto();
               produto.setId_produto(c.getInt(0));
               produto.setNome_produto(c.getString(1));
               produto.setQuantidade(c.getInt(2));
               produto.setValorDEproducao(c.getDouble(3));
               produto.setValorDEvenda(c.getDouble(4));
               lista.add(produto);
           }while (c.moveToNext());
        }
        db.close();
        return lista;
    }
    public List<Produto_Spinner>selecionarTodosProdutosSpinnner(){
        List<Produto_Spinner>lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectProdutos = "SELECT * FROM produto";
        Cursor c = db.rawQuery(sqlSelectProdutos, null);
        if (c.moveToFirst()){
            do {
                Produto_Spinner produto = new Produto_Spinner();
                produto.setId_produto(c.getInt(0));
                produto.setNome_produto(c.getString(1));
                produto.setQuantidade(c.getInt(2));
                produto.setValorDEproducao(c.getDouble(3));
                produto.setValorDEvenda(c.getDouble(4));
                lista.add(produto);
            }while (c.moveToNext());
        }
        db.close();
        return lista;
    }
    public List<Venda>selecionarTodasVenddas(){
        List<Venda>lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectVendas = "SELECT * FROM venda";
        Cursor c = db.rawQuery(sqlSelectVendas, null);
        if (c.moveToFirst()){
            do {
                Venda venda = new Venda();
                venda.setId_venda(c.getInt(0));
                venda.setId_feira(c.getInt(1));
                venda.setNome_produto(c.getString(2));
                venda.setQuantidade(c.getInt(3));
                venda.setValorDAvenda(c.getDouble(4));
                venda.setFormaDEpagamento(c.getString(5));
                venda.setNomeDAfeira(c.getString(6));
                venda.setDataDAfeira(c.getString(7));
                lista.add(venda);
            }while (c.moveToNext());
        }
        db.close();
        return lista;
    }
    public List<Gasto>selecionarTodosGastos() {
        List<Gasto> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectGastos = "SELECT * FROM gasto";
        Cursor c = db.rawQuery(sqlSelectGastos, null);
        if (c.moveToFirst()) {
            do {
                Gasto gasto = new Gasto();
                gasto.setId_gasto(c.getInt(0));
                gasto.setId_feira(c.getInt(1));
                gasto.setTipo(c.getString(2));
                gasto.setValorGasto(c.getDouble(3));
                gasto.setNomeFeira(c.getString(4));
                gasto.setDataGasto(c.getString(5));
                lista.add(gasto);
            } while (c.moveToNext());
        }
        db.close();
        return lista;
    }

    public String validarUsuario(String usuario_usu, String usuario_senha){
        SQLiteDatabase db = getReadableDatabase();
        String resultado = "";
        String sqlValidaUsuario = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        String[] selectionArgs = new String[] { usuario_usu, usuario_senha };
        Cursor c = db.rawQuery(sqlValidaUsuario, selectionArgs);
        c.moveToFirst();
        if (c.moveToFirst()){
            do {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(c.getInt(0));
                usuario.setNome_usuario(c.getString(1));
                usuario.setLogin(c.getString(2));
                usuario.setSenha(c.getString(3));
                usuario.setEmail(c.getString(4));
                resultado = "Usuario valido";
            }while (c.moveToNext());
        }
        db.close();
        return resultado;
    }
    public String trocarStatusfeira(String NF){
        SQLiteDatabase db = getReadableDatabase();
        String resultado = "";
        String sqlTrocaStatus = "UPDATE feira SET status = 'Encerrada' WHERE nomeDafeira = ?";
        String[] selectionArgs = new String[]{NF};
        Cursor c = db.rawQuery(sqlTrocaStatus, selectionArgs);
        c.moveToFirst();
        if (c.moveToFirst()){
            resultado = "Feira encerrada!";
        }else {
            resultado = "Feira em Aberto!";
        }
        db.close();
        return resultado;
    }
}
