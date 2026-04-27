package S1;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: S1.u5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0691u5 extends AbstractC0593i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile C0628m5 f4970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile C0628m5 f4971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0628m5 f4972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f4973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzdf f4974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile C0628m5 f4976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0628m5 f4977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f4979l;

    public C0691u5(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4979l = new Object();
        this.f4973f = new ConcurrentHashMap();
    }

    public final /* synthetic */ void A(Bundle bundle, C0628m5 c0628m5, C0628m5 c0628m52, long j4) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        G(c0628m5, c0628m52, j4, true, this.f4245a.C().t(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    public final /* synthetic */ void B(C0628m5 c0628m5, C0628m5 c0628m52, long j4, boolean z4, Bundle bundle) {
        G(c0628m5, c0628m52, j4, z4, null);
    }

    public final /* synthetic */ void C(C0628m5 c0628m5, boolean z4, long j4) {
        o(c0628m5, false, j4);
    }

    public final /* synthetic */ C0628m5 D() {
        return this.f4977j;
    }

    public final /* synthetic */ void E(C0628m5 c0628m5) {
        this.f4977j = null;
    }

    public final void F(String str, C0628m5 c0628m5, boolean z4) {
        C0628m5 c0628m52;
        C0628m5 c0628m53 = this.f4970c == null ? this.f4971d : this.f4970c;
        if (c0628m5.f4752b == null) {
            c0628m52 = new C0628m5(c0628m5.f4751a, str != null ? r(str, "Activity") : null, c0628m5.f4753c, c0628m5.f4755e, c0628m5.f4756f);
        } else {
            c0628m52 = c0628m5;
        }
        this.f4971d = this.f4970c;
        this.f4970c = c0628m52;
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.b().t(new RunnableC0644o5(this, c0628m52, c0628m53, c0658q3.f().a(), z4));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(S1.C0628m5 r15, S1.C0628m5 r16, long r17, boolean r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0691u5.G(S1.m5, S1.m5, long, boolean, android.os.Bundle):void");
    }

    @Override // S1.AbstractC0593i2
    public final boolean m() {
        return false;
    }

    public final void o(C0628m5 c0628m5, boolean z4, long j4) {
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.M().k(c0658q3.f().a());
        if (!c0658q3.z().f5022f.d(c0628m5 != null && c0628m5.f4754d, z4, j4) || c0628m5 == null) {
            return;
        }
        c0628m5.f4754d = false;
    }

    public final C0628m5 p(zzdf zzdfVar) {
        AbstractC0940s.k(zzdfVar);
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        Map map = this.f4973f;
        C0628m5 c0628m5 = (C0628m5) map.get(numValueOf);
        if (c0628m5 == null) {
            C0628m5 c0628m52 = new C0628m5(null, r(zzdfVar.zzb, "Activity"), this.f4245a.C().p0());
            map.put(numValueOf, c0628m52);
            c0628m5 = c0628m52;
        }
        return this.f4976i != null ? this.f4976i : c0628m5;
    }

    public final C0628m5 q(boolean z4) {
        j();
        h();
        if (!z4) {
            return this.f4972e;
        }
        C0628m5 c0628m5 = this.f4972e;
        return c0628m5 != null ? c0628m5 : this.f4977j;
    }

    public final String r(String str, String str2) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str3 = length > 0 ? strArrSplit[length - 1] : "";
        C0658q3 c0658q3 = this.f4245a;
        return str3.length() > c0658q3.w().x(null, false) ? str3.substring(0, c0658q3.w().x(null, false)) : str3;
    }

    public final void s(Bundle bundle, long j4) {
        synchronized (this.f4979l) {
            try {
                if (!this.f4978k) {
                    this.f4245a.a().t().a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null && (string.length() <= 0 || string.length() > this.f4245a.w().x(null, false))) {
                    this.f4245a.a().t().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > this.f4245a.w().x(null, false))) {
                    this.f4245a.a().t().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    zzdf zzdfVar = this.f4974g;
                    string2 = zzdfVar != null ? r(zzdfVar.zzb, "Activity") : "Activity";
                }
                C0628m5 c0628m5 = this.f4970c;
                if (this.f4975h && c0628m5 != null) {
                    this.f4975h = false;
                    boolean zEquals = Objects.equals(c0628m5.f4752b, string2);
                    boolean zEquals2 = Objects.equals(c0628m5.f4751a, string);
                    if (zEquals && zEquals2) {
                        this.f4245a.a().t().a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                C0658q3 c0658q3 = this.f4245a;
                c0658q3.a().w().c("Logging screen view with name, class", string == null ? "null" : string, string2 == null ? "null" : string2);
                C0628m5 c0628m52 = this.f4970c == null ? this.f4971d : this.f4970c;
                C0628m5 c0628m53 = new C0628m5(string, string2, c0658q3.C().p0(), true, j4);
                this.f4970c = c0628m53;
                this.f4971d = c0628m52;
                this.f4976i = c0628m53;
                c0658q3.b().t(new RunnableC0636n5(this, bundle, c0628m53, c0628m52, c0658q3.f().a()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(zzdf zzdfVar, String str, String str2) {
        C0658q3 c0658q3 = this.f4245a;
        if (!c0658q3.w().N()) {
            c0658q3.a().t().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        C0628m5 c0628m5 = this.f4970c;
        if (c0628m5 == null) {
            c0658q3.a().t().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.f4973f;
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        if (map.get(numValueOf) == null) {
            c0658q3.a().t().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = r(zzdfVar.zzb, "Activity");
        }
        String str3 = c0628m5.f4752b;
        String str4 = c0628m5.f4751a;
        boolean zEquals = Objects.equals(str3, str2);
        boolean zEquals2 = Objects.equals(str4, str);
        if (zEquals && zEquals2) {
            c0658q3.a().t().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > c0658q3.w().x(null, false))) {
            c0658q3.a().t().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > c0658q3.w().x(null, false))) {
            c0658q3.a().t().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        c0658q3.a().w().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        C0628m5 c0628m52 = new C0628m5(str, str2, c0658q3.C().p0());
        map.put(numValueOf, c0628m52);
        F(zzdfVar.zzb, c0628m52, true);
    }

    public final C0628m5 u() {
        return this.f4970c;
    }

    public final void v(zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.f4245a.w().N() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f4973f.put(Integer.valueOf(zzdfVar.zza), new C0628m5(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(DiagnosticsEntry.ID_KEY)));
    }

    public final void w(zzdf zzdfVar) {
        Object obj = this.f4979l;
        synchronized (obj) {
            this.f4978k = true;
            if (!Objects.equals(zzdfVar, this.f4974g)) {
                synchronized (obj) {
                    this.f4974g = zzdfVar;
                    this.f4975h = false;
                    C0658q3 c0658q3 = this.f4245a;
                    if (c0658q3.w().N()) {
                        this.f4976i = null;
                        c0658q3.b().t(new RunnableC0675s5(this));
                    }
                }
            }
        }
        C0658q3 c0658q32 = this.f4245a;
        if (!c0658q32.w().N()) {
            this.f4970c = this.f4976i;
            c0658q32.b().t(new RunnableC0652p5(this));
            return;
        }
        F(zzdfVar.zzb, p(zzdfVar), false);
        F0 f0M = this.f4245a.M();
        C0658q3 c0658q33 = f0M.f4245a;
        c0658q33.b().t(new RunnableC0559e0(f0M, c0658q33.f().a()));
    }

    public final void x(zzdf zzdfVar) {
        synchronized (this.f4979l) {
            this.f4978k = false;
            this.f4975h = true;
        }
        C0658q3 c0658q3 = this.f4245a;
        long jA = c0658q3.f().a();
        if (!c0658q3.w().N()) {
            this.f4970c = null;
            c0658q3.b().t(new RunnableC0660q5(this, jA));
        } else {
            C0628m5 c0628m5P = p(zzdfVar);
            this.f4971d = this.f4970c;
            this.f4970c = null;
            c0658q3.b().t(new RunnableC0667r5(this, c0628m5P, jA));
        }
    }

    public final void y(zzdf zzdfVar, Bundle bundle) {
        C0628m5 c0628m5;
        if (!this.f4245a.w().N() || bundle == null || (c0628m5 = (C0628m5) this.f4973f.get(Integer.valueOf(zzdfVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(DiagnosticsEntry.ID_KEY, c0628m5.f4753c);
        bundle2.putString("name", c0628m5.f4751a);
        bundle2.putString("referrer_name", c0628m5.f4752b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void z(zzdf zzdfVar) {
        synchronized (this.f4979l) {
            try {
                if (Objects.equals(this.f4974g, zzdfVar)) {
                    this.f4974g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f4245a.w().N()) {
            this.f4973f.remove(Integer.valueOf(zzdfVar.zza));
        }
    }
}
