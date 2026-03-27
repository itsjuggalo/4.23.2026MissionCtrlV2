package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0901e f9814b;

    public p0(int i4, AbstractC0901e abstractC0901e) {
        super(i4);
        this.f9814b = (AbstractC0901e) AbstractC0940s.l(abstractC0901e, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void a(Status status) {
        try {
            this.f9814b.setFailedResult(status);
        } catch (IllegalStateException e4) {
            Log.w("ApiCallRunner", "Exception reporting failure", e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void b(Exception exc) {
        try {
            this.f9814b.setFailedResult(new Status(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException e4) {
            Log.w("ApiCallRunner", "Exception reporting failure", e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void c(P p4) throws DeadObjectException {
        try {
            this.f9814b.run(p4.v());
        } catch (RuntimeException e4) {
            b(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final void d(E e4, boolean z4) {
        e4.c(this.f9814b, z4);
    }
}
