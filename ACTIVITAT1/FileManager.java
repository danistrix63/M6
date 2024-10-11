import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager {
    // Generar un archivo en formato Albarà
    public void crearAlbaran(Pedido pedido) {
        String fileName = "" + pedido.getNom() + "_" + System.currentTimeMillis() + ".txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
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
}
