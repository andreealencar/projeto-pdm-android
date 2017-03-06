package ifpb.edu.br.spreejpa.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.spreejpa.dao.EventoDAO;
import ifpb.edu.br.spreejpa.R;
import ifpb.edu.br.spreejpa.model.Evento;

public class ListagemEventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_eventos);

        ListView listViewEventos= (ListView) findViewById(R.id.listViewEventos);
//            Evento e1=new Evento("Virgens de Mangabeira","2424242424","Av. Epitacio Pèssoa",1000000,2);
//            Evento e2=new Evento("Muriçoquinhas","11111111111","Av. Epitacio Pèssoa",200000,2);
        ArrayList<Evento> eventos = null;
        EventoDAO daoE= new EventoDAO(this);
//            daoE.insert(e1);
//            daoE.insert(e2);


            eventos = (ArrayList<Evento>) daoE.get();

            AdapterEventos adapterEventos=new AdapterEventos(this,eventos);
            listViewEventos.setAdapter(adapterEventos);






//        List<String> nomes = new ArrayList<String>();
//
//        for (Evento e:eventos){
//            nomes.add(e.getNome());
//        }
//
//        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomes);
//        ListView listView=(ListView) findViewById(R.id.listViewEventos);
//        listView.setAdapter(adapter);
    }
}
