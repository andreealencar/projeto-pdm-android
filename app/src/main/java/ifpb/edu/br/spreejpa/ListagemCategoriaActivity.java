package ifpb.edu.br.spreejpa;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListagemCategoriaActivity extends AppCompatActivity {

//
//    SQLiteDatabase db;
//    Cursor cursor;
//    SimpleCursorAdapter ad;
//    ListView listViewCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_categoria);

        ArrayList<Categoria> Categorias = null;
        CategoriaDAO daoC = new CategoriaDAO(this);
//
//        Categoria c = new Categoria("Rock");
//        daoC.insert(c);
//        Categoria c1 = new Categoria("Samba");
//        daoC.insert(c1);
//        Categoria c2 = new Categoria("Forró");
//        daoC.insert(c2);
//        Categoria c3 = new Categoria("Eletronica");
//        daoC.insert(c3);
//        Categoria c4 = new Categoria("Funk");
//        daoC.insert(c4);
//
//        Evento e = new Evento(2, "Festa da luz", "998249393", "Bessa shopping", 11, 02, 2016, 40000);
//
//        daoE.insert(e);

        Categorias = (ArrayList<Categoria>) daoC.get();
        List<String> nomes = new ArrayList <String>();

        for(Categoria cat:Categorias){
            nomes.add(cat.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);

        ListView listView = (ListView) findViewById(R.id.listViewCategorias);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnClickList());
    }
    private class OnClickList implements AdapterView.OnItemClickListener{
    @Override
        public void onItemClick(AdapterView<?> parent,View view,int position,long id){
            Intent i=new Intent("listar");
            startActivity(i);
        }
    }
}
