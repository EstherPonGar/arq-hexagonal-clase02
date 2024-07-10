package com.example.hexagonal.adapter.in;

import com.example.hexagonal.application.OrderService;
import com.example.hexagonal.domain.model.Order;
import com.example.hexagonal.domain.model.OrderItem;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    @Inject
    OrderService orderService;

    @POST
    @Path("/{orderId}/items")
    public Response addItemToOrder(@PathParam("orderId") long orderId, OrderItem item) {
        orderService.addItemToOrder(orderId,item);
        return Response.ok().build();
    }

    @PUT
    @Path("/{orderId}/status")
    public Response updateOrderStatus(@PathParam("orderId") long orderId, String status) {
        orderService.updateOrderStatus(orderId,status);
        return Response.ok().build();
    }

    @GET
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{orderId}")
    public Order getOrderById(@PathParam("orderId") long orderId) {
        return orderService.findOrderById(orderId);
    }
}
