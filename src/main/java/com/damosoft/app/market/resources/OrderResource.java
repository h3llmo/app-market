package com.damosoft.app.market.resources;

import com.damosoft.app.market.commands.createorder.CreateOrderCommand;
import com.damosoft.app.market.commands.createorder.CreateOrderHandler;
import com.damosoft.app.market.commands.queryorders.QueryOrders;
import com.damosoft.app.market.commands.queryorders.QueryOrdersHandler;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("orders")
public class OrderResource {
    private final QueryOrdersHandler queryOrdersHandler;

    private final CreateOrderHandler createOrderHandler;

    public OrderResource(QueryOrdersHandler queryOrdersHandler, CreateOrderHandler createOrderHandler) {
        this.queryOrdersHandler = queryOrdersHandler;
        this.createOrderHandler = createOrderHandler;
    }

    @GET
    public Uni<Response> listAll(@BeanParam QueryOrders queryOrders) {
        return queryOrdersHandler.queryOrders(queryOrders);
    }

    @POST
    public Uni<Response> initiateOrder(CreateOrderCommand command) {
        return createOrderHandler.createOrder(command)
                .map(e -> Response
                        .created(URI.create("orders/" + command.getUuid()))
                        .build());
    }

}
