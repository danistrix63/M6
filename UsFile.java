import java.io.*;
public class UsFile{
    public static void main(String[] args) throws IOException {
        File f1 = new File("/home/dani/M6/carpeta/fitxer1.txt");
        f1.createNewFile();
        String forma2 = "/home/dani/M6/carpeta";
        File f2 = new File(forma2,"fitxer2.txt");
        f2.createNewFile();
        File dir1 = new File("/home/dani/M6/carpeta");
        File f3 = new File(dir1,"fitxer3.txt");
        f3.createNewFile();
        File subDir = new File("/home/dani/M6/carpeta/subcarpeta1");
        subDir.mkdir();
        File subDir2 = new File("/home/dani/M6/carpeta/subcarpeta2");
        subDir2.mkdir();
        File carpeta = new File("/home/dani/M6/carpeta");
        String [] mostraCarpetas = carpeta.list();
        // Asegurarse de que la lista no sea nula
        if (mostraCarpetas != null) {
            for (int i = 0; i < mostraCarpetas.length; i++) {
                File element = new File(carpeta, mostraCarpetas[i]);

                if (element.isFile()) {
                    System.out.println("Al directori: " + element.getAbsolutePath());
                    System.out.println("Hi ha l'arxiu amb nom: " + element.getName());
                } else if (element.isDirectory()) {
                    System.out.println("Al directori: " + element.getAbsolutePath());
                    System.out.println("Hi ha el directori amb nom: " + element.getName());
                }
            }
        }
    }
}