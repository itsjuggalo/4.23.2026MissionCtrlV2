package m9;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m9.c;
import n9.g;
import rb.k1;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f16127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f16128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f16129p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f16130q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f16131r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.b f16132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.b f16133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f16134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rb.z0 f16135d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n9.g f16137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g.d f16138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g.d f16139h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public rb.g f16142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n9.r f16143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u0 f16144m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t0 f16140i = t0.Initial;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16141j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f16136e = new b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16145a;

        public a(long j10) {
            this.f16145a = j10;
        }

        public void a(Runnable runnable) {
            c.this.f16137f.t();
            if (c.this.f16141j == this.f16145a) {
                runnable.run();
            } else {
                n9.v.a(c.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j();
        }
    }

    /* JADX INFO: renamed from: m9.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0289c implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f16148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16149b = 0;

        public C0289c(a aVar) {
            this.f16148a = aVar;
        }

        public static /* synthetic */ void d(C0289c c0289c, k1 k1Var) {
            c0289c.getClass();
            if (k1Var.p()) {
                n9.v.a(c.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(c.this)));
            } else {
                n9.v.e(c.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(c.this)), k1Var);
            }
            c.this.k(k1Var);
        }

        public static /* synthetic */ void e(C0289c c0289c, rb.y0 y0Var) {
            c0289c.getClass();
            if (n9.v.c()) {
                HashMap map = new HashMap();
                for (String str : y0Var.j()) {
                    if (q.f16245d.contains(str.toLowerCase(Locale.ENGLISH))) {
                        map.put(str, (String) y0Var.g(y0.g.e(str, rb.y0.f19747e)));
                    }
                }
                if (map.isEmpty()) {
                    return;
                }
                n9.v.a(c.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(c.this)), map);
            }
        }

        public static /* synthetic */ void f(C0289c c0289c, int i10, Object obj) {
            c0289c.getClass();
            if (n9.v.c()) {
                n9.v.a(c.this.getClass().getSimpleName(), "(%x) Stream received (%s): %s", Integer.valueOf(System.identityHashCode(c.this)), Integer.valueOf(i10), obj);
            }
            if (i10 == 1) {
                c.this.p(obj);
            } else {
                c.this.q(obj);
            }
        }

        public static /* synthetic */ void g(C0289c c0289c) {
            n9.v.a(c.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(c.this)));
            c.this.r();
        }

        @Override // m9.j0
        public void a() {
            this.f16148a.a(new Runnable() { // from class: m9.f
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0289c.g(this.f16162a);
                }
            });
        }

        @Override // m9.j0
        public void b(final k1 k1Var) {
            this.f16148a.a(new Runnable() { // from class: m9.g
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0289c.d(this.f16165a, k1Var);
                }
            });
        }

        @Override // m9.j0
        public void c(final rb.y0 y0Var) {
            this.f16148a.a(new Runnable() { // from class: m9.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0289c.e(this.f16158a, y0Var);
                }
            });
        }

        @Override // m9.j0
        public void onNext(final Object obj) {
            final int i10 = this.f16149b + 1;
            this.f16148a.a(new Runnable() { // from class: m9.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0289c.f(this.f16153a, i10, obj);
                }
            });
            this.f16149b = i10;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f16127n = timeUnit.toMillis(1L);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        f16128o = timeUnit2.toMillis(1L);
        f16129p = timeUnit2.toMillis(1L);
        f16130q = timeUnit.toMillis(10L);
        f16131r = timeUnit.toMillis(10L);
    }

    public c(y yVar, rb.z0 z0Var, n9.g gVar, g.d dVar, g.d dVar2, g.d dVar3, u0 u0Var) {
        this.f16134c = yVar;
        this.f16135d = z0Var;
        this.f16137f = gVar;
        this.f16138g = dVar2;
        this.f16139h = dVar3;
        this.f16144m = u0Var;
        this.f16143l = new n9.r(gVar, dVar, f16127n, 1.5d, f16128o);
    }

    public static /* synthetic */ void a(c cVar) {
        t0 t0Var = cVar.f16140i;
        n9.b.d(t0Var == t0.Backoff, "State should still be backoff but was %s", t0Var);
        cVar.f16140i = t0.Initial;
        cVar.t();
        n9.b.d(cVar.n(), "Stream should have started", new Object[0]);
    }

    public static /* synthetic */ void b(c cVar) {
        if (cVar.m()) {
            cVar.f16140i = t0.Healthy;
        }
    }

    public final void g() {
        g.b bVar = this.f16132a;
        if (bVar != null) {
            bVar.c();
            this.f16132a = null;
        }
    }

    public final void h() {
        g.b bVar = this.f16133b;
        if (bVar != null) {
            bVar.c();
            this.f16133b = null;
        }
    }

    public final void i(t0 t0Var, k1 k1Var) {
        n9.b.d(n(), "Only started streams should be closed.", new Object[0]);
        t0 t0Var2 = t0.Error;
        n9.b.d(t0Var == t0Var2 || k1Var.p(), "Can't provide an error when not in an error state.", new Object[0]);
        this.f16137f.t();
        if (q.g(k1Var)) {
            n9.g0.o(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", k1Var.m()));
        }
        h();
        g();
        this.f16143l.c();
        this.f16141j++;
        k1.b bVarN = k1Var.n();
        if (bVarN == k1.b.OK) {
            this.f16143l.e();
        } else if (bVarN == k1.b.RESOURCE_EXHAUSTED) {
            n9.v.a(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.f16143l.f();
        } else if (bVarN == k1.b.UNAUTHENTICATED && this.f16140i != t0.Healthy) {
            this.f16134c.h();
        } else if (bVarN == k1.b.UNAVAILABLE && ((k1Var.m() instanceof UnknownHostException) || (k1Var.m() instanceof ConnectException))) {
            this.f16143l.g(f16131r);
        }
        if (t0Var != t0Var2) {
            n9.v.a(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            v();
        }
        if (this.f16142k != null) {
            if (k1Var.p()) {
                n9.v.a(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                try {
                    this.f16142k.b();
                } catch (IllegalStateException e10) {
                    n9.v.a(getClass().getSimpleName(), "(%x) Closing stream client-side result in exception: [%s]", Integer.valueOf(System.identityHashCode(this)), e10);
                }
            }
            this.f16142k = null;
        }
        this.f16140i = t0Var;
        this.f16144m.b(k1Var);
    }

    public final void j() {
        if (m()) {
            i(t0.Initial, k1.f19592e);
        }
    }

    public void k(k1 k1Var) {
        n9.b.d(n(), "Can't handle server close on non-started stream!", new Object[0]);
        i(t0.Error, k1Var);
    }

    public void l() {
        n9.b.d(!n(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f16137f.t();
        this.f16140i = t0.Initial;
        this.f16143l.e();
    }

    public boolean m() {
        this.f16137f.t();
        t0 t0Var = this.f16140i;
        return t0Var == t0.Open || t0Var == t0.Healthy;
    }

    public boolean n() {
        this.f16137f.t();
        t0 t0Var = this.f16140i;
        return t0Var == t0.Starting || t0Var == t0.Backoff || m();
    }

    public void o() {
        if (m() && this.f16133b == null) {
            this.f16133b = this.f16137f.k(this.f16138g, f16129p, this.f16136e);
        }
    }

    public abstract void p(Object obj);

    public abstract void q(Object obj);

    public final void r() {
        this.f16140i = t0.Open;
        this.f16144m.a();
        if (this.f16132a == null) {
            this.f16132a = this.f16137f.k(this.f16139h, f16130q, new Runnable() { // from class: m9.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.b(this.f16120a);
                }
            });
        }
    }

    public final void s() {
        n9.b.d(this.f16140i == t0.Error, "Should only perform backoff in an error state", new Object[0]);
        this.f16140i = t0.Backoff;
        this.f16143l.b(new Runnable() { // from class: m9.a
            @Override // java.lang.Runnable
            public final void run() {
                c.a(this.f16116a);
            }
        });
    }

    public void t() {
        this.f16137f.t();
        n9.b.d(this.f16142k == null, "Last call still set", new Object[0]);
        n9.b.d(this.f16133b == null, "Idle timer still set", new Object[0]);
        t0 t0Var = this.f16140i;
        if (t0Var == t0.Error) {
            s();
            return;
        }
        n9.b.d(t0Var == t0.Initial, "Already started", new Object[0]);
        this.f16142k = this.f16134c.j(this.f16135d, new C0289c(new a(this.f16141j)));
        this.f16140i = t0.Starting;
    }

    public void u() {
        if (n()) {
            i(t0.Initial, k1.f19592e);
        }
    }

    public void w(Object obj) {
        this.f16137f.t();
        n9.v.a(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), obj);
        h();
        this.f16142k.d(obj);
    }

    public void v() {
    }
}
