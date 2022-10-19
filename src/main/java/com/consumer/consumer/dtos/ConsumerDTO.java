package com.consumer.consumer.dtos;

public class ConsumerDTO {
    private String consumer;

    public ConsumerDTO() {
    }

    public ConsumerDTO(String consumer) {
        this.consumer = consumer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

}
