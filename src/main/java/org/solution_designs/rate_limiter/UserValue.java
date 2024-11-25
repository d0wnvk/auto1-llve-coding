package org.solution_designs.rate_limiter;

import java.time.LocalDateTime;

public class UserValue {

    int count;
    LocalDateTime startTime;



    public UserValue(int count, LocalDateTime startTime) {
        this.count = count;
        this.startTime = startTime;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
