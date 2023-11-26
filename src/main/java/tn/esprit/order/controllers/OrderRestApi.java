package tn.esprit.order.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.order.entities.Orders;
import tn.esprit.order.services.IOrder;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderRestApi {
    private IOrder iOrder;
    @PostMapping("/addOrder")
    public Orders addOrder(@RequestBody Orders f){
        return iOrder.addOrder(f);

    }
    @PutMapping("/updateOrder")
    public Orders updateOrder(@RequestBody Orders f){
        return iOrder.updateOrder(f);

    }
    @GetMapping("/findAllOrder")
    public List<Orders> findAllOrder(){
        return iOrder.getAllOrder();
    }
    @GetMapping("/findCourBy/{IdF}")
    public Orders findOrderById(@PathVariable long IdF){
        return iOrder.getOrderById(IdF);
    }
    @DeleteMapping("/deleteOrder/{IdF}")
    public void deleteOrder(@PathVariable long IdF){
        iOrder.deleteOrder(IdF);
    }
}
