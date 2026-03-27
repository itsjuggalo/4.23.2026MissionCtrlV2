package N1;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: N1.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0113m1 extends G {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile C0104j1 f1696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile C0104j1 f1697d;
    public C0104j1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f1698f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zzdf f1699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f1700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile C0104j1 f1701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public C0104j1 f1702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f1704p;

    public C0113m1(C0138v0 c0138v0) {
        super(c0138v0);
        this.f1704p = new Object();
        this.f1698f = new ConcurrentHashMap();
    }

    @Override // N1.G
    public final boolean s() {
        return false;
    }

    public final void t(C0104j1 c0104j1, boolean z6, long j4) {
        C0138v0 c0138v0 = (C0138v0) this.f1130a;
        C0143x c0143x = c0138v0.f1822r;
        C0138v0.i(c0143x);
        c0138v0.f1819o.getClass();
        c0143x.s(SystemClock.elapsedRealtime());
        boolean z7 = c0104j1 != null && c0104j1.f1673d;
        E1 e12 = c0138v0.f1816l;
        C0138v0.k(e12);
        if (!e12.f1242f.a(z7, z6, j4) || c0104j1 == null) {
            return;
        }
        c0104j1.f1673d = false;
    }

    public final C0104j1 u(zzdf zzdfVar) {
        com.google.android.gms.common.internal.I.g(zzdfVar);
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        ConcurrentHashMap concurrentHashMap = this.f1698f;
        C0104j1 c0104j1 = (C0104j1) concurrentHashMap.get(numValueOf);
        if (c0104j1 == null) {
            String strW = w(zzdfVar.zzb);
            a2 a2Var = ((C0138v0) this.f1130a).f1817m;
            C0138v0.j(a2Var);
            C0104j1 c0104j12 = new C0104j1(null, strW, a2Var.l0());
            concurrentHashMap.put(numValueOf, c0104j12);
            c0104j1 = c0104j12;
        }
        return this.f1701m != null ? this.f1701m : c0104j1;
    }

    public final C0104j1 v(boolean z6) {
        q();
        p();
        if (!z6) {
            return this.e;
        }
        C0104j1 c0104j1 = this.e;
        return c0104j1 != null ? c0104j1 : this.f1702n;
    }

    public final String w(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        C0138v0 c0138v0 = (C0138v0) this.f1130a;
        c0138v0.f1813d.getClass();
        if (length2 <= 500) {
            return str2;
        }
        c0138v0.f1813d.getClass();
        return str2.substring(0, 500);
    }

    public final void x(zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (!((C0138v0) this.f1130a).f1813d.D() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f1698f.put(Integer.valueOf(zzdfVar.zza), new C0104j1(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void y(String str, C0104j1 c0104j1, boolean z6) {
        C0104j1 c0104j12;
        C0104j1 c0104j13 = this.f1696c == null ? this.f1697d : this.f1696c;
        if (c0104j1.f1671b == null) {
            c0104j12 = new C0104j1(c0104j1.f1670a, str != null ? w(str) : null, c0104j1.f1672c, c0104j1.e, c0104j1.f1674f);
        } else {
            c0104j12 = c0104j1;
        }
        this.f1697d = this.f1696c;
        this.f1696c = c0104j12;
        C0138v0 c0138v0 = (C0138v0) this.f1130a;
        c0138v0.f1819o.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C0126r0 c0126r0 = c0138v0.f1815k;
        C0138v0.l(c0126r0);
        c0126r0.y(new RunnableC0107k1(this, c0104j12, c0104j13, jElapsedRealtime, z6));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(N1.C0104j1 r18, N1.C0104j1 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.C0113m1.z(N1.j1, N1.j1, long, boolean, android.os.Bundle):void");
    }
}
