package com.damosoft.app.market.entities;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

import java.util.Date;
import java.util.Set;

public class OrderEntity extends ReactivePanacheMongoEntity {
    public String uuid;
    public String consumer;
    public Date onDate;

    public OrderStatusEnum status;
    public Set<OrderEntryEntity> entries;
}
