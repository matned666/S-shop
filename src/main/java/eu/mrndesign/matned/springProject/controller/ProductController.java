package eu.mrndesign.matned.springProject.controller;

import eu.mrndesign.matned.springProject.model.ProductModel;
import eu.mrndesign.matned.springProject.model.UserModel;
import eu.mrndesign.matned.springProject.repository.ProductRepository;
import eu.mrndesign.matned.springProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @RequestMapping(value = "/addProduct")
    public ModelAndView addProduct(Model model){
        return new ModelAndView("productform", "productToInsert", new ProductModel());
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute ProductModel product){
        productRepository.save(product);
        return "index";
    }

    @RequestMapping("/searchProds")
    public String productList(Model model){
        List<ProductModel> prods = productRepository.getProducts();
        model.addAttribute("products", prods);

        return "penalties";
    }

    @PostMapping("/deleteProduct")
    public RedirectView dedgdfgfdProduct(@ModelAttribute("prodid") ProductModel productModel){
        System.out.println("id to delete: "+productModel.getId());
        productRepository.delete(productModel);
        return new RedirectView("/searchProds");
    }

}
