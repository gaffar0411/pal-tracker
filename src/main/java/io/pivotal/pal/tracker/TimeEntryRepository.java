package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long timeEntryId);
    TimeEntry update(long id, TimeEntry timeEntry);
    void delete(long id);
    List<TimeEntry> list();
}
