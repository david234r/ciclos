//*Programa echo por Juan Pablo Morales y Dabid Robinson Hernandez*//

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println(".-=~=-.                                                                 .-=~=-.");
            System.out.println("(__  _)-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-(__  _)");
            System.out.println("( _ __)                                                                 ( _ __)");
            System.out.println("(__  _)            1. Suma n-esimo termino de la serie de Fibonacci     (__  _)");
            System.out.println("(_ ___)            2. Calcular el n-esimo numero primo                  (_ ___)");
            System.out.println("(__  _)            3. Calcular las raices de una ecuacion cuadratica    (__  _)");
            System.out.println("( _ __)            4. Calcular el promedio de n numeros                 ( _ __)");
            System.out.println("(__  _)            5. Salir                                             (__  _)");
            System.out.println("(_ ___)                                                                 (_ ___)");
            System.out.println("(__  _)-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-(__  _)");
            System.out.println("`-._.-'                                                                 `-._.-'");

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
                sc.nextLine();
            }

        } while (opcion != 5);

        sc.close();
    }

    public static void calcularFibonacci(Scanner sc) {
        int n = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("\nIngrese la cantidad de terminos (n): ");
                n = sc.nextInt();

                if (n < 0) {
                    System.out.println("Error: n no puede ser negativo.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero valido.");
                sc.nextLine();
            }
        }

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
        int n = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("\nIngrese la posicion del numero primo que desea (n): ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Error: n debe ser mayor que 0.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero valido.");
                sc.nextLine();
            }
        }

        int contador = 0;
        int numero = 1;
        int primoEncontrado = 0;

        while (contador < n) {
            numero++;
            boolean esPrimo = true;

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

    public static void calcularCuadratica(Scanner sc) {
        double a = 0;
        boolean aValido = false;

        while (!aValido) {
            try {
                System.out.print("\nIngrese el valor de a: ");
                a = sc.nextDouble();

                if (a == 0) {
                    System.out.println("Error: a no puede ser 0 (no seria una ecuacion cuadratica).");
                } else {
                    aValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                sc.nextLine();
            }
        }

        double b = 0;
        boolean bValido = false;

        while (!bValido) {
            try {
                System.out.print("Ingrese el valor de b: ");
                b = sc.nextDouble();
                bValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                sc.nextLine();
            }
        }

        double c = 0;
        boolean cValido = false;

        while (!cValido) {
            try {
                System.out.print("Ingrese el valor de c: ");
                c = sc.nextDouble();
                cValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                sc.nextLine();
            }
        }

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

    public static void calcularPromedio(Scanner sc) {
        int n = 0;
        boolean nValido = false;

        while (!nValido) {
            try {
                System.out.print("\nCuantos numeros desea promediar (n)?: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Error: n debe ser mayor que 0.");
                } else {
                    nValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero valido.");
                sc.nextLine();
            }
        }

        double suma = 0;

        for (int i = 1; i <= n; i++) {
            boolean valorValido = false;

            while (!valorValido) {
                try {
                    System.out.print("Ingrese el numero " + i + ": ");
                    double valor = sc.nextDouble();
                    suma = suma + valor;
                    valorValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un numero valido.");
                    sc.nextLine();
                }
            }
        }

        double promedio = suma / n;
        System.out.println("El promedio es: " + promedio);
    }
}