public double darValorTotalConsumos(String cedula) {
    Socio socio = buscarSocio(cedula);
    if (socio == null) {
        System.out.println("No existe un socio con la cédula: " + cedula);
        return 0;
    }
    ArrayList<Factura> facturas = socio.darFacturas();
    double total = 0;
    for (Factura factura : facturas) {
        total += factura.darValor();
    }
    return total;
}
