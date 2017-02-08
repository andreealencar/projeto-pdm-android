package ifpb.edu.br.spreejpa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListagemEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_eventos);


        ArrayList<String> eventos=null;
        EventoDAO daoE= new EventoDAO(this);

        eventos= (ArrayList<String>) daoE.getEventos();

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,eventos);

        ListView listView=(ListView) findViewById(R.id.listViewEventos);

        listView.setAdapter(adapter);
    }
}
