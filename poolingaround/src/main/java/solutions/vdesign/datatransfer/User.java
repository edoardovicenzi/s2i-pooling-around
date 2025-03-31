package solutions.vdesign.datatransfer;

import java.util.Date;

import solutions.vdesign.util.CustomFormatter;

public class User extends BaseDTO {
    private String cognome;
    private Date dataNascita;
    private int id;
    private String idDocumento;
    private String indirizzo;
    private String nome;

    // Builder pattern setters

    public User setCognome(String newCognome) {
        this.cognome = newCognome;
        return this;
    }

    public User setDataNascita(Date newDataNascita) {
        this.dataNascita = newDataNascita;
        return this;
    }

    public User setId(int newId) {
        this.id = newId;
        return this;
    }

    public User setIdDocumento(String newIdDocumento) {
        this.idDocumento = newIdDocumento;
        return this;
    }

    public User setIndirizzo(String newIndirizzo) {
        this.indirizzo = newIndirizzo;
        return this;
    }

    public User setNome(String newNome) {
        this.nome = newNome;
        return this;
    }

    // Getters
    public String getCognome() {
        return this.cognome;
    }

    public Date getDataNascita() {
        return this.dataNascita;
    }

    public String getDataNascitaString() {
        return CustomFormatter.getDateString(this.getDataNascita());
    }

    public int getId() {
        return this.id;
    }

    public String getIdDocumento() {
        return this.idDocumento;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\n");

        sb.append("\t");
        sb.append("ID: " + this.id);
        sb.append("\n");

        sb.append("\t");
        sb.append("Nome: " + this.nome);
        sb.append("\n");

        sb.append("\t");
        sb.append("Cognome: " + this.cognome);
        sb.append("\n");

        sb.append("\t");
        sb.append("Data di Nascita: " + CustomFormatter.getDateString(this.dataNascita));
        sb.append("\n");

        sb.append("\t");
        sb.append("Indirizzo: " + this.indirizzo);
        sb.append("\n");

        sb.append("\t");
        sb.append("ID Documento: " + this.idDocumento);
        sb.append("\n");

        sb.append("}");
        return sb.toString();
    }
}
