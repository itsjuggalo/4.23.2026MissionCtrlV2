package com.google.firebase.messaging;

import M3.a;
import O1.C0639a;
import O3.h;
import Q2.g;
import U3.AbstractC0701n;
import U3.C0700m;
import U3.C0703p;
import U3.F;
import U3.J;
import U3.O;
import U3.Q;
import U3.Y;
import U3.c0;
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
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.e;
import com.google.firebase.messaging.f;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o1.InterfaceC2298j;
import z3.C2889a;
import z3.InterfaceC2890b;
import z3.InterfaceC2892d;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static f f12196m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static ScheduledExecutorService f12198o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f12199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F f12201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f12202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f12203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f12204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f12205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Task f12206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final J f12207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f12209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f12195l = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static N3.b f12197n = new N3.b() { // from class: U3.q
        @Override // N3.b
        public final Object get() {
            return FirebaseMessaging.K();
        }
    };

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2892d f12210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public InterfaceC2890b f12212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f12213d;

        public a(InterfaceC2892d interfaceC2892d) {
            this.f12210a = interfaceC2892d;
        }

        public synchronized void b() {
            try {
                if (this.f12211b) {
                    return;
                }
                Boolean boolE = e();
                this.f12213d = boolE;
                if (boolE == null) {
                    InterfaceC2890b interfaceC2890b = new InterfaceC2890b() { // from class: U3.C
                        @Override // z3.InterfaceC2890b
                        public final void a(C2889a c2889a) {
                            this.f4792a.d(c2889a);
                        }
                    };
                    this.f12212c = interfaceC2890b;
                    this.f12210a.b(Q2.b.class, interfaceC2890b);
                }
                this.f12211b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f12213d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f12199a.x();
        }

        public final /* synthetic */ void d(C2889a c2889a) {
            if (c()) {
                FirebaseMessaging.this.T();
            }
        }

        public final Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextM = FirebaseMessaging.this.f12199a.m();
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
                InterfaceC2890b interfaceC2890b = this.f12212c;
                if (interfaceC2890b != null) {
                    this.f12210a.d(Q2.b.class, interfaceC2890b);
                    this.f12212c = null;
                }
                SharedPreferences.Editor editorEdit = FirebaseMessaging.this.f12199a.m().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                editorEdit.putBoolean("auto_init", z7);
                editorEdit.apply();
                if (z7) {
                    FirebaseMessaging.this.T();
                }
                this.f12213d = Boolean.valueOf(z7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public FirebaseMessaging(g gVar, M3.a aVar, N3.b bVar, N3.b bVar2, h hVar, N3.b bVar3, InterfaceC2892d interfaceC2892d) {
        this(gVar, aVar, bVar, bVar2, hVar, bVar3, interfaceC2892d, new J(gVar.m()));
    }

    public static /* synthetic */ InterfaceC2298j K() {
        return null;
    }

    public static /* synthetic */ Task L(String str, c0 c0Var) {
        return c0Var.r(str);
    }

    public static /* synthetic */ Task M(String str, c0 c0Var) {
        return c0Var.u(str);
    }

    public static synchronized FirebaseMessaging getInstance(g gVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) gVar.k(FirebaseMessaging.class);
        AbstractC1207s.l(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public static synchronized FirebaseMessaging r() {
        return getInstance(g.o());
    }

    public static synchronized f s(Context context) {
        try {
            if (f12196m == null) {
                f12196m = new f(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f12196m;
    }

    public static InterfaceC2298j w() {
        return (InterfaceC2298j) f12197n.get();
    }

    public boolean A() {
        return this.f12203e.c();
    }

    public boolean B() {
        return this.f12207i.g();
    }

    public final /* synthetic */ Task C(String str, f.a aVar, String str2) {
        s(this.f12200b).g(t(), str, str2, this.f12207i.a());
        if (aVar == null || !str2.equals(aVar.f12254a)) {
            z(str2);
        }
        return Tasks.forResult(str2);
    }

    public final /* synthetic */ Task D(final String str, final f.a aVar) {
        return this.f12201c.g().onSuccessTask(this.f12205g, new SuccessContinuation() { // from class: U3.A
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f4787a.C(str, aVar, (String) obj);
            }
        });
    }

    public final /* synthetic */ void E(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.f12201c.c());
            s(this.f12200b).d(t(), J.c(this.f12199a));
            taskCompletionSource.setResult(null);
        } catch (Exception e7) {
            taskCompletionSource.setException(e7);
        }
    }

    public final /* synthetic */ void F(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(n());
        } catch (Exception e7) {
            taskCompletionSource.setException(e7);
        }
    }

    public final /* synthetic */ void G(C0639a c0639a) {
        if (c0639a != null) {
            b.y(c0639a.A());
            x();
        }
    }

    public final /* synthetic */ void H() {
        if (A()) {
            T();
        }
    }

    public final /* synthetic */ void I(c0 c0Var) {
        if (A()) {
            c0Var.q();
        }
    }

    public void N(d dVar) {
        if (TextUtils.isEmpty(dVar.J())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(this.f12200b, 0, intent2, 67108864));
        intent.setPackage("com.google.android.gms");
        dVar.L(intent);
        this.f12200b.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void O(boolean z7) {
        this.f12203e.f(z7);
    }

    public void P(boolean z7) {
        b.B(z7);
        Q.g(this.f12200b, this.f12201c, R());
    }

    public synchronized void Q(boolean z7) {
        this.f12208j = z7;
    }

    public final boolean R() {
        O.c(this.f12200b);
        if (!O.d(this.f12200b)) {
            return false;
        }
        if (this.f12199a.k(S2.a.class) != null) {
            return true;
        }
        return b.a() && f12197n != null;
    }

    public final synchronized void S() {
        if (!this.f12208j) {
            V(0L);
        }
    }

    public final void T() {
        if (W(v())) {
            S();
        }
    }

    public Task U(final String str) {
        return this.f12206h.onSuccessTask(new SuccessContinuation() { // from class: U3.z
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return FirebaseMessaging.L(str, (c0) obj);
            }
        });
    }

    public synchronized void V(long j7) {
        p(new Y(this, Math.min(Math.max(30L, 2 * j7), f12195l)), j7);
        this.f12208j = true;
    }

    public boolean W(f.a aVar) {
        return aVar == null || aVar.b(this.f12207i.a());
    }

    public Task X(final String str) {
        return this.f12206h.onSuccessTask(new SuccessContinuation() { // from class: U3.r
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return FirebaseMessaging.M(str, (c0) obj);
            }
        });
    }

    public String n() throws IOException {
        final f.a aVarV = v();
        if (!W(aVarV)) {
            return aVarV.f12254a;
        }
        final String strC = J.c(this.f12199a);
        try {
            return (String) Tasks.await(this.f12202d.b(strC, new e.a() { // from class: U3.y
                @Override // com.google.firebase.messaging.e.a
                public final Task start() {
                    return this.f4947a.D(strC, aVarV);
                }
            }));
        } catch (InterruptedException | ExecutionException e7) {
            throw new IOException(e7);
        }
    }

    public Task o() {
        if (v() == null) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AbstractC0701n.e().execute(new Runnable() { // from class: U3.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f4940a.E(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void p(Runnable runnable, long j7) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f12198o == null) {
                    f12198o = new ScheduledThreadPoolExecutor(1, new X1.b("TAG"));
                }
                f12198o.schedule(runnable, j7, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Context q() {
        return this.f12200b;
    }

    public final String t() {
        return "[DEFAULT]".equals(this.f12199a.q()) ? "" : this.f12199a.s();
    }

    public Task u() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f12204f.execute(new Runnable() { // from class: U3.B
            @Override // java.lang.Runnable
            public final void run() {
                this.f4790a.F(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public f.a v() {
        return s(this.f12200b).e(t(), J.c(this.f12199a));
    }

    public final void x() {
        this.f12201c.f().addOnSuccessListener(this.f12204f, new OnSuccessListener() { // from class: U3.x
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f4946a.G((C0639a) obj);
            }
        });
    }

    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final void J() {
        O.c(this.f12200b);
        Q.g(this.f12200b, this.f12201c, R());
        if (R()) {
            x();
        }
    }

    public final void z(String str) {
        if ("[DEFAULT]".equals(this.f12199a.q())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f12199a.q());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C0700m(this.f12200b).k(intent);
        }
    }

    public FirebaseMessaging(g gVar, M3.a aVar, N3.b bVar, N3.b bVar2, h hVar, N3.b bVar3, InterfaceC2892d interfaceC2892d, J j7) {
        this(gVar, aVar, bVar3, interfaceC2892d, j7, new F(gVar, j7, bVar, bVar2, hVar), AbstractC0701n.f(), AbstractC0701n.c(), AbstractC0701n.b());
    }

    public FirebaseMessaging(g gVar, M3.a aVar, N3.b bVar, InterfaceC2892d interfaceC2892d, J j7, F f7, Executor executor, Executor executor2, Executor executor3) {
        this.f12208j = false;
        f12197n = bVar;
        this.f12199a = gVar;
        this.f12203e = new a(interfaceC2892d);
        Context contextM = gVar.m();
        this.f12200b = contextM;
        C0703p c0703p = new C0703p();
        this.f12209k = c0703p;
        this.f12207i = j7;
        this.f12201c = f7;
        this.f12202d = new e(executor);
        this.f12204f = executor2;
        this.f12205g = executor3;
        Context contextM2 = gVar.m();
        if (contextM2 instanceof Application) {
            ((Application) contextM2).registerActivityLifecycleCallbacks(c0703p);
        } else {
            Log.w("FirebaseMessaging", "Context " + contextM2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new a.InterfaceC0049a() { // from class: U3.t
            });
        }
        executor2.execute(new Runnable() { // from class: U3.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f4943a.H();
            }
        });
        Task taskF = c0.f(this, j7, f7, contextM, AbstractC0701n.g());
        this.f12206h = taskF;
        taskF.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: U3.v
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f4944a.I((c0) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: U3.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f4945a.J();
            }
        });
    }
}
