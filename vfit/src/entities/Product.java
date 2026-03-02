package entities;

import entities.enums.Category;

public abstract class Product {

    private String name; 
    private Category category;
    
    
    
    public Product() {
    }


    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract void  Order();



}
