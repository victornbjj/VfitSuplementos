package entities.product;

import entities.enums.Category;

public class Product {

    private String name;
    private Double price;  
    private Category type;
    private Integer stockQuantity;
   
   
    public Product() {
    }

   public Product(String name, Double price, Category type, int stockQuantity ) {
    this.name = name;
    this.price = price;
    this.type = type;
    this.stockQuantity = stockQuantity; // agora correto
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
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(Category type) {
        this.stockQuantity = stockQuantity;
    }
    public void decreaseStock(int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantidade inválida.");
        }
        if (quantity > stockQuantity){
            throw new IllegalArgumentException("Quantidade inválida.");
        }
         this.stockQuantity -= quantity;
    }
}
