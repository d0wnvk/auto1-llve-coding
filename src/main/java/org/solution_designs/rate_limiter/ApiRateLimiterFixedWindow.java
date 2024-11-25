package org.solution_designs.rate_limiter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * API Rate Limiter
 * https://github.com/CrazySquirrel/Outtalent/tree/master/System%20Design/Problems/API%20Rate%20Limiter#5-what-are-different-types-of-throttling
 * <p>
 * Let’s assume our rate limiter is allowing three requests per minute per user, so whenever a new request comes in the
 * Rate Limiter will perform following steps:
 */
public class ApiRateLimiterFixedWindow {

    Map<UserId, UserValue> storage = new HashMap<>();

    public boolean isRequestAllowed(UserId userId) {

        if (storage.containsKey(userId)) {
            // find the record of the ‘UserID’
            UserValue userValue = storage.get(userId);
            long between = ChronoUnit.SECONDS.between(LocalDate.now(), userValue.getStartTime());

            // if ‘CurrentTime – StartTime >= 1 min’,
            // set the ‘StartTime’ to the current time and ‘Count’ to 1, and allow the request.
            if (between >= 60) {
                storage.put(userId, new UserValue(1, LocalDateTime.now()));
                return true;
            }

            // If ‘CurrentTime - StartTime <= 1 min’ and
            // If ‘Count < 3’, increment the Count and allow the request.
            if (between < 60 && userValue.getCount() < 3) {
                int count = userValue.getCount();
                count = count + 1;
                userValue.setCount(count);
                storage.put(userId, userValue);
                return true;
            }
            // if ‘CurrentTime - StartTime <= 1 min’ and Count >=3 then not allowed
            return false;

        } else {
            // If the ‘UserID’ is not present in the hash-table,
            // insert it and set the ‘Count’ to 1 and ‘StartTime’ to the current time (normalized to a minute) ,
            // and allow the request.
            storage.put(new UserId(1), new UserValue(1, LocalDateTime.now()));
            return true;
        }

    }

}
