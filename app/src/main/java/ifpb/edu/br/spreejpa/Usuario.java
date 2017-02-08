package ifpb.edu.br.spreejpa;

/**
 * Created by Windows 10 on 07/02/2017.
 */

public class Usuario {
    private int id;
    private boolean admin;
    private String nome;
    private String login;
    private String senha;

    public Usuario(){

    }

    public Usuario(String login,String senha,String nome){

        this.admin=false;
        this.login=login;
        this.senha=senha;


    }

    public int getId() {
        return id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
