package entities.order;

import entities.product.Product;

public class OrderItem  {

    private final Product product;
    private Integer quantityOrder;

    public OrderItem(Product product, Integer quantity) {
        this.product = product;
        this.quantityOrder = quantity;
    }

    public Double subTotal() {
        return product.getPrice() * quantityOrder;
    }

    public Product getProduct() {
        return product;
    }



    public Integer getQuantity() {
        return quantityOrder;
    }

    public void setQuantity(Integer quantity) {
        this.quantityOrder = quantity;
    }



   

    

}
