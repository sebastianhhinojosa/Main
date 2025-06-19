package figuras;

import java.awt.*;

public class CirculoDibujable extends figuras.Circulo implements figuraDibujable {
    private int x,y;
    public CirculoDibujable(double valor1, int x, int y){
        super(valor1);
        this.x = x;
        this.y = y;
    }

    @Override
    public void setCoordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar2D(Graphics g){
        g.drawOval(this.x, this.y, (int) this.valor1, (int) this.valor1);
    }

}
