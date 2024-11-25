package org.solution_designs.rate_limiter;

import java.time.LocalDateTime;
import java.util.Set;

public class UserTimeStamps {

    Set<LocalDateTime> timestamps;

    public Set<LocalDateTime> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Set<LocalDateTime> timestamps) {
        this.timestamps = timestamps;
    }
}
