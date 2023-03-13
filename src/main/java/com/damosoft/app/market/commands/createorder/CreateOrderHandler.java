package com.damosoft.app.market.commands.createorder;

import com.damosoft.app.market.entities.OrderEntity;
import com.damosoft.app.market.entities.OrderStatusEnum;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Date;

@ApplicationScoped
public class CreateOrderHandler {
    public Uni<OrderEntity> createOrder(CreateOrderCommand createOrderCommand) {
        final OrderEntity orderEntity = new OrderEntity();
        orderEntity.uuid = createOrderCommand.getUuid();
        orderEntity.status = OrderStatusEnum.INITIATED;

        return orderEntity.persist();
    }
}
