package model;

public class Product {
    private int idProduct;
    private String nameProduct,description;
    private double costUnit;
    private int stock;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String description, double costUnit, int stock) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.costUnit = costUnit;
        this.stock = stock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(double costUnit) {
        this.costUnit = costUnit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", description='" + description + '\'' +
                ", costUnit=" + costUnit +
                ", stock=" + stock +
                '}';
    }
}

