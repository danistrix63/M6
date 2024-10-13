import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Per favor eligeix una d'aquestes opcions:");
        System.out.println("A: Generar un nou encàrrec");
        System.out.println("B: Mostrar un encàrrec");
        System.out.println("C: Sortir");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String entrada;
            boolean continuar = true;
            FileManager fileManager = new FileManager();

            while (continuar) {
                System.out.print("Opció(A,B,C): ");
                entrada = reader.readLine();

                switch (entrada.toUpperCase()) {
                    case "A":
                        System.out.println("Generant un nou encàrrec...");

                        // Recopilar dades del client
                        String clientName = "";
                        while (clientName.isEmpty()) {
                            System.out.print("Nom del client: ");
                            clientName = reader.readLine().trim();
                            if (clientName.isEmpty()) {
                                System.out.println("El nom del client no pot estar buit. Intenta-ho de nou.");
                            }
                        }

                        String clientPhone = "";
                        while (clientPhone.isEmpty()) {
                            System.out.print("Telèfon del client: ");
                            clientPhone = reader.readLine().trim();
                            if (clientPhone.isEmpty()) {
                                System.out.println("El telèfon del client no pot estar buit. Intenta-ho de nou.");
                            }
                        }

                        String orderDate = "";
                        while (true) {
                            System.out.print("Data de l'encàrrec (dd/mm/aaaa): ");
                            orderDate = reader.readLine().trim();
                            if (orderDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                                break;
                            } else {
                                System.out.println("Format de data no vàlid. Intenta-ho de nou (dd/mm/aaaa).");
                            }
                        }

                        // Crear un nou objecte Pedido
                        Pedido pedido = new Pedido(clientName, clientPhone, orderDate);

                        // Afegir articles al pedido
                        boolean addingArticles = true;
                        while (addingArticles) {
                            String articleName = "";
                            while (articleName.isEmpty()) {
                                System.out.print("Nom de l'article: ");
                                articleName = reader.readLine().trim();
                                if (articleName.isEmpty()) {
                                    System.out.println("El nom de l'article no pot estar buit. Intenta-ho de nou.");
                                }
                            }

                            float quantity = 0;
                            while (true) {
                                System.out.print("Quantitat: ");
                                String quantityInput = reader.readLine().trim();
                                try {
                                    quantity = Float.parseFloat(quantityInput);
                                    if (quantity <= 0) {
                                        System.out.println("La quantitat ha de ser un número positiu. Intenta-ho de nou.");
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada no vàlida. Intenta-ho de nou.");
                                }
                            }

                            String unitType = "";
                            while (true) {
                                System.out.print("Tipus d'unitat (kg, g, u, etc.): ");
                                unitType = reader.readLine().trim();
                                if (unitType.equals("kg") || unitType.equals("g") || unitType.equals("u")) {
                                    break;
                                } else {
                                    System.out.println("Tipus d'unitat no vàlid. Intenta-ho de nou (kg, g, u).");
                                }
                            }

                            // Afegir article al pedido
                            pedido.addArticle(articleName, quantity, unitType);

                            System.out.print("Voleu afegir més articles? (S/N): ");
                            String moreArticles = reader.readLine().trim();
                            if (moreArticles.equalsIgnoreCase("N")) {
                                addingArticles = false;
                            }
                        }

                        // Preguntar qué tipo de archivo generar
                        System.out.println("Selecciona el format del fitxer a generar:");
                        System.out.println("1: Albarà");
                        System.out.println("2: CSV");
                        System.out.println("3: Binari");

                        int fileType = 0;
                        while (true) {
                            try {
                                fileType = Integer.parseInt(reader.readLine().trim());
                                if (fileType >= 1 && fileType <= 3) {
                                    break;
                                } else {
                                    System.out.println("Opció no vàlida. Intenta-ho de nou (1-3).");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada no vàlida. Intenta-ho de nou (1-3).");
                            }
                        }

                        // Generar fitxers segons la selecció
                        switch (fileType) {
                            case 1:
                                fileManager.crearAlbaran(pedido);
                                break;
                            case 2:
                                fileManager.crearCSV(pedido);
                                break;
                            case 3:
                                fileManager.crearBinario(pedido);
                                break;
                            default:
                                System.out.println("Opció no vàlida.");
                        }
                        break;

                    case "B":
                        System.out.println("Introduïu la ruta del fitxer a mostrar:");
                        String filePath = reader.readLine().trim();
                        System.out.println("Selecciona el format del fitxer a mostrar:");
                        System.out.println("1: CSV");
                        System.out.println("2: Binari");

                        int showFileType = 0;
                        while (true) {
                            try {
                                showFileType = Integer.parseInt(reader.readLine().trim());
                                if (showFileType == 1 || showFileType == 2) {
                                    break;
                                } else {
                                    System.out.println("Opció no vàlida. Intenta-ho de nou (1-2).");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada no vàlida. Intenta-ho de nou (1-2).");
                            }
                        }

                        switch (showFileType) {
                            case 1:
                                fileManager.mostrarCSV(filePath);
                                break;
                            case 2:
                                fileManager.mostrarBinario(filePath);
                                break;
                            default:
                                System.out.println("Opció no vàlida.");
                        }
                        break;

                    case "C":
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opció no vàlida.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error en la entrada/sortida: " + e.getMessage());
        }
    }
}
