package com.google.firebase.appcheck.playintegrity.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class ExchangePlayIntegrityTokenRequest {
    static final String PLAY_INTEGRITY_TOKEN_KEY = "playIntegrityToken";
    private final String playIntegrityToken;

    public ExchangePlayIntegrityTokenRequest(String str) {
        this.playIntegrityToken = str;
    }

    public String toJsonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PLAY_INTEGRITY_TOKEN_KEY, this.playIntegrityToken);
        return jSONObject.toString();
    }
}
