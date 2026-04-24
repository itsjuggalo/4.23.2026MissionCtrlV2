package com.google.firebase.appcheck.playintegrity.internal;

import G1.q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class GeneratePlayIntegrityChallengeResponse {
    static final String CHALLENGE_KEY = "challenge";
    static final String TIME_TO_LIVE_KEY = "ttl";
    private String challenge;
    private String timeToLive;

    private GeneratePlayIntegrityChallengeResponse(String str, String str2) {
        AbstractC0940s.k(str);
        AbstractC0940s.k(str2);
        this.challenge = str;
        this.timeToLive = str2;
    }

    public static GeneratePlayIntegrityChallengeResponse fromJsonString(String str) throws FirebaseException {
        JSONObject jSONObject = new JSONObject(str);
        String strA = q.a(jSONObject.optString(CHALLENGE_KEY));
        String strA2 = q.a(jSONObject.optString(TIME_TO_LIVE_KEY));
        if (strA == null || strA2 == null) {
            throw new FirebaseException("Unexpected server response.");
        }
        return new GeneratePlayIntegrityChallengeResponse(strA, strA2);
    }

    public String getChallenge() {
        return this.challenge;
    }

    public String getTimeToLive() {
        return this.timeToLive;
    }
}
