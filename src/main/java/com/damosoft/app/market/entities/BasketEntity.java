package com.damosoft.app.market.entities;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

import java.util.Set;

public class BasketEntity extends ReactivePanacheMongoEntity {
    public String uuid;
    public String consumer;
    public Set<BasketItemEntity> items;
}
