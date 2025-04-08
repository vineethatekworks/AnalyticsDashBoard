package com.analytics.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analytics.models.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
}
