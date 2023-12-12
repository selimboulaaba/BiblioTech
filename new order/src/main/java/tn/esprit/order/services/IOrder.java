package tn.esprit.order.services;

import tn.esprit.order.entities.Orders;

import java.util.Date;
import java.util.List;

public interface IOrder {
    public Orders addOrder(Orders e);
    public Orders updateOrder(Orders e);
    public List<Orders> getAllOrder();
    public Orders getOrderById(long id);
    public void deleteOrder(long id);
    public Date findByIdBook(long id);

}
