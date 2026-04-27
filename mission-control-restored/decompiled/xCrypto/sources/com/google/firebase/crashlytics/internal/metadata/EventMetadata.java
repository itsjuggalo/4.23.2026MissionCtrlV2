package com.google.firebase.crashlytics.internal.metadata;

import X2.L;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class EventMetadata {
    private final Map<String, String> additionalCustomKeys;
    private final String sessionId;
    private final long timestamp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventMetadata(String sessionId, long j4) {
        this(sessionId, j4, null, 4, null);
        r.f(sessionId, "sessionId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventMetadata copy$default(EventMetadata eventMetadata, String str, long j4, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = eventMetadata.sessionId;
        }
        if ((i4 & 2) != 0) {
            j4 = eventMetadata.timestamp;
        }
        if ((i4 & 4) != 0) {
            map = eventMetadata.additionalCustomKeys;
        }
        return eventMetadata.copy(str, j4, map);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Map<String, String> component3() {
        return this.additionalCustomKeys;
    }

    public final EventMetadata copy(String sessionId, long j4, Map<String, String> additionalCustomKeys) {
        r.f(sessionId, "sessionId");
        r.f(additionalCustomKeys, "additionalCustomKeys");
        return new EventMetadata(sessionId, j4, additionalCustomKeys);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return r.b(this.sessionId, eventMetadata.sessionId) && this.timestamp == eventMetadata.timestamp && r.b(this.additionalCustomKeys, eventMetadata.additionalCustomKeys);
    }

    public final Map<String, String> getAdditionalCustomKeys() {
        return this.additionalCustomKeys;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((this.sessionId.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31) + this.additionalCustomKeys.hashCode();
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.sessionId + ", timestamp=" + this.timestamp + ", additionalCustomKeys=" + this.additionalCustomKeys + ')';
    }

    public EventMetadata(String sessionId, long j4, Map<String, String> additionalCustomKeys) {
        r.f(sessionId, "sessionId");
        r.f(additionalCustomKeys, "additionalCustomKeys");
        this.sessionId = sessionId;
        this.timestamp = j4;
        this.additionalCustomKeys = additionalCustomKeys;
    }

    public /* synthetic */ EventMetadata(String str, long j4, Map map, int i4, AbstractC1585j abstractC1585j) {
        this(str, j4, (i4 & 4) != 0 ? L.e() : map);
    }
}
