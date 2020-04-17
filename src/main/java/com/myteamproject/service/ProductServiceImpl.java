
package com.myteamproject.service;

import com.myteamproject.dao.ProductDao;
import com.myteamproject.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{   

    @Autowired
    private ProductDao productDao;
    
    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }    

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        productDao.saveProduct(theProduct);  
    }  

    @Override
    @Transactional
    public Product getProduct(int theId) {
        return productDao.getProduct(theId );

    }

    @Override
    @Transactional
    public void deleteProduct(int theId) {
         productDao.deleteProduct(theId);
    }
}    

