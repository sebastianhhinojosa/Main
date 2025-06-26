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
