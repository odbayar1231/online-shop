package odko.nanjid.onlineshop2.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("seller")
public class Seller extends User{

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "seller")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "seller")
    private List<Order> orders = new ArrayList<Order>();

    public Seller(){}

    public Seller(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        product.setSeller(this);
        products.add(product);
    }
    public void removeProduct(Product product){
        product.setSeller(null);
        products.remove(product);
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

}

