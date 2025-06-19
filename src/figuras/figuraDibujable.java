package figuras;

import java.awt.*;

public interface figuraDibujable {
    void dibujar2D(Graphics g);
    void setCoordenadas(int x, int y);
    double getArea();
    double getPerimetro();
}