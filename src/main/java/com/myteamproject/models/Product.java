package com.myteamproject.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="productId")
    private int productId;
    
    @OneToMany(fetch=FetchType.LAZY,
                mappedBy="product",
                cascade=CascadeType.ALL)
    private List<Order_Product> orderProducts;
    
    @Column(name="productName")
    private String productName;
    
    @Column(name="description")
    private String description;
    
    @Column(name="quantityInStock")
    private int quantityInStock;
    
    @Column(name="price")
    private int price;
    
    public Product(){}

    public Product(String productName, String description, int quantityInStock, int price) {
        this.description=description;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<Order_Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<Order_Product> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void addProductToOrderProducts(Order_Product orderProduct){
        if (orderProducts==null){
            orderProducts=new ArrayList<>();
        }
        orderProducts.add(orderProduct);
        orderProduct.setProduct(this);    
    }

    @Override
    public String toString() {
        return "ProductId=" + productId + ", ProductName=" + productName + ", QuantityInStock=" + quantityInStock + ", Price=" + price ;
    }
    
    
    
    
}
