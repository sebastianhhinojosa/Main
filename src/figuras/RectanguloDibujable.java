package figuras;

import java.awt.*;

public class RectanguloDibujable extends Figura implements figuraDibujable {
    private int x, y;
    private double altura;

    public RectanguloDibujable(double base, double altura, int x, int y) {
        super(base);
        this.altura = altura;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return getValor1() * altura;
    }

    @Override
    public double getPerimetro() {
        return 2 * (getValor1() + altura);
    }

    @Override
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar2D(Graphics g) {
        g.drawRect(x, y, (int) getValor1(), (int) altura);
    }
}