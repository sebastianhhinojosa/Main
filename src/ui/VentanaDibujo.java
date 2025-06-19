package ui;

import figuras.*;
import javax.swing.*;
import java.awt.*;

public class VentanaDibujo {
    private JFrame frame;

    public VentanaDibujo(CirculoDibujable circulo, RectanguloDibujable rectangulo, TrianguloDibujable triangulo) {
        inicializarVentana(circulo, rectangulo, triangulo);
    }

    private void inicializarVentana(CirculoDibujable circulo, RectanguloDibujable rectangulo, TrianguloDibujable triangulo) {
        frame = new JFrame("Dibujar Figuras Geométricas");
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                circulo.dibujar2D(g);
                rectangulo.dibujar2D(g);
                triangulo.dibujar2D(g);
            }
        };

        panel.setPreferredSize(new Dimension(800, 600));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}