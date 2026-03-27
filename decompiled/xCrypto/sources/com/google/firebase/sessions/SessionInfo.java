package com.google.firebase.sessions;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SessionInfo {
    private final DataCollectionStatus dataCollectionStatus;
    private final long eventTimestampUs;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;

    public SessionInfo(String sessionId, String firstSessionId, int i4, long j4, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        r.f(sessionId, "sessionId");
        r.f(firstSessionId, "firstSessionId");
        r.f(dataCollectionStatus, "dataCollectionStatus");
        r.f(firebaseInstallationId, "firebaseInstallationId");
        r.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i4;
        this.eventTimestampUs = j4;
        this.dataCollectionStatus = dataCollectionStatus;
        this.firebaseInstallationId = firebaseInstallationId;
        this.firebaseAuthenticationToken = firebaseAuthenticationToken;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i4, long j4, DataCollectionStatus dataCollectionStatus, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = sessionInfo.sessionId;
        }
        if ((i5 & 2) != 0) {
            str2 = sessionInfo.firstSessionId;
        }
        if ((i5 & 4) != 0) {
            i4 = sessionInfo.sessionIndex;
        }
        if ((i5 & 8) != 0) {
            j4 = sessionInfo.eventTimestampUs;
        }
        if ((i5 & 16) != 0) {
            dataCollectionStatus = sessionInfo.dataCollectionStatus;
        }
        if ((i5 & 32) != 0) {
            str3 = sessionInfo.firebaseInstallationId;
        }
        if ((i5 & 64) != 0) {
            str4 = sessionInfo.firebaseAuthenticationToken;
        }
        String str5 = str4;
        DataCollectionStatus dataCollectionStatus2 = dataCollectionStatus;
        long j5 = j4;
        int i6 = i4;
        return sessionInfo.copy(str, str2, i6, j5, dataCollectionStatus2, str3, str5);
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
        return this.eventTimestampUs;
    }

    public final DataCollectionStatus component5() {
        return this.dataCollectionStatus;
    }

    public final String component6() {
        return this.firebaseInstallationId;
    }

    public final String component7() {
        return this.firebaseAuthenticationToken;
    }

    public final SessionInfo copy(String sessionId, String firstSessionId, int i4, long j4, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        r.f(sessionId, "sessionId");
        r.f(firstSessionId, "firstSessionId");
        r.f(dataCollectionStatus, "dataCollectionStatus");
        r.f(firebaseInstallationId, "firebaseInstallationId");
        r.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new SessionInfo(sessionId, firstSessionId, i4, j4, dataCollectionStatus, firebaseInstallationId, firebaseAuthenticationToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return r.b(this.sessionId, sessionInfo.sessionId) && r.b(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && r.b(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && r.b(this.firebaseInstallationId, sessionInfo.firebaseInstallationId) && r.b(this.firebaseAuthenticationToken, sessionInfo.firebaseAuthenticationToken);
    }

    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    public final String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
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

    public int hashCode() {
        return (((((((((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + Integer.hashCode(this.sessionIndex)) * 31) + Long.hashCode(this.eventTimestampUs)) * 31) + this.dataCollectionStatus.hashCode()) * 31) + this.firebaseInstallationId.hashCode()) * 31) + this.firebaseAuthenticationToken.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", eventTimestampUs=" + this.eventTimestampUs + ", dataCollectionStatus=" + this.dataCollectionStatus + ", firebaseInstallationId=" + this.firebaseInstallationId + ", firebaseAuthenticationToken=" + this.firebaseAuthenticationToken + ')';
    }
}
