package com.behsa.usdp.serviceeventdelivery.repositorytest;



import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import com.behsa.usdp.serviceeventdelivery.domaintest.EventActionTest;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventActionRepositoryTest extends JpaRepository<EventActionTest,String> {
    public Optional<EventActionTest> findById(String id);
    public List<EventActionTest> findAllBy();

}


