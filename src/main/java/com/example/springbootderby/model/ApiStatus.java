package com.example.springbootderby.model;

public class ApiStatus {

    public ApiStatus(String apiStatusCode, String apiStatusMessage) {
        this.apiStatusCode = apiStatusCode;
        this.apiStatusMessage = apiStatusMessage;
    }

    public String getApiStatusCode() {
        return apiStatusCode;
    }

    @Override
    public String toString() {
        return "ApiStatus{" +
                "apiStatusCode='" + apiStatusCode + '\'' +
                ", apiStatusMessage='" + apiStatusMessage + '\'' +
                '}';
    }

    public void setApiStatusCode(String apiStatusCode) {
        this.apiStatusCode = apiStatusCode;
    }

    public String getApiStatusMessage() {
        return apiStatusMessage;
    }

    public void setApiStatusMessage(String apiStatusMessage) {
        this.apiStatusMessage = apiStatusMessage;
    }

    private String apiStatusCode;

    private String apiStatusMessage;
}
