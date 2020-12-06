package com.behsa.usdp.serviceeventdelivery.service;

import com.behsa.usdp.ServiceEventDeliver;
import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import com.behsa.usdp.serviceeventdelivery.enums.EventActionStatus;
import com.behsa.usdp.serviceeventdelivery.repository.EventActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventActionService {
    private final EventActionRepository eventActionRepository;

    public void updateEventAction(ServiceEventDeliver serviceEventDeliver) {
        Optional<EventAction> optionalEventAction = eventActionRepository.findById(serviceEventDeliver.getActionId());
        if (optionalEventAction.isPresent()) {
            EventAction eventAction = optionalEventAction.get();
            eventAction.setStatus(EventActionStatus.SUCCESS)
                    .setDeliverDate(new Timestamp(new Date().getTime()))
                    .setServiceFinishDate(new Timestamp(serviceEventDeliver.getFinishDateTime()))
                    .setServiceReceiveDate(new Timestamp(serviceEventDeliver.getEventReceivedDateTime()));
            eventActionRepository.save(eventAction);
        } else {
            log.error("record not found for this id: " + serviceEventDeliver.getActionId());
        }


    }
}
