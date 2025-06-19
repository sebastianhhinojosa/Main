import figuras.*;
import ui.*;

public class Main {
    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario();
        Object[] datosFiguras = interfaz.obtenerDatosFiguras();

        CirculoDibujable circulo = (CirculoDibujable) datosFiguras[0];
        RectanguloDibujable rectangulo = (RectanguloDibujable) datosFiguras[1];
        TrianguloDibujable triangulo = (TrianguloDibujable) datosFiguras[2];

        System.out.println("\nRESULTADOS:");
        System.out.printf("Círculo - Área: %.2f, Perímetro: %.2f%n", circulo.getArea(), circulo.getPerimetro());
        System.out.printf("Rectángulo - Área: %.2f, Perímetro: %.2f%n", rectangulo.getArea(), rectangulo.getPerimetro());
        System.out.printf("Triángulo - Área: %.2f, Perímetro: %.2f%n", triangulo.getArea(), triangulo.getPerimetro());

        VentanaDibujo ventana = new VentanaDibujo(circulo, rectangulo, triangulo);
        ventana.mostrar();
    }
}