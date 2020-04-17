
package com.myteamproject.dao;

import com.myteamproject.models.Product;
import java.util.List;


public interface ProductDao {   
    
    public List<Product> getProducts();
    
    public void saveProduct(Product theProduct);

    public Product getProduct(int theId);

    public void deleteProduct(int theId);
    
}
