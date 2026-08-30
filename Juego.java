import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int min = 0;
        int max = 0;
        boolean rangoValido = false;

        while (!rangoValido) {
            try {
                System.out.print("Ingrese el límite inferior (n): ");
                min = sc.nextInt();
                System.out.print("Ingrese el límite superior (m): ");
                max = sc.nextInt();

                if (min >= max) {
                    System.out.println("Error: El límite superior (m) debe ser mayor que el inferior (n).");
                } else {
                    rangoValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar números enteros válidos.");
                sc.nextLine(); 
            }
        }

        int numeroSecreto = rand.nextInt(max - min + 1) + min;
        int intento;
        boolean gano = false;

        System.out.println("\n--- ¡Adivina el número entre " + min + " y " + max + "! ---");

        while (!gano) {
            try {
                System.out.print("Tu número: ");
                intento = sc.nextInt();

                if (intento == numeroSecreto) {
                    System.out.println("¡Ganaste! El número era " + numeroSecreto);
                    gano = true;
                } else if (intento < numeroSecreto) {
                    System.out.println("Muy bajo, intenta de nuevo.");
                } else {
                    System.out.println("Muy alto, intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Ingresa solo números.");
                sc.nextLine(); // Limpiar búfer
            }
        }

        int numeroTabla = 0;
        boolean numeroValido = false;

        System.out.println("\n--- Tabla de multiplicar ---");

        while (!numeroValido) {
            try {
                System.out.print("Ingrese un número para ver su tabla de multiplicar: ");
                numeroTabla = sc.nextInt();
                numeroValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                sc.nextLine(); 
            }
        }

        System.out.println("\n--- Tabla del " + numeroTabla + " ---");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numeroTabla + " x " + i + " = " + (numeroTabla * i));
        }

        sc.close();
    }
} 