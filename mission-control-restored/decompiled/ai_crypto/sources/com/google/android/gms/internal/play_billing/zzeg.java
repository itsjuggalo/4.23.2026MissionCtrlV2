package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzeg extends zzcf implements Future {
    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        return zzc().cancel(z7);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return zzc().get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return zzc().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return zzc().isDone();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf
    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    public abstract Future zzc();

    @Override // java.util.concurrent.Future
    public final Object get(long j7, TimeUnit timeUnit) {
        return zzc().get(j7, timeUnit);
    }
}
