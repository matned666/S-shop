package eu.mrndesign.matned.springProject.repository;

import eu.mrndesign.matned.springProject.model.ProductModel;
import eu.mrndesign.matned.springProject.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ProductRepository {


    private final List<ProductModel> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }

    public void save(ProductModel product) {
        product.setAddDate(new Date());
        if(products.size() > 0) product.setId(products.get(products.size()-1).getId()+1);
        else product.setId(1);
        products.add(product);
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void delete(int id) {
        products.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .ifPresent(products::remove);
    }

   public void delete(ProductModel product) {
        products.remove(product);
    }


}
