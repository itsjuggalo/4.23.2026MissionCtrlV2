package com.google.firebase.sessions.api;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public interface SessionSubscriber {

    public enum Name {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    public static final class SessionDetails {
        private final String sessionId;

        public SessionDetails(String sessionId) {
            r.f(sessionId, "sessionId");
            this.sessionId = sessionId;
        }

        public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = sessionDetails.sessionId;
            }
            return sessionDetails.copy(str);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final SessionDetails copy(String sessionId) {
            r.f(sessionId, "sessionId");
            return new SessionDetails(sessionId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionDetails) && r.b(this.sessionId, ((SessionDetails) obj).sessionId);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.sessionId + ')';
        }
    }

    Name getSessionSubscriberName();

    boolean isDataCollectionEnabled();

    void onSessionChanged(SessionDetails sessionDetails);
}
