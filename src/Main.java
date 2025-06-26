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

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Cédula: ");
                        String cedula = scanner.nextLine();
                        if (!cedula.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                            System.out.println("ERROR: El nombre debe contener solo letras.");
                            break;
                        }

                        System.out.print("Tipo (REGULAR/VIP): ");
                        String tipoStr = scanner.nextLine();
                        Tipo tipo = tipoStr.equalsIgnoreCase("VIP") ? Tipo.VIP : Tipo.REGULAR;
                        club.afiliarSocio(cedula, nombre, tipo);
                        System.out.println("Socio afiliado.");
                        break;

                    case 2:
                        System.out.print("Cédula del socio: ");
                        String cedulaAut = scanner.nextLine();
                        if (!cedulaAut.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        System.out.print("Nombre del autorizado: ");
                        String nombreAut = scanner.nextLine();
                        if (!nombreAut.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                            System.out.println("ERROR: El nombre debe contener solo letras.");
                            break;
                        }

                        club.agregarAutorizadoSocio(cedulaAut, nombreAut);
                        System.out.println("Autorizado agregado.");
                        break;

                    case 3:
                        System.out.print("Cédula del socio: ");
                        String cedulaCons = scanner.nextLine();
                        if (!cedulaCons.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        System.out.print("Nombre de quien consume: ");
                        String nombreCons = scanner.nextLine();
                        if (!nombreCons.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                            System.out.println("ERROR: El nombre debe contener solo letras.");
                            break;
                        }

                        System.out.print("Descripción: ");
                        String desc = scanner.nextLine();

                        System.out.print("Valor: ");
                        double valor = Double.parseDouble(scanner.nextLine());

                        club.registrarConsumo(cedulaCons, nombreCons, desc, valor);
                        System.out.println("Consumo registrado.");
                        break;

                    case 4:
                        System.out.print("Cédula del socio: ");
                        String cedulaFact = scanner.nextLine();
                        if (!cedulaFact.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        List<Factura> facturas = club.darFacturasSocio(cedulaFact);
                        if (facturas.isEmpty()) {
                            System.out.println("No se encontraron facturas.");
                        } else {
                            for (int i = 0; i < facturas.size(); i++) {
                                System.out.println(i + ": " + facturas.get(i));
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Cédula del socio: ");
                        String cedulaPago = scanner.nextLine();
                        if (!cedulaPago.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        System.out.print("Número de factura a pagar: ");
                        int numFactura = Integer.parseInt(scanner.nextLine());

                        club.pagarFacturaSocio(cedulaPago, numFactura);
                        System.out.println("Factura pagada.");
                        break;

                    case 6:
                        System.out.print("Cédula del socio: ");
                        String cedulaFondos = scanner.nextLine();
                        if (!cedulaFondos.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        System.out.print("Monto a aumentar: ");
                        double monto = Double.parseDouble(scanner.nextLine());
                        club.aumentarFondosSocio(cedulaFondos, monto);
                        System.out.println("Fondos aumentados.");
                        break;

                    case 7:
                        System.out.print("Cédula del socio: ");
                        String cedulaTotal = scanner.nextLine();
                        if (!cedulaTotal.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        double total = club.darValorTotalConsumos(cedulaTotal);
                        System.out.println("Total consumos: $" + total);
                        break;

                    case 8:
                        System.out.print("Cédula del socio: ");
                        String cedulaVerAut = scanner.nextLine();
                        if (!cedulaVerAut.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

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
                        if (!cedulaElimAut.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        System.out.print("Nombre del autorizado a eliminar: ");
                        String nombreElim = scanner.nextLine();
                        if (!nombreElim.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                            System.out.println("ERROR: El nombre debe contener solo letras.");
                            break;
                        }

                        club.eliminarAutorizadoSocio(cedulaElimAut, nombreElim);
                        System.out.println("Autorizado eliminado.");
                        break;

                    case 10:
                        System.out.print("Cédula del socio: ");
                        String cedulaElim = scanner.nextLine();
                        if (!cedulaElim.matches("\\d+")) {
                            System.out.println("ERROR: La cédula debe contener solo números.");
                            break;
                        }

                        String mensaje = club.sePuedeEliminarSocio(cedulaElim);
                        System.out.println(mensaje);
                        break;

                    case 11:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("ERROR: Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Entrada numérica inválida.");
            } catch (SocioNoEncontradoException | FondosInsuficientesException | AutorizadoNoValidoException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERROR inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
