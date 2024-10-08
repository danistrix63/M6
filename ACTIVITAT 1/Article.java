import java.util.ArrayList;

public class Article {
    private String nom;
    private int quantitat;
    private String tipusUnitat;

    // Constructor con todos los campos
    public Article(String nomArticle, int quantitat, String tipusUnitat) {
        this.nomArticle = nomArticle;
        this.quantitat = quantitat;
        this.tipusUnitat = tipusUnitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getQuantitat() {
        return quantitat;
    }


    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public String getTipusUnitat() {
        return tipusUnitat;
    }

    public void setTipusUnitat(String tipusUnitat) {
        this.tipusUnitat = tipusUnitat;
    }

    @Override
    public String toString() {
        return "Article [nom=" + nom + ", quantitat=" + quantitat + ", tipusUnitat=" + tipusUnitat + "]";
    }
    public String toCSV() {
        return nomArticle + ";" + quantitat + ";" + tipusUnitat + ";";
    }

}
