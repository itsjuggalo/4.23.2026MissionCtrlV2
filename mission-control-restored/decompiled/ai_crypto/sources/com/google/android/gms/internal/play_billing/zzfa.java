package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzfa extends zzex implements zzew {
    final ScheduledExecutorService zza;

    public zzfa(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j7, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzfh zzfhVarZzr = zzfh.zzr(runnable, null);
        return new zzey(zzfhVarZzr, scheduledExecutorService.schedule(zzfhVarZzr, j7, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        zzez zzezVar = new zzez(runnable);
        return new zzey(zzezVar, this.zza.scheduleAtFixedRate(zzezVar, j7, j8, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        zzez zzezVar = new zzez(runnable);
        return new zzey(zzezVar, this.zza.scheduleWithFixedDelay(zzezVar, j7, j8, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j7, TimeUnit timeUnit) {
        zzfh zzfhVar = new zzfh(callable);
        return new zzey(zzfhVar, this.zza.schedule(zzfhVar, j7, timeUnit));
    }
}
