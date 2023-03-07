package com.damosoft.app.market.entities;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class BasketItemEntity extends ReactivePanacheMongoEntity {
    public String uuid;
    public String item;
    public int sortOrder;
    public boolean selected;
}
