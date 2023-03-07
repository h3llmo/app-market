package com.damosoft.app.market.entities;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class ItemEntity extends ReactivePanacheMongoEntity {
    public String uuid;
    @NotBlank
    public String name;
    public String reference;
    public Double price;
    public Set<PriceAlterEntity> currentAlters;
}
