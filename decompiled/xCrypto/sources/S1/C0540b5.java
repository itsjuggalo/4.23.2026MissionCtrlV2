package S1;

import a2.l;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzql;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.messaging.Constants;
import e2.AbstractC1231c;
import e2.InterfaceFutureC1233e;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import k0.AbstractC1566a;
import u.C1853a;

/* JADX INFO: renamed from: S1.b5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0540b5 extends AbstractC0593i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public N4 f4354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0563e4 f4355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f4356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f4358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f4359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public A f4362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public A f4363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PriorityQueue f4364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public C0531a4 f4366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f4367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4368q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final t7 f4369r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4370s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public A f4371t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f4372u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public A f4373v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k7 f4374w;

    public C0540b5(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4356e = new CopyOnWriteArraySet();
        this.f4359h = new Object();
        this.f4360i = false;
        this.f4361j = 1;
        this.f4370s = true;
        this.f4374w = new C4(this);
        this.f4358g = new AtomicReference();
        this.f4366o = C0531a4.f4335c;
        this.f4368q = -1L;
        this.f4367p = new AtomicLong(0L);
        this.f4369r = new t7(c0658q3);
    }

    public final void A(String str, String str2, long j4, Object obj) {
        this.f4245a.b().t(new RunnableC0682t4(this, str, str2, obj, j4));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.AbstractC0940s.e(r10)
            com.google.android.gms.common.internal.AbstractC0940s.e(r11)
            r9.h()
            r9.j()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L74
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L53
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            r12 = 1
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r12 == r11) goto L37
            r11 = 0
            goto L38
        L37:
            r11 = r2
        L38:
            S1.q3 r4 = r9.f4245a
            java.lang.Long r12 = java.lang.Long.valueOf(r11)
            S1.Q2 r11 = r4.x()
            S1.P2 r11 = r11.f4192n
            long r4 = r12.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4e
            java.lang.String r0 = "true"
        L4e:
            r11.b(r0)
        L51:
            r11 = r1
            goto L63
        L53:
            if (r12 != 0) goto L63
            S1.q3 r11 = r9.f4245a
            S1.Q2 r11 = r11.x()
            S1.P2 r11 = r11.f4192n
            java.lang.String r0 = "unset"
            r11.b(r0)
            goto L51
        L63:
            S1.q3 r0 = r9.f4245a
            S1.C2 r0 = r0.a()
            S1.A2 r0 = r0.w()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.c(r1, r2, r12)
        L74:
            r4 = r11
            r7 = r12
            S1.q3 r11 = r9.f4245a
            boolean r12 = r11.g()
            if (r12 != 0) goto L8e
            S1.q3 r10 = r9.f4245a
            S1.C2 r10 = r10.a()
            S1.A2 r10 = r10.w()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.a(r11)
            return
        L8e:
            boolean r11 = r11.m()
            if (r11 != 0) goto L95
            return
        L95:
            S1.q3 r11 = r9.f4245a
            S1.h7 r3 = new S1.h7
            r8 = r10
            r5 = r13
            r3.<init>(r4, r5, r7, r8)
            S1.e6 r10 = r11.J()
            r10.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0540b5.B(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final Map C(String str, String str2, boolean z4) {
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.b().p()) {
            c0658q3.a().o().a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        c0658q3.c();
        if (C0566f.a()) {
            c0658q3.a().o().a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f4245a.b().u(atomicReference, 5000L, "get user properties", new A4(this, atomicReference, null, str, str2, z4));
        List<h7> list = (List) atomicReference.get();
        if (list == null) {
            c0658q3.a().o().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z4));
            return Collections.EMPTY_MAP;
        }
        C1853a c1853a = new C1853a(list.size());
        for (h7 h7Var : list) {
            Object objI = h7Var.i();
            if (objI != null) {
                c1853a.put(h7Var.f4661b, objI);
            }
        }
        return c1853a;
    }

    public final String D() {
        return (String) this.f4358g.get();
    }

    public final void E(String str) {
        this.f4358g.set(str);
    }

    public final void F() {
        h();
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.x().f4199u.a()) {
            c0658q3.a().v().a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jA = c0658q3.x().f4200v.a();
        c0658q3.x().f4200v.b(1 + jA);
        c0658q3.w();
        if (jA >= 5) {
            c0658q3.a().r().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            c0658q3.x().f4199u.b(true);
        } else {
            if (this.f4371t == null) {
                this.f4371t = new C0698v4(this, this.f4245a);
            }
            this.f4371t.b(0L);
        }
    }

    public final void G(long j4) {
        this.f4358g.set(null);
        this.f4245a.b().t(new RunnableC0706w4(this, j4));
    }

    public final void H() {
        h();
        j();
        if (this.f4245a.m()) {
            C0658q3 c0658q3 = this.f4245a;
            C0622m c0622mW = c0658q3.w();
            c0622mW.f4245a.c();
            Boolean boolJ = c0622mW.J("google_analytics_deferred_deep_link_enabled");
            if (boolJ != null && boolJ.booleanValue()) {
                c0658q3.a().v().a("Deferred Deep Link feature enabled.");
                c0658q3.b().t(new Runnable() { // from class: S1.Y4
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f4305a.F();
                    }
                });
            }
            this.f4245a.J().s();
            this.f4370s = false;
            Q2 q2X = c0658q3.x();
            q2X.h();
            String string = q2X.p().getString("previous_os_version", null);
            q2X.f4245a.K().l();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = q2X.p().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            c0658q3.K().l();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            t("auto", "_ou", bundle);
        }
    }

    public final void I(InterfaceC0563e4 interfaceC0563e4) {
        InterfaceC0563e4 interfaceC0563e42;
        h();
        j();
        if (interfaceC0563e4 != null && interfaceC0563e4 != (interfaceC0563e42 = this.f4355d)) {
            AbstractC0940s.o(interfaceC0563e42 == null, "EventInterceptor already set.");
        }
        this.f4355d = interfaceC0563e4;
    }

    public final void J(InterfaceC0571f4 interfaceC0571f4) {
        j();
        AbstractC0940s.k(interfaceC0571f4);
        if (this.f4356e.add(interfaceC0571f4)) {
            return;
        }
        this.f4245a.a().r().a("OnEventListener already registered");
    }

    public final void K(InterfaceC0571f4 interfaceC0571f4) {
        j();
        AbstractC0940s.k(interfaceC0571f4);
        if (this.f4356e.remove(interfaceC0571f4)) {
            return;
        }
        this.f4245a.a().r().a("OnEventListener had not been registered");
    }

    public final int L(String str) {
        AbstractC0940s.e(str);
        this.f4245a.w();
        return 25;
    }

    public final void M(Bundle bundle) {
        N(bundle, this.f4245a.f().currentTimeMillis());
    }

    public final void N(Bundle bundle, long j4) {
        AbstractC0940s.k(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.f4245a.a().r().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        AbstractC0940s.k(bundle2);
        W3.b(bundle2, "app_id", String.class, null);
        W3.b(bundle2, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        W3.b(bundle2, "name", String.class, null);
        W3.b(bundle2, "value", Object.class, null);
        W3.b(bundle2, "trigger_event_name", String.class, null);
        W3.b(bundle2, "trigger_timeout", Long.class, 0L);
        W3.b(bundle2, "timed_out_event_name", String.class, null);
        W3.b(bundle2, "timed_out_event_params", Bundle.class, null);
        W3.b(bundle2, "triggered_event_name", String.class, null);
        W3.b(bundle2, "triggered_event_params", Bundle.class, null);
        W3.b(bundle2, "time_to_live", Long.class, 0L);
        W3.b(bundle2, "expired_event_name", String.class, null);
        W3.b(bundle2, "expired_event_params", Bundle.class, null);
        AbstractC0940s.e(bundle2.getString("name"));
        AbstractC0940s.e(bundle2.getString(FirebaseAnalytics.Param.ORIGIN));
        AbstractC0940s.k(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j4);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.C().y0(string) != 0) {
            c0658q3.a().o().b("Invalid conditional user property name", c0658q3.D().c(string));
            return;
        }
        if (c0658q3.C().y(string, obj) != 0) {
            c0658q3.a().o().c("Invalid conditional user property value", c0658q3.D().c(string), obj);
            return;
        }
        Object objZ = c0658q3.C().z(string, obj);
        if (objZ == null) {
            c0658q3.a().o().c("Unable to normalize conditional user property value", c0658q3.D().c(string), obj);
            return;
        }
        W3.a(bundle2, objZ);
        long j5 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            c0658q3.w();
            if (j5 > 15552000000L || j5 < 1) {
                c0658q3.a().o().c("Invalid conditional user property timeout", c0658q3.D().c(string), Long.valueOf(j5));
                return;
            }
        }
        long j6 = bundle2.getLong("time_to_live");
        c0658q3.w();
        if (j6 > 15552000000L || j6 < 1) {
            c0658q3.a().o().c("Invalid conditional user property time to live", c0658q3.D().c(string), Long.valueOf(j6));
        } else {
            c0658q3.b().t(new RunnableC0714x4(this, bundle2));
        }
    }

    public final void O(String str, String str2, Bundle bundle) {
        C0658q3 c0658q3 = this.f4245a;
        long jCurrentTimeMillis = c0658q3.f().currentTimeMillis();
        AbstractC0940s.e(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        c0658q3.b().t(new RunnableC0722y4(this, bundle2));
    }

    public final ArrayList P(String str, String str2) {
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.b().p()) {
            c0658q3.a().o().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        c0658q3.c();
        if (C0566f.a()) {
            c0658q3.a().o().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f4245a.b().u(atomicReference, 5000L, "get conditional user properties", new RunnableC0730z4(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return l7.h0(list);
        }
        c0658q3.a().o().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final String Q() {
        C0628m5 c0628m5U = this.f4245a.I().u();
        if (c0628m5U != null) {
            return c0628m5U.f4751a;
        }
        return null;
    }

    public final String R() {
        C0628m5 c0628m5U = this.f4245a.I().u();
        if (c0628m5U != null) {
            return c0628m5U.f4752b;
        }
        return null;
    }

    public final /* synthetic */ void S(SharedPreferences sharedPreferences, String str) {
        C0658q3 c0658q3 = this.f4245a;
        if (!c0658q3.w().H(null, AbstractC0569f2.f4556a1)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                c0658q3.a().w().a("IABTCF_TCString change picked up in listener.");
                ((A) AbstractC0940s.k(this.f4373v)).b(500L);
                return;
            }
            return;
        }
        if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            c0658q3.a().w().a("IABTCF_TCString change picked up in listener.");
            ((A) AbstractC0940s.k(this.f4373v)).b(500L);
        }
    }

    public final /* synthetic */ void T(Bundle bundle) {
        Bundle bundle2;
        int i4;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            C0658q3 c0658q3 = this.f4245a;
            bundle2 = new Bundle(c0658q3.x().f4204z.a());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i4 = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (c0658q3.C().B0(obj)) {
                        c0658q3.C().B(this.f4374w, null, 27, null, null, 0);
                    }
                    c0658q3.a().t().c("Invalid default event parameter type. Name, value", next, obj);
                } else if (l7.N(next)) {
                    c0658q3.a().t().b("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (c0658q3.C().C0("param", next, c0658q3.w().x(null, false), obj)) {
                    c0658q3.C().A(bundle2, next, obj);
                }
            }
            c0658q3.C();
            int iV = c0658q3.w().v();
            if (bundle2.size() > iV) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i4++;
                    if (i4 > iV) {
                        bundle2.remove(str);
                    }
                }
                c0658q3.C().B(this.f4374w, null, 26, null, null, 0);
                c0658q3.a().t().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        C0658q3 c0658q32 = this.f4245a;
        c0658q32.x().f4204z.b(bundle2);
        if (!bundle.isEmpty() || c0658q32.w().H(null, AbstractC0569f2.f4549X0)) {
            this.f4245a.J().v(bundle2);
        }
    }

    public final /* synthetic */ void U(int i4) {
        if (this.f4362k == null) {
            this.f4362k = new C0627m4(this, this.f4245a);
        }
        this.f4362k.b(((long) i4) * 1000);
    }

    public final /* synthetic */ void V(Boolean bool, boolean z4) {
        e0(bool, true);
    }

    public final /* synthetic */ void W(C0531a4 c0531a4, long j4, boolean z4, boolean z5) {
        h();
        j();
        C0658q3 c0658q3 = this.f4245a;
        C0531a4 c0531a4W = c0658q3.x().w();
        if (j4 <= this.f4368q && C0531a4.u(c0531a4W.b(), c0531a4.b())) {
            c0658q3.a().u().b("Dropped out-of-date consent setting, proposed settings", c0531a4);
            return;
        }
        Q2 q2X = c0658q3.x();
        C0658q3 c0658q32 = q2X.f4245a;
        q2X.h();
        int iB = c0531a4.b();
        if (!q2X.v(iB)) {
            c0658q3.a().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(c0531a4.b()));
            return;
        }
        C0658q3 c0658q33 = this.f4245a;
        SharedPreferences.Editor editorEdit = q2X.p().edit();
        editorEdit.putString("consent_settings", c0531a4.l());
        editorEdit.putInt("consent_source", iB);
        editorEdit.apply();
        c0658q3.a().w().b("Setting storage consent(FE)", c0531a4);
        this.f4368q = j4;
        if (c0658q33.J().D()) {
            c0658q33.J().Z(z4);
        } else {
            c0658q33.J().Y(z4);
        }
        if (z5) {
            c0658q33.J().q(new AtomicReference());
        }
    }

    public final /* synthetic */ void Y(boolean z4) {
        this.f4360i = false;
    }

    public final /* synthetic */ int Z() {
        return this.f4361j;
    }

    public final /* synthetic */ void a0(int i4) {
        this.f4361j = i4;
    }

    public final /* synthetic */ A b0() {
        return this.f4371t;
    }

    public final /* synthetic */ int c0(Throwable th) {
        String message = th.getMessage();
        this.f4365n = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (!message.contains("Background")) {
            return 1;
        }
        this.f4365n = true;
        return 1;
    }

    public final EnumC0604j5 d0(final G6 g6) {
        try {
            URL url = new URI(g6.f3978c).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String strS = this.f4245a.L().s();
            C0658q3 c0658q3 = this.f4245a;
            A2 a2W = c0658q3.a().w();
            Long lValueOf = Long.valueOf(g6.f3976a);
            a2W.d("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, g6.f3978c, Integer.valueOf(g6.f3977b.length));
            if (!TextUtils.isEmpty(g6.f3982g)) {
                c0658q3.a().w().c("[sgtm] Uploading data from app. row_id", lValueOf, g6.f3982g);
            }
            HashMap map = new HashMap();
            Bundle bundle = g6.f3979d;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    map.put(str, string);
                }
            }
            C0580g5 c0580g5F = c0658q3.F();
            byte[] bArr = g6.f3977b;
            InterfaceC0556d5 interfaceC0556d5 = new InterfaceC0556d5() { // from class: S1.O4
                /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
                @Override // S1.InterfaceC0556d5
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final /* synthetic */ void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
                    /*
                        r6 = this;
                        S1.b5 r7 = r6.f4149a
                        r7.h()
                        S1.G6 r10 = r3
                        r11 = 200(0xc8, float:2.8E-43)
                        if (r8 == r11) goto L14
                        r11 = 204(0xcc, float:2.86E-43)
                        if (r8 == r11) goto L14
                        r11 = 304(0x130, float:4.26E-43)
                        if (r8 != r11) goto L2e
                        r8 = r11
                    L14:
                        if (r9 != 0) goto L2e
                        S1.q3 r8 = r7.f4245a
                        S1.C2 r8 = r8.a()
                        S1.A2 r8 = r8.w()
                        long r0 = r10.f3976a
                        java.lang.Long r9 = java.lang.Long.valueOf(r0)
                        java.lang.String r11 = "[sgtm] Upload succeeded for row_id"
                        r8.b(r11, r9)
                        S1.j5 r8 = S1.EnumC0604j5.SUCCESS
                        goto L69
                    L2e:
                        S1.q3 r11 = r7.f4245a
                        S1.C2 r11 = r11.a()
                        S1.A2 r11 = r11.r()
                        long r0 = r10.f3976a
                        java.lang.Long r0 = java.lang.Long.valueOf(r0)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
                        java.lang.String r2 = "[sgtm] Upload failed for row_id. response, exception"
                        r11.d(r2, r0, r1, r9)
                        S1.e2 r9 = S1.AbstractC0569f2.f4605u
                        r11 = 0
                        java.lang.Object r9 = r9.b(r11)
                        java.lang.String r9 = (java.lang.String) r9
                        java.lang.String r11 = ","
                        java.lang.String[] r9 = r9.split(r11)
                        java.util.List r9 = java.util.Arrays.asList(r9)
                        java.lang.String r8 = java.lang.String.valueOf(r8)
                        boolean r8 = r9.contains(r8)
                        if (r8 == 0) goto L67
                        S1.j5 r8 = S1.EnumC0604j5.BACKOFF
                        goto L69
                    L67:
                        S1.j5 r8 = S1.EnumC0604j5.FAILURE
                    L69:
                        java.util.concurrent.atomic.AtomicReference r9 = r2
                        S1.q3 r11 = r7.f4245a
                        S1.e6 r11 = r11.J()
                        S1.g r0 = new S1.g
                        long r1 = r10.f3976a
                        int r3 = r8.zza()
                        long r4 = r10.f3981f
                        r0.<init>(r1, r3, r4)
                        r11.k0(r0)
                        S1.q3 r7 = r7.f4245a
                        S1.C2 r7 = r7.a()
                        S1.A2 r7 = r7.w()
                        java.lang.Long r10 = java.lang.Long.valueOf(r1)
                        java.lang.String r11 = "[sgtm] Updated status for row_id"
                        r7.c(r11, r10, r8)
                        monitor-enter(r9)
                        r9.set(r8)     // Catch: java.lang.Throwable -> L9d
                        r9.notifyAll()     // Catch: java.lang.Throwable -> L9d
                        monitor-exit(r9)     // Catch: java.lang.Throwable -> L9d
                        return
                    L9d:
                        r0 = move-exception
                        r7 = r0
                        monitor-exit(r9)     // Catch: java.lang.Throwable -> L9d
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: S1.O4.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
                }
            };
            c0580g5F.l();
            AbstractC0940s.k(url);
            AbstractC0940s.k(bArr);
            AbstractC0940s.k(interfaceC0556d5);
            c0580g5F.f4245a.b().w(new RunnableC0572f5(c0580g5F, strS, url, bArr, map, interfaceC0556d5));
            try {
                C0658q3 c0658q32 = c0658q3.C().f4245a;
                long jCurrentTimeMillis = c0658q32.f().currentTimeMillis();
                long j4 = jCurrentTimeMillis + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
                synchronized (atomicReference) {
                    for (long jCurrentTimeMillis2 = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS; atomicReference.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = j4 - c0658q32.f().currentTimeMillis()) {
                        try {
                            atomicReference.wait(jCurrentTimeMillis2);
                        } finally {
                        }
                    }
                }
            } catch (InterruptedException unused) {
                this.f4245a.a().r().a("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? EnumC0604j5.UNKNOWN : (EnumC0604j5) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e4) {
            this.f4245a.a().o().d("[sgtm] Bad upload url for row_id", g6.f3978c, Long.valueOf(g6.f3976a), e4);
            return EnumC0604j5.FAILURE;
        }
    }

    public final void e0(Boolean bool, boolean z4) {
        h();
        j();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().v().b("Setting app measurement enabled (FE)", bool);
        c0658q3.x().s(bool);
        if (z4) {
            Q2 q2X = c0658q3.x();
            C0658q3 c0658q32 = q2X.f4245a;
            q2X.h();
            SharedPreferences.Editor editorEdit = q2X.p().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.f4245a.j() || !(bool == null || bool.booleanValue())) {
            X();
        }
    }

    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final void X() {
        C0540b5 c0540b5;
        h();
        C0658q3 c0658q3 = this.f4245a;
        String strA = c0658q3.x().f4192n.a();
        if (strA == null) {
            c0540b5 = this;
        } else if ("unset".equals(strA)) {
            c0540b5 = this;
            c0540b5.B("app", "_npa", null, c0658q3.f().currentTimeMillis());
        } else {
            B("app", "_npa", Long.valueOf(true != com.amazon.a.a.o.b.af.equals(strA) ? 0L : 1L), c0658q3.f().currentTimeMillis());
            c0540b5 = this;
        }
        if (!c0540b5.f4245a.g() || !c0540b5.f4370s) {
            c0658q3.a().v().a("Updating Scion state (FE)");
            c0540b5.f4245a.J().X();
        } else {
            c0658q3.a().v().a("Recording app launch after enabling measurement for the first time (FE)");
            H();
            c0540b5.f4245a.z().f5021e.a();
            c0658q3.b().t(new RunnableC0643o4(this));
        }
    }

    public final void g0() {
        C0658q3 c0658q3 = this.f4245a;
        if (!(c0658q3.e().getApplicationContext() instanceof Application) || this.f4354c == null) {
            return;
        }
        ((Application) c0658q3.e().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f4354c);
    }

    public final Boolean h0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f4245a.b().u(atomicReference, 15000L, "boolean test flag value", new RunnableC0690u4(this, atomicReference));
    }

    public final String i0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f4245a.b().u(atomicReference, 15000L, "String test flag value", new D4(this, atomicReference));
    }

    public final Long j0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f4245a.b().u(atomicReference, 15000L, "long test flag value", new E4(this, atomicReference));
    }

    public final Integer k0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f4245a.b().u(atomicReference, 15000L, "int test flag value", new F4(this, atomicReference));
    }

    public final Double l0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f4245a.b().u(atomicReference, 15000L, "double test flag value", new G4(this, atomicReference));
    }

    @Override // S1.AbstractC0593i2
    public final boolean m() {
        return false;
    }

    public final void m0(Boolean bool) {
        j();
        this.f4245a.b().t(new H4(this, bool));
    }

    public final void n0(Bundle bundle, int i4, long j4) {
        Object obj;
        String string;
        j();
        C0531a4 c0531a4 = C0531a4.f4335c;
        Z3[] z3ArrC = Y3.STORAGE.c();
        int length = z3ArrC.length;
        int i5 = 0;
        while (true) {
            obj = null;
            if (i5 >= length) {
                break;
            }
            String str = z3ArrC[i5].f4321a;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i5++;
        }
        if (obj != null) {
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.a().t().b("Ignoring invalid consent setting", obj);
            c0658q3.a().t().a("Valid consent values are 'granted', 'denied'");
        }
        boolean zP = this.f4245a.b().p();
        C0531a4 c0531a4E = C0531a4.e(bundle, i4);
        if (c0531a4E.c()) {
            p0(c0531a4E, zP);
        }
        B bH = B.h(bundle, i4);
        if (bH.d()) {
            o0(bH, zP);
        }
        Boolean boolI = B.i(bundle);
        if (boolI != null) {
            String str2 = i4 == -30 ? "tcf" : "app";
            if (zP) {
                B(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, boolI.toString(), j4);
            } else {
                z(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, boolI.toString(), false, j4);
            }
        }
    }

    public final void o(C0531a4 c0531a4) {
        h();
        boolean z4 = (c0531a4.o(Z3.ANALYTICS_STORAGE) && c0531a4.o(Z3.AD_STORAGE)) || this.f4245a.J().C();
        C0658q3 c0658q3 = this.f4245a;
        if (z4 != c0658q3.j()) {
            c0658q3.i(z4);
            Q2 q2X = this.f4245a.x();
            C0658q3 c0658q32 = q2X.f4245a;
            q2X.h();
            Boolean boolValueOf = q2X.p().contains("measurement_enabled_from_api") ? Boolean.valueOf(q2X.p().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z4 || boolValueOf == null || boolValueOf.booleanValue()) {
                e0(Boolean.valueOf(z4), false);
            }
        }
    }

    public final void o0(B b4, boolean z4) {
        I4 i4 = new I4(this, b4);
        if (!z4) {
            this.f4245a.b().t(i4);
        } else {
            h();
            i4.run();
        }
    }

    public final void p(String str, String str2, Bundle bundle) {
        q(str, str2, bundle, true, true, this.f4245a.f().currentTimeMillis());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:56:0x00d0
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void p0(S1.C0531a4 r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0540b5.p0(S1.a4, boolean):void");
    }

    public final void q(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j4) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.f4245a.I().s(bundle2, j4);
            return;
        }
        boolean z6 = true;
        if (z5 && this.f4355d != null && !l7.N(str2)) {
            z6 = false;
        }
        boolean z7 = z6;
        if (str == null) {
            str = "app";
        }
        x(str, str2, j4, bundle2, z5, z7, z4, null);
    }

    public final void q0(Runnable runnable) {
        j();
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.b().p()) {
            c0658q3.a().o().a("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        if (c0658q3.b().q()) {
            c0658q3.a().o().a("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        c0658q3.c();
        if (C0566f.a()) {
            c0658q3.a().o().a("Cannot retrieve and upload batches from main thread");
            return;
        }
        c0658q3.a().w().a("[sgtm] Started client-side batch upload work.");
        boolean z4 = false;
        int size = 0;
        int i4 = 0;
        while (!z4) {
            c0658q3.a().w().a("[sgtm] Getting upload batches from service (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            c0658q3.b().u(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: S1.Z4
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f4322a.f4245a.J().j0(atomicReference, I6.i(EnumC0612k5.SGTM_CLIENT));
                }
            });
            K6 k6 = (K6) atomicReference.get();
            if (k6 == null) {
                break;
            }
            List list = k6.f4079a;
            if (!list.isEmpty()) {
                c0658q3.a().w().b("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                size += list.size();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    EnumC0604j5 enumC0604j5D0 = d0((G6) it.next());
                    if (enumC0604j5D0 == EnumC0604j5.SUCCESS) {
                        i4++;
                    } else if (enumC0604j5D0 == EnumC0604j5.BACKOFF) {
                        z4 = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        c0658q3.a().w().c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i4));
        runnable.run();
    }

    public final void r() {
        C0716x6 c0716x6;
        C0716x6 c0716x62;
        zzkp zzkpVar;
        h();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().v().a("Handle tcf update.");
        SharedPreferences sharedPreferencesQ = c0658q3.x().q();
        HashMap map = new HashMap();
        C0561e2 c0561e2 = AbstractC0569f2.f4556a1;
        int i4 = 2;
        if (((Boolean) c0561e2.b(null)).booleanValue()) {
            a2.k kVar = AbstractC0732z6.f5091a;
            zzko zzkoVar = zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            EnumC0724y6 enumC0724y6 = EnumC0724y6.CONSENT;
            Map.Entry entryA = AbstractC0532a5.a(zzkoVar, enumC0724y6);
            int i5 = 1;
            zzko zzkoVar2 = zzko.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            EnumC0724y6 enumC0724y62 = EnumC0724y6.FLEXIBLE_LEGITIMATE_INTEREST;
            a2.l lVarN = a2.l.n(entryA, AbstractC0532a5.a(zzkoVar2, enumC0724y62), AbstractC0532a5.a(zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, enumC0724y6), AbstractC0532a5.a(zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, enumC0724y6), AbstractC0532a5.a(zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, enumC0724y62), AbstractC0532a5.a(zzko.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, enumC0724y62), AbstractC0532a5.a(zzko.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, enumC0724y62));
            a2.m mVarU = a2.m.u("CH");
            char[] cArr = new char[5];
            boolean zContains = sharedPreferencesQ.contains("IABTCF_TCString");
            int iB = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_CmpSdkID");
            int iB2 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_PolicyVersion");
            int iB3 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_gdprApplies");
            int iB4 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_PurposeOneTreatment");
            int iB5 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_EnableAdvertiserConsentMode");
            String strA = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_PublisherCC");
            l.a aVarA = a2.l.a();
            a2.B it = lVarN.keySet().iterator();
            while (it.hasNext()) {
                zzko zzkoVar3 = (zzko) it.next();
                int iZza = zzkoVar3.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(iZza);
                String strA2 = AbstractC0732z6.a(sharedPreferencesQ, sb.toString());
                if (TextUtils.isEmpty(strA2) || strA2.length() < 755) {
                    zzkpVar = zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int iDigit = Character.digit(strA2.charAt(754), 10);
                    zzkpVar = (iDigit < 0 || iDigit > zzkp.values().length || iDigit == 0) ? zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED : iDigit != i5 ? iDigit != i4 ? zzkp.PURPOSE_RESTRICTION_UNDEFINED : zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                }
                aVarA.f(zzkoVar3, zzkpVar);
                i4 = 2;
                i5 = 1;
            }
            a2.l lVarC = aVarA.c();
            String strA3 = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_PurposeConsents");
            String strA4 = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_VendorConsents");
            boolean z4 = !TextUtils.isEmpty(strA4) && strA4.length() >= 755 && strA4.charAt(754) == '1';
            String strA5 = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_PurposeLegitimateInterests");
            String strA6 = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_VendorLegitimateInterests");
            boolean z5 = !TextUtils.isEmpty(strA6) && strA6.length() >= 755 && strA6.charAt(754) == '1';
            cArr[0] = '2';
            c0716x6 = new C0716x6(AbstractC0732z6.d(lVarN, lVarC, mVarU, cArr, iB, iB5, iB3, iB2, iB4, strA, strA3, strA5, z4, z5, zContains));
        } else {
            String strA7 = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_VendorConsents");
            if (!"".equals(strA7) && strA7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strA7.charAt(754)));
            }
            int iB6 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_gdprApplies");
            if (iB6 != -1) {
                map.put("gdprApplies", String.valueOf(iB6));
            }
            int iB7 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_EnableAdvertiserConsentMode");
            if (iB7 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(iB7));
            }
            int iB8 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_PolicyVersion");
            if (iB8 != -1) {
                map.put("PolicyVersion", String.valueOf(iB8));
            }
            String strA8 = AbstractC0732z6.a(sharedPreferencesQ, "IABTCF_PurposeConsents");
            if (!"".equals(strA8)) {
                map.put("PurposeConsents", strA8);
            }
            int iB9 = AbstractC0732z6.b(sharedPreferencesQ, "IABTCF_CmpSdkID");
            if (iB9 != -1) {
                map.put("CmpSdkID", String.valueOf(iB9));
            }
            c0716x6 = new C0716x6(map);
        }
        c0658q3.a().w().b("Tcf preferences read", c0716x6);
        if (!c0658q3.w().H(null, c0561e2)) {
            if (c0658q3.x().x(c0716x6)) {
                Bundle bundleB = c0716x6.b();
                c0658q3.a().w().b("Consent generated from Tcf", bundleB);
                if (bundleB != Bundle.EMPTY) {
                    n0(bundleB, -30, c0658q3.f().currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", c0716x6.e());
                t("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        Q2 q2X = c0658q3.x();
        q2X.h();
        String string = q2X.p().getString("stored_tcf_param", "");
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            c0716x62 = new C0716x6(map2);
        } else {
            for (String str : string.split(";")) {
                String[] strArrSplit = str.split(com.amazon.a.a.o.b.f.f8805b);
                if (strArrSplit.length >= 2 && AbstractC0732z6.f5091a.contains(strArrSplit[0])) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            c0716x62 = new C0716x6(map2);
        }
        if (c0658q3.x().x(c0716x6)) {
            Bundle bundleB2 = c0716x6.b();
            c0658q3.a().w().b("Consent generated from Tcf", bundleB2);
            if (bundleB2 != Bundle.EMPTY) {
                n0(bundleB2, -30, c0658q3.f().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfm", c0716x6.d(c0716x62));
            bundle2.putString("_tcfd2", c0716x6.c());
            bundle2.putString("_tcfd", c0716x6.e());
            t("auto", "_tcf", bundle2);
        }
    }

    public final void r0(long j4) {
        h();
        if (this.f4363l == null) {
            this.f4363l = new C0603j4(this, this.f4245a);
        }
        this.f4363l.b(j4);
    }

    public final void s() {
        h();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().v().a("Register tcfPrefChangeListener.");
        if (this.f4372u == null) {
            this.f4373v = new C0666r4(this, this.f4245a);
            this.f4372u = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: S1.V4
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    this.f4265a.S(sharedPreferences, str);
                }
            };
        }
        c0658q3.x().q().registerOnSharedPreferenceChangeListener(this.f4372u);
    }

    public final void s0() {
        h();
        A a4 = this.f4363l;
        if (a4 != null) {
            a4.d();
        }
    }

    public final void t(String str, String str2, Bundle bundle) {
        h();
        u(str, str2, this.f4245a.f().currentTimeMillis(), bundle);
    }

    public final void t0() {
        zzql.zza();
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.w().H(null, AbstractC0569f2.f4537R0)) {
            if (c0658q3.b().p()) {
                c0658q3.a().o().a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            c0658q3.c();
            if (C0566f.a()) {
                c0658q3.a().o().a("Cannot get trigger URIs from main thread");
                return;
            }
            j();
            c0658q3.a().w().a("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            c0658q3.b().u(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: S1.P4
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    C0540b5 c0540b5 = this.f4168a;
                    c0540b5.f4245a.J().i0(atomicReference, c0540b5.f4245a.x().f4193o.a());
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                c0658q3.a().q().a("Timed out waiting for get trigger URIs");
            } else {
                c0658q3.b().t(new Runnable() { // from class: S1.S4
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        C0540b5 c0540b5 = this.f4236a;
                        c0540b5.h();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        List<B6> list2 = list;
                        SparseArray sparseArrayR = c0540b5.f4245a.x().r();
                        for (B6 b6 : list2) {
                            int i4 = b6.f3873c;
                            if (!sparseArrayR.contains(i4) || ((Long) sparseArrayR.get(i4)).longValue() < b6.f3872b) {
                                c0540b5.v0().add(b6);
                            }
                        }
                        c0540b5.w0();
                    }
                });
            }
        }
    }

    public final void u(String str, String str2, long j4, Bundle bundle) {
        h();
        boolean z4 = true;
        if (this.f4355d != null && !l7.N(str2)) {
            z4 = false;
        }
        v(str, str2, j4, bundle, true, z4, true, null);
    }

    public final boolean u0() {
        return this.f4365n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(String str, String str2, long j4, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        boolean z7;
        int i4;
        C0658q3 c0658q3;
        long j5;
        long j6;
        String str4;
        C0658q3 c0658q32;
        long j7;
        Bundle[] bundleArr;
        String str5 = str;
        AbstractC0940s.e(str5);
        AbstractC0940s.k(bundle);
        h();
        j();
        C0658q3 c0658q33 = this.f4245a;
        if (!c0658q33.g()) {
            this.f4245a.a().v().a("Event not sent since app measurement is disabled");
            return;
        }
        List listW = this.f4245a.L().w();
        if (listW != null && !listW.contains(str2)) {
            this.f4245a.a().v().c("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.f4357f) {
            this.f4357f = true;
            try {
                try {
                    (!c0658q33.G() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.f4245a.e().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.f4245a.e());
                } catch (Exception e4) {
                    this.f4245a.a().r().b("Failed to invoke Tag Manager's initialize() method", e4);
                }
            } catch (ClassNotFoundException unused) {
                this.f4245a.a().u().a("Tag Manager is not found and thus will not be used");
            }
        }
        C0658q3 c0658q34 = this.f4245a;
        if (!c0658q34.w().H(null, AbstractC0569f2.f4577h1) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
            c0658q34.c();
            B("auto", "_lgclid", bundle.getString("gclid"), c0658q34.f().currentTimeMillis());
        }
        C0540b5 c0540b5 = this;
        c0658q34.c();
        if (z4 && l7.U(str2)) {
            c0658q34.C().w(bundle, c0658q34.x().f4204z.a());
        }
        if (!z6) {
            c0658q34.c();
            if (!"_iap".equals(str2)) {
                C0658q3 c0658q35 = c0540b5.f4245a;
                l7 l7VarC = c0658q35.C();
                int i5 = 2;
                if (l7VarC.t0("event", str2)) {
                    if (l7VarC.v0("event", AbstractC0539b4.f4350a, AbstractC0539b4.f4351b, str2)) {
                        l7VarC.f4245a.w();
                        if (l7VarC.w0("event", 40, str2)) {
                            i5 = 0;
                        }
                    } else {
                        i5 = 13;
                    }
                }
                if (i5 != 0) {
                    c0658q34.a().q().b("Invalid public event name. Event will not be logged (FE)", c0658q34.D().a(str2));
                    l7 l7VarC2 = c0658q35.C();
                    c0658q35.w();
                    c0658q35.C().B(c0540b5.f4374w, null, i5, "_ev", l7VarC2.q(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        c0658q34.c();
        C0658q3 c0658q36 = c0540b5.f4245a;
        C0628m5 c0628m5Q = c0658q36.I().q(false);
        if (c0628m5Q != null && !bundle.containsKey("_sc")) {
            c0628m5Q.f4754d = true;
        }
        l7.k0(c0628m5Q, bundle, z4 && !z6);
        boolean zEquals = "am".equals(str5);
        boolean zN = l7.N(str2);
        if (!z4 || c0540b5.f4355d == null || zN) {
            z7 = zEquals;
        } else {
            if (!zEquals) {
                c0658q34.a().v().c("Passing event to registered event handler (FE)", c0658q34.D().a(str2), c0658q34.D().e(bundle));
                AbstractC0940s.k(c0540b5.f4355d);
                c0540b5.f4355d.a(str5, str2, bundle, j4);
                return;
            }
            z7 = true;
        }
        C0658q3 c0658q37 = c0540b5.f4245a;
        if (c0658q37.m()) {
            int iX0 = c0658q34.C().x0(str2);
            if (iX0 != 0) {
                c0658q34.a().q().b("Invalid event name. Event will not be logged (FE)", c0658q34.D().a(str2));
                l7 l7VarC3 = c0658q34.C();
                c0658q34.w();
                c0658q37.C().B(c0540b5.f4374w, str3, iX0, "_ev", l7VarC3.q(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle bundleT = c0658q34.C().t(str3, str2, bundle, G1.e.b("_o", "_sn", "_sc", "_si"), z6);
            AbstractC0940s.k(bundleT);
            c0658q34.c();
            if (c0658q36.I().q(false) == null || !io.flutter.plugins.firebase.crashlytics.Constants.FIREBASE_APPLICATION_EXCEPTION.equals(str2)) {
                i4 = 0;
                c0658q3 = c0658q36;
                j5 = 0;
            } else {
                C0684t6 c0684t6 = c0658q36.z().f5022f;
                j5 = 0;
                long jA = c0684t6.f4956d.f4245a.f().a();
                i4 = 0;
                c0658q3 = c0658q36;
                long j8 = jA - c0684t6.f4954b;
                c0684t6.f4954b = jA;
                if (j8 > 0) {
                    c0658q34.C().Z(bundleT, j8);
                }
            }
            if (!"auto".equals(str5) && "_ssr".equals(str2)) {
                l7 l7VarC4 = c0658q34.C();
                String string = bundleT.getString("_ffr");
                if (G1.q.b(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                C0658q3 c0658q38 = l7VarC4.f4245a;
                if (Objects.equals(string, c0658q38.x().f4201w.a())) {
                    c0658q38.a().v().a("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                c0658q38.x().f4201w.b(string);
            } else if (io.flutter.plugins.firebase.crashlytics.Constants.FIREBASE_APPLICATION_EXCEPTION.equals(str2)) {
                String strA = c0658q34.C().f4245a.x().f4201w.a();
                if (!TextUtils.isEmpty(strA)) {
                    bundleT.putString("_ffr", strA);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleT);
            boolean zP = c0658q34.w().H(null, AbstractC0569f2.f4545V0) ? c0658q3.z().p() : c0658q34.x().f4198t.a();
            if (c0658q34.x().f4195q.a() > j5) {
                c0658q32 = c0658q34;
                if (c0658q34.x().A(j4) && zP) {
                    c0658q32.a().w().a("Current session is expired, remove the session number, ID, and engagement time");
                    long jCurrentTimeMillis = c0658q32.f().currentTimeMillis();
                    j6 = j5;
                    str4 = io.flutter.plugins.firebase.crashlytics.Constants.FIREBASE_APPLICATION_EXCEPTION;
                    B("auto", "_sid", null, jCurrentTimeMillis);
                    B("auto", "_sno", null, c0658q32.f().currentTimeMillis());
                    B("auto", "_se", null, c0658q32.f().currentTimeMillis());
                    c0540b5 = this;
                    c0658q32.x().f4196r.b(j6);
                } else {
                    j6 = j5;
                    str4 = io.flutter.plugins.firebase.crashlytics.Constants.FIREBASE_APPLICATION_EXCEPTION;
                }
            } else {
                j6 = j5;
                str4 = io.flutter.plugins.firebase.crashlytics.Constants.FIREBASE_APPLICATION_EXCEPTION;
                c0658q32 = c0658q34;
            }
            if (bundleT.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j6) == 1) {
                c0658q32.a().w().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                j7 = j4;
                c0658q37.z().f5021e.b(j7, true);
            } else {
                j7 = j4;
            }
            ArrayList arrayList2 = new ArrayList(bundleT.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i6 = i4; i6 < size; i6++) {
                String str6 = (String) arrayList2.get(i6);
                if (str6 != null) {
                    c0658q32.C();
                    Object obj = bundleT.get(str6);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[1];
                        bundleArr[i4] = (Bundle) obj;
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleT.putParcelableArray(str6, bundleArr);
                    }
                }
            }
            int i7 = i4;
            while (i7 < arrayList.size()) {
                Bundle bundleQ = (Bundle) arrayList.get(i7);
                String str7 = i7 != 0 ? "_ep" : str2;
                bundleQ.putString("_o", str5);
                if (z5) {
                    bundleQ = c0658q32.C().Q(bundleQ, null);
                }
                Bundle bundle2 = bundleQ;
                c0658q3.J().c0(new J(str7, new H(bundle2), str5, j7), str3);
                if (!z7) {
                    Iterator it = c0540b5.f4356e.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0571f4) it.next()).onEvent(str, str2, new Bundle(bundle2), j4);
                    }
                }
                i7++;
                str5 = str;
                j7 = j4;
            }
            c0658q32.c();
            if (c0658q3.I().q(i4) == null || !str4.equals(str2)) {
                return;
            }
            c0658q3.z().f5022f.d(true, true, c0658q32.f().a());
        }
    }

    public final PriorityQueue v0() {
        if (this.f4364m == null) {
            this.f4364m = new PriorityQueue(Comparator.comparing(new Function() { // from class: S1.T4
                @Override // java.util.function.Function
                public final /* synthetic */ Object apply(Object obj) {
                    return Long.valueOf(((B6) obj).f3872b);
                }
            }, new Comparator() { // from class: S1.U4
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.f4364m;
    }

    public final void w(String str, String str2, Bundle bundle, String str3) {
        C0658q3.q();
        x("auto", str2, this.f4245a.f().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void w0() {
        B6 b6;
        h();
        this.f4365n = false;
        if (v0().isEmpty() || this.f4360i || (b6 = (B6) v0().poll()) == null) {
            return;
        }
        C0658q3 c0658q3 = this.f4245a;
        AbstractC1566a abstractC1566aH = c0658q3.C().H();
        if (abstractC1566aH != null) {
            this.f4360i = true;
            A2 a2W = c0658q3.a().w();
            String str = b6.f3871a;
            a2W.b("Registering trigger URI", str);
            InterfaceFutureC1233e interfaceFutureC1233eC = abstractC1566aH.c(Uri.parse(str));
            if (interfaceFutureC1233eC != null) {
                AbstractC1231c.a(interfaceFutureC1233eC, new C0619l4(this, b6), new ExecutorC0611k4(this));
            } else {
                this.f4360i = false;
                v0().add(b6);
            }
        }
    }

    public final void x(String str, String str2, long j4, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        String[] strArr = l7.f4736i;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i4 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i4 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i4];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i4] = new Bundle((Bundle) parcelable);
                        }
                        i4++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i4 < list.size()) {
                        Object obj2 = list.get(i4);
                        if (obj2 instanceof Bundle) {
                            list.set(i4, new Bundle((Bundle) obj2));
                        }
                        i4++;
                    }
                }
            }
        }
        this.f4245a.b().t(new RunnableC0674s4(this, str, str2, j4, bundle2, z4, z5, z6, str3));
    }

    public final void y(String str, String str2, Object obj, boolean z4) {
        z("auto", "_ldl", obj, true, this.f4245a.f().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(java.lang.String r17, java.lang.String r18, java.lang.Object r19, boolean r20, long r21) {
        /*
            r16 = this;
            r0 = r16
            r2 = r18
            r1 = r19
            r3 = 0
            r4 = 24
            if (r20 == 0) goto L17
            S1.q3 r5 = r0.f4245a
            S1.l7 r5 = r5.C()
            int r5 = r5.y0(r2)
        L15:
            r12 = r5
            goto L41
        L17:
            S1.q3 r5 = r0.f4245a
            S1.l7 r5 = r5.C()
            java.lang.String r6 = "user property"
            boolean r7 = r5.t0(r6, r2)
            r8 = 6
            if (r7 != 0) goto L28
        L26:
            r12 = r8
            goto L41
        L28:
            java.lang.String[] r7 = S1.AbstractC0555d4.f4451a
            r9 = 0
            boolean r7 = r5.v0(r6, r7, r9, r2)
            if (r7 != 0) goto L34
            r5 = 15
            goto L15
        L34:
            S1.q3 r7 = r5.f4245a
            r7.w()
            boolean r5 = r5.w0(r6, r4, r2)
            if (r5 != 0) goto L40
            goto L26
        L40:
            r12 = r3
        L41:
            r5 = 1
            if (r12 == 0) goto L67
            S1.q3 r1 = r0.f4245a
            S1.l7 r6 = r1.C()
            r1.w()
            java.lang.String r14 = r6.q(r2, r4, r5)
            if (r2 == 0) goto L57
            int r3 = r2.length()
        L57:
            r15 = r3
            S1.q3 r1 = r0.f4245a
            S1.k7 r10 = r0.f4374w
            S1.l7 r9 = r1.C()
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.B(r10, r11, r12, r13, r14, r15)
            return
        L67:
            if (r17 != 0) goto L6c
            java.lang.String r6 = "app"
            goto L6e
        L6c:
            r6 = r17
        L6e:
            if (r1 == 0) goto Lbb
            S1.q3 r7 = r0.f4245a
            S1.l7 r8 = r7.C()
            int r12 = r8.y(r2, r1)
            if (r12 == 0) goto Laa
            S1.l7 r6 = r7.C()
            r7.w()
            java.lang.String r14 = r6.q(r2, r4, r5)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L92
            boolean r2 = r1 instanceof java.lang.CharSequence
            if (r2 == 0) goto L90
            goto L92
        L90:
            r15 = r3
            goto L9b
        L92:
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            goto L90
        L9b:
            S1.q3 r1 = r0.f4245a
            S1.k7 r10 = r0.f4374w
            S1.l7 r9 = r1.C()
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.B(r10, r11, r12, r13, r14, r15)
            return
        Laa:
            S1.l7 r3 = r7.C()
            java.lang.Object r5 = r3.z(r2, r1)
            if (r5 == 0) goto Lba
            r3 = r21
            r1 = r6
            r0.A(r1, r2, r3, r5)
        Lba:
            return
        Lbb:
            r1 = r6
            r5 = 0
            r0 = r16
            r2 = r18
            r3 = r21
            r0.A(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0540b5.z(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }
}
