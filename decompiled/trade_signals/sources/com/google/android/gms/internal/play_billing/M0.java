package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class M0 extends AbstractC1419x0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public G0 f15183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledFuture f15184i;

    public M0(G0 g02) {
        this.f15183h = g02;
    }

    public static G0 z(G0 g02, long j8, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        M0 m02 = new M0(g02);
        J0 j02 = new J0(m02);
        m02.f15184i = scheduledExecutorService.schedule(j02, 28500L, timeUnit);
        g02.b(j02, EnumC1415w0.INSTANCE);
        return m02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1357k0
    public final String n() {
        G0 g02 = this.f15183h;
        ScheduledFuture scheduledFuture = this.f15184i;
        if (g02 == null) {
            return null;
        }
        String str = "inputFuture=[" + g02.toString() + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1357k0
    public final void p() {
        G0 g02 = this.f15183h;
        if ((this.f15491a instanceof C1332f0) & (g02 != null)) {
            Object obj = this.f15491a;
            g02.cancel((obj instanceof C1332f0) && ((C1332f0) obj).f15410a);
        }
        ScheduledFuture scheduledFuture = this.f15184i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f15183h = null;
        this.f15184i = null;
    }
}
