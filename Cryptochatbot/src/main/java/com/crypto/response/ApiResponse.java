package com.crypto.response;

import lombok.Data;

@Data

public class ApiResponse {
    private String message;

    // Getter and Setter for 'message'
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
