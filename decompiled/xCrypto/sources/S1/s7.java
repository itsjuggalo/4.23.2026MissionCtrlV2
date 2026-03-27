package S1;

import android.content.BroadcastReceiver;

/* JADX INFO: loaded from: classes.dex */
public final class s7 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0658q3 f4932a;

    public s7(C0658q3 c0658q3) {
        this.f4932a = c0658q3;
    }

    public final /* synthetic */ void a() {
        this.f4932a.N().o(((Long) AbstractC0569f2.f4508D.b(null)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r3, android.content.Intent r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L12
            S1.q3 r3 = r2.f4932a
            S1.C2 r3 = r3.a()
            S1.A2 r3 = r3.r()
            java.lang.String r4 = "App receiver called with null intent"
            r3.a(r4)
            return
        L12:
            java.lang.String r3 = r4.getAction()
            if (r3 != 0) goto L28
            S1.q3 r3 = r2.f4932a
            S1.C2 r3 = r3.a()
            S1.A2 r3 = r3.r()
            java.lang.String r4 = "App receiver called with null action"
            r3.a(r4)
            return
        L28:
            int r4 = r3.hashCode()
            r0 = -1928239649(0xffffffff8d1165df, float:-4.4804198E-31)
            r1 = 1
            if (r4 == r0) goto L42
            r0 = 1279883384(0x4c497878, float:5.2814304E7)
            if (r4 == r0) goto L38
            goto L4c
        L38:
            java.lang.String r4 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L4c
            r3 = r1
            goto L4d
        L42:
            java.lang.String r4 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L4c
            r3 = 0
            goto L4d
        L4c:
            r3 = -1
        L4d:
            if (r3 == 0) goto L7d
            if (r3 == r1) goto L61
            S1.q3 r3 = r2.f4932a
            S1.C2 r3 = r3.a()
            S1.A2 r3 = r3.r()
            java.lang.String r4 = "App receiver called with unknown action"
            r3.a(r4)
            return
        L61:
            S1.q3 r3 = r2.f4932a
            S1.C2 r4 = r3.a()
            S1.A2 r4 = r4.w()
            java.lang.String r0 = "[sgtm] App Receiver notified batches are available"
            r4.a(r0)
            S1.i3 r3 = r3.b()
            S1.p7 r4 = new S1.p7
            r4.<init>()
            r3.t(r4)
            return
        L7d:
            S1.q3 r3 = r2.f4932a
            com.google.android.gms.internal.measurement.zzql.zza()
            S1.m r4 = r3.w()
            r0 = 0
            S1.e2 r1 = S1.AbstractC0569f2.f4537R0
            boolean r4 = r4.H(r0, r1)
            if (r4 != 0) goto L90
            return
        L90:
            S1.C2 r4 = r3.a()
            S1.A2 r4 = r4.w()
            java.lang.String r0 = "App receiver notified triggers are available"
            r4.a(r0)
            S1.i3 r4 = r3.b()
            S1.q7 r0 = new S1.q7
            r0.<init>()
            r4.t(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.s7.onReceive(android.content.Context, android.content.Intent):void");
    }
}
