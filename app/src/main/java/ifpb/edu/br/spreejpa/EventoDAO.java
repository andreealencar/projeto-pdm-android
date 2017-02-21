package ifpb.edu.br.spreejpa;
import android.app.usage.UsageEvents;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

            cv.put("categoria", p.getCategoriaid());
            cv.put("nome", p.getNome());
            cv.put("telefone", p.getTelefone());
            cv.put("endereco", p.getEndereco());
            cv.put("data", p.getData());

            this.banco.insert("Evento", null, cv);
        }

        public List<Evento> get(){
            List<Evento> lista = new ArrayList<Evento>();
            String colunas[] = {"id", "nome", "telefone","endereco", "data, categoria"};
            Cursor c = this.banco.query("Evento", colunas, null, null, null, null, "nome");
            Log.i("IFPB", c.toString());
            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String nome = c.getString(c.getColumnIndex("nome"));
                    int categoria = c.getInt(c.getColumnIndex("categoria"));
                    String endereco = c.getString(c.getColumnIndex("endereco"));
                    String telefone = c.getString(c.getColumnIndex("telefone"));
                    Long data = c.getLong(c.getColumnIndex("data"));

                    Evento e = new Evento(nome,telefone,endereco,data);
                    e.setCategoriaid(categoria);
                    lista.add(new Evento(nome,telefone,endereco,data));
                } while (c.moveToNext());
            }
            return lista;
        }
        // Metodo verifica se já existe uma evento com o nome informado
        // compara os nomes ambos em minusculo.
        public boolean jaExiste(Evento evento) {
            List<Evento> lista = new ArrayList<Evento>();
            String colunas[] = {"nome"};
            Cursor c = this.banco.query("Evento", colunas, null, null, null, null, "nome");
            String nomeEvento = evento.getNome().toLowerCase();

            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    String nome = c.getString(c.getColumnIndex("nome"));
                    if (nome.toLowerCase().equals(nomeEvento)) {
                        return true;
                    }
                } while (c.moveToNext());
            }else {

            }
            return false;
        }

//    public Evento getById(int id){
//        Evento e;
//        String colunas[] = {"id"};
//        Cursor c = this.banco.query("Evento", colunas, null, null, null, null, "id");
//        if(c.getCount()>0){
//            c.moveToFirst();
//            do{
//                int idEvento=c.getInt(c.getColumnIndex("id"));
//                if(idEvento==id){
//                    return
//                }
//
//            }
//
//        }
//    }
    }