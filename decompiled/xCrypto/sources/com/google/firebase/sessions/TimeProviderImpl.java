package com.google.firebase.sessions;

import android.os.SystemClock;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public final class TimeProviderImpl implements TimeProvider {
    public static final TimeProviderImpl INSTANCE = new TimeProviderImpl();
    private static final long US_PER_MILLIS = 1000;

    private TimeProviderImpl() {
    }

    @Override // com.google.firebase.sessions.TimeProvider
    public long currentTimeUs() {
        return System.currentTimeMillis() * 1000;
    }

    @Override // com.google.firebase.sessions.TimeProvider
    /* JADX INFO: renamed from: elapsedRealtime-UwyO8pc */
    public long mo17elapsedRealtimeUwyO8pc() {
        C1779a.C0237a c0237a = C1779a.f14679b;
        return s3.c.t(SystemClock.elapsedRealtime(), s3.d.f14688d);
    }
}
