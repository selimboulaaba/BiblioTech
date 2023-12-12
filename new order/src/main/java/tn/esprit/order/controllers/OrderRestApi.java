package tn.esprit.order.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.order.entities.OrderStatus;
import tn.esprit.order.entities.Orders;
import tn.esprit.order.services.IOrder;
import tn.esprit.order.services.OrderServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class OrderRestApi {
    private OrderServiceImpl iOrder;
    @GetMapping("/addOrder")
    public Orders addOrder(@RequestParam(name = "idUser") long idUser, @RequestParam(name = "idBook") long idBook, @RequestParam(name = "pickupDate") String pickupDate, @RequestParam(name = "returnDate") String returnDate, @RequestParam(name = "orderStatus") OrderStatus orderStatus){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Orders f = new Orders();
        try {
            f.setIdUser(idUser);
            f.setIdBook(idBook);
            f.setPickupDate(dateFormat.parse(pickupDate));
            f.setReturnDate(dateFormat.parse(returnDate));
            f.setOrderStatus(orderStatus);
        } catch (Exception ex) {

        }
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
    @GetMapping("/getDateFinByIdBook/{IdF}")
    public Date getByIdBook(@PathVariable long IdF){
        return iOrder.findByIdBook(IdF);
    }
}
