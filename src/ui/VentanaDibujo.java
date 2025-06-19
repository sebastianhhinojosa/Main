package ui;

import figuras.CirculoDibujable;
import figuras.CuadradoDibujable;
import javax.swing.*;
import java.awt.*;

public class VentanaDibujo {
    private JFrame frame;
    private CirculoDibujable circulo;
    private CuadradoDibujable cuadrado;

    public VentanaDibujo(CirculoDibujable circulo, CuadradoDibujable cuadrado) {
        this.circulo = circulo;
        this.cuadrado = cuadrado;
        inicializarVentana();
    }

    private void inicializarVentana() {
        frame = new JFrame("Dibujar Figuras");
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                circulo.dibujar2D(g);
                cuadrado.dibujar2D(g);
            }
        };

        panel.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}