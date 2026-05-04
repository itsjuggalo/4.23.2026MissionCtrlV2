package u7;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f22372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f22373c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x f22376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public x f22377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p f22379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h0 f22380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a8.g f22381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t7.b f22382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s7.a f22383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f22384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r7.a f22385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final r7.k f22386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v7.i f22387q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f22375e = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f22374d = new m0();

    public w(a7.g gVar, h0 h0Var, r7.a aVar, c0 c0Var, t7.b bVar, s7.a aVar2, a8.g gVar2, m mVar, r7.k kVar, v7.i iVar) {
        this.f22372b = gVar;
        this.f22373c = c0Var;
        this.f22371a = gVar.m();
        this.f22380j = h0Var;
        this.f22385o = aVar;
        this.f22382l = bVar;
        this.f22383m = aVar2;
        this.f22381k = gVar2;
        this.f22384n = mVar;
        this.f22386p = kVar;
        this.f22387q = iVar;
    }

    public static String k() {
        return "20.0.3";
    }

    public static boolean l(String str, boolean z10) {
        if (!z10) {
            r7.g.f().i("Configured not to require a build ID.");
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
        try {
            this.f22378h = Boolean.TRUE.equals((Boolean) this.f22387q.f23152a.d().submit(new Callable() { // from class: u7.r
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.f22352a.f22379i.r());
                }
            }).get(3L, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.f22378h = false;
        }
    }

    public boolean g() {
        return this.f22376f.c();
    }

    public final void h(c8.j jVar) {
        v7.i.c();
        o();
        try {
            try {
                this.f22382l.a(new t7.a() { // from class: u7.t
                    @Override // t7.a
                    public final void a(String str) {
                        this.f22362a.m(str);
                    }
                });
                this.f22379i.Q();
                if (!jVar.b().f3712b.f3719a) {
                    r7.g.f().b("Collection of crash reports disabled in Crashlytics settings.");
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if (!this.f22379i.y(jVar)) {
                    r7.g.f().k("Previous sessions could not be finalized.");
                }
                this.f22379i.S(jVar.a());
                n();
            } catch (Exception e10) {
                r7.g.f().e("Crashlytics encountered a problem during asynchronous initialization.", e10);
                n();
            }
        } catch (Throwable th) {
            n();
            throw th;
        }
    }

    public Task i(final c8.j jVar) {
        return this.f22387q.f23152a.e(new Runnable() { // from class: u7.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f22350a.h(jVar);
            }
        });
    }

    public final void j(final c8.j jVar) {
        Future<?> futureSubmit = this.f22387q.f23152a.d().submit(new Runnable() { // from class: u7.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f22360a.h(jVar);
            }
        });
        r7.g.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            r7.g.f().e("Crashlytics was interrupted during initialization.", e10);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e11) {
            r7.g.f().e("Crashlytics encountered a problem during initialization.", e11);
        } catch (TimeoutException e12) {
            r7.g.f().e("Crashlytics timed out during initialization.", e12);
        }
    }

    public void m(final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() - this.f22375e;
        this.f22387q.f23152a.e(new Runnable() { // from class: u7.u
            @Override // java.lang.Runnable
            public final void run() {
                w wVar = this.f22364a;
                wVar.f22387q.f23153b.e(new Runnable() { // from class: u7.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        wVar.f22379i.V(j, str);
                    }
                });
            }
        });
    }

    public void n() {
        v7.i.c();
        try {
            if (this.f22376f.d()) {
                return;
            }
            r7.g.f().k("Initialization marker file was not properly removed.");
        } catch (Exception e10) {
            r7.g.f().e("Problem encountered deleting Crashlytics initialization marker.", e10);
        }
    }

    public void o() {
        v7.i.c();
        this.f22376f.a();
        r7.g.f().i("Initialization marker file was created.");
    }

    public boolean p(a aVar, c8.j jVar) {
        if (!l(aVar.f22220b, i.i(this.f22371a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String strC = new h().c();
        try {
            this.f22377g = new x("crash_marker", this.f22381k);
            this.f22376f = new x("initialization_marker", this.f22381k);
            w7.o oVar = new w7.o(strC, this.f22381k, this.f22387q);
            w7.f fVar = new w7.f(this.f22381k);
            d8.a aVar2 = new d8.a(1024, new d8.c(10));
            this.f22386p.b(oVar);
            this.f22379i = new p(this.f22371a, this.f22380j, this.f22373c, this.f22381k, this.f22377g, aVar, oVar, fVar, r0.j(this.f22371a, this.f22380j, this.f22381k, aVar, fVar, oVar, aVar2, jVar, this.f22374d, this.f22384n, this.f22387q), this.f22385o, this.f22383m, this.f22384n, this.f22387q);
            boolean zG = g();
            f();
            this.f22379i.w(strC, Thread.getDefaultUncaughtExceptionHandler(), jVar);
            if (!zG || !i.d(this.f22371a)) {
                r7.g.f().b("Successfully configured exception handler.");
                return true;
            }
            r7.g.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            j(jVar);
            return false;
        } catch (Exception e10) {
            r7.g.f().e("Crashlytics was not started due to an exception during initialization", e10);
            this.f22379i = null;
            return false;
        }
    }
}
