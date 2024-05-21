package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static Scanner in = new Scanner(System.in);

    public static int lerInt() {

        int valor;

        do {
            try {

                valor = in.nextInt();
                break;

            } catch (InputMismatchException e) {

                System.out.println("Valor inválido, digite apenas valores inteiros.");

            } finally {

                in.nextLine();

            }
        } while (true);

        return valor;
    }

    public static float lerFloat() {

        float valor;

        do {
            try {

                valor = in.nextFloat();
                break;

            } catch (InputMismatchException e) {

                System.out.println("Valor inválido, digite apenas valores com ponto flutuante.");

            } finally {

                in.nextLine();

            }
        } while (true);

        return valor;
    }

    public static String lerString() {

        String txt;

        do {
            try {

                txt = in.nextLine();
                break;

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }
        } while (true);

        return txt;
    }
}
