package com.google.firebase.sessions.settings;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SessionConfigs {
    private final Integer cacheDuration;
    private final Long cacheUpdatedTime;
    private final Boolean sessionEnabled;
    private final Integer sessionRestartTimeout;
    private final Double sessionSamplingRate;

    public SessionConfigs(Boolean bool, Double d4, Integer num, Integer num2, Long l4) {
        this.sessionEnabled = bool;
        this.sessionSamplingRate = d4;
        this.sessionRestartTimeout = num;
        this.cacheDuration = num2;
        this.cacheUpdatedTime = l4;
    }

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d4, Integer num, Integer num2, Long l4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bool = sessionConfigs.sessionEnabled;
        }
        if ((i4 & 2) != 0) {
            d4 = sessionConfigs.sessionSamplingRate;
        }
        if ((i4 & 4) != 0) {
            num = sessionConfigs.sessionRestartTimeout;
        }
        if ((i4 & 8) != 0) {
            num2 = sessionConfigs.cacheDuration;
        }
        if ((i4 & 16) != 0) {
            l4 = sessionConfigs.cacheUpdatedTime;
        }
        Long l5 = l4;
        Integer num3 = num;
        return sessionConfigs.copy(bool, d4, num3, num2, l5);
    }

    public final Boolean component1() {
        return this.sessionEnabled;
    }

    public final Double component2() {
        return this.sessionSamplingRate;
    }

    public final Integer component3() {
        return this.sessionRestartTimeout;
    }

    public final Integer component4() {
        return this.cacheDuration;
    }

    public final Long component5() {
        return this.cacheUpdatedTime;
    }

    public final SessionConfigs copy(Boolean bool, Double d4, Integer num, Integer num2, Long l4) {
        return new SessionConfigs(bool, d4, num, num2, l4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return r.b(this.sessionEnabled, sessionConfigs.sessionEnabled) && r.b(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && r.b(this.sessionRestartTimeout, sessionConfigs.sessionRestartTimeout) && r.b(this.cacheDuration, sessionConfigs.cacheDuration) && r.b(this.cacheUpdatedTime, sessionConfigs.cacheUpdatedTime);
    }

    public final Integer getCacheDuration() {
        return this.cacheDuration;
    }

    public final Long getCacheUpdatedTime() {
        return this.cacheUpdatedTime;
    }

    public final Boolean getSessionEnabled() {
        return this.sessionEnabled;
    }

    public final Integer getSessionRestartTimeout() {
        return this.sessionRestartTimeout;
    }

    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public int hashCode() {
        Boolean bool = this.sessionEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d4 = this.sessionSamplingRate;
        int iHashCode2 = (iHashCode + (d4 == null ? 0 : d4.hashCode())) * 31;
        Integer num = this.sessionRestartTimeout;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cacheDuration;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l4 = this.cacheUpdatedTime;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.sessionEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionRestartTimeout=" + this.sessionRestartTimeout + ", cacheDuration=" + this.cacheDuration + ", cacheUpdatedTime=" + this.cacheUpdatedTime + ')';
    }
}
