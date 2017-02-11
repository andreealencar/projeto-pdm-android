package ifpb.edu.br.spreejpa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListagemEventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_eventos);

        ArrayList<Evento> eventos = null;
        EventoDAO daoE= new EventoDAO(this);
        eventos = (ArrayList<Evento>) daoE.get();
        List<String> nomes = new ArrayList<String>();

        for (Evento e:eventos){
            nomes.add(e.getNome());
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomes);
        ListView listView=(ListView) findViewById(R.id.listViewEventos);
        listView.setAdapter(adapter);
    }
}
