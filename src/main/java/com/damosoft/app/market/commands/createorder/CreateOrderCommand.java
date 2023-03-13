package com.damosoft.app.market.commands.createorder;

import lombok.Data;

@Data
public class CreateOrderCommand {
    private String uuid;
    private String consumer;
    private String basket;
}
