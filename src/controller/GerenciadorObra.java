package controller;

import java.util.ArrayList;

import model.Obra;

public class GerenciadorObra {

    private static ArrayList<Obra> lista = new ArrayList<Obra>();

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
}
