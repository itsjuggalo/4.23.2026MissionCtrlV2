package com.google.firebase.sessions;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SessionDetails {
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;
    private final long sessionStartTimestampUs;

    public SessionDetails(String sessionId, String firstSessionId, int i4, long j4) {
        r.f(sessionId, "sessionId");
        r.f(firstSessionId, "firstSessionId");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i4;
        this.sessionStartTimestampUs = j4;
    }

    public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, String str2, int i4, long j4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = sessionDetails.sessionId;
        }
        if ((i5 & 2) != 0) {
            str2 = sessionDetails.firstSessionId;
        }
        if ((i5 & 4) != 0) {
            i4 = sessionDetails.sessionIndex;
        }
        if ((i5 & 8) != 0) {
            j4 = sessionDetails.sessionStartTimestampUs;
        }
        int i6 = i4;
        return sessionDetails.copy(str, str2, i6, j4);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.firstSessionId;
    }

    public final int component3() {
        return this.sessionIndex;
    }

    public final long component4() {
        return this.sessionStartTimestampUs;
    }

    public final SessionDetails copy(String sessionId, String firstSessionId, int i4, long j4) {
        r.f(sessionId, "sessionId");
        r.f(firstSessionId, "firstSessionId");
        return new SessionDetails(sessionId, firstSessionId, i4, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return r.b(this.sessionId, sessionDetails.sessionId) && r.b(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public final long getSessionStartTimestampUs() {
        return this.sessionStartTimestampUs;
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + Integer.hashCode(this.sessionIndex)) * 31) + Long.hashCode(this.sessionStartTimestampUs);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }
}
