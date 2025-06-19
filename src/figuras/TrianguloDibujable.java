package figuras;

import java.awt.*;

public class TrianguloDibujable extends Figura implements figuraDibujable {
    private int x, y;
    private double altura;

    public TrianguloDibujable(double base, double altura, int x, int y) {
        super(base);
        this.altura = altura;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return (getValor1() * altura) / 2;
    }

    @Override
    public double getPerimetro() {
        double hipotenusa = Math.sqrt(Math.pow(getValor1(), 2) + Math.pow(altura, 2));
        return getValor1() + altura + hipotenusa;
    }

    @Override
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar2D(Graphics g) {
        int[] xPoints = {x, x + (int)getValor1(), x};
        int[] yPoints = {y, y, y + (int)altura};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}