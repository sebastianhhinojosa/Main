package figuras;

public class Circulo extends Figura {
    public Circulo(double valor1) {
        super(valor1);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(getValor1(), 2);
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * getValor1();
    }
}
