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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_categoria);

        ArrayList<Categoria> Categorias = null;
        CategoriaDAO daoC = new CategoriaDAO(this);
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
            Intent i=new Intent(ListagemCategoriaActivity.this, ListagemEventosActivity.class);
            startActivity(i);
        }
    }
}
