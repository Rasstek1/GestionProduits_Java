package com.rasstek.gestionproduits.mesModels;

public class Produit {

    public Produit(int numero, String description, double prix) {
        this.numero = numero;
        this.description = description;
        this.prix = prix;
    }
    private int numero;
    private String description;
    private double prix;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
