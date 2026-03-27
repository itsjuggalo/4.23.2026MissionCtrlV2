package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class q0 extends Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0920y f9816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource f9817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0918w f9818d;

    public q0(int i4, AbstractC0920y abstractC0920y, TaskCompletionSource taskCompletionSource, InterfaceC0918w interfaceC0918w) {
        super(i4);
        this.f9817c = taskCompletionSource;
        this.f9816b = abstractC0920y;
        this.f9818d = interfaceC0918w;
        if (i4 == 2 && abstractC0920y.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void a(Status status) {
        this.f9817c.trySetException(this.f9818d.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void b(Exception exc) {
        this.f9817c.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void c(P p4) throws DeadObjectException {
        try {
            this.f9816b.b(p4.v(), this.f9817c);
        } catch (DeadObjectException e4) {
            throw e4;
        } catch (RemoteException e5) {
            a(s0.e(e5));
        } catch (RuntimeException e6) {
            this.f9817c.trySetException(e6);
        }
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void d(E e4, boolean z4) {
        e4.d(this.f9817c, z4);
    }

    @Override // com.google.android.gms.common.api.internal.Z
    public final boolean f(P p4) {
        return this.f9816b.c();
    }

    @Override // com.google.android.gms.common.api.internal.Z
    public final C1986d[] g(P p4) {
        return this.f9816b.e();
    }
}
