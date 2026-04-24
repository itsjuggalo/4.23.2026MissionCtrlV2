package S1;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: S1.q3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0658q3 implements V3 {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static volatile C0658q3 f4850E;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f4851A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f4852B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final long f4854D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0566f f4857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0622m f4858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Q2 f4859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2 f4860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0594i3 f4861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0708w6 f4862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l7 f4863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0696v2 f4864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final G1.d f4865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0691u5 f4866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C0540b5 f4867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final F0 f4868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C0580g5 f4869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f4870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public C0680t2 f4871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0565e6 f4872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public D f4873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public C0657q2 f4874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public C0596i5 f4875u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f4877w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f4878x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile Boolean f4879y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f4880z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4876v = false;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final AtomicInteger f4853C = new AtomicInteger(0);

    public C0658q3(C0587h4 c0587h4) {
        AbstractC0940s.k(c0587h4);
        Context context = c0587h4.f4651a;
        C0566f c0566f = new C0566f(context);
        this.f4857c = c0566f;
        Z1.f4313a = c0566f;
        this.f4855a = context;
        this.f4856b = c0587h4.f4655e;
        this.f4879y = c0587h4.f4652b;
        this.f4870p = c0587h4.f4657g;
        this.f4880z = true;
        zzkl.zzb(context);
        G1.d dVarC = G1.g.c();
        this.f4865k = dVarC;
        Long l4 = c0587h4.f4656f;
        this.f4854D = l4 != null ? l4.longValue() : dVarC.currentTimeMillis();
        this.f4858d = new C0622m(this);
        Q2 q22 = new Q2(this);
        q22.m();
        this.f4859e = q22;
        C2 c22 = new C2(this);
        c22.m();
        this.f4860f = c22;
        l7 l7Var = new l7(this);
        l7Var.m();
        this.f4863i = l7Var;
        this.f4864j = new C0696v2(new C0579g4(c0587h4, this));
        this.f4868n = new F0(this);
        C0691u5 c0691u5 = new C0691u5(this);
        c0691u5.k();
        this.f4866l = c0691u5;
        C0540b5 c0540b5 = new C0540b5(this);
        c0540b5.k();
        this.f4867m = c0540b5;
        C0708w6 c0708w6 = new C0708w6(this);
        c0708w6.k();
        this.f4862h = c0708w6;
        C0580g5 c0580g5 = new C0580g5(this);
        c0580g5.m();
        this.f4869o = c0580g5;
        C0594i3 c0594i3 = new C0594i3(this);
        c0594i3.m();
        this.f4861g = c0594i3;
        zzdd zzddVar = c0587h4.f4654d;
        boolean z4 = zzddVar == null || zzddVar.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            t(c0540b5);
            if (c0540b5.f4245a.f4855a.getApplicationContext() instanceof Application) {
                Application application = (Application) c0540b5.f4245a.f4855a.getApplicationContext();
                if (c0540b5.f4354c == null) {
                    c0540b5.f4354c = new N4(c0540b5);
                }
                if (z4) {
                    application.unregisterActivityLifecycleCallbacks(c0540b5.f4354c);
                    application.registerActivityLifecycleCallbacks(c0540b5.f4354c);
                    C2 c23 = c0540b5.f4245a.f4860f;
                    u(c23);
                    c23.w().a("Registered activity lifecycle callback");
                }
            }
        } else {
            u(c22);
            c22.r().a("Application context is not an Application");
        }
        c0594i3.t(new RunnableC0602j3(this, c0587h4));
    }

    public static C0658q3 O(Context context, zzdd zzddVar, Long l4) {
        Bundle bundle;
        if (zzddVar != null) {
            Bundle bundle2 = zzddVar.zzd;
            zzddVar = new zzdd(zzddVar.zza, zzddVar.zzb, zzddVar.zzc, bundle2, null);
        }
        AbstractC0940s.k(context);
        AbstractC0940s.k(context.getApplicationContext());
        if (f4850E == null) {
            synchronized (C0658q3.class) {
                try {
                    if (f4850E == null) {
                        f4850E = new C0658q3(new C0587h4(context, zzddVar, l4));
                    }
                } finally {
                }
            }
        } else if (zzddVar != null && (bundle = zzddVar.zzd) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            AbstractC0940s.k(f4850E);
            f4850E.f4879y = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        AbstractC0940s.k(f4850E);
        return f4850E;
    }

    public static final void q() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public static final void r(H1 h12) {
        if (h12 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void s(T3 t32) {
        if (t32 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void t(AbstractC0593i2 abstractC0593i2) {
        if (abstractC0593i2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!abstractC0593i2.i()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(abstractC0593i2.getClass())));
        }
    }

    public static final void u(U3 u32) {
        if (u32 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!u32.k()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(u32.getClass())));
        }
    }

    public final C0594i3 A() {
        return this.f4861g;
    }

    public final C0540b5 B() {
        C0540b5 c0540b5 = this.f4867m;
        t(c0540b5);
        return c0540b5;
    }

    public final l7 C() {
        l7 l7Var = this.f4863i;
        s(l7Var);
        return l7Var;
    }

    public final C0696v2 D() {
        return this.f4864j;
    }

    public final C0680t2 E() {
        t(this.f4871q);
        return this.f4871q;
    }

    public final C0580g5 F() {
        C0580g5 c0580g5 = this.f4869o;
        u(c0580g5);
        return c0580g5;
    }

    public final boolean G() {
        return this.f4856b;
    }

    public final String H() {
        return this.f4870p;
    }

    public final C0691u5 I() {
        C0691u5 c0691u5 = this.f4866l;
        t(c0691u5);
        return c0691u5;
    }

    public final C0565e6 J() {
        t(this.f4872r);
        return this.f4872r;
    }

    public final D K() {
        u(this.f4873s);
        return this.f4873s;
    }

    public final C0657q2 L() {
        t(this.f4874t);
        return this.f4874t;
    }

    public final F0 M() {
        F0 f02 = this.f4868n;
        r(f02);
        return f02;
    }

    public final C0596i5 N() {
        r(this.f4875u);
        return this.f4875u;
    }

    public final void P(boolean z4) {
        this.f4879y = Boolean.valueOf(z4);
    }

    @Override // S1.V3
    public final C2 a() {
        C2 c22 = this.f4860f;
        u(c22);
        return c22;
    }

    @Override // S1.V3
    public final C0594i3 b() {
        C0594i3 c0594i3 = this.f4861g;
        u(c0594i3);
        return c0594i3;
    }

    @Override // S1.V3
    public final C0566f c() {
        return this.f4857c;
    }

    public final boolean d() {
        return this.f4879y != null && this.f4879y.booleanValue();
    }

    @Override // S1.V3
    public final Context e() {
        return this.f4855a;
    }

    @Override // S1.V3
    public final G1.d f() {
        return this.f4865k;
    }

    public final boolean g() {
        return h() == 0;
    }

    public final int h() {
        C0594i3 c0594i3 = this.f4861g;
        u(c0594i3);
        c0594i3.h();
        C0622m c0622m = this.f4858d;
        if (c0622m.L()) {
            return 1;
        }
        u(c0594i3);
        c0594i3.h();
        if (!this.f4880z) {
            return 8;
        }
        Q2 q22 = this.f4859e;
        s(q22);
        Boolean boolT = q22.t();
        if (boolT != null) {
            return boolT.booleanValue() ? 0 : 3;
        }
        C0566f c0566f = c0622m.f4245a.f4857c;
        Boolean boolJ = c0622m.J("firebase_analytics_collection_enabled");
        return boolJ != null ? boolJ.booleanValue() ? 0 : 4 : (this.f4879y == null || this.f4879y.booleanValue()) ? 0 : 7;
    }

    public final void i(boolean z4) {
        C0594i3 c0594i3 = this.f4861g;
        u(c0594i3);
        c0594i3.h();
        this.f4880z = z4;
    }

    public final boolean j() {
        C0594i3 c0594i3 = this.f4861g;
        u(c0594i3);
        c0594i3.h();
        return this.f4880z;
    }

    public final void k() {
        this.f4851A++;
    }

    public final void l() {
        this.f4853C.incrementAndGet();
    }

    public final boolean m() {
        if (!this.f4876v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        C0594i3 c0594i3 = this.f4861g;
        u(c0594i3);
        c0594i3.h();
        Boolean bool = this.f4877w;
        if (bool == null || this.f4878x == 0 || (!bool.booleanValue() && Math.abs(this.f4865k.a() - this.f4878x) > 1000)) {
            this.f4878x = this.f4865k.a();
            l7 l7Var = this.f4863i;
            s(l7Var);
            boolean z4 = false;
            if (l7Var.M("android.permission.INTERNET")) {
                s(l7Var);
                if (l7Var.M("android.permission.ACCESS_NETWORK_STATE")) {
                    Context context = this.f4855a;
                    if (I1.f.a(context).f() || this.f4858d.m() || (l7.j0(context) && l7.E(context, false))) {
                        z4 = true;
                    }
                }
            }
            Boolean boolValueOf = Boolean.valueOf(z4);
            this.f4877w = boolValueOf;
            if (boolValueOf.booleanValue()) {
                s(l7Var);
                this.f4877w = Boolean.valueOf(l7Var.o(L().r()));
            }
        }
        return this.f4877w.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0658q3.n():boolean");
    }

    public final /* synthetic */ void o(String str, int i4, Throwable th, byte[] bArr, Map map) {
        int i5;
        if (i4 != 200 && i4 != 204) {
            i5 = RCHTTPStatusCodes.NOT_MODIFIED;
            if (i4 != 304) {
                i5 = i4;
            }
            C2 c22 = this.f4860f;
            u(c22);
            c22.r().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i5), th);
        }
        i5 = i4;
        if (th == null) {
            Q2 q22 = this.f4859e;
            s(q22);
            q22.f4199u.b(true);
            if (bArr == null || bArr.length == 0) {
                C2 c23 = this.f4860f;
                u(c23);
                c23.v().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String strOptString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(strOptString)) {
                    C2 c24 = this.f4860f;
                    u(c24);
                    c24.v().a("Deferred Deep Link is empty.");
                    return;
                }
                String strOptString2 = jSONObject.optString("gclid", "");
                String strOptString3 = jSONObject.optString("gbraid", "");
                String strOptString4 = jSONObject.optString("gad_source", "");
                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                Bundle bundle = new Bundle();
                l7 l7Var = this.f4863i;
                s(l7Var);
                C0658q3 c0658q3 = l7Var.f4245a;
                if (!TextUtils.isEmpty(strOptString)) {
                    Context context = c0658q3.f4855a;
                    List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                    if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(strOptString3)) {
                            bundle.putString("gbraid", strOptString3);
                        }
                        if (!TextUtils.isEmpty(strOptString4)) {
                            bundle.putString("gad_source", strOptString4);
                        }
                        bundle.putString("gclid", strOptString2);
                        bundle.putString("_cis", "ddp");
                        this.f4867m.t("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        s(l7Var);
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            editorEdit.putString("deeplink", strOptString);
                            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                            if (editorEdit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = l7Var.f4245a.f4855a;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                } else {
                                    context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                    return;
                                }
                            }
                            return;
                        } catch (RuntimeException e4) {
                            C2 c25 = l7Var.f4245a.f4860f;
                            u(c25);
                            c25.o().b("Failed to persist Deferred Deep Link. exception", e4);
                            return;
                        }
                    }
                }
                C2 c26 = this.f4860f;
                u(c26);
                c26.r().d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            } catch (JSONException e5) {
                C2 c27 = this.f4860f;
                u(c27);
                c27.o().b("Failed to parse the Deferred Deep Link response. exception", e5);
                return;
            }
        }
        C2 c222 = this.f4860f;
        u(c222);
        c222.r().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i5), th);
    }

    public final /* synthetic */ void p(C0587h4 c0587h4) {
        C0594i3 c0594i3 = this.f4861g;
        u(c0594i3);
        c0594i3.h();
        C0622m c0622m = this.f4858d;
        c0622m.u();
        D d4 = new D(this);
        d4.m();
        this.f4873s = d4;
        zzdd zzddVar = c0587h4.f4654d;
        C0657q2 c0657q2 = new C0657q2(this, c0587h4.f4653c, zzddVar == null ? 0L : zzddVar.zza);
        c0657q2.k();
        this.f4874t = c0657q2;
        C0680t2 c0680t2 = new C0680t2(this);
        c0680t2.k();
        this.f4871q = c0680t2;
        C0565e6 c0565e6 = new C0565e6(this);
        c0565e6.k();
        this.f4872r = c0565e6;
        l7 l7Var = this.f4863i;
        l7Var.n();
        this.f4859e.n();
        this.f4874t.l();
        C0596i5 c0596i5 = new C0596i5(this);
        c0596i5.k();
        this.f4875u = c0596i5;
        c0596i5.l();
        C2 c22 = this.f4860f;
        u(c22);
        A2 a2U = c22.u();
        c0622m.A();
        a2U.b("App measurement initialized, version", 130000L);
        u(c22);
        c22.u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strQ = c0657q2.q();
        s(l7Var);
        if (l7Var.P(strQ, c0622m.R())) {
            u(c22);
            c22.u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        } else {
            u(c22);
            c22.u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strQ)));
        }
        u(c22);
        c22.v().a("Debug-level message logging enabled");
        int i4 = this.f4851A;
        AtomicInteger atomicInteger = this.f4853C;
        if (i4 != atomicInteger.get()) {
            u(c22);
            c22.o().c("Not all components initialized", Integer.valueOf(this.f4851A), Integer.valueOf(atomicInteger.get()));
        }
        this.f4876v = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(com.google.android.gms.internal.measurement.zzdd r14) {
        /*
            Method dump skipped, instruction units count: 1043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0658q3.v(com.google.android.gms.internal.measurement.zzdd):void");
    }

    public final C0622m w() {
        return this.f4858d;
    }

    public final Q2 x() {
        Q2 q22 = this.f4859e;
        s(q22);
        return q22;
    }

    public final C2 y() {
        C2 c22 = this.f4860f;
        if (c22 == null || !c22.k()) {
            return null;
        }
        return c22;
    }

    public final C0708w6 z() {
        C0708w6 c0708w6 = this.f4862h;
        t(c0708w6);
        return c0708w6;
    }
}
