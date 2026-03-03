package application;

import entities.enums.Category;
import entities.order.Order;
import entities.order.OrderItem;
import entities.product.Product;

public class App {

    public static void main(String[] args) {
        
        System.out.println("========== TESTE DAS ENTIDADES ==========\n");

        // 1. Criar produtos de teste
        System.out.println("--- Criando Produtos ---");
        Product whey = new Product("Whey Protein Gold", 150.00, Category.WHEY, 50);
        Product creatina = new Product("Creatina Monohidratada", 80.00, Category.CREATINA, 30);
        Product preTreino = new Product("Pré-Treino C4", 120.00, Category.PRE_TREINO, 20);
        
        System.out.println("✓ Whey Protein: " + whey.getName() + " - R$ " + whey.getPrice());
        System.out.println("✓ Creatina: " + creatina.getName() + " - R$ " + creatina.getPrice());
        System.out.println("✓ Pré-Treino: " + preTreino.getName() + " - R$ " + preTreino.getPrice());

        // 2. Criar um pedido
        System.out.println("\n--- Criando Pedido ---");
        Order pedido = new Order();
        System.out.println("✓ Pedido criado com status: " + pedido.getStatus());

        // 3. Adicionar itens ao pedido
        System.out.println("\n--- Adicionando Itens ao Pedido ---");
        pedido.addItem(whey, 2);
        System.out.println("✓ Adicionado: 2x " + whey.getName());
        
        pedido.addItem(creatina, 1);
        System.out.println("✓ Adicionado: 1x " + creatina.getName());
        
        pedido.addItem(preTreino, 3);
        System.out.println("✓ Adicionado: 3x " + preTreino.getName());

        // 4. Exibir itens do pedido
        System.out.println("\n--- Itens do Pedido ---");
        System.out.println("Total de itens: " + pedido.getItems().size());
        for (int i = 0; i < pedido.getItems().size(); i++) {
            OrderItem item = pedido.getItems().get(i);
            System.out.println((i + 1) + ". " + item.getProduct().getName() + 
                             " - Quantidade: " + item.getQuantity() + 
                             " - Subtotal: R$ " + item.subTotal());
        }

        // 5. Calcular valor total
        System.out.println("\n--- Valor Total do Pedido ---");
        Double total = pedido.totalValue();
        System.out.println("Valor Total: R$ " + String.format("%.2f", total));

        // 6. Testar aumento de quantidade (mesmo produto)
        System.out.println("\n--- Aumentando Quantidade ---");
        pedido.addItem(whey, 1);
        System.out.println("✓ Adicionado mais 1x Whey Protein");
        OrderItem itemWhey = pedido.getItems().get(0);
        System.out.println("  Nova quantidade de Whey: " + itemWhey.getQuantity());

        // 7. Recalcular total
        System.out.println("\n--- Novo Total ---");
        total = pedido.totalValue();
        System.out.println("Valor Total Atualizado: R$ " + String.format("%.2f", total));

        // 8. Testar remoção de item
        System.out.println("\n--- Removendo Item ---");
        pedido.removeItem(pedido.getItems().get(1));
        System.out.println("✓ Creatina removida do pedido");
        System.out.println("Total de itens agora: " + pedido.getItems().size());

        // 9. Checkout
        System.out.println("\n--- Finalizando Pedido ---");
        pedido.checkout();
        System.out.println("✓ Pedido finalizado com sucesso!");
        System.out.println("Status do pedido: " + pedido.getStatus());

        // 10. Testar exceções
        System.out.println("\n--- Testando Tratamento de Erros ---");
        Order pedido2 = new Order();
        
        try {
            pedido2.addItem(null, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Erro capturado: " + e.getMessage());
        }

        try {
            pedido2.addItem(whey, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Erro capturado: " + e.getMessage());
        }

        try {
            pedido2.addItem(whey, 100); // Mais do que tem em estoque
        } catch (IllegalStateException e) {
            System.out.println("✓ Erro capturado: " + e.getMessage());
        }

        System.out.println("\n========== FIM DO TESTE ==========");
    }
}
