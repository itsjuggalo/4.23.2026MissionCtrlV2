package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0925c;
import com.google.android.gms.common.internal.C0928f;
import com.google.android.gms.common.internal.C0938p;
import com.google.android.gms.common.internal.C0941t;
import com.google.android.gms.common.internal.C0942u;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import z1.C1984b;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0897b0 implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0904h f9746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0898c f9748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9750e;

    public C0897b0(C0904h c0904h, int i4, C0898c c0898c, long j4, long j5, String str, String str2) {
        this.f9746a = c0904h;
        this.f9747b = i4;
        this.f9748c = c0898c;
        this.f9749d = j4;
        this.f9750e = j5;
    }

    public static C0897b0 a(C0904h c0904h, int i4, C0898c c0898c) {
        boolean zM;
        if (!c0904h.e()) {
            return null;
        }
        C0942u c0942uA = C0941t.b().a();
        if (c0942uA == null) {
            zM = true;
        } else {
            if (!c0942uA.l()) {
                return null;
            }
            zM = c0942uA.m();
            P pT = c0904h.t(c0898c);
            if (pT != null) {
                if (!(pT.v() instanceof AbstractC0925c)) {
                    return null;
                }
                AbstractC0925c abstractC0925c = (AbstractC0925c) pT.v();
                if (abstractC0925c.hasConnectionInfo() && !abstractC0925c.isConnecting()) {
                    C0928f c0928fB = b(pT, abstractC0925c, i4);
                    if (c0928fB == null) {
                        return null;
                    }
                    pT.G();
                    zM = c0928fB.n();
                }
            }
        }
        return new C0897b0(c0904h, i4, c0898c, zM ? System.currentTimeMillis() : 0L, zM ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    public static C0928f b(P p4, AbstractC0925c abstractC0925c, int i4) {
        int[] iArrK;
        int[] iArrL;
        C0928f telemetryConfiguration = abstractC0925c.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.m() || ((iArrK = telemetryConfiguration.k()) != null ? !G1.b.a(iArrK, i4) : !((iArrL = telemetryConfiguration.l()) == null || !G1.b.a(iArrL, i4))) || p4.t() >= telemetryConfiguration.i()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        P pT;
        int iN;
        int i4;
        int i5;
        int i6;
        long j4;
        long j5;
        if (this.f9746a.e()) {
            C0942u c0942uA = C0941t.b().a();
            if ((c0942uA == null || c0942uA.l()) && (pT = this.f9746a.t(this.f9748c)) != null && (pT.v() instanceof AbstractC0925c)) {
                AbstractC0925c abstractC0925c = (AbstractC0925c) pT.v();
                int i7 = 0;
                boolean zM = this.f9749d > 0;
                int gCoreServiceId = abstractC0925c.getGCoreServiceId();
                int iK = 100;
                if (c0942uA != null) {
                    zM &= c0942uA.m();
                    int i8 = c0942uA.i();
                    int iK2 = c0942uA.k();
                    iN = c0942uA.n();
                    if (abstractC0925c.hasConnectionInfo() && !abstractC0925c.isConnecting()) {
                        C0928f c0928fB = b(pT, abstractC0925c, this.f9747b);
                        if (c0928fB == null) {
                            return;
                        }
                        boolean z4 = c0928fB.n() && this.f9749d > 0;
                        iK2 = c0928fB.i();
                        zM = z4;
                    }
                    i5 = i8;
                    i4 = iK2;
                } else {
                    iN = 0;
                    i4 = 100;
                    i5 = 5000;
                }
                C0904h c0904h = this.f9746a;
                int iElapsedRealtime = -1;
                if (task.isSuccessful()) {
                    i6 = 0;
                } else if (task.isCanceled()) {
                    i7 = iK;
                    i6 = -1;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof com.google.android.gms.common.api.b) {
                        Status status = ((com.google.android.gms.common.api.b) exception).getStatus();
                        iK = status.k();
                        C1984b c1984bI = status.i();
                        if (c1984bI != null) {
                            i6 = c1984bI.i();
                            i7 = iK;
                        }
                        i7 = iK;
                        i6 = -1;
                    } else {
                        i7 = 101;
                        i6 = -1;
                    }
                }
                if (zM) {
                    long j6 = this.f9749d;
                    long j7 = this.f9750e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j7);
                    j5 = jCurrentTimeMillis;
                    j4 = j6;
                } else {
                    j4 = 0;
                    j5 = 0;
                }
                c0904h.E(new C0938p(this.f9747b, i7, i6, j4, j5, null, null, gCoreServiceId, iElapsedRealtime), iN, i5, i4);
            }
        }
    }
}
