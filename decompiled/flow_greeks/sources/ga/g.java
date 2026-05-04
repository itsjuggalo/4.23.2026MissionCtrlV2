package ga;

import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import ga.i;
import ia.d;
import ia.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import o7.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f10448m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadFactory f10449n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f10450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ia.c f10451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ha.c f10452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f10453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f10454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f10455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f10456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f10457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f10458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set f10460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f10461l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f10462a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f10462a.getAndIncrement())));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10464b;

        static {
            int[] iArr = new int[f.b.values().length];
            f10464b = iArr;
            try {
                iArr[f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10464b[f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10464b[f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f10463a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10463a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public g(final a7.g gVar, fa.b bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, gVar, new ia.c(gVar.m(), bVar), new ha.c(gVar), p.c(), new w(new fa.b() { // from class: ga.c
            @Override // fa.b
            public final Object get() {
                return g.e(gVar);
            }
        }), new n());
    }

    public static /* synthetic */ ha.b e(a7.g gVar) {
        return new ha.b(gVar);
    }

    public static g p() {
        return q(a7.g.o());
    }

    public static g q(a7.g gVar) {
        s.b(gVar != null, "Null is not a valid value of FirebaseApp.");
        return (g) gVar.k(h.class);
    }

    public final synchronized void A(String str) {
        this.f10459j = str;
    }

    public final synchronized void B(ha.d dVar, ha.d dVar2) {
        if (this.f10460k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator it = this.f10460k.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                dVar2.d();
                throw null;
            }
        }
    }

    @Override // ga.h
    public Task a(final boolean z10) {
        v();
        Task taskF = f();
        this.f10457h.execute(new Runnable() { // from class: ga.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f10444a.j(z10);
            }
        });
        return taskF;
    }

    public final Task f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new k(this.f10453d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new l(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // ga.h
    public Task getId() {
        v();
        String strN = n();
        if (strN != null) {
            return Tasks.forResult(strN);
        }
        Task taskG = g();
        this.f10457h.execute(new Runnable() { // from class: ga.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f10443a.j(false);
            }
        });
        return taskG;
    }

    public final void h(o oVar) {
        synchronized (this.f10456g) {
            this.f10461l.add(oVar);
        }
    }

    public final void i(boolean z10) {
        ha.d dVarX;
        ha.d dVarR = r();
        try {
            if (dVarR.i() || dVarR.l()) {
                dVarX = x(dVarR);
            } else {
                if (!z10 && !this.f10453d.f(dVarR)) {
                    return;
                }
                dVarX = k(dVarR);
            }
            u(dVarX);
            B(dVarR, dVarX);
            if (dVarX.k()) {
                A(dVarX.d());
            }
            if (dVarX.i()) {
                y(new i(i.a.BAD_CONFIG));
            } else if (dVarX.j()) {
                y(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                z(dVarX);
            }
        } catch (i e10) {
            y(e10);
        }
    }

    public final void j(final boolean z10) {
        ha.d dVarS = s();
        if (z10) {
            dVarS = dVarS.p();
        }
        z(dVarS);
        this.f10458i.execute(new Runnable() { // from class: ga.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f10446a.i(z10);
            }
        });
    }

    public final ha.d k(ha.d dVar) throws i {
        ia.f fVarE = this.f10451b.e(l(), dVar.d(), t(), dVar.f());
        int i10 = b.f10464b[fVarE.b().ordinal()];
        if (i10 == 1) {
            return dVar.o(fVarE.c(), fVarE.d(), this.f10453d.b());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i10 != 3) {
            throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
        }
        A(null);
        return dVar.r();
    }

    public String l() {
        return this.f10450a.r().b();
    }

    public String m() {
        return this.f10450a.r().c();
    }

    public final synchronized String n() {
        return this.f10459j;
    }

    public final ha.b o() {
        return (ha.b) this.f10454e.get();
    }

    /* JADX WARN: Finally extract failed */
    public final ha.d r() {
        ha.d dVarD;
        synchronized (f10448m) {
            try {
                ga.b bVarA = ga.b.a(this.f10450a.m(), "generatefid.lock");
                try {
                    dVarD = this.f10452c.d();
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVarD;
    }

    /* JADX WARN: Finally extract failed */
    public final ha.d s() {
        ha.d dVarD;
        synchronized (f10448m) {
            try {
                ga.b bVarA = ga.b.a(this.f10450a.m(), "generatefid.lock");
                try {
                    dVarD = this.f10452c.d();
                    if (dVarD.j()) {
                        dVarD = this.f10452c.b(dVarD.t(w(dVarD)));
                    }
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVarD;
    }

    public String t() {
        return this.f10450a.r().g();
    }

    /* JADX WARN: Finally extract failed */
    public final void u(ha.d dVar) {
        synchronized (f10448m) {
            try {
                ga.b bVarA = ga.b.a(this.f10450a.m(), "generatefid.lock");
                try {
                    this.f10452c.b(dVar);
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void v() {
        s.f(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.f(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.f(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.b(p.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.b(p.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String w(ha.d dVar) {
        if ((!this.f10450a.q().equals("CHIME_ANDROID_SDK") && !this.f10450a.y()) || !dVar.m()) {
            return this.f10455f.a();
        }
        String strF = o().f();
        return TextUtils.isEmpty(strF) ? this.f10455f.a() : strF;
    }

    public final ha.d x(ha.d dVar) throws i {
        ia.d dVarD = this.f10451b.d(l(), dVar.d(), t(), m(), (dVar.d() == null || dVar.d().length() != 11) ? null : o().i());
        int i10 = b.f10463a[dVarD.e().ordinal()];
        if (i10 == 1) {
            return dVar.s(dVarD.c(), dVarD.d(), this.f10453d.b(), dVarD.b().c(), dVarD.b().d());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
    }

    public final void y(Exception exc) {
        synchronized (this.f10456g) {
            try {
                Iterator it = this.f10461l.iterator();
                while (it.hasNext()) {
                    if (((o) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(ha.d dVar) {
        synchronized (this.f10456g) {
            try {
                Iterator it = this.f10461l.iterator();
                while (it.hasNext()) {
                    if (((o) it.next()).b(dVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public g(ExecutorService executorService, Executor executor, a7.g gVar, ia.c cVar, ha.c cVar2, p pVar, w wVar, n nVar) {
        this.f10456g = new Object();
        this.f10460k = new HashSet();
        this.f10461l = new ArrayList();
        this.f10450a = gVar;
        this.f10451b = cVar;
        this.f10452c = cVar2;
        this.f10453d = pVar;
        this.f10454e = wVar;
        this.f10455f = nVar;
        this.f10457h = executorService;
        this.f10458i = executor;
    }
}
