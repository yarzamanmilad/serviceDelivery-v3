package com.behsa.usdp.serviceeventdelivery.consumer;


import com.behsa.usdp.ServiceEventDeliver;
import com.behsa.usdp.serviceeventdelivery.constrant.Constrant;
import com.behsa.usdp.serviceeventdelivery.service.EventActionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@RequiredArgsConstructor
@Service
@Log4j2
public class EventActionConsumer {
    private final ObjectMapper mapper;
    private final EventActionService eventActionService;

   // @RabbitListener(queues = Constrant.DIRECT_QUEUE_NAME)
    public void listen(String msg) {
        try {
            ServiceEventDeliver serviceEventDeliver = mapper.readValue(msg, ServiceEventDeliver.class);
            eventActionService.updateEventAction(serviceEventDeliver);
        } catch (IOException e) {
            log.error(msg);
            log.error("objectMapper error:", e);
        }

    }
}
