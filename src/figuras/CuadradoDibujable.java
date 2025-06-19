package figuras;

import java.awt.*;

public class CuadradoDibujable extends figuras.Figura implements figuraDibujable {
    private int x, y;

    public CuadradoDibujable(double lado, int x, int y) {
        super(lado);
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return valor1 * valor1;
    }

    @Override
    public double getPerimetro() {
        return 4 * valor1;
    }

    @Override
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar2D(Graphics g) {
        g.drawRect(x, y, (int) valor1, (int) valor1);
    }
}