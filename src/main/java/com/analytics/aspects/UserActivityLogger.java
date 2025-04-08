package com.analytics.aspects;

import java.time.Instant;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.analytics.models.Job;
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
        UUID userId = ((User) user).getUserId();
        saveActivity(userId, "LOGIN");
    }

    @AfterReturning(
        pointcut = "execution(* com.analytics.services.UserService.updateProfile(..))",
        returning = "user"
    )
    public void logProfileUpdate(JoinPoint joinPoint, Object user) {
        UUID userId = ((User) user).getUserId();
        saveActivity(userId, "UPDATE_PROFILE");
    }

    @AfterReturning(
        pointcut = "execution(* com.analytics.services.JobService.applyJob(..))",
        returning = "job"
    )
    public void logApplyJob(JoinPoint joinPoint, Object job) {
        User applicant = ((Job) job).getPostedBy(); // replace with actual applicant if needed
        if (applicant != null) {
            saveActivity(applicant.getUserId(), "APPLY_JOB");
        }
    }

    private void saveActivity(UUID userId, String action) {
        UserActivity activity = new UserActivity();
        activity.setId(UUID.randomUUID()); // This is the activity ID
        activity.setUserId(userId);        // This is the ID of the user who acted
        activity.setAction(action);
        activity.setTimestamp(Instant.now());
        userActivityRepository.save(activity);
    }
}
