package com.behsa.usdp.serviceeventdelivery.domaintest;



import com.behsa.usdp.serviceeventdelivery.enums.EventActionStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "TBL_RABBIT_EVENT_ACTION", schema = "USSD_MIGRATE_CRM", catalog = "")
@RequiredArgsConstructor
@Data
@Accessors(chain = true)
@Component
public class EventActionTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_RABBIT_EVENT_ACTION")
    private String id;
    @Enumerated(EnumType.ORDINAL)
    private EventActionStatus status;
    /* @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     @JsonSerialize(using = LocalDateTimeSerializer.class)
     @JsonDeserialize(using = LocalDateTimeDeserializer.class)*/
    private Timestamp serviceFinishDate;
    @Column(name = "SERVICE_RECEIVE_DATE")
    private Timestamp serviceReceiveDate;
    private Long FK_BROKER_ID;
    private Timestamp deliverDate;
    private Timestamp actionDate;
    private String rowId;


}

