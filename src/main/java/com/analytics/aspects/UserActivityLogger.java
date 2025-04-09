package com.analytics.aspects;


import java.time.Instant;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.analytics.models.User;
import com.analytics.models.UserActivity;
import com.analytics.repos.UserActivityRepository;

@Aspect
@Component
public class UserActivityLogger {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @AfterReturning(
            pointcut = "execution(* com.analytics.services.UserService.login(..))",
            returning = "user"
        )
        public void logLogin(JoinPoint joinPoint, Object user) {
            if (user instanceof User) {
                UUID userId = ((User) user).getUserId();
                saveActivity(userId, "LOGIN");
            }
        }

        @AfterReturning(
            pointcut = "execution(* com.analytics.services.UserService.updateProfile(..))",
            returning = "user"
        )
        public void logProfileUpdate(JoinPoint joinPoint, Object user) {
            if (user instanceof User) {
                UUID userId = ((User) user).getUserId();
                saveActivity(userId, "UPDATE_PROFILE");
            }
        }



    private void saveActivity(UUID userId, String action) {
        UserActivity activity = new UserActivity();
        activity.setId(UUID.randomUUID()); 
        activity.setUserId(userId);    
        activity.setAction(action);
        activity.setTimestamp(Instant.now());
        userActivityRepository.save(activity);
    }
}
