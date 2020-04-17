package com.myteamproject.controllers;

import com.myteamproject.models.Product;
import com.myteamproject.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    //need to inject the customer service
    @Autowired
    private ProductService productService;
    
    @GetMapping("/list")
    public String listProducts(Model theModel){
        
        //get products from the dao
        List<Product> theProducts = productService.getProducts();
       
        
        //ad the products to the model
        theModel.addAttribute("products", theProducts);
        
         return "list-products";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        
        //create model attribute to bind data
        Product theProduct=new Product();
        theModel.addAttribute("product", theProduct);
        return "product-form";    
    }
    
    @PostMapping("/saveProduct")
    public String saveCustomer(@ModelAttribute("product") Product theProduct){
        
        //save the product using our service
        productService.saveProduct(theProduct);
        
        return "redirect:/product/list";
    }   
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId")int theId,
            Model theModel){
        //get the product from the service
        Product theProduct=productService.getProduct(theId);       
        
        //set product as a model attribute to prepopulate the form
        theModel.addAttribute("product", theProduct);
        
        //send over to our form
        return "product-form";     
    }
    
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int theId){
        //delete the customer
        productService.deleteProduct(theId);
        
        return "redirect:/product/list";
    
    }
}
