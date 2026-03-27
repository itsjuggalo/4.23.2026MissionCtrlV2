package com.google.firebase.sessions;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessionsData {
    private final String sessionId;

    public FirebaseSessionsData(String str) {
        this.sessionId = str;
    }

    public static /* synthetic */ FirebaseSessionsData copy$default(FirebaseSessionsData firebaseSessionsData, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = firebaseSessionsData.sessionId;
        }
        return firebaseSessionsData.copy(str);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final FirebaseSessionsData copy(String str) {
        return new FirebaseSessionsData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FirebaseSessionsData) && r.b(this.sessionId, ((FirebaseSessionsData) obj).sessionId);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        String str = this.sessionId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.sessionId + ')';
    }
}
