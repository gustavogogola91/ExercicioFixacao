package view;

import java.util.ArrayList;

import controller.GerenciadorObra;
import controller.Input;
import model.*;

public class Sistema {

    public static void executar() {

        try {
            GerenciadorObra.recuperarDados();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("SISTEMA DE CONTROLE DE OBRAS");

        int op;

        do {
            exibirMenu();
            op = Input.lerInt();

            verificarOpcao(op);
        } while (op != 0);
    }

    private static void exibirMenu() {

        System.out.println("\n\nMENU\n");
        System.out.println("1) Cadastrar obra");
        System.out.println("2) Buscar obra");
        System.out.println("3) Listar todas as obras");
        System.out.println("4) Excluir obra");
        System.out.println("5) Alterar informações da obra");
        System.out.println("6) Salvar obras");
        System.out.println("0) Sair");
        System.out.print(">> ");
    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:
                cadastrarObra();
                break;
            case 2:
                buscarObra();
                break;
            case 3:
                listarObras();
                break;
            case 4:
                excluirObra();
                break;
            case 5:
                alterarObra();
                break;
            case 6:
                salvarObras();
                break;
            case 0:
                System.out.println("Finalizando programa...");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
    }

    private static void cadastrarObra() {
        System.out.println("CADASTRO DE OBRA");
        System.out.println("Selecione o tipo da obra:");
        System.out.println("1) Escultura");
        System.out.println("2) Fotografia");
        System.out.println("3) Pintura");
        System.out.print(">> ");
        int op = Input.lerInt();

        switch (op) {
            case 1:
                cadastrarEscultura();
                break;
            case 2:
                cadastrarFotografia();
                break;
            case 3:
                cadastrarPintura();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void cadastrarEscultura() {
        String titulo;
        String artista;
        int anoCriacao;
        String localizacao;
        String material;

        System.out.print("Digite o título: ");
        titulo = Input.lerString();
        System.out.print("Digite o artista: ");
        artista = Input.lerString();
        System.out.print("Digite o ano de criação: ");
        anoCriacao = Input.lerInt();
        System.out.print("Digite a localização: ");
        localizacao = Input.lerString();
        System.out.print("Digite o material: ");
        material = Input.lerString();

        Escultura tempEscultura = new Escultura(titulo, artista, anoCriacao, localizacao, material);

        GerenciadorObra.adicionarObra(tempEscultura);

    }

    private static void cadastrarFotografia() {
        String titulo;
        String artista;
        int anoCriacao;
        String localizacao;
        String material;

        System.out.print("Digite o título: ");
        titulo = Input.lerString();
        System.out.print("Digite o artista: ");
        artista = Input.lerString();
        System.out.print("Digite o ano de criação: ");
        anoCriacao = Input.lerInt();
        System.out.print("Digite a localização: ");
        localizacao = Input.lerString();
        System.out.print("Digite o material do papel: ");
        material = Input.lerString();

        Fotografia tempFotografia = new Fotografia(titulo, artista, anoCriacao, localizacao, material);

        GerenciadorObra.adicionarObra(tempFotografia);

    }

    private static void cadastrarPintura() {
        String titulo;
        String artista;
        int anoCriacao;
        String localizacao;
        String tipo;

        System.out.print("Digite o título: ");
        titulo = Input.lerString();
        System.out.print("Digite o artista: ");
        artista = Input.lerString();
        System.out.print("Digite o ano de criação: ");
        anoCriacao = Input.lerInt();
        System.out.print("Digite a localização: ");
        localizacao = Input.lerString();
        System.out.print("Digite o tipo da pintura: ");
        tipo = Input.lerString();

        Pintura tempPintura = new Pintura(titulo, artista, anoCriacao, localizacao, tipo);

        GerenciadorObra.adicionarObra(tempPintura);

    }

    private static void buscarObra() {

        try {
            GerenciadorObra.listaVazia();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return;
        }

        System.out.println("BUSCA");
        System.out.println("1) Buscar pelo título");
        System.out.println("2) Buscar pelo artista");
        System.out.println("3) Buscar pelo ano de criação");
        System.out.println("4) Buscar pelo tipo");
        System.out.print(">> ");
        int op = Input.lerInt();

        switch (op) {
            case 1:

                System.out.print("Digite o título: ");
                String titulo = Input.lerString();
                try {
                    Obra busca = GerenciadorObra.buscarObra(titulo);
                    System.out.println("\n" + busca + "\n");
                    return;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.print("Digite o artista: ");
                String artista = Input.lerString();

                try {
                    for (Obra tempObra : GerenciadorObra.buscarObraComFiltro(artista)) {
                        System.out.println(tempObra);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.print("Digite o artista: ");
                int ano = Input.lerInt();

                try {
                    for (Obra tempObra : GerenciadorObra.buscarObraComFiltro(ano)) {
                        System.out.println(tempObra);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("Selecione o tipo da obra:");
                System.out.println("1) Escultura");
                System.out.println("2) Fotografia");
                System.out.println("3) Pintura");
                System.out.print(">> ");
                int tipo = Input.lerInt();

                try {

                    ArrayList<Obra> obraList = new ArrayList<Obra>();

                    if (tipo == 1) {
                        obraList = GerenciadorObra.buscarEsculturas();
                        System.out.println("\nEsculturas cadastradas: ");
                    } else if (tipo == 2) {
                        obraList = GerenciadorObra.buscarFotografias();
                        System.out.println("\nFotografias cadastradas: ");
                    } else if (tipo == 3) {
                        obraList = GerenciadorObra.buscarPinturas();
                        System.out.println("\nPinturas cadastradas: ");
                    } else {
                        System.out.println("Opção inválida");
                        return;
                    }

                    for (Obra obra : obraList) {
                        System.out.println(obra);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void listarObras() {

        try {
            System.out.println("Obras cadastradas: ");
            for (Obra tempObra : GerenciadorObra.listarTodas()) {
                System.out.println(tempObra);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void excluirObra() {

        System.out.println("EXCLUSÃo DE OBRA");

        System.out.print("Digite o título: ");
        String titulo = Input.lerString();

        try {
            GerenciadorObra.excluirObra(titulo);
            System.out.println("Obra excluida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void alterarObra() {
        System.out.println("ALTERAÇÃO DE OBRA");

        System.out.print("Insira o titulo da obra: ");
        String titulo = Input.lerString();

        System.out.println("O que deseja alterar ?");
        System.out.println("1) Titulo");
        System.out.println("2) Artista");
        System.out.println("3) Ano de criação");
        System.out.println("4) Localização");
        System.out.print(">> ");
        int op = Input.lerInt();

        switch (op) {
            case 1:
                System.out.print("Digite o novo título: ");
                String novoTitulo = Input.lerString();

                try {
                    GerenciadorObra.alterarTitulo(titulo, novoTitulo);
                    System.out.println("Titulo alterado");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("Digite o novo artista: ");
                String novoArtista = Input.lerString();

                try {
                    GerenciadorObra.alterarArtista(titulo, novoArtista);
                    ;
                    System.out.println("Artista alterado");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.print("Digite o novo ano de criação: ");
                int novoAno = Input.lerInt();

                try {
                    GerenciadorObra.alterarAnoCriacao(titulo, novoAno);
                    ;
                    ;
                    System.out.println("Ano de criação alterado");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.print("Digite a nova localização: ");
                String novaLocalizacao = Input.lerString();

                try {
                    GerenciadorObra.alterarLocalizacao(titulo, novaLocalizacao);
                    System.out.println("Localização alterada");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void salvarObras() {

        try {
            GerenciadorObra.salvarObras();
            System.out.println("Obras salvas");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}