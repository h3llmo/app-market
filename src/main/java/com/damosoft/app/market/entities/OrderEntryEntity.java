package com.damosoft.app.market.entities;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

import java.util.List;

public class OrderEntryEntity extends ReactivePanacheMongoEntity {
    public String uuid;
    public int sortOrder;
    public String item;
    public int units;
    public Double price;
    public List<PriceAlterEntity> alters;
}
