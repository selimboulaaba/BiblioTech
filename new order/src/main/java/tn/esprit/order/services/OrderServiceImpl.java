package tn.esprit.order.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.order.entities.Orders;
import tn.esprit.order.repositories.OrderRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrder{
    private OrderRepository orderRepository;
    @Override
    public Orders addOrder(Orders e) {
        return orderRepository.save(e);
    }

    @Override
    public Orders updateOrder(Orders e) {
        return orderRepository.save(e);
    }

    @Override
    public List<Orders> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public Date findByIdBook(long id) {
        return orderRepository.findByIdBook(id);
    }
}
