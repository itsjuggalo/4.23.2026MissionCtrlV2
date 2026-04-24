package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class B0 extends D0 {
    public static G0 a(Object obj) {
        return new E0(obj);
    }

    public static G0 b(G0 g02, long j8, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return g02.isDone() ? g02 : M0.z(g02, 28500L, timeUnit, scheduledExecutorService);
    }

    public static void c(G0 g02, InterfaceC1427z0 interfaceC1427z0, Executor executor) {
        g02.b(new A0(g02, interfaceC1427z0), executor);
    }
}
