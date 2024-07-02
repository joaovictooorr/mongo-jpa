package com.spring.demo.shop;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Order {

    @Id
    private String id;
    private String customerId;
    private Date orderDate;
    private List<LineItem> items;

    public Order(String customerId, Date orderDate, List<LineItem> items) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public Order(String customerId, Date orderDate) {
        this(customerId, orderDate, new ArrayList<>());
    }

    public Order(String customerId, Date orderDate, ArrayList<LineItem> items) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public Order addItem(LineItem item) {
        this.items.add(item);
        return this;
    }
}