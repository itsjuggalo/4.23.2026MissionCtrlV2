package com.google.android.gms.internal.play_billing;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class S3 implements G0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f15363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N3 f15364b = new R3(this);

    public S3(O3 o32) {
        this.f15363a = new WeakReference(o32);
    }

    @Override // com.google.android.gms.internal.play_billing.G0
    public final void b(Runnable runnable, Executor executor) {
        this.f15364b.b(runnable, executor);
    }

    public final boolean c(Object obj) {
        return this.f15364b.e(obj);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        O3 o32 = (O3) this.f15363a.get();
        boolean zCancel = this.f15364b.cancel(z7);
        if (!zCancel || o32 == null) {
            return zCancel;
        }
        o32.a();
        return true;
    }

    public final boolean d(Throwable th) {
        V1 v12 = new V1(th);
        H0 h02 = N3.f15188f;
        N3 n32 = this.f15364b;
        if (!h02.d(n32, null, v12)) {
            return false;
        }
        N3.d(n32);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f15364b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15364b.f15190a instanceof C1338g1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f15364b.isDone();
    }

    public final String toString() {
        return this.f15364b.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j8, TimeUnit timeUnit) {
        return this.f15364b.get(j8, timeUnit);
    }
}
