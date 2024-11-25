package org.solution_designs.rate_limiter;

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
public class ApiRateLimitedSlidingWindow {

    Map<UserId, UserTimeStamps> storage = new HashMap<>();

    public boolean isRequestAllowed(UserId userId) {

        if (storage.containsKey(userId)) {
            UserTimeStamps userTimeStamps = storage.get(userId);
            long count = userTimeStamps.getTimestamps().stream()
                .filter(localDateTime -> ChronoUnit.SECONDS.between(localDateTime, LocalDateTime.now()) < 60)
                .count();

            if (count >= 3) {
                return false;
            } else {
                userTimeStamps.getTimestamps().add(LocalDateTime.now());
                return true;
            }

        } else {
            UserTimeStamps userTimeStamps = new UserTimeStamps();
            userTimeStamps.getTimestamps().add(LocalDateTime.now());
            storage.put(userId, userTimeStamps);
            return true;
        }

    }

}
