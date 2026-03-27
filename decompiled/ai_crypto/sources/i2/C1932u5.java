package i2;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzdf;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: i2.u5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1932u5 extends AbstractC1833i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile C1868m5 f16129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile C1868m5 f16130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C1868m5 f16131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f16132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzdf f16133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f16134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile C1868m5 f16135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C1868m5 f16136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f16138l;

    public C1932u5(C1898q3 c1898q3) {
        super(c1898q3);
        this.f16138l = new Object();
        this.f16132f = new ConcurrentHashMap();
    }

    public final /* synthetic */ void A(Bundle bundle, C1868m5 c1868m5, C1868m5 c1868m52, long j7) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        G(c1868m5, c1868m52, j7, true, this.f15404a.C().t(null, "screen_view", bundle, null, false));
    }

    public final /* synthetic */ void B(C1868m5 c1868m5, C1868m5 c1868m52, long j7, boolean z7, Bundle bundle) {
        G(c1868m5, c1868m52, j7, z7, null);
    }

    public final /* synthetic */ void C(C1868m5 c1868m5, boolean z7, long j7) {
        o(c1868m5, false, j7);
    }

    public final /* synthetic */ C1868m5 D() {
        return this.f16136j;
    }

    public final /* synthetic */ void E(C1868m5 c1868m5) {
        this.f16136j = null;
    }

    public final void F(String str, C1868m5 c1868m5, boolean z7) {
        C1868m5 c1868m52;
        C1868m5 c1868m53 = this.f16129c == null ? this.f16130d : this.f16129c;
        if (c1868m5.f15911b == null) {
            c1868m52 = new C1868m5(c1868m5.f15910a, str != null ? r(str, "Activity") : null, c1868m5.f15912c, c1868m5.f15914e, c1868m5.f15915f);
        } else {
            c1868m52 = c1868m5;
        }
        this.f16130d = this.f16129c;
        this.f16129c = c1868m52;
        C1898q3 c1898q3 = this.f15404a;
        c1898q3.b().t(new RunnableC1884o5(this, c1868m52, c1868m53, c1898q3.f().b(), z7));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(i2.C1868m5 r16, i2.C1868m5 r17, long r18, boolean r20, android.os.Bundle r21) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C1932u5.G(i2.m5, i2.m5, long, boolean, android.os.Bundle):void");
    }

    @Override // i2.AbstractC1833i2
    public final boolean m() {
        return false;
    }

    public final void o(C1868m5 c1868m5, boolean z7, long j7) {
        C1898q3 c1898q3 = this.f15404a;
        c1898q3.M().k(c1898q3.f().b());
        if (!c1898q3.z().f16181f.d(c1868m5 != null && c1868m5.f15913d, z7, j7) || c1868m5 == null) {
            return;
        }
        c1868m5.f15913d = false;
    }

    public final C1868m5 p(zzdf zzdfVar) {
        AbstractC1207s.k(zzdfVar);
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        Map map = this.f16132f;
        C1868m5 c1868m5 = (C1868m5) map.get(numValueOf);
        if (c1868m5 == null) {
            C1868m5 c1868m52 = new C1868m5(null, r(zzdfVar.zzb, "Activity"), this.f15404a.C().p0());
            map.put(numValueOf, c1868m52);
            c1868m5 = c1868m52;
        }
        return this.f16135i != null ? this.f16135i : c1868m5;
    }

    public final C1868m5 q(boolean z7) {
        j();
        h();
        if (!z7) {
            return this.f16131e;
        }
        C1868m5 c1868m5 = this.f16131e;
        return c1868m5 != null ? c1868m5 : this.f16136j;
    }

    public final String r(String str, String str2) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str3 = length > 0 ? strArrSplit[length - 1] : "";
        C1898q3 c1898q3 = this.f15404a;
        return str3.length() > c1898q3.w().x(null, false) ? str3.substring(0, c1898q3.w().x(null, false)) : str3;
    }

    public final void s(Bundle bundle, long j7) {
        synchronized (this.f16138l) {
            try {
                if (!this.f16137k) {
                    this.f15404a.a().t().a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > this.f15404a.w().x(null, false))) {
                    this.f15404a.a().t().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > this.f15404a.w().x(null, false))) {
                    this.f15404a.a().t().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    zzdf zzdfVar = this.f16133g;
                    string2 = zzdfVar != null ? r(zzdfVar.zzb, "Activity") : "Activity";
                }
                C1868m5 c1868m5 = this.f16129c;
                if (this.f16134h && c1868m5 != null) {
                    this.f16134h = false;
                    boolean zEquals = Objects.equals(c1868m5.f15911b, string2);
                    boolean zEquals2 = Objects.equals(c1868m5.f15910a, string);
                    if (zEquals && zEquals2) {
                        this.f15404a.a().t().a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                C1898q3 c1898q3 = this.f15404a;
                c1898q3.a().w().c("Logging screen view with name, class", string == null ? "null" : string, string2 == null ? "null" : string2);
                C1868m5 c1868m52 = this.f16129c == null ? this.f16130d : this.f16129c;
                C1868m5 c1868m53 = new C1868m5(string, string2, c1898q3.C().p0(), true, j7);
                this.f16129c = c1868m53;
                this.f16130d = c1868m52;
                this.f16135i = c1868m53;
                c1898q3.b().t(new RunnableC1876n5(this, bundle, c1868m53, c1868m52, c1898q3.f().b()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(zzdf zzdfVar, String str, String str2) {
        C1898q3 c1898q3 = this.f15404a;
        if (!c1898q3.w().N()) {
            c1898q3.a().t().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        C1868m5 c1868m5 = this.f16129c;
        if (c1868m5 == null) {
            c1898q3.a().t().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.f16132f;
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        if (map.get(numValueOf) == null) {
            c1898q3.a().t().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = r(zzdfVar.zzb, "Activity");
        }
        String str3 = c1868m5.f15911b;
        String str4 = c1868m5.f15910a;
        boolean zEquals = Objects.equals(str3, str2);
        boolean zEquals2 = Objects.equals(str4, str);
        if (zEquals && zEquals2) {
            c1898q3.a().t().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > c1898q3.w().x(null, false))) {
            c1898q3.a().t().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > c1898q3.w().x(null, false))) {
            c1898q3.a().t().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        c1898q3.a().w().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        C1868m5 c1868m52 = new C1868m5(str, str2, c1898q3.C().p0());
        map.put(numValueOf, c1868m52);
        F(zzdfVar.zzb, c1868m52, true);
    }

    public final C1868m5 u() {
        return this.f16129c;
    }

    public final void v(zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.f15404a.w().N() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f16132f.put(Integer.valueOf(zzdfVar.zza), new C1868m5(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(DiagnosticsEntry.ID_KEY)));
    }

    public final void w(zzdf zzdfVar) {
        Object obj = this.f16138l;
        synchronized (obj) {
            this.f16137k = true;
            if (!Objects.equals(zzdfVar, this.f16133g)) {
                synchronized (obj) {
                    this.f16133g = zzdfVar;
                    this.f16134h = false;
                    C1898q3 c1898q3 = this.f15404a;
                    if (c1898q3.w().N()) {
                        this.f16135i = null;
                        c1898q3.b().t(new RunnableC1916s5(this));
                    }
                }
            }
        }
        C1898q3 c1898q32 = this.f15404a;
        if (!c1898q32.w().N()) {
            this.f16129c = this.f16135i;
            c1898q32.b().t(new RunnableC1892p5(this));
            return;
        }
        F(zzdfVar.zzb, p(zzdfVar), false);
        F0 f0M = this.f15404a.M();
        C1898q3 c1898q33 = f0M.f15404a;
        c1898q33.b().t(new RunnableC1799e0(f0M, c1898q33.f().b()));
    }

    public final void x(zzdf zzdfVar) {
        synchronized (this.f16138l) {
            this.f16137k = false;
            this.f16134h = true;
        }
        C1898q3 c1898q3 = this.f15404a;
        long jB = c1898q3.f().b();
        if (!c1898q3.w().N()) {
            this.f16129c = null;
            c1898q3.b().t(new RunnableC1900q5(this, jB));
        } else {
            C1868m5 c1868m5P = p(zzdfVar);
            this.f16130d = this.f16129c;
            this.f16129c = null;
            c1898q3.b().t(new RunnableC1908r5(this, c1868m5P, jB));
        }
    }

    public final void y(zzdf zzdfVar, Bundle bundle) {
        C1868m5 c1868m5;
        if (!this.f15404a.w().N() || bundle == null || (c1868m5 = (C1868m5) this.f16132f.get(Integer.valueOf(zzdfVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(DiagnosticsEntry.ID_KEY, c1868m5.f15912c);
        bundle2.putString("name", c1868m5.f15910a);
        bundle2.putString("referrer_name", c1868m5.f15911b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void z(zzdf zzdfVar) {
        synchronized (this.f16138l) {
            try {
                if (Objects.equals(this.f16133g, zzdfVar)) {
                    this.f16133g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f15404a.w().N()) {
            this.f16132f.remove(Integer.valueOf(zzdfVar.zza));
        }
    }
}
