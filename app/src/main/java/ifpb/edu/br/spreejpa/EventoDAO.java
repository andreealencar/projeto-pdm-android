package ifpb.edu.br.spreejpa;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows 10 on 07/02/2017.
 */

public class EventoDAO {

        private SQLiteDatabase banco;

        public EventoDAO(Context context){
            this.banco = new BancoHelper(context).getWritableDatabase();
        }

        public void insert(Evento p){
            ContentValues cv = new ContentValues();
            cv.put("categoria", p.getCategoria());
            cv.put("nome", p.getNome());
            cv.put("data", p.getData());
            cv.put("endereco", p.getEndereco());

            cv.put("telefone", p.getTelefone());

            this.banco.insert("Evento", null, cv);
        }

        public List<Evento> get(){
            List<Evento> lista = new ArrayList<Evento>();
            String colunas[] = {"categoria","nome","data","endereco","telefone"};
            Cursor c = this.banco.query("Evento", colunas, null, null, null, null, "nome");
            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String nome = c.getString(c.getColumnIndex("nome"));
                    String categoria = c.getString(c.getColumnIndex("categoria"));
                    String endereco = c.getString(c.getColumnIndex("endereco"));

                    String telefone = c.getString(c.getColumnIndex("telefone"));
                    long data = c.getLong(c.getColumnIndex("data"));
                    lista.add(new Evento(categoria,nome,telefone,endereco,data));
                } while (c.moveToNext());
            }
            return lista;
        }
    }


