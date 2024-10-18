package model;

public class OrderDetails {
    private int idDetails,idOrder,idProduct,quantity;
    private double priceUnit,totalPrice;

    public OrderDetails() {
    }

    public OrderDetails(int idDetails, int idOrder, int idProduct, int quantity, double priceUnit, double totalPrice) {
        this.idDetails = idDetails;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
        this.totalPrice = totalPrice;
    }

    public int getIdDetails() {
        return idDetails;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "idDetails=" + idDetails +
                ", idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", priceUnit=" + priceUnit +
                ", totalPrice=" + totalPrice +
                '}';
    }
}