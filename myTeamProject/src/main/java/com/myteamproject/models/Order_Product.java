
package com.myteamproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
public class Order_Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderProductId") 
    private int orderProductId;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="orderId")
    private Order order;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="productId")
    private Product product;
    
    @Column(name="quantity")
    private int quantity;
    
    @Column(name="pricePerEach")
    private int pricePerEach;
    
    @Column(name="category")
    private String category;
    
    public Order_Product (){}

    public Order_Product(int orderProductId, int quantity, int pricePerEach, String category) {
        this.orderProductId = orderProductId;
        this.quantity = quantity;
        this.pricePerEach = pricePerEach;
        this.category = category;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPricePerEach() {
        return pricePerEach;
    }

    public void setPricePerEach(int pricePerEach) {
        this.pricePerEach = pricePerEach;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "OrderProductId=" + orderProductId +
                ", OrderId=" + order.getOrderId() + ", ProductId=" + product.getProductId() 
                + ", ProductName=" + product.getProductName()
                + ", Quantity=" + quantity + ", PricePerEach=" + pricePerEach + ", Category=" + category;
    }
    
    
    
    
}
