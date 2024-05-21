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
            if(obra.getTitulo().equals(titulo)) {
                return obra;
            }
        }

        throw new Exception("Não há obras com este nome");
    }
}
