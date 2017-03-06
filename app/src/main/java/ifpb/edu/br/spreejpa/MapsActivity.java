package ifpb.edu.br.spreejpa;


import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import static android.support.test.InstrumentationRegistry.getContext;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{
    double lat=-7.065485;



    double longi=-34.839783;
    LatLng ll= new LatLng(lat,longi);

    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

////            Toast.makeText(getApplicationContext(),"Não possui localização",Toast.LENGTH_SHORT).show();

    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat,longi)).title("Bessa grill"));
        map.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate location= CameraUpdateFactory.newLatLngZoom(ll,20);

        CameraUpdate zoom= CameraUpdateFactory.zoomTo(20);

        map.moveCamera(location);

        map.animateCamera(zoom,3000,null);

        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }



//        EventoDAO eventoDAO= new EventoDAO(getContext());
//        for (Evento evento : eventoDAO)
//
//    {
//        LatLng coordenada = pegaCoordenadaDoEndereco(evento.getEndereco());
//        if (coordenada != null) {
//            MarkerOptions marcador = new MarkerOptions();
//            marcador.position(coordenada);
//            marcador.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//            marcador.title(evento.getNome());
//
//            mapa.addMarker(marcador);
//
//        }
//    }'
//            '
//        eventoDAO.close();






    private LatLng pegaCoordenadaDoEndereco(String endereco){
        // esse try catch serve para verificar a conexao
        try {
            Geocoder geocoder = new Geocoder(getContext()); //transforma uma string em latitude e longitude
            List<Address> resultados = geocoder.getFromLocationName(endereco, 1); //https://developer.android.com/reference/android/location/Geocoder.html

            if (!resultados.isEmpty()){
                LatLng posicao = new LatLng(resultados.get(0).getLatitude(), resultados.get(0).getLongitude());
                return posicao;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null; //caso nao tenha nenhum retorno
    }

    public void centralizarEm(LatLng coordenada) {
        if(mapa != null){
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(coordenada, 17);
            mapa.moveCamera(update);
        }
    }
}

