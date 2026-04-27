package com.google.firebase.appcheck.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HttpErrorResponse {
    static final String CODE_KEY = "code";
    static final String ERROR_KEY = "error";
    static final String MESSAGE_KEY = "message";
    private int errorCode;
    private String errorMessage;

    private HttpErrorResponse(int i4, String str) {
        this.errorCode = i4;
        this.errorMessage = str;
    }

    public static HttpErrorResponse fromJsonString(String str) {
        JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("error"));
        return new HttpErrorResponse(jSONObject.optInt(CODE_KEY), jSONObject.optString("message"));
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
