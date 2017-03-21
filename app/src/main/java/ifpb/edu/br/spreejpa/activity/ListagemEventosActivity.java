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



public class ListagemEventosActivity extends AppCompatActivity implements Serializable{
    Button btnLocalization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_eventos);

        ListView listViewEventos= (ListView) findViewById(R.id.listViewEventos);
//            Evento e1=new Evento("Show Legião urbana","43536262","Bairro dos Estados, Joao Pessoa Paraíba",1000000,2);
//             Evento e2=new Evento("Transpiration","41435351","Conde",1000000,1);
//            Evento e3=new Evento("Vintage Culture","989898989","Praia de Camboinha",200000,7);
//        Evento e4=new Evento("Liquid Sky","43536262","Pipa, Rio Grande do Norte",1000000,3);

        ArrayList<Evento> eventos = null;
        EventoDAO daoE= new EventoDAO(this);
//            daoE.insert(e1);
//            daoE.insert(e2);
        //            daoE.insert(e3);
        //            daoE.insert(e4);





        Integer categoriaid= (Integer) getIntent().getSerializableExtra("idcategoria");

        eventos = (ArrayList<Evento>) daoE.EventosPorCategoria(categoriaid);



            AdapterEventos adapterEventos=new AdapterEventos(this,eventos);
            listViewEventos.setAdapter(adapterEventos);








    }



    }





//
//    private class OnClickList implements AdapterView.OnItemClickListener{
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//
//            ArrayList<Evento> eventos = null;
//            EventoDAO daoE= new EventoDAO(ListagemEventosActivity.this);
//            Integer categoriaid= (Integer) getIntent().getSerializableExtra("idcategoria");
//            eventos = (ArrayList<Evento>) daoE.EventosPorCategoria(categoriaid);
//
//            Intent i=new Intent(ListagemEventosActivity.this, MapsActivity.class);
//            i.putExtra("endereco", eventos.get(position).getEndereco());
//
//            startActivity(i);
//        }
//    }

