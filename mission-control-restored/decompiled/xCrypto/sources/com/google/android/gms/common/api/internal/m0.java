package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class m0 extends Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f9806b;

    public m0(int i4, TaskCompletionSource taskCompletionSource) {
        super(i4);
        this.f9806b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void a(Status status) {
        this.f9806b.trySetException(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void b(Exception exc) {
        this.f9806b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void c(P p4) throws DeadObjectException {
        try {
            h(p4);
        } catch (DeadObjectException e4) {
            a(s0.e(e4));
            throw e4;
        } catch (RemoteException e5) {
            a(s0.e(e5));
        } catch (RuntimeException e6) {
            this.f9806b.trySetException(e6);
        }
    }

    public abstract void h(P p4);
}
