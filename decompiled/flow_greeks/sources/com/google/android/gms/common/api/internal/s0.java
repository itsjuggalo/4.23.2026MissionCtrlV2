package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5625e;

    public s0(g gVar, int i10, b bVar, long j10, long j11, String str, String str2) {
        this.f5621a = gVar;
        this.f5622b = i10;
        this.f5623c = bVar;
        this.f5624d = j10;
        this.f5625e = j11;
    }

    public static s0 a(g gVar, int i10, b bVar) {
        boolean zU;
        if (!gVar.x()) {
            return null;
        }
        com.google.android.gms.common.internal.u uVarA = com.google.android.gms.common.internal.t.b().a();
        if (uVarA == null) {
            zU = true;
        } else {
            if (!uVarA.T()) {
                return null;
            }
            zU = uVarA.U();
            h0 h0VarS = gVar.s(bVar);
            if (h0VarS != null) {
                if (!(h0VarS.t() instanceof com.google.android.gms.common.internal.c)) {
                    return null;
                }
                com.google.android.gms.common.internal.c cVar = (com.google.android.gms.common.internal.c) h0VarS.t();
                if (cVar.hasConnectionInfo() && !cVar.isConnecting()) {
                    com.google.android.gms.common.internal.f fVarB = b(h0VarS, cVar, i10);
                    if (fVarB == null) {
                        return null;
                    }
                    h0VarS.D();
                    zU = fVarB.V();
                }
            }
        }
        return new s0(gVar, i10, bVar, zU ? System.currentTimeMillis() : 0L, zU ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    public static com.google.android.gms.common.internal.f b(h0 h0Var, com.google.android.gms.common.internal.c cVar, int i10) {
        int[] iArrS;
        int[] iArrT;
        com.google.android.gms.common.internal.f telemetryConfiguration = cVar.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.U() || ((iArrS = telemetryConfiguration.S()) != null ? !t5.b.a(iArrS, i10) : !((iArrT = telemetryConfiguration.T()) == null || !t5.b.a(iArrT, i10))) || h0Var.C() >= telemetryConfiguration.R()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        h0 h0VarS;
        long j10;
        int i10;
        int i11;
        int i12;
        int iS;
        int iR;
        int i13;
        long j11;
        long j12;
        int iElapsedRealtime;
        g gVar = this.f5621a;
        if (gVar.x()) {
            com.google.android.gms.common.internal.u uVarA = com.google.android.gms.common.internal.t.b().a();
            if ((uVarA == null || uVarA.T()) && (h0VarS = gVar.s(this.f5623c)) != null && (h0VarS.t() instanceof com.google.android.gms.common.internal.c)) {
                com.google.android.gms.common.internal.c cVar = (com.google.android.gms.common.internal.c) h0VarS.t();
                long j13 = this.f5624d;
                boolean zU = j13 > 0;
                int gCoreServiceId = cVar.getGCoreServiceId();
                if (uVarA != null) {
                    zU &= uVarA.U();
                    int iR2 = uVarA.R();
                    int iS2 = uVarA.S();
                    int iV = uVarA.V();
                    if (!cVar.hasConnectionInfo() || cVar.isConnecting()) {
                        i10 = iV;
                        j10 = j13;
                    } else {
                        com.google.android.gms.common.internal.f fVarB = b(h0VarS, cVar, this.f5622b);
                        if (fVarB == null) {
                            return;
                        }
                        boolean z10 = fVarB.V() && j13 > 0;
                        iS2 = fVarB.R();
                        i10 = iV;
                        j10 = j13;
                        zU = z10;
                    }
                    i12 = iR2;
                    i11 = iS2;
                } else {
                    j10 = j13;
                    i10 = 0;
                    i11 = 100;
                    i12 = 5000;
                }
                if (task.isSuccessful()) {
                    i13 = 0;
                    iR = 0;
                } else if (task.isCanceled()) {
                    iR = -1;
                    i13 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof com.google.android.gms.common.api.b) {
                        Status status = ((com.google.android.gms.common.api.b) exception).getStatus();
                        iS = status.S();
                        m5.b bVarR = status.R();
                        if (bVarR != null) {
                            iR = bVarR.R();
                        }
                        i13 = iS;
                    } else {
                        iS = 101;
                    }
                    iR = -1;
                    i13 = iS;
                }
                if (zU) {
                    long j14 = this.f5625e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    j11 = j10;
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j14);
                    j12 = jCurrentTimeMillis;
                } else {
                    j11 = 0;
                    j12 = 0;
                    iElapsedRealtime = -1;
                }
                gVar.B(new com.google.android.gms.common.internal.p(this.f5622b, i13, iR, j11, j12, null, null, gCoreServiceId, iElapsedRealtime), i10, i12, i11);
            }
        }
    }
}
