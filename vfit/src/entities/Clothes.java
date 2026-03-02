package entities;

import entities.enums.Category;
import javafx.scene.paint.Color;

public class Clothes extends Product{
    private Character size;
    private Color color;


    public Clothes() {
        super();
    }
    
    
    public Clothes(String name, Category category, Character size, Color color) {
            super(name, category);
            this.size = size;
            this.color = color;
        }


    public Character getSize() {
        return size;
    }
    public void setSize(Character size) {
        this.size = size;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

}
