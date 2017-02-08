package ifpb.edu.br.spreejpa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 27/01/17.
 */
public class BancoHelper extends SQLiteOpenHelper
{
    public BancoHelper(Context context) {
        super(context, "spreeDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Usuario(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR(100), " +
                "login VARCHAR(100),"+
                "senha VARCHAR(100));");


        db.execSQL("CREATE TABLE IF NOT EXISTS Evento(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "categoria VARCHAR(100), " +
                "nome VARCHAR(100), " +
                "telefone VARCHAR(100),"+
                "data VARCHAR(100));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table pessoa");
        this.onCreate(db);
    }
}