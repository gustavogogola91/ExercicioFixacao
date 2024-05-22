package model;

import controller.GerenciadorObra;

public class Pintura extends Obra {

    String tipo;

    public Pintura(String titulo, String artista, int anoCriacao, String localizacao, String tipo) {
        super(titulo, artista, anoCriacao, localizacao);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pintura, " + super.toString() + ", " + tipo;
    }

    public static Pintura fromString(String linha) {
        
        String[] dados = linha.split(", ");

        return new Pintura(dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5]);
    }

}
