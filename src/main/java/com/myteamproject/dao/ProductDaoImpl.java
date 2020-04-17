
package com.myteamproject.dao;

import com.myteamproject.models.Product;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao{
    
    @Autowired
    private SessionFactory sessionFactory;   
    
    @Override    
    public List<Product> getProducts() {
        
        //get the current hibername sassion
        Session currentSession=sessionFactory.getCurrentSession();
        
        //create a query
        Query<Product> theQuery=currentSession.createQuery("from Product"
                + " order by productName", Product.class);
        
        //execute query and get result list
        List<Product> products=theQuery.getResultList();
        
        //return the results
        return products;
    }

    @Override
    public void saveProduct(Product theProduct) {
        //get current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
        
        //save/update the customer
        currentSession.saveOrUpdate(theProduct);
    }

    @Override
    public Product getProduct(int theId) {
        //get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
        
        //now retreive from database using the primary key
        Product theProduct=currentSession.get(Product.class, theId);
        
        return theProduct;
    }

    @Override
   
    public void deleteProduct(int theId) {
        //get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
//        Session session;
//             try {
//                    session = sessionFactory.getCurrentSession();
//                 } catch (HibernateException e) {
//                    session = sessionFactory.openSession();
                 
        //delete object with primary key
        Query theQuery=currentSession.createQuery("delete from Product where id=: productId");
        theQuery.setParameter("productId", theId);        
        
        theQuery.executeUpdate();
    }
    
}
