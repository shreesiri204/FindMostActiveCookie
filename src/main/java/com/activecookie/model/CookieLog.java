package com.activecookie.model;

import java.time.ZonedDateTime;

public class CookieLog {
	
    private String cookie;

    private ZonedDateTime timestamp;
    

    public CookieLog(String cookie, String time) {
		super();
		this.cookie = cookie;
		this.timestamp = ZonedDateTime.parse(time);
	}

	public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
    	this.timestamp = ZonedDateTime.parse(timestamp);
    }

    @Override
    public String toString() {
        return "CookieLog{" +
                "cookie='" + cookie + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
