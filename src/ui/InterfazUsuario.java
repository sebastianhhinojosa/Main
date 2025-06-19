package ui;

import figuras.CirculoDibujable;
import figuras.CuadradoDibujable;
import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public Object[] obtenerDatosFiguras() {
        try {
            System.out.println("Ingrese los datos para el círculo:");
            double radioCirculo = obtenerDoubleValido("Radio del círculo: ");
            int xCirculo = obtenerIntValido("Coordenada X del centro: ");
            int yCirculo = obtenerIntValido("Coordenada Y del centro: ");

            System.out.println("\nIngrese los datos para el cuadrado:");
            double ladoCuadrado = obtenerDoubleValido("Lado del cuadrado: ");
            int xCuadrado = obtenerIntValido("Coordenada X de la esquina superior izquierda: ");
            int yCuadrado = obtenerIntValido("Coordenada Y de la esquina superior izquierda: ");

            return new Object[] {
                    new CirculoDibujable(radioCirculo, xCirculo, yCirculo),
                    new CuadradoDibujable(ladoCuadrado, xCuadrado, yCuadrado)
            };

        } finally {
            scanner.close();
        }
    }

    private double obtenerDoubleValido(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String input = scanner.nextLine();
                double valor = Double.parseDouble(input);
                if (valor <= 0) {
                    throw new IllegalArgumentException("El valor debe ser mayor que cero");
                }
                return valor;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debe ingresar un número válido. Intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }
    }

    private int obtenerIntValido(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Error: Debe ingresar un número entero válido. Intente nuevamente.");
            }
        }
    }
}