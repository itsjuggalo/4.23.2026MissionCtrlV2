package com.google.firebase.appcheck.internal;

import G1.q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppCheckTokenResponse {
    static final String TIME_TO_LIVE_KEY = "ttl";
    static final String TOKEN_KEY = "token";
    private String timeToLive;
    private String token;

    private AppCheckTokenResponse(String str, String str2) {
        AbstractC0940s.k(str);
        AbstractC0940s.k(str2);
        this.token = str;
        this.timeToLive = str2;
    }

    public static AppCheckTokenResponse fromJsonString(String str) throws FirebaseException {
        JSONObject jSONObject = new JSONObject(str);
        String strA = q.a(jSONObject.optString("token"));
        String strA2 = q.a(jSONObject.optString(TIME_TO_LIVE_KEY));
        if (strA == null || strA2 == null) {
            throw new FirebaseException("Unexpected server response.");
        }
        return new AppCheckTokenResponse(strA, strA2);
    }

    public String getTimeToLive() {
        return this.timeToLive;
    }

    public String getToken() {
        return this.token;
    }
}
