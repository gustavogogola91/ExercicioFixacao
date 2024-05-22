package model;

public class Obra {

    protected String titulo;
    protected String artista;
    protected int anoCriacao;
    protected String localizacao;

    public Obra(String titulo, String artista, int anoCriacao, String localizacao) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoCriacao = anoCriacao;
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoCriacao + ", " + localizacao;
    }

    
}