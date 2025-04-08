package com.analytics.dto;

import java.util.UUID;

public class UserResponse {
    private UUID id;
  

	private String fullName;
    private String bio;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    public UUID getId() {
  		return id;
  	}

  	public void setId(UUID id) {
  		this.id = id;
  	}
}
