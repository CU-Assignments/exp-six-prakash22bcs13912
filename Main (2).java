import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + category + ", " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        // Populate the products list with a large dataset of products
        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Smartphone", "Electronics", 800.00));
        products.add(new Product("Tablet", "Electronics", 500.00));
        products.add(new Product("TV", "Electronics", 1500.00));
        products.add(new Product("Refrigerator", "Home Appliance", 1000.00));
        products.add(new Product("Washing Machine", "Home Appliance", 700.00));
        products.add(new Product("Oven", "Home Appliance", 300.00));
        products.add(new Product("Blender", "Home Appliance", 150.00));
        products.add(new Product("Shoes", "Fashion", 80.00));
        products.add(new Product("Jacket", "Fashion", 120.00));

        // 1. Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(product -> product.category));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(System.out::println);
        });

        // 2. Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        product -> product.category,
                        Collectors.maxBy((p1, p2) -> Double.compare(p1.price, p2.price))
                ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println("Category: " + category + ", Product: " + product.orElse(null));
        });

        // 3. Calculate the average price of all products
        DoubleSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingDouble(product -> product.price));
        double averagePrice = stats.getAverage();

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
