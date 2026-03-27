package com.google.firebase.messaging;

import C3.a;
import P1.C0757a;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.messaging.Y;
import com.google.firebase.messaging.d0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import l2.InterfaceC2324h;
import l2.InterfaceC2327k;
import w1.InterfaceC2907j;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static d0 f15593m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static ScheduledExecutorService f15595o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2.f f15596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f15597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G f15598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Y f15599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f15600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f15601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f15602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AbstractC2328l f15603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final L f15604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f15606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f15592l = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static S3.b f15594n = new S3.b() { // from class: com.google.firebase.messaging.u
        @Override // S3.b
        public final Object get() {
            return FirebaseMessaging.K();
        }
    };

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A3.d f15607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public A3.b f15609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f15610d;

        public a(A3.d dVar) {
            this.f15607a = dVar;
        }

        public synchronized void b() {
            try {
                if (this.f15608b) {
                    return;
                }
                Boolean boolE = e();
                this.f15610d = boolE;
                if (boolE == null) {
                    A3.b bVar = new A3.b() { // from class: com.google.firebase.messaging.D
                        @Override // A3.b
                        public final void handle(A3.a aVar) {
                            this.f15589a.d(aVar);
                        }
                    };
                    this.f15609c = bVar;
                    this.f15607a.a(G2.b.class, bVar);
                }
                this.f15608b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f15610d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f15596a.x();
        }

        public final /* synthetic */ void d(A3.a aVar) {
            if (c()) {
                FirebaseMessaging.this.T();
            }
        }

        public final Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextM = FirebaseMessaging.this.f15596a.m();
            SharedPreferences sharedPreferences = contextM.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = contextM.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(contextM.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public synchronized void f(boolean z7) {
            try {
                b();
                A3.b bVar = this.f15609c;
                if (bVar != null) {
                    this.f15607a.b(G2.b.class, bVar);
                    this.f15609c = null;
                }
                SharedPreferences.Editor editorEdit = FirebaseMessaging.this.f15596a.m().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                editorEdit.putBoolean("auto_init", z7);
                editorEdit.apply();
                if (z7) {
                    FirebaseMessaging.this.T();
                }
                this.f15610d = Boolean.valueOf(z7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public FirebaseMessaging(G2.f fVar, C3.a aVar, S3.b bVar, A3.d dVar, L l8, G g8, Executor executor, Executor executor2, Executor executor3) {
        this.f15605j = false;
        f15594n = bVar;
        this.f15596a = fVar;
        this.f15600e = new a(dVar);
        Context contextM = fVar.m();
        this.f15597b = contextM;
        C1446q c1446q = new C1446q();
        this.f15606k = c1446q;
        this.f15604i = l8;
        this.f15598c = g8;
        this.f15599d = new Y(executor);
        this.f15601f = executor2;
        this.f15602g = executor3;
        Context contextM2 = fVar.m();
        if (contextM2 instanceof Application) {
            ((Application) contextM2).registerActivityLifecycleCallbacks(c1446q);
        } else {
            Log.w("FirebaseMessaging", "Context " + contextM2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new a.InterfaceC0011a() { // from class: com.google.firebase.messaging.y
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f15804a.H();
            }
        });
        AbstractC2328l abstractC2328lF = i0.f(this, l8, g8, contextM, AbstractC1444o.g());
        this.f15603h = abstractC2328lF;
        abstractC2328lF.f(executor2, new InterfaceC2324h() { // from class: com.google.firebase.messaging.A
            @Override // l2.InterfaceC2324h
            public final void onSuccess(Object obj) {
                this.f15586a.I((i0) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.B
            @Override // java.lang.Runnable
            public final void run() {
                this.f15587a.J();
            }
        });
    }

    public static /* synthetic */ InterfaceC2907j K() {
        return null;
    }

    public static /* synthetic */ AbstractC2328l L(String str, i0 i0Var) {
        return i0Var.r(str);
    }

    public static /* synthetic */ AbstractC2328l M(String str, i0 i0Var) {
        return i0Var.u(str);
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(G2.f fVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) fVar.k(FirebaseMessaging.class);
        AbstractC1294n.k(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public static synchronized FirebaseMessaging r() {
        return getInstance(G2.f.o());
    }

    public static synchronized d0 s(Context context) {
        try {
            if (f15593m == null) {
                f15593m = new d0(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15593m;
    }

    public static InterfaceC2907j w() {
        return (InterfaceC2907j) f15594n.get();
    }

    public boolean A() {
        return this.f15600e.c();
    }

    public boolean B() {
        return this.f15604i.g();
    }

    public final /* synthetic */ AbstractC2328l C(String str, d0.a aVar, String str2) {
        s(this.f15597b).g(t(), str, str2, this.f15604i.a());
        if (aVar == null || !str2.equals(aVar.f15712a)) {
            z(str2);
        }
        return AbstractC2331o.e(str2);
    }

    public final /* synthetic */ AbstractC2328l D(final String str, final d0.a aVar) {
        return this.f15598c.g().p(this.f15602g, new InterfaceC2327k() { // from class: com.google.firebase.messaging.t
            @Override // l2.InterfaceC2327k
            public final AbstractC2328l a(Object obj) {
                return this.f15795a.C(str, aVar, (String) obj);
            }
        });
    }

    public final /* synthetic */ void E(C2329m c2329m) {
        try {
            AbstractC2331o.a(this.f15598c.c());
            s(this.f15597b).d(t(), L.c(this.f15596a));
            c2329m.c(null);
        } catch (Exception e8) {
            c2329m.b(e8);
        }
    }

    public final /* synthetic */ void F(C2329m c2329m) {
        try {
            c2329m.c(n());
        } catch (Exception e8) {
            c2329m.b(e8);
        }
    }

    public final /* synthetic */ void G(C0757a c0757a) {
        if (c0757a != null) {
            K.y(c0757a.a());
            x();
        }
    }

    public final /* synthetic */ void H() {
        if (A()) {
            T();
        }
    }

    public final /* synthetic */ void I(i0 i0Var) {
        if (A()) {
            i0Var.q();
        }
    }

    public void N(V v8) {
        if (TextUtils.isEmpty(v8.I())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(this.f15597b, 0, intent2, 67108864));
        intent.setPackage("com.google.android.gms");
        v8.K(intent);
        this.f15597b.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void O(boolean z7) {
        this.f15600e.f(z7);
    }

    public void P(boolean z7) {
        K.B(z7);
        U.g(this.f15597b, this.f15598c, R());
    }

    public synchronized void Q(boolean z7) {
        this.f15605j = z7;
    }

    public final boolean R() {
        S.c(this.f15597b);
        if (!S.d(this.f15597b)) {
            return false;
        }
        if (this.f15596a.k(AnalyticsConnector.class) != null) {
            return true;
        }
        return K.a() && f15594n != null;
    }

    public final synchronized void S() {
        if (!this.f15605j) {
            V(0L);
        }
    }

    public final void T() {
        if (W(v())) {
            S();
        }
    }

    public AbstractC2328l U(final String str) {
        return this.f15603h.q(new InterfaceC2327k() { // from class: com.google.firebase.messaging.r
            @Override // l2.InterfaceC2327k
            public final AbstractC2328l a(Object obj) {
                return FirebaseMessaging.L(str, (i0) obj);
            }
        });
    }

    public synchronized void V(long j8) {
        p(new e0(this, Math.min(Math.max(30L, 2 * j8), f15592l)), j8);
        this.f15605j = true;
    }

    public boolean W(d0.a aVar) {
        return aVar == null || aVar.b(this.f15604i.a());
    }

    public AbstractC2328l X(final String str) {
        return this.f15603h.q(new InterfaceC2327k() { // from class: com.google.firebase.messaging.w
            @Override // l2.InterfaceC2327k
            public final AbstractC2328l a(Object obj) {
                return FirebaseMessaging.M(str, (i0) obj);
            }
        });
    }

    public String n() throws IOException {
        final d0.a aVarV = v();
        if (!W(aVarV)) {
            return aVarV.f15712a;
        }
        final String strC = L.c(this.f15596a);
        try {
            return (String) AbstractC2331o.a(this.f15599d.b(strC, new Y.a() { // from class: com.google.firebase.messaging.s
                @Override // com.google.firebase.messaging.Y.a
                public final AbstractC2328l start() {
                    return this.f15792a.D(strC, aVarV);
                }
            }));
        } catch (InterruptedException | ExecutionException e8) {
            throw new IOException(e8);
        }
    }

    public AbstractC2328l o() {
        if (v() == null) {
            return AbstractC2331o.e(null);
        }
        final C2329m c2329m = new C2329m();
        AbstractC1444o.e().execute(new Runnable() { // from class: com.google.firebase.messaging.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f15801a.E(c2329m);
            }
        });
        return c2329m.a();
    }

    public void p(Runnable runnable, long j8) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f15595o == null) {
                    f15595o = new ScheduledThreadPoolExecutor(1, new X1.a("TAG"));
                }
                f15595o.schedule(runnable, j8, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Context q() {
        return this.f15597b;
    }

    public final String t() {
        return "[DEFAULT]".equals(this.f15596a.q()) ? "" : this.f15596a.s();
    }

    public AbstractC2328l u() {
        final C2329m c2329m = new C2329m();
        this.f15601f.execute(new Runnable() { // from class: com.google.firebase.messaging.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f15798a.F(c2329m);
            }
        });
        return c2329m.a();
    }

    public d0.a v() {
        return s(this.f15597b).e(t(), L.c(this.f15596a));
    }

    public final void x() {
        this.f15598c.f().f(this.f15601f, new InterfaceC2324h() { // from class: com.google.firebase.messaging.C
            @Override // l2.InterfaceC2324h
            public final void onSuccess(Object obj) {
                this.f15588a.G((C0757a) obj);
            }
        });
    }

    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final void J() {
        S.c(this.f15597b);
        U.g(this.f15597b, this.f15598c, R());
        if (R()) {
            x();
        }
    }

    public final void z(String str) {
        if ("[DEFAULT]".equals(this.f15596a.q())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f15596a.q());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C1443n(this.f15597b).k(intent);
        }
    }

    public FirebaseMessaging(G2.f fVar, C3.a aVar, S3.b bVar, S3.b bVar2, T3.h hVar, S3.b bVar3, A3.d dVar) {
        this(fVar, aVar, bVar, bVar2, hVar, bVar3, dVar, new L(fVar.m()));
    }

    public FirebaseMessaging(G2.f fVar, C3.a aVar, S3.b bVar, S3.b bVar2, T3.h hVar, S3.b bVar3, A3.d dVar, L l8) {
        this(fVar, aVar, bVar3, dVar, l8, new G(fVar, l8, bVar, bVar2, hVar), AbstractC1444o.f(), AbstractC1444o.c(), AbstractC1444o.b());
    }
}
