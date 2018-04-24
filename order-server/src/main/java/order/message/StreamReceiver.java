package order.message;

import lombok.extern.slf4j.Slf4j;
import order.dto.OrderDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message) {
//        log.info("StreamReceiver:{}",message);
//    }

    /**
     * 接收对象
     *
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.RECEIVE)
    public String process(OrderDTO message) {
        log.info("StreamReceiver:{}", message);
        return "receive.";
    }

    @StreamListener(StreamClient.RECEIVE)
    public void receive(String message) {
        log.info("Receive:{}",message);
    }
}
