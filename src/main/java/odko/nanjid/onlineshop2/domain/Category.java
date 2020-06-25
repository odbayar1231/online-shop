package odko.nanjid.onlineshop2.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Category(){}
    public Category(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}

