package com.damosoft.app.market.commands.createorder;

public class CreateOrderCommand {
    private String uuid;
    private String consumer;
    private String basket;

    public CreateOrderCommand() {
    }

    public CreateOrderCommand(String uuid, String consumer, String basket) {
        this.uuid = uuid;
        this.consumer = consumer;
        this.basket = basket;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getBasket() {
        return basket;
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }
}
