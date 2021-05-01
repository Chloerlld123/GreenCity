package com.example.greencity;

public class VilleDatas {

    private int idProduit ;
    private String produit ;
    private String modalite ;


    // dans le constructeur on fait appel aux setters
    public VilleDatas(int idProduit, String produit, String modalite) {
        this.setIdProduit(idProduit);
        this.setProduit(produit);
        this.setModalite(modalite);
    }

    public int getIdProduit() { return idProduit; }

    public void setIdProduit(int idProduit) { this.idProduit = idProduit; }

    public String getProduit() { return produit; }

    public void setProduit(String produit) { this.produit = produit; }

    public String getModalite() { return modalite; }

    public void setModalite(String modalite) { this.modalite = modalite; }

    @Override
    public String toString() {
        return "VilleDatas{" +
                "idProduit=" + idProduit +
                ", produit='" + produit + '\'' +
                ", modalite='" + modalite + '\'' +
                '}';
    }

    public String toStringProduit(){
        return  "produit = '" + produit + '\'' + "  : " +
                modalite + '\'' ;
    }


    public boolean equals (String s ){
        if (produit.equals(s)){
            return true ;
        }
        return false ;
    }
}
