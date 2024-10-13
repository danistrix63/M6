    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;

    public class FileManager {

        // Crear un archivo de texto con formato Albarà
        public void crearAlbaran(Pedido pedido) {
            String fileName = "C:\\Users\\accesadades\\" + "encarrecs_client_" + pedido.getNom() + "_" + System.currentTimeMillis() + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write("Albarà d'Encàrrec");
                writer.newLine();
                writer.write("=====================");
                writer.newLine();
                writer.write("Nom del client: " + pedido.getNom());
                writer.newLine();
                writer.write("Telèfon del client: " + pedido.getNumero());
                writer.newLine();
                writer.write("Data de l'encàrrec: " + pedido.getData());
                writer.newLine();
                writer.write("Quantitat\tUnitats\tArticle");
                writer.newLine();
                writer.write("=============== ========== ===============");
                writer.newLine();

                for (Article article : pedido.getArticles()) {
                    writer.write(article.getQuantitat() + "\t" + article.getTipusUnitat() + "\t" + article.getNom());
                    writer.newLine();
                }

                System.out.println("Fitxer albarà creat: " + fileName);
            } catch (IOException e) {
                System.err.println("Error al generar el fitxer albarà: " + e.getMessage());
            }
        }

        // Crear un archivo CSV
        public void crearCSV(Pedido pedido) {
            String fileName = "C:\\Users\\accesadades\\" + "encarrecs_client_" + pedido.getNom() + "_" + System.currentTimeMillis() + ".csv";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(pedido.getNom() + ";" + pedido.getNumero() + ";" + pedido.getData() + ";");
                writer.newLine();
                for (Article article : pedido.getArticles()) {
                    writer.write(article.toCSV());
                    writer.newLine();
                }
                System.out.println("Fitxer CSV creat: " + fileName);
            } catch (IOException e) {
                System.err.println("Error al generar el fitxer CSV: " + e.getMessage());
            }
        }

        // Crear un archivo binario
        public void crearBinario(Pedido pedido) {
            String fileName = "C:\\Users\\accesadades\\" + "encarrecs_client_" + pedido.getNom() + "_" + System.currentTimeMillis() + ".bin";

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
                dos.writeUTF(pedido.getNom());
                dos.writeUTF(pedido.getNumero());
                dos.writeUTF(pedido.getData());
                for (Article article : pedido.getArticles()) {
                    dos.writeUTF(article.getNom());
                    dos.writeFloat(article.getQuantitat());
                    dos.writeUTF(article.getTipusUnitat());
                }
                System.out.println("Fitxer binari creat: " + fileName);
            } catch (IOException e) {
                System.err.println("Error al generar el fitxer binari: " + e.getMessage());
            }
        }

        // Mostrar un encargo desde un archivo CSV
        public void mostrarCSV(String filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                String[] headers = reader.readLine().split(";");

                System.out.println("Nom del client: " + headers[0]);
                System.out.println("Telèfon del client: " + headers[1]);
                System.out.println("Data de l'encàrrec: " + headers[2]);
                System.out.println("Quantitat\tUnitats\tArticle");
                System.out.println("=============== ========== ===============");

                while ((line = reader.readLine()) != null) {
                    System.out.println(line.replace(";", "\t"));
                }
            } catch (IOException e) {
                System.err.println("Error al llegir el fitxer CSV: " + e.getMessage());
            }
        }

        // Mostrar un encargo desde un archivo binario
        public void mostrarBinario(String filePath) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
                String clientName = dis.readUTF();
                String clientPhone = dis.readUTF();
                String orderDate = dis.readUTF();

                System.out.println("Nom del client: " + clientName);
                System.out.println("Telèfon del client: " + clientPhone);
                System.out.println("Data de l'encàrrec: " + orderDate);
                System.out.println("Quantitat\tUnitats\tArticle");
                System.out.println("=============== ========== ===============");

                while (dis.available() > 0) {
                    String articleName = dis.readUTF();
                    float quantity = dis.readFloat();
                    String unitType = dis.readUTF();
                    System.out.println(quantity + "\t" + unitType + "\t" + articleName);
                }
            } catch (IOException e) {
                System.err.println("Error al llegir el fitxer binari: " + e.getMessage());
            }
        }
    }
