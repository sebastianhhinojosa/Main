import java.util.ArrayList;

public class Club {
    public static final int MAXIMO_VIP = 3;
    private ArrayList<Socio> socios;

    public Club() {
        socios = new ArrayList<>();
    }

    public ArrayList<Socio> darSocios() {
        return socios;
    }

    public void afiliarSocio(String cedula, String nombre, Tipo tipo) {
        if (buscarSocio(cedula) != null) return;

        int vipCount = contarSociosVIP();
        if (tipo == Tipo.VIP && vipCount >= MAXIMO_VIP) return;

        Socio socio = new Socio(cedula, nombre, tipo);
        socios.add(socio);
    }

    public Socio buscarSocio(String cedula) {
        for (Socio socio : socios) {
            if (socio.darCedula().equals(cedula)) {
                return socio;
            }
        }
        return null;
    }

    public int contarSociosVIP() {
        int count = 0;
        for (Socio socio : socios) {
            if (socio.darTipo() == Tipo.VIP) count++;
        }
        return count;
    }

    public ArrayList<String> darAutorizadosSocio(String cedula) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            return socio.darAutorizados();
        }
        return new ArrayList<>();
    }

    public void agregarAutorizadoSocio(String cedula, String nombreAutorizado) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            socio.agregarAutorizado(nombreAutorizado);
        }
    }

    public void eliminarAutorizadoSocio(String cedula, String nombreAutorizado) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            socio.eliminarAutorizado(nombreAutorizado);
        }
    }

    public void registrarConsumo(String cedula, String nombre, String concepto, double valor) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            socio.registrarConsumo(nombre, concepto, valor);
        }
    }

    public ArrayList<Factura> darFacturasSocio(String cedula) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            return socio.darFacturas();
        }
        return new ArrayList<>();
    }

    public void pagarFacturaSocio(String cedula, int posicion) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            socio.pagarFactura(posicion);
        }
    }

    public void aumentarFondosSocio(String cedula, double valor) {
        Socio socio = buscarSocio(cedula);
        if (socio != null) {
            socio.aumentarFondos(valor);
        }
    }

    public double darValorTotalConsumos(String cedula) {
        Socio socio = buscarSocio(cedula);
        if (socio == null) {
            System.out.println("No existe un socio con la cédula: " + cedula);
            return 0;
        }

        double total = 0;
        for (Factura factura : socio.darFacturas()) {
            total += factura.darValor();
        }
        return total;
    }

    public String sePuedeEliminarSocio(String cedula) {
        Socio socio = buscarSocio(cedula);
        if (socio == null) {
            return "No existe un socio con la cédula: " + cedula;
        }
        if (socio.darTipo() == Tipo.VIP) {
            return "No se puede eliminar: el socio es de tipo VIP.";
        }
        if (socio.tieneFacturaAsociada()) {
            return "No se puede eliminar: el socio tiene facturas pendientes de pago.";
        }
        if (socio.darAutorizados().size() > 1) {
            return "No se puede eliminar: el socio tiene más de un autorizado.";
        }
        return "El socio puede ser eliminado.";
    }

    public String metodo1() {
        return "Método 1 aún no implementado";
    }

    public String metodo2() {
        return "Método 2 aún no implementado";
    }
}