package ifpb.edu.br.spreejpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainAdminActivity extends AppCompatActivity {
    private Button btnCadastroCategoria, btnCadastroEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        this.btnCadastroCategoria = (Button) findViewById(R.id.btnCadastroCategoria);
        this.btnCadastroEvento = (Button) findViewById(R.id.btnCadastroEvento);

        this.btnCadastroCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAdminActivity.this, CadastroCategoriaActivity.class);
                startActivity(intent);
            }
        });

        this.btnCadastroEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAdminActivity.this, CadastroEventoActivity.class);
                startActivity(intent);
            }
        });
    }
}
