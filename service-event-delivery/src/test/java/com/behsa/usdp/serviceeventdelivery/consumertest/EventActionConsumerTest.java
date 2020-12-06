package com.behsa.usdp.serviceeventdelivery.consumertest;

import com.behsa.usdp.ServiceEventDeliver;
import com.behsa.usdp.serviceeventdelivery.consumer.EventActionConsumer;
import com.behsa.usdp.serviceeventdelivery.domaintest.EventActionTest;
import com.behsa.usdp.serviceeventdelivery.repositorytest.EventActionRepositoryTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.Date;



@Log4j2
@SpringBootTest

class EventActionConsumerTest {

    private static final ServiceEventDeliver serviceEventDeliverTemp =new ServiceEventDeliver();
    @Autowired
    private static final EventActionTest EVENT_ACTION_TEST_Temp=new EventActionTest();
       static {
           serviceEventDeliverTemp.setActionId("82");
           serviceEventDeliverTemp.setEventReceivedDateTime(new Date().getTime());
           serviceEventDeliverTemp.setFinishDateTime(new Date().getTime());

       }
    @Autowired
   private  EventActionRepositoryTest eventActionRepositorytest;
    @Autowired
    private EventActionConsumer eventActionConsumer;
    @Autowired
    EventActionTest eventAction;
    @Autowired
    private  ObjectMapper mapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
 /*   @Test
       void sendMsg(){


        try {

            String msg=mapper.writeValueAsString(serviceEventDeliver);

                rabbitTemplate.convertAndSend(Constrant.DIRECT_EXCHANGE_NAME,Constrant.ROUTING_KEY,msg);
            System.out.println(msg);


        } catch (JsonProcessingException e) {
            log.error("object mapper unit test error. error message: "+e.getMessage());
        }
    }*/
    void creatNewRecord(){

    }
  @Test
  void sendMsg(){
      Pageable limit = PageRequest.of(0,2);
      Page<EventActionTest> all = eventActionRepositorytest.findAll(limit);
      Object[] objects = all.get().toArray();
      for (Object object : objects) {
          try {
              String msg = mapper.writeValueAsString(((EventActionTest) object));
              eventActionConsumer.listen(msg);
          } catch (JsonProcessingException e) {
              e.printStackTrace();
          }
      }
  }
  @Test
    void checkEventActionInDb(){

  }

}