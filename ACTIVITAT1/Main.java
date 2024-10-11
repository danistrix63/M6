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

            while (continuar) {
                System.out.print("Opció: ");
                entrada = reader.readLine();

                switch (entrada.toUpperCase()) {
                    case "A":
                        System.out.println("Generant un nou encàrrec...");

                        // Recopilar dades del client
                        System.out.print("Nom del client: ");
                        String clientName = reader.readLine();

                        System.out.print("Telèfon del client: ");
                        String clientPhone = reader.readLine();

                        System.out.print("Data de l'encàrrec (dd/mm/aaaa): ");
                        String orderDate = reader.readLine();

                        // Crear un nou objecte Pedido
                        Pedido pedido = new Pedido(clientName, clientPhone, orderDate);

                        // Afegir articles al pedido
                        boolean addingArticles = true;
                        while (addingArticles) {
                            System.out.print("Nom de l'article: ");
                            String articleName = reader.readLine();

                            System.out.print("Quantitat: ");
                            float quantity = Float.parseFloat(reader.readLine());

                            System.out.print("Tipus d'unitat (kg, g, u, etc.): ");
                            String unitType = reader.readLine();

                            // Afegir article al pedido
                            pedido.addArticle(articleName, quantity, unitType);

                            System.out.print("Vols afegir un altre article? (sí/no): ");
                            String addMore = reader.readLine();
                            if (!addMore.equalsIgnoreCase("sí")) {
                                addingArticles = false;
                            }
                        }
                        break;

                    case "B":
                        System.out.println("Mostrant un encàrrec...");
                        
                        break;

                    case "C":
                        System.out.println("Sortint del programa...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opció no vàlida. Si us plau, tria A, B o C.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
