package com.behsa.usdp.serviceeventdelivery;

import com.behsa.usdp.serviceeventdelivery.domain.EventActionTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceEventDeliveryApplicationTests {
     @Autowired
     EventActionTest eventAction;
    @Test
    void contextLoads() {


    }

}
