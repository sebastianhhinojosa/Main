package ui;

import figuras.*;
import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public Object[] obtenerDatosFiguras() {
        try {
            System.out.println("Ingrese los datos para el círculo:");
            double radio = obtenerDoubleValido("Radio del círculo: ");
            int xCirculo = obtenerIntValido("Coordenada X del centro: ");
            int yCirculo = obtenerIntValido("Coordenada Y del centro: ");

            System.out.println("\nIngrese los datos para el rectángulo:");
            double baseRect = obtenerDoubleValido("Base del rectángulo: ");
            double alturaRect = obtenerDoubleValido("Altura del rectángulo: ");
            int xRect = obtenerIntValido("Coordenada X de la esquina superior izquierda: ");
            int yRect = obtenerIntValido("Coordenada Y de la esquina superior izquierda: ");

            System.out.println("\nIngrese los datos para el triángulo:");
            double baseTriang = obtenerDoubleValido("Base del triángulo: ");
            double alturaTriang = obtenerDoubleValido("Altura del triángulo: ");
            int xTriang = obtenerIntValido("Coordenada X del vértice superior: ");
            int yTriang = obtenerIntValido("Coordenada Y del vértice superior: ");

            return new Object[] {
                    new CirculoDibujable(radio, xCirculo, yCirculo),
                    new RectanguloDibujable(baseRect, alturaRect, xRect, yRect),
                    new TrianguloDibujable(baseTriang, alturaTriang, xTriang, yTriang)
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