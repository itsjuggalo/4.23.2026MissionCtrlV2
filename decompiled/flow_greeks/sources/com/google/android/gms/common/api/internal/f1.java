package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 extends u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f5542b;

    public f1(int i10, TaskCompletionSource taskCompletionSource) {
        super(i10);
        this.f5542b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void a(Status status) {
        this.f5542b.trySetException(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void b(Exception exc) {
        this.f5542b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void d(h0 h0Var) throws DeadObjectException {
        try {
            h(h0Var);
        } catch (DeadObjectException e10) {
            a(j1.e(e10));
            throw e10;
        } catch (RemoteException e11) {
            a(j1.e(e11));
        } catch (RuntimeException e12) {
            this.f5542b.trySetException(e12);
        }
    }

    public abstract void h(h0 h0Var);
}
