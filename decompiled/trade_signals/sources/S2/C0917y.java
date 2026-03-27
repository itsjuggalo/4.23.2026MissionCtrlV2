package S2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import b3.C1192a;
import b3.C1194c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l2.AbstractC2328l;

/* JADX INFO: renamed from: S2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0917y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G2.f f7621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E f7622c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0918z f7625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C0918z f7626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f7628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final J f7629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Y2.g f7630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final R2.b f7631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Q2.a f7632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C0907n f7633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final P2.a f7634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final P2.l f7635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final T2.i f7636q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7624e = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final O f7623d = new O();

    public C0917y(G2.f fVar, J j8, P2.a aVar, E e8, R2.b bVar, Q2.a aVar2, Y2.g gVar, C0907n c0907n, P2.l lVar, T2.i iVar) {
        this.f7621b = fVar;
        this.f7622c = e8;
        this.f7620a = fVar.m();
        this.f7629j = j8;
        this.f7634o = aVar;
        this.f7631l = bVar;
        this.f7632m = aVar2;
        this.f7630k = gVar;
        this.f7633n = c0907n;
        this.f7635p = lVar;
        this.f7636q = iVar;
    }

    public static String k() {
        return "20.0.0";
    }

    public static boolean l(String str, boolean z7) {
        if (!z7) {
            P2.g.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    public final void f() {
        boolean zEquals;
        try {
            zEquals = Boolean.TRUE.equals((Boolean) this.f7636q.f7946a.c().submit(new Callable() { // from class: S2.t
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f7610a.m();
                }
            }).get(3L, TimeUnit.SECONDS));
        } catch (Exception unused) {
            zEquals = false;
        }
        this.f7627h = zEquals;
    }

    public boolean g() {
        return this.f7625f.c();
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void o(a3.j jVar) {
        T2.i.c();
        t();
        try {
            try {
                this.f7631l.a(new R2.a() { // from class: S2.v
                    @Override // R2.a
                    public final void a(String str) {
                        this.f7613a.r(str);
                    }
                });
                this.f7628i.S();
            } catch (Exception e8) {
                P2.g.f().e("Crashlytics encountered a problem during asynchronous initialization.", e8);
            }
            if (!jVar.b().f9919b.f9926a) {
                P2.g.f().b("Collection of crash reports disabled in Crashlytics settings.");
                throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
            }
            if (!this.f7628i.y(jVar)) {
                P2.g.f().k("Previous sessions could not be finalized.");
            }
            this.f7628i.U(jVar.a());
            s();
        } catch (Throwable th) {
            s();
            throw th;
        }
    }

    public AbstractC2328l i(final a3.j jVar) {
        return this.f7636q.f7946a.f(new Runnable() { // from class: S2.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f7608a.n(jVar);
            }
        });
    }

    public final void j(final a3.j jVar) {
        P2.g gVarF;
        String str;
        Future<?> futureSubmit = this.f7636q.f7946a.c().submit(new Runnable() { // from class: S2.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f7611a.o(jVar);
            }
        });
        P2.g.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e8) {
            P2.g.f().e("Crashlytics was interrupted during initialization.", e8);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e9) {
            e = e9;
            gVarF = P2.g.f();
            str = "Crashlytics encountered a problem during initialization.";
            gVarF.e(str, e);
        } catch (TimeoutException e10) {
            e = e10;
            gVarF = P2.g.f();
            str = "Crashlytics timed out during initialization.";
            gVarF.e(str, e);
        }
    }

    public final /* synthetic */ Boolean m() {
        return Boolean.valueOf(this.f7628i.r());
    }

    public final /* synthetic */ void p(long j8, String str) {
        this.f7628i.X(j8, str);
    }

    public final /* synthetic */ void q(final long j8, final String str) {
        this.f7636q.f7947b.f(new Runnable() { // from class: S2.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f7617a.p(j8, str);
            }
        });
    }

    public void r(final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() - this.f7624e;
        this.f7636q.f7946a.f(new Runnable() { // from class: S2.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f7614a.q(jCurrentTimeMillis, str);
            }
        });
    }

    public void s() {
        T2.i.c();
        try {
            if (this.f7625f.d()) {
                return;
            }
            P2.g.f().k("Initialization marker file was not properly removed.");
        } catch (Exception e8) {
            P2.g.f().e("Problem encountered deleting Crashlytics initialization marker.", e8);
        }
    }

    public void t() {
        T2.i.c();
        this.f7625f.a();
        P2.g.f().i("Initialization marker file was created.");
    }

    public boolean u(C0895b c0895b, a3.j jVar) {
        if (!l(c0895b.f7516b, AbstractC0903j.i(this.f7620a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String strC = new C0902i().c();
        try {
            this.f7626g = new C0918z("crash_marker", this.f7630k);
            this.f7625f = new C0918z("initialization_marker", this.f7630k);
            U2.o oVar = new U2.o(strC, this.f7630k, this.f7636q);
            U2.f fVar = new U2.f(this.f7630k);
            C1192a c1192a = new C1192a(1024, new C1194c(10));
            this.f7635p.c(oVar);
            this.f7628i = new r(this.f7620a, this.f7629j, this.f7622c, this.f7630k, this.f7626g, c0895b, oVar, fVar, d0.j(this.f7620a, this.f7629j, this.f7630k, c0895b, fVar, oVar, c1192a, jVar, this.f7623d, this.f7633n, this.f7636q), this.f7634o, this.f7632m, this.f7633n, this.f7636q);
            boolean zG = g();
            f();
            this.f7628i.w(strC, Thread.getDefaultUncaughtExceptionHandler(), jVar);
            if (!zG || !AbstractC0903j.d(this.f7620a)) {
                P2.g.f().b("Successfully configured exception handler.");
                return true;
            }
            P2.g.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            j(jVar);
            return false;
        } catch (Exception e8) {
            P2.g.f().e("Crashlytics was not started due to an exception during initialization", e8);
            this.f7628i = null;
            return false;
        }
    }
}
