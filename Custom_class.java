package Rachit_Questionnaire_1;
import java.util.*;

class Product {
    private int id,quantityAvailable;;
    private String name;
    private double price;
    public Product(int id, String name, double price, int quantityAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantityAvailable() {
        return quantityAvailable;
    }
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}

class ShoppingCart {
    private HashMap<Product, Integer> products = new HashMap<>();
    public void addProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            products.put(product, currentQuantity + quantity);
        } else {
            products.put(product, quantity);
        }
    }
    public void removeProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (currentQuantity <= quantity) {
                products.remove(product);
            } else {
                products.put(product, currentQuantity - quantity);
            }
        }
    }

    public void displayProducts() {
        for (HashMap.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Quantity: " + quantity);
        }
    }
}

class Customer {
    private int id;
    private String name;
    private ShoppingCart shoppingCart;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
    }

    public void addToCart(Product product, int quantity) {
        shoppingCart.addProduct(product, quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        shoppingCart.removeProduct(product, quantity);
    }

    public void displayCart() {
        shoppingCart.displayProducts();
    }
}


public class Custom_class {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product(1, "Salt", 999.99, 10);
        Product product2 = new Product(2, "Sugar", 499.99, 20);
        Product product3 = new Product(3, "Pulse", 99.99, 30);

        // Create a customer
        Customer c1 = new Customer(1, "Rachit");

        // Add products to the customer's cart
        c1.addToCart(product1, 1);
        c1.addToCart(product2, 2);
        c1.addToCart(product3, 3);

        // Display products in the customer's cart
        c1.displayCart();

        // Remove a product from the customer's cart
        c1.removeFromCart(product2, 1);

        // Display products in the customer's cart after removal
        c1.displayCart();
    }
}
