package entities.product;

import entities.enums.Category;

public class Product {

    private String name;
    private Double price;  
    private Category type;
    private Integer stockQuantity;
   
   
    public Product() {
    }

    public Product(String name, Double price, Category type, int stotkQuantity ) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.stockQuantity = stockQuantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(Category type) {
        this.type = type;
    }
    public void decreaseStock(int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantidade inválida.");
        }
        if (quantity > stockQuantity){
            new IllegalArgumentException("Quantidade inválida.");
        }
         this.stockQuantity -= quantity;
    }
}
