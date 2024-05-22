package model;

public class Fotografia extends Obra {

    String materialPapel;

    public Fotografia(String titulo, String artista, int anoCriacao, String localizacao, String materialPapel) {
        super(titulo, artista, anoCriacao, localizacao);
        this.materialPapel = materialPapel;
    }

    public String getMaterialPapel() {
        return materialPapel;
    }

    public void setMaterialPapel(String materialPapel) {
        this.materialPapel = materialPapel;
    }

    @Override
    public String toString() {
        return "Fotografia, " + super.toString() + ", " + materialPapel;
    }

    public static Fotografia fromString(String linha) {
        
        String[] dados = linha.split(", ");

        return new Fotografia(dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5]);
    }

}
