package ifpb.edu.br.spreejpa;

import java.util.Calendar;

/**
 * Created by Windows 10 on 07/02/2017.
 */

public class Evento {

    private int id;

    private String nome;
    private String telefone;
    private String endereco;
    private int categoriaid;

    private Calendar data;


//    public Evento(String nome,){
//
//        this.nome = nome;
//        this.data = Calendar.getInstance();
//
//    }

    public Evento(int categoriaid,String nome,String telefone,String endereco,int dia, int mes, int ano,long data){
        this.categoriaid=categoriaid;
        this.nome=nome;
        this.endereco=endereco;
        this.data = Calendar.getInstance();
        this.data.set(ano, mes, dia);
        this.data.setTimeInMillis(data);
        this.telefone=telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
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
