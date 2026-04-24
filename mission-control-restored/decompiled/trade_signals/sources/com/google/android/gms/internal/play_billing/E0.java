package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class E0 implements G0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F0 f15102b = new F0(E0.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f15103a;

    public E0(Object obj) {
        this.f15103a = obj;
    }

    @Override // com.google.android.gms.internal.play_billing.G0
    public final void b(Runnable runnable, Executor executor) {
        A.c(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e8) {
            f15102b.a().logp(Level.SEVERE, "com.google.common.util.concurrent.ImmediateFuture", "addListener", "RuntimeException while executing runnable " + runnable.toString() + " with executor " + String.valueOf(executor), (Throwable) e8);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f15103a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        Object obj = this.f15103a;
        return super.toString() + "[status=SUCCESS, result=[" + obj.toString() + "]]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j8, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.f15103a;
    }
}
