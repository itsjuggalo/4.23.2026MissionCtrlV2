package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends j1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f5564b;

    public g1(int i10, d dVar) {
        super(i10);
        this.f5564b = (d) com.google.android.gms.common.internal.s.l(dVar, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void a(Status status) {
        try {
            this.f5564b.setFailedResult(status);
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void b(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb2.append(simpleName);
        sb2.append(": ");
        sb2.append(localizedMessage);
        try {
            this.f5564b.setFailedResult(new Status(10, sb2.toString()));
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void c(y yVar, boolean z10) {
        yVar.a(this.f5564b, z10);
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void d(h0 h0Var) throws DeadObjectException {
        try {
            this.f5564b.run(h0Var.t());
        } catch (RuntimeException e10) {
            b(e10);
        }
    }
}
