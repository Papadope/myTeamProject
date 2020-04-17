package com.myteamproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="paymentId")
    private int paymentId;  
    
    @Column(name="totalPrice")
    private int totalPrice;
    
    @Column(name="paymentType")
    private String paymentType;
    
    @Column(name="isPayed")
    private boolean isPayed;
    
    @OneToOne(mappedBy="payment", 
        cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})    
    private Order order; 
    
    public Payment (){}

    public Payment(int totalPrice,  boolean isPayed) {
        this.totalPrice = totalPrice;
        this.isPayed = isPayed;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PaymentId=" + paymentId + ", TotalPrice=" + totalPrice + ", PaymentType=" + paymentType + ", IsPayed=" + isPayed + ", OrderId=" + order.getOrderId();
    }   
}
