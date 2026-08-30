import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // El menú se repite hasta que el usuario elija la opción 5 (Salir)
        do {
            System.out.println("\n=========================================");
            System.out.println("          TALLER 3 - CODIGO 1");
            System.out.println("=========================================");
            System.out.println("1. Suma n-esimo termino de la serie de Fibonacci");
            System.out.println("2. Calcular el n-esimo numero primo");
            System.out.println("3. Calcular las raices de una ecuacion cuadratica");
            System.out.println("4. Calcular el promedio de n numeros");
            System.out.println("5. Salir");
            System.out.println("=========================================");

            try {
                System.out.print("Seleccione una opcion (1-5): ");
                opcion = sc.nextInt();

                if (opcion == 1) {
                    calcularFibonacci(sc);
                } else if (opcion == 2) {
                    calcularPrimo(sc);
                } else if (opcion == 3) {
                    calcularCuadratica(sc);
                } else if (opcion == 4) {
                    calcularPromedio(sc);
                } else if (opcion == 5) {
                    System.out.println("\nSaliendo del programa...");
                } else {
                    System.out.println("\nOpcion invalida. Seleccione un numero entre 1 y 5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nError: Debe ingresar un numero entero valido.");
                sc.nextLine(); // Limpiar el buffer del Scanner
            }

        } while (opcion != 5);

        sc.close();
    }

    // 1. Suma de los primeros n terminos de la serie de Fibonacci
    public static void calcularFibonacci(Scanner sc) {
        System.out.print("\nIngrese la cantidad de terminos (n): ");
        int n = sc.nextInt();

        int anterior = 0;
        int actual = 1;
        int suma = 0;

        for (int i = 0; i < n; i++) {
            suma = suma + anterior;
            int siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }

        System.out.println("La suma de los primeros " + n + " terminos de Fibonacci es: " + suma);
    }

    // 2. Calcular el n-esimo numero primo
    public static void calcularPrimo(Scanner sc) {
        System.out.print("\nIngrese la posicion del numero primo que desea (n): ");
        int n = sc.nextInt();

        int contador = 0;   // cuenta cuantos primos se han encontrado
        int numero = 1;      // numero que se va a revisar
        int primoEncontrado = 0;

        while (contador < n) {
            numero++;
            boolean esPrimo = true;

            // Se revisa si "numero" es divisible por algun valor entre 2 y numero-1
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    esPrimo = false;
                }
            }

            if (esPrimo) {
                contador++;
                primoEncontrado = numero;
            }
        }

        System.out.println("El numero primo en la posicion " + n + " es: " + primoEncontrado);
    }

    // 3. Raices de una ecuacion cuadratica (formula general)
    public static void calcularCuadratica(Scanner sc) {
        System.out.print("\nIngrese el valor de a: ");
        double a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = sc.nextDouble();
        System.out.print("Ingrese el valor de c: ");
        double c = sc.nextDouble();

        double discriminante = (b * b) - (4 * a * c);

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las raices son reales y distintas:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("Hay una unica raiz real: x = " + x);
        } else {
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * a);
            System.out.println("Las raices son complejas:");
            System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i");
            System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i");
        }
    }

    // 4. Promedio de n numeros ingresados por el usuario
    public static void calcularPromedio(Scanner sc) {
        System.out.print("\nCuantos numeros desea promediar (n)?: ");
        int n = sc.nextInt();

        double suma = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese el numero " + i + ": ");
            double valor = sc.nextDouble();
            suma = suma + valor;
        }

        double promedio = suma / n;
        System.out.println("El promedio es: " + promedio);
    }
}