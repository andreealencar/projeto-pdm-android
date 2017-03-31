package ifpb.edu.br.spreejpa.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.spreejpa.dao.CategoriaDAO;
import ifpb.edu.br.spreejpa.dao.EventoDAO;
import ifpb.edu.br.spreejpa.R;
import ifpb.edu.br.spreejpa.model.Categoria;
import ifpb.edu.br.spreejpa.model.Evento;


public class ListagemEventosActivity extends AppCompatActivity implements Serializable {
    Button btnLocalization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_eventos);

        ListView listViewEventos = (ListView) findViewById(R.id.listViewEventos);

        ArrayList<Evento> eventos = null;
        EventoDAO daoE = new EventoDAO(this);

        Integer categoriaid = (Integer) getIntent().getSerializableExtra("idcategoria");

        eventos = (ArrayList<Evento>) daoE.EventosPorCategoria(categoriaid);

        AdapterEventos adapterEventos = new AdapterEventos(this, eventos);
        listViewEventos.setAdapter(adapterEventos);
    }

}

//    private class OnClickList implements AdapterView.OnItemClickListener{
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//
//            ArrayList<Evento> eventos = null;
//            EventoDAO daoE= new EventoDAO();
//            Integer categoriaid = (Integer) getIntent().getSerializableExtra("idcategoria");
//            eventos = (ArrayList<Evento>) daoE.EventosPorCategoria(categoriaid);
//
//            Intent i = new Intent(ListagemEventosActivity.this, MapsActivity.class);
//            i.putExtra("endereco", eventos.get(position).getEndereco());
//
//            startActivity(i);
//        }
//    }

