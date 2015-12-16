package org.mixit.cesar.site.service;

import com.google.common.annotations.VisibleForTesting;
import org.mixit.cesar.site.model.event.Event;
import org.mixit.cesar.site.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@DependsOn("cesarInitializer")
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    private static Event currentEvent;
    private static int min, max;
    @Autowired
    private EventRepository eventRepository;

    @PostConstruct
    public void initBean() {
        initCurrentEvent();
        if(currentEvent!=null) {
            initMinMaxEvent();
        }
    }

    @VisibleForTesting
    protected void initCurrentEvent() {
        List<Event> event = eventRepository.findByCurrent(true);
        if (event.isEmpty()) {
            logger.error("Error on init event service", new BeanInitializationException("There's no current event in database"));
        }
        else{
            currentEvent = event.get(0);
        }
        if (event.size() > 1) {
            throw new BeanInitializationException("There's more than one current event in database");
        }

    }

    @VisibleForTesting
    protected void initMinMaxEvent() {
        min = eventRepository.findFirstYearEdition();
        max = eventRepository.findLatestYearEdition();
    }

    public static Event getCurrent() {
        return currentEvent;
    }

    public Event getEvent(Integer year) {
        if (year == null) {
            return currentEvent;
        }
        if (year >= min && year <= max) {
            return eventRepository.findByYear(year);
        }
        throw new IllegalArgumentException("No event was found for the year " + year);
    }
}
