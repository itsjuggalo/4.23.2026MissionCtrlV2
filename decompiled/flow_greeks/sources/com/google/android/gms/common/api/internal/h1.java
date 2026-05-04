package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f5578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource f5579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f5580d;

    public h1(int i10, v vVar, TaskCompletionSource taskCompletionSource, t tVar) {
        super(i10);
        this.f5579c = taskCompletionSource;
        this.f5578b = vVar;
        this.f5580d = tVar;
        if (i10 == 2 && vVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void a(Status status) {
        this.f5579c.trySetException(this.f5580d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void b(Exception exc) {
        this.f5579c.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void c(y yVar, boolean z10) {
        yVar.b(this.f5579c, z10);
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void d(h0 h0Var) throws DeadObjectException {
        try {
            this.f5578b.b(h0Var.t(), this.f5579c);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a(j1.e(e11));
        } catch (RuntimeException e12) {
            this.f5579c.trySetException(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.u0
    public final m5.d[] f(h0 h0Var) {
        return this.f5578b.d();
    }

    @Override // com.google.android.gms.common.api.internal.u0
    public final boolean g(h0 h0Var) {
        return this.f5578b.c();
    }
}
