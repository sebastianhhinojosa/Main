public class Main {
    public static void main(String[] args) {
        Club club = new Club();

        club.afiliarSocio("123", "Juan Pérez", Tipo.REGULAR);
        club.afiliarSocio("456", "Ana Torres", Tipo.VIP);
        club.afiliarSocio("789", "Carlos Ruiz", Tipo.VIP);
        club.afiliarSocio("321", "María López", Tipo.VIP);
        club.afiliarSocio("999", "Extra VIP", Tipo.VIP); // No se afilia (máximo VIP = 3)

        club.agregarAutorizadoSocio("123", "Luis Amigo");
        club.agregarAutorizadoSocio("456", "Sofía Hermana");

        club.registrarConsumo("123", "Juan Pérez", "Comida", 20000);         // permitido
        club.registrarConsumo("123", "Luis Amigo", "Piscina", 10000);       // permitido
        club.registrarConsumo("456", "Sofía Hermana", "Spa", 50000);        // permitido
        club.registrarConsumo("456", "No Autorizado", "Bar", 20000);        // no se registra

        System.out.println("\n Facturas de Juan Pérez:");
        for (Factura f : club.darFacturasSocio("123")) {
            System.out.println(f);

            club.pagarFacturaSocio("123", 0);

            double total123 = club.darValorTotalConsumos("123");
            System.out.println("\n Total de consumos de Juan Pérez: $" + total123);

            club.aumentarFondosSocio("123", 200000);
            System.out.println("Fondos de Juan Pérez después de aumentar: $" + club.buscarSocio("123").darFondos());

            System.out.println("\n ¿Se puede eliminar '123'? → " + club.sePuedeEliminarSocio("123"));
            System.out.println(" ¿Se puede eliminar '456'? → " + club.sePuedeEliminarSocio("456"));
            System.out.println(" ¿Se puede eliminar '000'? → " + club.sePuedeEliminarSocio("000")); // No existe

            club.eliminarAutorizadoSocio("456", "Sofía Hermana");  // tiene factura

            club.eliminarAutorizadoSocio("123", "Luis Amigo");

            System.out.println("\n Autorizados de Juan Pérez:");
            for (String a : club.darAutorizadosSocio("123")) {
                System.out.println(" - " + a);
            }
        }
    }}