package com.fdaindia.hrms.response;

import java.util.Date;
//
//import com.example.demo.entity.FDAIndiaKendra;

public class UserResponse {
    private boolean status;
    private String message;
    private Object object;
    private String token;
    private String sessionId;
    private Date sessionExpiry;
    private String role;
  //  private FDAIndiaKendra user; // Explicitly define user field

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// Getters and setters for the fields
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }//

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getSessionExpiry() {
        return sessionExpiry;
    }

    public void setSessionExpiry(Date sessionExpiry) {
        this.sessionExpiry = sessionExpiry;
    }

//    public FDAIndiaKendra getUser() {
//        return user;
//    }
//
//    public void setUser(FDAIndiaKendra user) {
//        this.user = user;
//    }
}
