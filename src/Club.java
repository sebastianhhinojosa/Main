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
        if (buscarSocioOpcional(cedula) != null) return;

        int vipCount = contarSociosVIP();
        if (tipo == Tipo.VIP && vipCount >= MAXIMO_VIP) return;

        Socio socio = new Socio(cedula, nombre, tipo);
        socios.add(socio);
    }

    public Socio buscarSocio(String cedula) throws SocioNoEncontradoException {
        for (Socio socio : socios) {
            if (socio.darCedula().equals(cedula)) {
                return socio;
            }
        }
        throw new SocioNoEncontradoException("No existe un socio con la cédula: " + cedula);
    }

    private Socio buscarSocioOpcional(String cedula) {
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

    public ArrayList<String> darAutorizadosSocio(String cedula) throws SocioNoEncontradoException {
        return buscarSocio(cedula).darAutorizados();
    }

    public void agregarAutorizadoSocio(String cedula, String nombreAutorizado)
            throws SocioNoEncontradoException {
        buscarSocio(cedula).agregarAutorizado(nombreAutorizado);
    }

    public void eliminarAutorizadoSocio(String cedula, String nombreAutorizado)
            throws SocioNoEncontradoException {
        buscarSocio(cedula).eliminarAutorizado(nombreAutorizado);
    }

    public void registrarConsumo(String cedula, String nombre, String concepto, double valor)
            throws SocioNoEncontradoException, AutorizadoNoValidoException, FondosInsuficientesException {
        buscarSocio(cedula).registrarConsumo(nombre, concepto, valor);
    }

    public ArrayList<Factura> darFacturasSocio(String cedula) throws SocioNoEncontradoException {
        return buscarSocio(cedula).darFacturas();
    }

    public void pagarFacturaSocio(String cedula, int posicion)
            throws SocioNoEncontradoException, FondosInsuficientesException {
        buscarSocio(cedula).pagarFactura(posicion);
    }

    public void aumentarFondosSocio(String cedula, double valor)
            throws SocioNoEncontradoException {
        buscarSocio(cedula).aumentarFondos(valor);
    }

    public double darValorTotalConsumos(String cedula) throws SocioNoEncontradoException {
        double total = 0;
        for (Factura factura : buscarSocio(cedula).darFacturas()) {
            total += factura.darValor();
        }
        return total;
    }

    public String sePuedeEliminarSocio(String cedula) {
        Socio socio = buscarSocioOpcional(cedula);
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
}
