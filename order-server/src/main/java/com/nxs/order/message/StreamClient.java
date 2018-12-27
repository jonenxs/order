package com.nxs.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String INPUT = "myMessage";
    String RECEIVE = "receiveMessage";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();

    @Input(StreamClient.RECEIVE)
    SubscribableChannel inputReceive();

    @Output(StreamClient.RECEIVE)
    MessageChannel outputReceive();
}
