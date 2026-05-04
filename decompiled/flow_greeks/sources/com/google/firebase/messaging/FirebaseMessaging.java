package com.google.firebase.messaging;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.a1;
import com.google.firebase.messaging.v0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p9.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static a1 f6240m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static ScheduledExecutorService f6242o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f6243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f6245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v0 f6246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f6247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f6248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f6249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Task f6250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l0 f6251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f6253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f6239l = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static fa.b f6241n = new fa.b() { // from class: com.google.firebase.messaging.u
        @Override // fa.b
        public final Object get() {
            return FirebaseMessaging.e();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c9.d f6254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c9.b f6256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f6257d;

        public a(c9.d dVar) {
            this.f6254a = dVar;
        }

        public static /* synthetic */ void a(a aVar, c9.a aVar2) {
            if (aVar.c()) {
                FirebaseMessaging.this.I();
            }
        }

        public synchronized void b() {
            try {
                if (this.f6255b) {
                    return;
                }
                Boolean boolD = d();
                this.f6257d = boolD;
                if (boolD == null) {
                    c9.b bVar = new c9.b() { // from class: com.google.firebase.messaging.d0
                        @Override // c9.b
                        public final void handle(c9.a aVar) {
                            FirebaseMessaging.a.a(this.f6304a, aVar);
                        }
                    };
                    this.f6256c = bVar;
                    this.f6254a.b(a7.b.class, bVar);
                }
                this.f6255b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f6257d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f6243a.x();
        }

        public final Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextM = FirebaseMessaging.this.f6243a.m();
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

        public synchronized void e(boolean z10) {
            try {
                b();
                c9.b bVar = this.f6256c;
                if (bVar != null) {
                    this.f6254a.c(a7.b.class, bVar);
                    this.f6256c = null;
                }
                SharedPreferences.Editor editorEdit = FirebaseMessaging.this.f6243a.m().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                editorEdit.putBoolean("auto_init", z10);
                editorEdit.apply();
                if (z10) {
                    FirebaseMessaging.this.I();
                }
                this.f6257d = Boolean.valueOf(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public FirebaseMessaging(a7.g gVar, p9.a aVar, fa.b bVar, fa.b bVar2, ga.h hVar, fa.b bVar3, c9.d dVar) {
        this(gVar, aVar, bVar, bVar2, hVar, bVar3, dVar, new l0(gVar.m()));
    }

    public static /* synthetic */ Task a(FirebaseMessaging firebaseMessaging, String str, a1.a aVar, String str2) {
        s(firebaseMessaging.f6244b).g(firebaseMessaging.t(), str, str2, firebaseMessaging.f6251i.a());
        if (aVar == null || !str2.equals(aVar.f6283a)) {
            firebaseMessaging.z(str2);
        }
        return Tasks.forResult(str2);
    }

    public static /* synthetic */ void b(FirebaseMessaging firebaseMessaging) {
        if (firebaseMessaging.A()) {
            firebaseMessaging.I();
        }
    }

    public static /* synthetic */ void c(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        firebaseMessaging.getClass();
        try {
            taskCompletionSource.setResult(firebaseMessaging.n());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ i4.j e() {
        return null;
    }

    public static /* synthetic */ void g(FirebaseMessaging firebaseMessaging, l5.a aVar) {
        firebaseMessaging.getClass();
        if (aVar != null) {
            k0.y(aVar.R());
            firebaseMessaging.x();
        }
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(a7.g gVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) gVar.k(FirebaseMessaging.class);
        com.google.android.gms.common.internal.s.l(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public static /* synthetic */ void i(FirebaseMessaging firebaseMessaging, f1 f1Var) {
        if (firebaseMessaging.A()) {
            f1Var.p();
        }
    }

    public static /* synthetic */ void k(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        firebaseMessaging.getClass();
        try {
            Tasks.await(firebaseMessaging.f6245c.c());
            s(firebaseMessaging.f6244b).d(firebaseMessaging.t(), l0.c(firebaseMessaging.f6243a));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static synchronized FirebaseMessaging r() {
        return getInstance(a7.g.o());
    }

    public static synchronized a1 s(Context context) {
        try {
            if (f6240m == null) {
                f6240m = new a1(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6240m;
    }

    public static i4.j w() {
        return (i4.j) f6241n.get();
    }

    public boolean A() {
        return this.f6247e.c();
    }

    public boolean B() {
        return this.f6251i.g();
    }

    public void C(s0 s0Var) {
        if (TextUtils.isEmpty(s0Var.a0())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(this.f6244b, 0, intent2, 67108864));
        intent.setPackage("com.google.android.gms");
        s0Var.c0(intent);
        this.f6244b.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void D(boolean z10) {
        this.f6247e.e(z10);
    }

    public void E(boolean z10) {
        k0.B(z10);
        r0.f(this.f6244b, this.f6245c, G());
    }

    public synchronized void F(boolean z10) {
        this.f6252j = z10;
    }

    public final boolean G() {
        p0.c(this.f6244b);
        if (!p0.d(this.f6244b)) {
            return false;
        }
        if (this.f6243a.k(AnalyticsConnector.class) != null) {
            return true;
        }
        return k0.a() && f6241n != null;
    }

    public final synchronized void H() {
        if (!this.f6252j) {
            K(0L);
        }
    }

    public final void I() {
        if (L(v())) {
            H();
        }
    }

    public Task J(final String str) {
        return this.f6250h.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.r
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ((f1) obj).q(str);
            }
        });
    }

    public synchronized void K(long j10) {
        p(new b1(this, Math.min(Math.max(30L, 2 * j10), f6239l)), j10);
        this.f6252j = true;
    }

    public boolean L(a1.a aVar) {
        return aVar == null || aVar.b(this.f6251i.a());
    }

    public Task M(final String str) {
        return this.f6250h.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.w
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ((f1) obj).t(str);
            }
        });
    }

    public String n() throws IOException {
        final a1.a aVarV = v();
        if (!L(aVarV)) {
            return aVarV.f6283a;
        }
        final String strC = l0.c(this.f6243a);
        try {
            return (String) Tasks.await(this.f6246d.b(strC, new v0.a() { // from class: com.google.firebase.messaging.s
                @Override // com.google.firebase.messaging.v0.a
                public final Task start() {
                    FirebaseMessaging firebaseMessaging = this.f6397a;
                    return firebaseMessaging.f6245c.g().onSuccessTask(firebaseMessaging.f6249g, new SuccessContinuation() { // from class: com.google.firebase.messaging.t
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        public final Task then(Object obj) {
                            return FirebaseMessaging.a(firebaseMessaging, str, aVar, (String) obj);
                        }
                    });
                }
            }));
        } catch (InterruptedException | ExecutionException e10) {
            throw new IOException(e10);
        }
    }

    public Task o() {
        if (v() == null) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        o.e().execute(new Runnable() { // from class: com.google.firebase.messaging.x
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.k(this.f6442a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void p(Runnable runnable, long j10) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f6242o == null) {
                    f6242o = new ScheduledThreadPoolExecutor(1, new u5.b("TAG"));
                }
                f6242o.schedule(runnable, j10, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Context q() {
        return this.f6244b;
    }

    public final String t() {
        return "[DEFAULT]".equals(this.f6243a.q()) ? "" : this.f6243a.s();
    }

    public Task u() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f6248f.execute(new Runnable() { // from class: com.google.firebase.messaging.v
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.c(this.f6436a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public a1.a v() {
        return s(this.f6244b).e(t(), l0.c(this.f6243a));
    }

    public final void x() {
        this.f6245c.f().addOnSuccessListener(this.f6248f, new OnSuccessListener() { // from class: com.google.firebase.messaging.c0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.g(this.f6295a, (l5.a) obj);
            }
        });
    }

    public final void y() {
        p0.c(this.f6244b);
        r0.f(this.f6244b, this.f6245c, G());
        if (G()) {
            x();
        }
    }

    public final void z(String str) {
        if ("[DEFAULT]".equals(this.f6243a.q())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f6243a.q());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new n(this.f6244b).g(intent);
        }
    }

    public FirebaseMessaging(a7.g gVar, p9.a aVar, fa.b bVar, fa.b bVar2, ga.h hVar, fa.b bVar3, c9.d dVar, l0 l0Var) {
        this(gVar, aVar, bVar3, dVar, l0Var, new g0(gVar, l0Var, bVar, bVar2, hVar), o.f(), o.c(), o.b());
    }

    public FirebaseMessaging(a7.g gVar, p9.a aVar, fa.b bVar, c9.d dVar, l0 l0Var, g0 g0Var, Executor executor, Executor executor2, Executor executor3) {
        this.f6252j = false;
        f6241n = bVar;
        this.f6243a = gVar;
        this.f6247e = new a(dVar);
        Context contextM = gVar.m();
        this.f6244b = contextM;
        q qVar = new q();
        this.f6253k = qVar;
        this.f6251i = l0Var;
        this.f6245c = g0Var;
        this.f6246d = new v0(executor);
        this.f6248f = executor2;
        this.f6249g = executor3;
        Context contextM2 = gVar.m();
        if (contextM2 instanceof Application) {
            ((Application) contextM2).registerActivityLifecycleCallbacks(qVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + contextM2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new a.InterfaceC0312a() { // from class: com.google.firebase.messaging.y
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.z
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.b(this.f6451a);
            }
        });
        Task taskF = f1.f(this, l0Var, g0Var, contextM, o.g());
        this.f6250h = taskF;
        taskF.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.a0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.i(this.f6280a, (f1) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f6288a.y();
            }
        });
    }
}
