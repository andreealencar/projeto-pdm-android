package ifpb.edu.br.spreejpa;

import android.content.Intent;
import android.support.test.espresso.core.deps.guava.hash.Hashing;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;

public class LoginActivity extends AppCompatActivity {
    private EditText login, senha;
    private Button btnRegister, btnLogin;
    private UsuarioDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.userDAO = new UsuarioDAO(this);

        this.login = (EditText) findViewById(R.id.emailUser);
        this.senha = (EditText) findViewById(R.id.senhaUser);

        this.btnLogin = (Button) findViewById(R.id.login);
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String loginField = LoginActivity.this.login.toString();
                    String senhaField = Hashing.sha256()
                            .hashString(LoginActivity.this.senha.toString(), StandardCharsets.UTF_8)
                            .toString();
                    if (userDAO.validaLogin(loginField, senhaField)){
                        Log.i("IFPB", loginField.toString());
                        Log.i("IFPB", senhaField.toString());
                        Log.i("IFPB", "DEU CERTO!");
                    }else {
                        Log.i("IFPB", loginField.toString());
                        Log.i("IFPB", senhaField.toString());
                        Log.i("IFPB", "DEU CERTO!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        this.btnRegister = (Button) findViewById(R.id.signup);
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }
}