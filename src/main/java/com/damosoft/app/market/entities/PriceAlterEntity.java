package com.damosoft.app.market.entities;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class PriceAlterEntity extends ReactivePanacheMongoEntity {
    public String uuid;
    public String name;
    public Double amount;
    public boolean percent;
    public boolean reduce;
}
