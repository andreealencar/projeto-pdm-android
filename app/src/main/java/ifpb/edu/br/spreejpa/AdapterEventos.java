package ifpb.edu.br.spreejpa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Windows 10 on 19/02/2017.
 */

public class AdapterEventos extends BaseAdapter {
    private Context context;
    private ArrayList<Evento> eventos;


    public AdapterEventos(Context context, ArrayList<Evento> eventos){
        this.context=context;
        this.eventos=eventos;
    }
    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= inflater.inflate(R.layout.evento_list_item,null);

        if(view !=null){

            ImageView img= (ImageView) view.findViewById(R.id.imageView);
            TextView titulo= (TextView) view.findViewById(R.id.titulo);
            TextView data= (TextView) view.findViewById(R.id.data);

            Evento evento = eventos.get(position);
            img.setImageResource(evento.getIcon());
            titulo.setText(evento.getNome());
            data.setText(evento.getData());

        }

        return view;
    }
}
