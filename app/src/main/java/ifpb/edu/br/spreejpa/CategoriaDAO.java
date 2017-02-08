package ifpb.edu.br.spreejpa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
        cv.put("categoriaid", c.getId());
        cv.put("nome", c.getNome());





        this.banco.insert("Categoria", null, cv);
    }


    public List<String> getCategorias(){

        String sql="SELECT nome FROM Categoria";
        Cursor c =banco.rawQuery(sql,null);
        ArrayList<String> lista=null;

        if (c.getCount() > 0) {
            lista=new ArrayList<String>();
            c.moveToFirst();

            do {

                lista.add(c.getString(0));
            } while (c.moveToNext());
        }
        return lista;
    }
}
