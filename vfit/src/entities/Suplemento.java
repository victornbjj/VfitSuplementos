package entities;

import entities.enums.Category;


public class Suplemento extends Product {
    private Double grams; 
    private String mark;
    private Integer quantity;
   
     
    public Suplemento(){
        super();
    }
   
    public Suplemento(String name, Category category, Double grams, String mark) {
        super(name, category);
        this.grams = grams;
        this.mark = mark;
    }

    public Double getGrams() {
        return grams;
    }

    public void setGrams(Double grams) {
        this.grams = grams;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public abstract void  Order(quantity){
        return quantity - this.quantity;

    }

}
