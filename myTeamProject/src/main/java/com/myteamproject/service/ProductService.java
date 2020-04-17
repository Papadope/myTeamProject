
package com.myteamproject.service;

import com.myteamproject.models.Product;
import java.util.List;


public interface ProductService {
   
    public List <Product> getProducts();
    
    public void saveProduct(Product theProduct);

    public Product getProduct(int theId);

    public void deleteProduct(int theId);
    
}
