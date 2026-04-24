package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class A0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f15085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1427z0 f15086b;

    public A0(Future future, InterfaceC1427z0 interfaceC1427z0) {
        this.f15085a = future;
        this.f15086b = interfaceC1427z0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thA;
        Future future = this.f15085a;
        if ((future instanceof N0) && (thA = O0.a((N0) future)) != null) {
            this.f15086b.b(thA);
            return;
        }
        try {
            if (!future.isDone()) {
                throw new IllegalStateException(D.a("Future was expected to be done: %s", future));
            }
            boolean z7 = false;
            Future future2 = future;
            while (true) {
                try {
                    obj = future2.get();
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    future2 = future2;
                } catch (Throwable th) {
                    if (z7) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            this.f15086b.a(obj);
        } catch (ExecutionException e8) {
            this.f15086b.b(e8.getCause());
        } catch (Throwable th2) {
            this.f15086b.b(th2);
        }
    }

    public final String toString() {
        C1414w c1414wA = AbstractC1422y.a(this);
        c1414wA.a(this.f15086b);
        return c1414wA.toString();
    }
}
