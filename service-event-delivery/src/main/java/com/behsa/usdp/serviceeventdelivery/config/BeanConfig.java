package com.behsa.usdp.serviceeventdelivery.config;

import com.behsa.usdp.ServiceEventDeliver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    ServiceEventDeliver  getServiceEventDeliver(){return new ServiceEventDeliver();}
    @Bean
    ObjectMapper getObjectMapper(){return new ObjectMapper();}
}
