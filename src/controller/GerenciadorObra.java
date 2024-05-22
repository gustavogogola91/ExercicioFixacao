package controller;

import java.io.*;
import java.util.ArrayList;

import model.Obra;

public class GerenciadorObra {

    private static ArrayList<Obra> lista = new ArrayList<Obra>();

    private static final File ARQUIVO = new File("src/dataBase/obras.txt");

    public static void adicionarObra(Obra obra) {

        lista.add(obra);

    }

    public static Obra buscarObra(String titulo) throws Exception {

        for (Obra obra : lista) {
            if (obra.getTitulo().equals(titulo)) {
                return obra;
            }
        }

        throw new Exception("Não há obras com este nome");
    }

    public static void excluirObra(String titulo) throws Exception {

        Obra obra = buscarObra(titulo);

        lista.remove(obra);
    }

    public static ArrayList<Obra> listarTodas() {

        return lista;
    }

    public static void alterarTitulo(String tituloAntigo, String novoTitulo) throws Exception {

        Obra obra = buscarObra(tituloAntigo);

        obra.setTitulo(novoTitulo);
    }

    public static void alterarArtista(String titulo, String novoArtista) throws Exception {

        Obra obra = buscarObra(titulo);

        obra.setArtista(novoArtista);
    }

    public static void alterarAnoCriacao(String titulo, int novoAno) throws Exception {

        Obra obra = buscarObra(titulo);

        obra.setAnoCriacao(novoAno);
    }

    public static void alterarLocalizacao(String titulo, String novaLocalizacao) throws Exception {

        Obra obra = buscarObra(titulo);

        obra.setLocalizacao(novaLocalizacao);
    }

    public static void salvarObras() throws IOException, Exception {

        if (lista.isEmpty()) {
            throw new Exception("Nenhuma obra cadastrada");
        }

        try (FileWriter fw = new FileWriter(ARQUIVO, true); BufferedWriter bw = new BufferedWriter(fw)) {

            for (Obra obra : lista) {
                bw.write(obra.toString());
            }
        }
    }

    public static void recuperarDados() throws IOException{

        try (FileReader fr = new FileReader(ARQUIVO); BufferedReader br = new BufferedReader(fr)) {
            
            String linha;

            while((linha = br.readLine()) != null) {

                Obra tempObra = Obra.fromString(linha);

                adicionarObra(tempObra);
            }

        } 
    }
}
