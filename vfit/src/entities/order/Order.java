package entities.order;

import java.util.ArrayList;
import java.util.List;
import entities.enums.OrderStatus;
import entities.product.Product;


public class Order {
    private List <OrderItem> items = new ArrayList<>();
    private OrderStatus status =   OrderStatus.OPEN;


    
    

     public List<OrderItem> getItems() {
        return items;
    }
     
    public OrderStatus getStatus() {
        return status;
    }
    
    public void addItem( Product product, int quantity) {
    

    if (status != OrderStatus.OPEN) {
        throw new IllegalStateException("Pedido não pode ser modificado.");
    }

    if (product == null || quantity <= 0) {
        throw new IllegalArgumentException("Produto ou quantidade inválida.");
    }

    for (OrderItem item : items) {

        if (item.getProduct().equals(product)) {

            int newQuantity = item.getQuantity() + quantity;

            if (newQuantity > product.getStockQuantity()) {
                throw new IllegalStateException("Estoque insuficiente para somar quantidades.");
            }

            item.setQuantity(newQuantity);
            return;
        }
    }


    items.add(new OrderItem(product, quantity));
    }
    
    public void removeItem(OrderItem item){
        if(status != status.OPEN){
            throw new IllegalStateException("Pedido não pode ser modificado.");
        }
        items.remove(item);
    }

    public Double totalValue() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    public void checkout() {

    if (status != OrderStatus.OPEN) {
        throw new IllegalStateException("Pedido já foi finalizado ou cancelado.");
    }

    if (items.isEmpty()) {
        throw new IllegalStateException("Não é possível finalizar pedido vazio.");
    }
    
    for (OrderItem item : items) {
        Product product = item.getProduct();
        product.decreaseStock(item.getQuantity());
    }
 


    this.status = OrderStatus.CLOSED;
    }

    public void cancel() {

    if (status == OrderStatus.CLOSED) {
        throw new IllegalStateException("Pedido já finalizado não pode ser cancelado.");
    }

    this.status = OrderStatus.CANCELLED;
      }






}
     
     




    






