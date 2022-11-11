package ss12.Bai_tap;

public class Product{
    public static int id = 0;
    int productId;
    String name;
    double cost;

    public Product() {
        id ++;
    }

    public Product(String name, double cost) {
        productId = id++;
        this.name = name;
        this.cost = cost;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id= " + productId + '\'' +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

}
