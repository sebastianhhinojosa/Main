package figuras;

import java.awt.*;

public class CirculoDibujable extends Circulo implements figuraDibujable {
    private int x, y;

    public CirculoDibujable(double valor1, int x, int y) {
        super(valor1);
        this.x = x;
        this.y = y;
    }

    @Override
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar2D(Graphics g) {
        g.drawOval(x, y, (int) getValor1(), (int) getValor1());
    }
}