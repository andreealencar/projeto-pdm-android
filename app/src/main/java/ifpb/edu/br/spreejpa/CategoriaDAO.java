package ifpb.edu.br.spreejpa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows 10 on 08/02/2017.
 */

public class CategoriaDAO {

    private SQLiteDatabase banco;

    public CategoriaDAO(Context context){
        this.banco = new BancoHelper(context).getWritableDatabase();
    }


    public void insert(Categoria c){
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());
        this.banco.insert("Categoria", null, cv);
    }


    public List<Categoria> getCategorias() {
        List<Categoria> lista = new ArrayList<Categoria>();
        String colunas[] = {"nome"};
        Cursor c = this.banco.query("categoria", colunas, null, null, null, null, "nome");
        Log.i("IFPB", c.toString());
        if (c.getCount() > 0) {
            c.moveToFirst();
            do {
                int id = c.getInt(c.getColumnIndex("categoriaId"));
                String nome = c.getString(c.getColumnIndex("nome"));
                Categoria cat = new Categoria(nome);
                lista.add(cat);
            } while (c.moveToNext());
        }
        return lista;
    }

    public List<Categoria> get(){
        List<Categoria> lista = new ArrayList<Categoria>();
        String colunas[] = {"categoriaId","nome"};
        Cursor c = this.banco.query("Categoria", colunas, null, null, null, null, "nome");
        if (c.getCount() > 0) {
            c.moveToFirst();
            do {
                int id = c.getInt(c.getColumnIndex("categoriaId"));
                String nome = c.getString(c.getColumnIndex("nome"));
                Categoria cat = new Categoria(nome);
                cat.setId(id);
                lista.add(cat);
            } while (c.moveToNext());
        }
        return lista;
    }
}
