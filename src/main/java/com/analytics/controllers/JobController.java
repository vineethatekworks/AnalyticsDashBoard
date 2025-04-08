//package com.analytics.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.analytics.dto.ApplyJobRequest;
//import com.analytics.dto.JobResponse;
//import com.analytics.services.JobService;
//
//@RestController
//@RequestMapping("/api/jobs")
//public class JobController {
//
//	@Autowired
//    private JobService jobService;
//
//    @PostMapping("/apply")
//    public ResponseEntity<JobResponse> applyJob(@RequestBody ApplyJobRequest request) {
//        JobResponse response = jobService.applyForJob(request);
//        return ResponseEntity.ok(response);
//    }
//}