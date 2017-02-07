package ifpb.edu.br.spreejpa;

/**
 * Created by Windows 10 on 07/02/2017.
 */

public class Evento {

    private int id;
    private String categoria;
    private String nome;
    private String telefone;
    private String endereco;
    private String horario;
    private String data;


    public Evento(){

    }

    public Evento(String categoria,String nome,String telefone,String endereco,String horario,String data){
        this.categoria=categoria;
        this.nome=nome;
        this.endereco=endereco;
        this.data=data;

        this.telefone=telefone;
        this.horario=horario;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
