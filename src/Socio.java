import java.util.ArrayList;

public class Socio {
    public static final double FONDOS_INICIALES_REGULARES = 50_000;
    public static final double FONDOS_INICIALES_VIP = 100_000;
    public static final double MONTO_MAXIMO_REGULARES = 1_000_000;
    public static final double MONTO_MAXIMO_VIP = 5_000_000;

    private String cedula;
    private String nombre;
    private double fondos;
    private Tipo tipoSubscripcion;
    private ArrayList<Factura> facturas;
    private ArrayList<String> autorizados;

    public Socio(String cedula, String nombre, Tipo tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipoSubscripcion = tipo;
        this.facturas = new ArrayList<>();
        this.autorizados = new ArrayList<>();

        this.fondos = tipo == Tipo.REGULAR ? FONDOS_INICIALES_REGULARES : FONDOS_INICIALES_VIP;
    }

    public String darNombre() {
        return nombre;
    }

    public String darCedula() {
        return cedula;
    }

    public double darFondos() {
        return fondos;
    }

    public Tipo darTipo() {
        return tipoSubscripcion;
    }

    public ArrayList<Factura> darFacturas() {
        return facturas;
    }

    public ArrayList<String> darAutorizados() {
        return autorizados;
    }

    public boolean existeAutorizado(String nombre) {
        return autorizados.contains(nombre);
    }

    public boolean tieneFacturaAsociada() {
        for (Factura f : facturas) {
            if (f.darNombre().equals(nombre) || autorizados.contains(f.darNombre())) {
                return true;
            }
        }
        return false;
    }

    public void aumentarFondos(double monto) {
        double maximo = tipoSubscripcion == Tipo.REGULAR ? MONTO_MAXIMO_REGULARES : MONTO_MAXIMO_VIP;
        if (fondos + monto <= maximo) {
            fondos += monto;
        }
    }

    public void registrarConsumo(String nombreConsumidor, String concepto, double valor)
            throws AutorizadoNoValidoException, FondosInsuficientesException {
        if (!(this.nombre.equals(nombreConsumidor) || existeAutorizado(nombreConsumidor))) {
            throw new AutorizadoNoValidoException("El consumidor no está autorizado.");
        }
        if (fondos < valor) {
            throw new FondosInsuficientesException("Fondos insuficientes para realizar el consumo.");
        }
        facturas.add(new Factura(concepto, nombreConsumidor, valor));
    }

    public void agregarAutorizado(String nombreAutorizado) {
        if (!existeAutorizado(nombreAutorizado) && fondos > 0) {
            autorizados.add(nombreAutorizado);
        }
    }

    public void eliminarAutorizado(String nombreAutorizado) {
        boolean tieneFactura = false;
        for (Factura f : facturas) {
            if (f.darNombre().equals(nombreAutorizado)) {
                tieneFactura = true;
                break;
            }
        }
        if (!tieneFactura) {
            autorizados.remove(nombreAutorizado);
        }
    }

    public void pagarFactura(int posicion) throws FondosInsuficientesException {
        if (posicion >= 0 && posicion < facturas.size()) {
            Factura f = facturas.get(posicion);
            if (fondos < f.darValor()) {
                throw new FondosInsuficientesException("Fondos insuficientes para pagar la factura.");
            }
            fondos -= f.darValor();
            facturas.remove(posicion);
        }
    }

    public boolean puedeConsumir(String nombre) {
        return this.nombre.equals(nombre) || existeAutorizado(nombre);
    }

    public String toString() {
        return "Socio: " + nombre + " (" + cedula + "), tipo: " + tipoSubscripcion + ", fondos: $" + fondos;
    }
}

