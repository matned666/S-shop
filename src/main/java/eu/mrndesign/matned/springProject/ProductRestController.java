package eu.mrndesign.matned.springProject;

import eu.mrndesign.matned.springProject.model.ProductModel;
import eu.mrndesign.matned.springProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiProduct")
public class ProductRestController {

    @Autowired
    ProductRepository repository;

    @GetMapping("/prodlist")
    public List<ProductModel> showAllProds(){
        return repository.getProducts();
    }

    @PostMapping("/addProd")
    public ProductModel addProd(@RequestBody ProductModel productModel){
        repository.save(productModel);
        return productModel;
    }

    @PostMapping("/addProds")
    public List<ProductModel> addProds(@RequestBody List<ProductModel> prods){
        for (ProductModel user: prods) {
            repository.save(user);
        }
        return prods;
    }

    @PostMapping("/deleteProd/{prodId}")
    public void deleteUsers(@PathVariable int prodId){
            repository.delete(prodId);

    }





}
