package com.analytics.dto;

public class ApplyJobRequest {
	private String userId;
	private String jobId;

	public ApplyJobRequest() {
	}

	public ApplyJobRequest(String userId, String jobId) {
		this.userId = userId;
		this.jobId = jobId;
	}

	// Getters and Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
}
