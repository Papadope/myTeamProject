
package com.myteamproject.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order")
public class Order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderId")
    private int orderId;
    
    @OneToMany(fetch=FetchType.LAZY,
                mappedBy="order",
                cascade=CascadeType.ALL)
    private List<Order_Product> orderProducts;
    
    @Column(name="orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Column (name="status")
    private int status;
    
    @Column(name="shippedDate")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    
    @Column(name="comment")
    private String comment;
    
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="userIdOrder")
    private User user;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="paymentId")
    private Payment payment;

    public Order(){}

    public Order(Date orderDate, int status, User user) {
        this.orderDate = orderDate;
        this.status = status;
        this.user = user;
    }   
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Order_Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<Order_Product> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
    public void addOrderToOrderProducts(Order_Product orderProduct){
        if (orderProducts==null){
            orderProducts=new ArrayList<>();
        }
        orderProducts.add(orderProduct);
        orderProduct.setOrder(this);    
    }   
    
    @Override
    public String toString() {
        return "OrderId=" + orderId + ", OrderDate=" + orderDate + ", UserId=" + user.getUserId();
    }
    
    
    
    
    
}
