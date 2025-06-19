import figuras.CirculoDibujable;
import figuras.CuadradoDibujable;
import ui.InterfazUsuario;
import ui.VentanaDibujo;

public class Main {
    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario();
        Object[] datosFiguras = interfaz.obtenerDatosFiguras();

        CirculoDibujable circulo = (CirculoDibujable) datosFiguras[0];
        CuadradoDibujable cuadrado = (CuadradoDibujable) datosFiguras[1];

        System.out.println("\nEl área del círculo es: " + circulo.getArea());
        System.out.println("El perímetro del círculo es: " + circulo.getPerimetro());
        System.out.println("El área del cuadrado es: " + cuadrado.getArea());
        System.out.println("El perímetro del cuadrado es: " + cuadrado.getPerimetro());

        VentanaDibujo ventana = new VentanaDibujo(circulo, cuadrado);
        ventana.mostrar();
    }
}