package model;

public class Escultura extends Obra {

    String material;

    public Escultura(String titulo, String artista, int anoCriacao, String localizacao, String material) {
        super(titulo, artista, anoCriacao, localizacao);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Escultura, " + super.toString() + ", " + material;
    }

    public static Escultura fromString(String linha) {
        
        String[] dados = linha.split(", ");

        return new Escultura(dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5]);
    }

}
