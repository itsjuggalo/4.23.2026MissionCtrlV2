package S1;

import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class B4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcu f3866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3867b;

    public B4(C0540b5 c0540b5, zzcu zzcuVar) {
        this.f3866a = zzcuVar;
        Objects.requireNonNull(c0540b5);
        this.f3867b = c0540b5;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r8 = this;
            S1.b5 r0 = r8.f3867b
            S1.q3 r1 = r0.f4245a
            S1.w6 r1 = r1.z()
            S1.q3 r1 = r1.f4245a
            S1.Q2 r2 = r1.x()
            S1.a4 r2 = r2.w()
            S1.Z3 r3 = S1.Z3.ANALYTICS_STORAGE
            boolean r2 = r2.o(r3)
            r3 = 0
            if (r2 != 0) goto L2a
            S1.C2 r1 = r1.a()
            S1.A2 r1 = r1.t()
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            r1.a(r2)
        L28:
            r1 = r3
            goto L5b
        L2a:
            S1.Q2 r2 = r1.x()
            G1.d r4 = r1.f()
            long r4 = r4.currentTimeMillis()
            boolean r2 = r2.A(r4)
            if (r2 != 0) goto L28
            S1.Q2 r2 = r1.x()
            S1.N2 r2 = r2.f4196r
            long r4 = r2.a()
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L4d
            goto L28
        L4d:
            S1.Q2 r1 = r1.x()
            S1.N2 r1 = r1.f4196r
            long r1 = r1.a()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L5b:
            if (r1 == 0) goto L6d
            S1.q3 r0 = r0.f4245a
            com.google.android.gms.internal.measurement.zzcu r2 = r8.f3866a
            S1.l7 r0 = r0.C()
            long r3 = r1.longValue()
            r0.b0(r2, r3)
            return
        L6d:
            com.google.android.gms.internal.measurement.zzcu r0 = r8.f3866a     // Catch: android.os.RemoteException -> L73
            r0.zzb(r3)     // Catch: android.os.RemoteException -> L73
            return
        L73:
            r0 = move-exception
            S1.b5 r1 = r8.f3867b
            S1.q3 r1 = r1.f4245a
            S1.C2 r1 = r1.a()
            S1.A2 r1 = r1.o()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.B4.run():void");
    }
}
