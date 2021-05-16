package com.example.springbootderby.model;

public class ApiError {
    @Override
    public String toString() {
        return "ApiError{" +
                "apiErrorCode='" + apiErrorCode + '\'' +
                ", apiErrorMessage='" + apiErrorMessage + '\'' +
                '}';
    }

    public String getApiErrorCode() {
        return apiErrorCode;
    }

    public void setApiErrorCode(String apiErrorCode) {
        this.apiErrorCode = apiErrorCode;
    }

    public String getApiErrorMessage() {
        return apiErrorMessage;
    }

    public void setApiErrorMessage(String apiErrorMessage) {
        this.apiErrorMessage = apiErrorMessage;
    }

    public ApiError(String apiErrorCode, String apiErrorMessage) {
        this.apiErrorCode = apiErrorCode;
        this.apiErrorMessage = apiErrorMessage;
    }

    private String apiErrorCode;

    private String apiErrorMessage;
}
