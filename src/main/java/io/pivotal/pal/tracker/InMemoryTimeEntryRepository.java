package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> map = new HashMap<>();
    private long idCounter = 1L;

    public TimeEntry create(TimeEntry timeEntry){

        timeEntry.setId(idCounter);
        map.put(idCounter, timeEntry);
        ++idCounter;
        return map.get(timeEntry.getId());
    }

    public TimeEntry find(long timeEntryId){
        return map.get(timeEntryId);
    }

    public TimeEntry update(long id, TimeEntry timeEntry){
        timeEntry.setId(id);
        map.replace(id, timeEntry);
        return map.get(id);
    }

    public void delete(long id) {

        map.remove(id);
    }

    public List<TimeEntry> list(){
        return new ArrayList<>(map.values());
    }
}
