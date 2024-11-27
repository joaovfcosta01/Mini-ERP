package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número inteiro válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
    }
    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Valor inválido. Por favor, insira um número inteiro.");
            scanner.next(); // Limpa o buffer do scanner
        }
        return scanner.nextInt();
    }
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido. Por favor, insira um número válido.");
            scanner.next(); // Limpa o buffer do scanner
        }
        return scanner.nextDouble();
    }
    public static double getDoubleInput() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número decimal válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
    }

    public static String getStringInput() {
        scanner.nextLine(); // Consome o newline pendente
        return scanner.nextLine();
    }

    public static int getPositiveIntInput() {
        int value;
        do {
            value = getIntInput();
            if (value < 0) {
                System.out.println("Erro: Por favor, insira um número positivo.");
            }
        } while (value < 0);
        return value;
    }

    public static double getPositiveDoubleInput() {
        double value;
        do {
            value = getDoubleInput();
            if (value < 0) {
                System.out.println("Erro: Por favor, insira um número positivo.");
            }
        } while (value < 0);
        return value;
    }
}