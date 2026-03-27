package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends W {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f10976b;

    public j0(int i7, TaskCompletionSource taskCompletionSource) {
        super(i7);
        this.f10976b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void a(Status status) {
        this.f10976b.trySetException(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void b(Exception exc) {
        this.f10976b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void c(M m7) throws DeadObjectException {
        try {
            h(m7);
        } catch (DeadObjectException e7) {
            a(p0.e(e7));
            throw e7;
        } catch (RemoteException e8) {
            a(p0.e(e8));
        } catch (RuntimeException e9) {
            this.f10976b.trySetException(e9);
        }
    }

    public abstract void h(M m7);
}
