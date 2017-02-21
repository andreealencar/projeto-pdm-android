package ifpb.edu.br.spreejpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.support.test.InstrumentationRegistry.getContext;

public class CadastroEventoActivity extends AppCompatActivity {
    EditText eventoNome, eventoTelefone, eventoEndereco,eventoCategoria;
    DatePicker eventoData;
    Button btnEnviar;
    EventoDAO eventoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        this.eventoDAO = new EventoDAO(this);

        this.eventoNome = (EditText) findViewById(R.id.nomeEvento);
        this.eventoTelefone = (EditText) findViewById(R.id.telefoneEvento);
        this.eventoEndereco = (EditText) findViewById(R.id.enderecoEvento);
        this.eventoData = (DatePicker) findViewById(R.id.dataEvento);
        this.eventoCategoria=(EditText)findViewById(R.id.categoriaEvento);

        this.btnEnviar = (Button) findViewById(R.id.salvarEvento);
        this.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = CadastroEventoActivity.this.eventoNome.getText().toString();
                String telefone = CadastroEventoActivity.this.eventoTelefone.getText().toString();
                String endereco = CadastroEventoActivity.this.eventoEndereco.getText().toString();
                String categoria = CadastroEventoActivity.this.eventoCategoria.getText().toString();
                int dia = CadastroEventoActivity.this.eventoData.getDayOfMonth();
                int mes = CadastroEventoActivity.this.eventoData.getMonth();
                int ano = CadastroEventoActivity.this.eventoData.getYear();



                GregorianCalendar calendar = new GregorianCalendar(ano, mes, dia);
                calendar.getTimeInMillis();

                Evento evento = new Evento(nome, telefone, endereco, calendar.getTimeInMillis());

                if(CadastroEventoActivity.this.eventoDAO.jaExiste(evento)){
                    Toast.makeText(getApplicationContext(), "Evento já existe! ", Toast.LENGTH_SHORT).show();
                    Log.i("IFPB", "Não pode cadastra essa categoria!");
                    Intent intent = new Intent(CadastroEventoActivity.this, MainAdminActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Evento cadastrado! ", Toast.LENGTH_SHORT).show();
                    Log.i("IFPB", "Pode cadastra esse evento!");
                    CadastroEventoActivity.this.eventoDAO.insert(evento);
                    Intent intent = new Intent(CadastroEventoActivity.this, MainAdminActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
