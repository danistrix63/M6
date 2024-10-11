import java.util.ArrayList;

public class Pedido {
    private String nom; // Nombre del cliente
    private String numero; // Teléfono del cliente
    private String data; // Fecha del pedido
    private ArrayList<Article> articles; // Lista de artículos

    // Constructor
    public Pedido(String clientName, String clientPhone, String orderDate) {
        this.nom = clientName; 
        this.numero = clientPhone;
        this.data = orderDate;
        this.articles = new ArrayList<>();
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    // Método para añadir un artículo
    public void addArticle(String name, float quantity, String unit) {
        Article newArticle = new Article(name, quantity, unit); // Crear un nuevo objeto Article
        articles.add(newArticle); // Añadir el artículo al ArrayList
    }
}
