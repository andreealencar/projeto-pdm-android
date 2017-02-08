package ifpb.edu.br.spreejpa;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by admin on 27/01/17.
 */
public class UsuarioDAO {
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        this.banco = new BancoHelper(context).getWritableDatabase();
    }

    public void insert(Usuario p){
        ContentValues cv = new ContentValues();
        cv.put("nome", p.getNome());
        cv.put("login", p.getLogin());
        cv.put("senha", p.getSenha());
        this.banco.insert("Usuario", null, cv);
    }

    public List<Usuario> get(){
        List<Usuario> lista = new ArrayList<Usuario>();
        String colunas[] = {"nome", "login", "senha"};
        Cursor c = this.banco.query("usuario", colunas, null, null, null, null, "nome");
        if (c.getCount() > 0) {
            c.moveToFirst();
            do {
                int id = c.getInt(c.getColumnIndex("id"));
                String nome = c.getString(c.getColumnIndex("nome"));
                String login = c.getString(c.getColumnIndex("login"));
                String senha = c.getString(c.getColumnIndex("senha"));
                lista.add(new Usuario(nome,login,senha));
            } while (c.moveToNext());
        }
        return lista;
    }
}
