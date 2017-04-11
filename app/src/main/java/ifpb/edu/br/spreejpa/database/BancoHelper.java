package ifpb.edu.br.spreejpa.database;

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
                "senha VARCHAR(100),"+
                "admin BOOLEAN);");

        db.execSQL("CREATE TABLE IF NOT EXISTS Categoria(" +
                "categoriaId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR(100));");

        db.execSQL("CREATE TABLE IF NOT EXISTS Evento(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR(100), " +
                "telefone VARCHAR(100), "+
                "endereco VARCHAR(100), "+
                "data DATETIME, "+
                "categoria INTEGER, FOREIGN KEY (categoria) REFERENCES Categoria(categoriaId));");

        // Popular banco com as categorias e um usuario admin para demonstração.
        db.execSQL("INSERT INTO Categoria Values(1, 'Forro')");
        db.execSQL("INSERT INTO Categoria Values(2, 'Samba')");
        db.execSQL("INSERT INTO Categoria Values(3, 'Eletronica')");
        db.execSQL("INSERT INTO Categoria Values(4, 'Rock')");
        db.execSQL("INSERT INTO Categoria Values(5, 'Gospel')");
        db.execSQL("INSERT INTO Categoria Values(6, 'Sertanejo')");

        db.execSQL("INSERT INTO Usuario Values (99, 'admin', 'admin@email.com', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',1)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Usuario");
        db.execSQL("drop table Evento");
        db.execSQL("drop table Categoria");
        this.onCreate(db);
    }
}