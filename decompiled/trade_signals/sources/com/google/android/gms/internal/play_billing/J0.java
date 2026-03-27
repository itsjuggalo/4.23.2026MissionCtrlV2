package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class J0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public M0 f15169a;

    public J0(M0 m02) {
        this.f15169a = m02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        G0 g02;
        M0 m02 = this.f15169a;
        if (m02 == null || (g02 = m02.f15183h) == null) {
            return;
        }
        this.f15169a = null;
        if (g02.isDone()) {
            m02.s(g02);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = m02.f15184i;
            m02.f15184i = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    m02.r(new K0(str, null));
                    throw th;
                }
            }
            m02.r(new K0(str + ": " + g02.toString(), null));
        } finally {
            g02.cancel(true);
        }
    }
}
