package model;

public class Obra {

    protected String titulo;
    protected String artista;
    protected int anoCriacao;
    protected String tipo; // TODO: alterar para herança
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoCriacao + ", " + tipo + ", " + localizacao;
    }

    public static Obra fromString(String linha) {

        String[] dados = linha.split(", ");

        return new Obra(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3]);
    }

}