import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Club club = new Club();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n==== MENÚ DEL CLUB ====");
            System.out.println("1. Afiliar socio");
            System.out.println("2. Agregar autorizado a un socio");
            System.out.println("3. Registrar consumo");
            System.out.println("4. Ver facturas de un socio");
            System.out.println("5. Pagar factura");
            System.out.println("6. Aumentar fondos de un socio");
            System.out.println("7. Ver total de consumos de un socio");
            System.out.println("8. Ver autorizados de un socio");
            System.out.println("9. Eliminar autorizado de un socio");
            System.out.println("10. Ver si se puede eliminar un socio");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo (REGULAR/VIP): ");
                    String tipoStr = scanner.nextLine();
                    Tipo tipo = tipoStr.equalsIgnoreCase("VIP") ? Tipo.VIP : Tipo.REGULAR;
                    club.afiliarSocio(cedula, nombre, tipo);
                    System.out.println("Socio afiliado.");
                    break;

                case 2:
                    System.out.print("Cédula del socio: ");
                    String cedulaAut = scanner.nextLine();
                    System.out.print("Nombre del autorizado: ");
                    String nombreAut = scanner.nextLine();
                    club.agregarAutorizadoSocio(cedulaAut, nombreAut);
                    System.out.println("Autorizado agregado.");
                    break;

                case 3:
                    System.out.print("Cédula del socio: ");
                    String cedulaCons = scanner.nextLine();
                    System.out.print("Nombre de quien consume: ");
                    String nombreCons = scanner.nextLine();
                    System.out.print("Descripción del consumo: ");
                    String desc = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    club.registrarConsumo(cedulaCons, nombreCons, desc, valor);
                    break;

                case 4:
                    System.out.print("Cédula del socio: ");
                    String cedulaFact = scanner.nextLine();
                    List<Factura> facturas = club.darFacturasSocio(cedulaFact);
                    if (facturas.isEmpty()) {
                        System.out.println("No hay facturas.");
                    } else {
                        for (int i = 0; i < facturas.size(); i++) {
                            System.out.println(i + ": " + facturas.get(i));
                        }
                    }
                    break;

                case 5:
                    System.out.print("Cédula del socio: ");
                    String cedulaPago = scanner.nextLine();
                    System.out.print("Número de factura a pagar (índice): ");
                    int numFactura = Integer.parseInt(scanner.nextLine());
                    club.pagarFacturaSocio(cedulaPago, numFactura);
                    System.out.println("Factura pagada.");
                    break;

                case 6:
                    System.out.print("Cédula del socio: ");
                    String cedulaFondos = scanner.nextLine();
                    System.out.print("Monto a aumentar: ");
                    double monto = Double.parseDouble(scanner.nextLine());
                    club.aumentarFondosSocio(cedulaFondos, monto);
                    System.out.println("Fondos aumentados.");
                    break;

                case 7:
                    System.out.print("Cédula del socio: ");
                    String cedulaTotal = scanner.nextLine();
                    double total = club.darValorTotalConsumos(cedulaTotal);
                    System.out.println("Total consumos: $" + total);
                    break;

                case 8:
                    System.out.print("Cédula del socio: ");
                    String cedulaVerAut = scanner.nextLine();
                    List<String> autorizados = club.darAutorizadosSocio(cedulaVerAut);
                    if (autorizados.isEmpty()) {
                        System.out.println("No hay autorizados.");
                    } else {
                        for (String aut : autorizados) {
                            System.out.println(" - " + aut);
                        }
                    }
                    break;

                case 9:
                    System.out.print("Cédula del socio: ");
                    String cedulaElimAut = scanner.nextLine();
                    System.out.print("Nombre del autorizado a eliminar: ");
                    String nombreElim = scanner.nextLine();
                    club.eliminarAutorizadoSocio(cedulaElimAut, nombreElim);
                    System.out.println("Autorizado eliminado.");
                    break;

                case 10:
                    System.out.print("Cédula del socio: ");
                    String cedulaElim = scanner.nextLine();
                    boolean puedeEliminar = Boolean.parseBoolean(club.sePuedeEliminarSocio(cedulaElim));
                    System.out.println("¿Se puede eliminar? → " + puedeEliminar);
                    break;

                case 11:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}
