package com.analytics.dto;

public class UpdateProfileRequest {
	private String name;
	private String bio;

	// Constructors
	public UpdateProfileRequest() {
	}

	public UpdateProfileRequest(String name, String bio) {
		this.name = name;
		this.bio = bio;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
