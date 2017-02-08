package ifpb.edu.br.spreejpa;

import java.util.Calendar;

/**
 * Created by Windows 10 on 07/02/2017.
 */

public class Evento {

    private int id;
    private String categoria;
    private String nome;
    private String telefone;
    private String endereco;

    private Calendar data;


    public Evento(String nome,int dia, int mes, int ano){

        this.nome = nome;
        this.data = Calendar.getInstance();
        this.data.set(ano, mes, dia);
    }

    public Evento(String categoria,String nome,String telefone,String endereco,long data){
        this.categoria=categoria;
        this.nome=nome;
        this.endereco=endereco;
        this.data = Calendar.getInstance();
        this.data.setTimeInMillis(data);

        this.telefone=telefone;



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



    public String getData(){
        return String.format("%d/%d/%d", this.data.get(Calendar.DAY_OF_MONTH),
                this.data.get(Calendar.MONTH) + 1,
                this.data.get(Calendar.YEAR));
    }

    public long getDataLong(){
        return this.data.getTimeInMillis();
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
