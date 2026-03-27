package S1;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: S1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0622m extends T3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f4744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0614l f4746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f4747e;

    public C0622m(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4746d = new InterfaceC0614l() { // from class: S1.k
            @Override // S1.InterfaceC0614l
            public final /* synthetic */ String d(String str, String str2) {
                return null;
            }
        };
    }

    public static final long n() {
        return ((Long) AbstractC0569f2.f4566e.b(null)).longValue();
    }

    public static final int o() {
        return Math.max(0, ((Integer) AbstractC0569f2.f4581j.b(null)).intValue());
    }

    public static final long p() {
        return ((Integer) AbstractC0569f2.f4587l.b(null)).intValue();
    }

    public static final long q() {
        return ((Long) AbstractC0569f2.f4538S.b(null)).longValue();
    }

    public static final long r() {
        return ((Long) AbstractC0569f2.f4528N.b(null)).longValue();
    }

    public final long A() {
        this.f4245a.c();
        return 130000L;
    }

    public final boolean B() {
        if (this.f4747e == null) {
            synchronized (this) {
                try {
                    if (this.f4747e == null) {
                        C0658q3 c0658q3 = this.f4245a;
                        ApplicationInfo applicationInfo = c0658q3.e().getApplicationInfo();
                        String strA = G1.p.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z4 = false;
                            if (str != null && str.equals(strA)) {
                                z4 = true;
                            }
                            this.f4747e = Boolean.valueOf(z4);
                        }
                        if (this.f4747e == null) {
                            this.f4747e = Boolean.TRUE;
                            c0658q3.a().o().a("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.f4747e.booleanValue();
    }

    public final String C(String str, C0561e2 c0561e2) {
        return TextUtils.isEmpty(str) ? (String) c0561e2.b(null) : (String) c0561e2.b(this.f4746d.d(str, c0561e2.a()));
    }

    public final long D(String str, C0561e2 c0561e2) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) c0561e2.b(null)).longValue();
        }
        String strD = this.f4746d.d(str, c0561e2.a());
        if (TextUtils.isEmpty(strD)) {
            return ((Long) c0561e2.b(null)).longValue();
        }
        try {
            return ((Long) c0561e2.b(Long.valueOf(Long.parseLong(strD)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) c0561e2.b(null)).longValue();
        }
    }

    public final int E(String str, C0561e2 c0561e2) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) c0561e2.b(null)).intValue();
        }
        String strD = this.f4746d.d(str, c0561e2.a());
        if (TextUtils.isEmpty(strD)) {
            return ((Integer) c0561e2.b(null)).intValue();
        }
        try {
            return ((Integer) c0561e2.b(Integer.valueOf(Integer.parseInt(strD)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) c0561e2.b(null)).intValue();
        }
    }

    public final int F(String str, C0561e2 c0561e2, int i4, int i5) {
        return Math.max(Math.min(E(str, c0561e2), i5), i4);
    }

    public final double G(String str, C0561e2 c0561e2) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) c0561e2.b(null)).doubleValue();
        }
        String strD = this.f4746d.d(str, c0561e2.a());
        if (TextUtils.isEmpty(strD)) {
            return ((Double) c0561e2.b(null)).doubleValue();
        }
        try {
            return ((Double) c0561e2.b(Double.valueOf(Double.parseDouble(strD)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) c0561e2.b(null)).doubleValue();
        }
    }

    public final boolean H(String str, C0561e2 c0561e2) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) c0561e2.b(null)).booleanValue();
        }
        String strD = this.f4746d.d(str, c0561e2.a());
        return TextUtils.isEmpty(strD) ? ((Boolean) c0561e2.b(null)).booleanValue() : ((Boolean) c0561e2.b(Boolean.valueOf("1".equals(strD)))).booleanValue();
    }

    public final Bundle I() {
        try {
            C0658q3 c0658q3 = this.f4245a;
            if (c0658q3.e().getPackageManager() == null) {
                c0658q3.a().o().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoC = I1.f.a(c0658q3.e()).c(c0658q3.e().getPackageName(), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            if (applicationInfoC != null) {
                return applicationInfoC.metaData;
            }
            c0658q3.a().o().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e4) {
            this.f4245a.a().o().b("Failed to load metadata: Package name not found", e4);
            return null;
        }
    }

    public final Boolean J(String str) {
        AbstractC0940s.e(str);
        Bundle bundleI = I();
        if (bundleI == null) {
            this.f4245a.a().o().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleI.containsKey(str)) {
            return Boolean.valueOf(bundleI.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List K(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.AbstractC0940s.e(r4)
            android.os.Bundle r0 = r3.I()
            r1 = 0
            if (r0 != 0) goto L1d
            S1.q3 r4 = r3.f4245a
            S1.C2 r4 = r4.a()
            S1.A2 r4 = r4.o()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            S1.q3 r0 = r3.f4245a     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.e()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            S1.q3 r0 = r3.f4245a
            S1.C2 r0 = r0.a()
            S1.A2 r0 = r0.o()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0622m.K(java.lang.String):java.util.List");
    }

    public final boolean L() {
        this.f4245a.c();
        Boolean boolJ = J("firebase_analytics_collection_deactivated");
        return boolJ != null && boolJ.booleanValue();
    }

    public final boolean M() {
        Boolean boolJ = J("google_analytics_adid_collection_enabled");
        return boolJ == null || boolJ.booleanValue();
    }

    public final boolean N() {
        Boolean boolJ = J("google_analytics_automatic_screen_reporting_enabled");
        return boolJ == null || boolJ.booleanValue();
    }

    public final X3 O(String str, boolean z4) {
        Object obj;
        AbstractC0940s.e(str);
        C0658q3 c0658q3 = this.f4245a;
        Bundle bundleI = I();
        if (bundleI == null) {
            c0658q3.a().o().a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleI.get(str);
        }
        if (obj == null) {
            return X3.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return X3.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return X3.DENIED;
        }
        if (z4 && "eu_consent_policy".equals(obj)) {
            return X3.POLICY;
        }
        c0658q3.a().r().b("Invalid manifest metadata for", str);
        return X3.UNINITIALIZED;
    }

    public final boolean P() {
        Boolean boolJ = J("google_analytics_sgtm_upload_enabled");
        if (boolJ == null) {
            return false;
        }
        return boolJ.booleanValue();
    }

    public final void Q(String str) {
        this.f4745c = str;
    }

    public final String R() {
        return this.f4745c;
    }

    public final String i() {
        return s("debug.firebase.analytics.app", "");
    }

    public final String j() {
        return s("debug.deferred.deeplink", "");
    }

    public final boolean k(String str) {
        return "1".equals(this.f4746d.d(str, "gaia_collection_enabled"));
    }

    public final boolean l(String str) {
        return "1".equals(this.f4746d.d(str, "measurement.event_sampling_enabled"));
    }

    public final boolean m() {
        if (this.f4744b == null) {
            Boolean boolJ = J("app_measurement_lite");
            this.f4744b = boolJ;
            if (boolJ == null) {
                this.f4744b = Boolean.FALSE;
            }
        }
        return this.f4744b.booleanValue() || !this.f4245a.G();
    }

    public final String s(String str, String str2) {
        try {
            String str3 = (String) Class.forName(com.amazon.a.a.o.b.at).getMethod(com.amazon.a.a.o.b.au, String.class, String.class).invoke(null, str, "");
            AbstractC0940s.k(str3);
            return str3;
        } catch (ClassNotFoundException e4) {
            this.f4245a.a().o().b("Could not find SystemProperties class", e4);
            return "";
        } catch (IllegalAccessException e5) {
            this.f4245a.a().o().b("Could not access SystemProperties.get()", e5);
            return "";
        } catch (NoSuchMethodException e6) {
            this.f4245a.a().o().b("Could not find SystemProperties.get() method", e6);
            return "";
        } catch (InvocationTargetException e7) {
            this.f4245a.a().o().b("SystemProperties.get() threw an exception", e7);
            return "";
        }
    }

    public final void t(InterfaceC0614l interfaceC0614l) {
        this.f4746d = interfaceC0614l;
    }

    public final String u() {
        this.f4245a.c();
        return "FA";
    }

    public final int v() {
        return this.f4245a.C().V(201500000, true) ? 100 : 25;
    }

    public final int w(String str) {
        return F(str, AbstractC0569f2.f4550Y, 25, 100);
    }

    public final int x(String str, boolean z4) {
        if (z4) {
            return F(str, AbstractC0569f2.f4579i0, 100, 500);
        }
        return 500;
    }

    public final int y(String str, boolean z4) {
        return Math.max(x(str, z4), 256);
    }

    public final int z(String str) {
        return F(str, AbstractC0569f2.f4548X, 500, 2000);
    }
}
