package be.bstorm.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    public Adresse(String rue, int numero, String boite, int cp, String localite) {
        this.rue = rue;
        this.numero = numero;
        this.boite = boite;
        this.cp = cp;
        this.localite = localite;
    }

    public Adresse(){};
    private String rue;
    private int numero;
    private String boite;
    private int cp;
    private String localite;

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }
}
