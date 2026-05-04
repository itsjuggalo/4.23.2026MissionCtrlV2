package aa;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import q9.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d0 implements q9.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final da.a f409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k3 f410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i3 f411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ea.m f413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m2 f414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ea.i f416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f418k = false;

    public d0(s0 s0Var, da.a aVar, k3 k3Var, i3 i3Var, k kVar, ea.m mVar, m2 m2Var, n nVar, ea.i iVar, String str) {
        this.f408a = s0Var;
        this.f409b = aVar;
        this.f410c = k3Var;
        this.f411d = i3Var;
        this.f412e = kVar;
        this.f413f = mVar;
        this.f414g = m2Var;
        this.f415h = nVar;
        this.f416i = iVar;
        this.f417j = str;
    }

    public static /* synthetic */ Object i(TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setResult(null);
        return null;
    }

    public static /* synthetic */ cc.n l(TaskCompletionSource taskCompletionSource, Throwable th) {
        if (th instanceof Exception) {
            taskCompletionSource.setException((Exception) th);
        } else {
            taskCompletionSource.setException(new RuntimeException(th));
        }
        return cc.j.g();
    }

    public static Task u(cc.j jVar, cc.r rVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        jVar.f(new ic.d() { // from class: aa.c0
            @Override // ic.d
            public final void accept(Object obj) {
                taskCompletionSource.setResult(obj);
            }
        }).x(cc.j.l(new Callable() { // from class: aa.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d0.i(taskCompletionSource);
            }
        })).r(new ic.e() { // from class: aa.t
            @Override // ic.e
            public final Object apply(Object obj) {
                return d0.l(taskCompletionSource, (Throwable) obj);
            }
        }).v(rVar).s();
        return taskCompletionSource.getTask();
    }

    @Override // q9.r
    public Task a(final r.a aVar) {
        if (!v()) {
            p("message dismissal to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        h2.a("Attempting to record: message dismissal to metrics logger");
        return r(cc.b.g(new ic.a() { // from class: aa.v
            @Override // ic.a
            public final void run() {
                d0 d0Var = this.f587a;
                d0Var.f414g.m(d0Var.f416i, aVar);
            }
        }));
    }

    @Override // q9.r
    public Task b(ea.a aVar) {
        if (v()) {
            return aVar.b() == null ? a(r.a.CLICK) : s(aVar);
        }
        p("message click to metrics logger");
        return new TaskCompletionSource().getTask();
    }

    @Override // q9.r
    public Task c(final r.b bVar) {
        if (!v()) {
            p("render error to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        h2.a("Attempting to record: render error to metrics logger");
        return u(t().b(cc.b.g(new ic.a() { // from class: aa.r
            @Override // ic.a
            public final void run() {
                d0 d0Var = this.f565a;
                d0Var.f414g.q(d0Var.f416i, bVar);
            }
        })).b(w()).n(), this.f410c.a());
    }

    @Override // q9.r
    public Task d() {
        if (!v() || this.f418k) {
            p("message impression to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        h2.a("Attempting to record: message impression to metrics logger");
        return u(t().b(cc.b.g(new ic.a() { // from class: aa.u
            @Override // ic.a
            public final void run() {
                d0 d0Var = this.f580a;
                d0Var.f414g.o(d0Var.f416i);
            }
        })).b(w()).n(), this.f410c.a());
    }

    public final void p(String str) {
        q(str, null);
    }

    public final void q(String str, cc.j jVar) {
        if (jVar != null) {
            h2.a(String.format("Not recording: %s. Reason: %s", str, jVar));
            return;
        }
        if (this.f416i.a().c()) {
            h2.a(String.format("Not recording: %s. Reason: Message is test message", str));
        } else if (this.f415h.b()) {
            h2.a(String.format("Not recording: %s", str));
        } else {
            h2.a(String.format("Not recording: %s. Reason: Data collection is disabled", str));
        }
    }

    public final Task r(cc.b bVar) {
        if (!this.f418k) {
            d();
        }
        return u(bVar.n(), this.f410c.a());
    }

    public final Task s(final ea.a aVar) {
        h2.a("Attempting to record: message click to metrics logger");
        return r(cc.b.g(new ic.a() { // from class: aa.w
            @Override // ic.a
            public final void run() {
                d0 d0Var = this.f593a;
                d0Var.f414g.p(d0Var.f416i, aVar);
            }
        }));
    }

    public final cc.b t() {
        String strA = this.f416i.a().a();
        h2.a("Attempting to record message impression in impression store for id: " + strA);
        cc.b bVarD = this.f408a.m((ib.a) ib.a.d0().y(this.f409b.a()).x(strA).n()).e(new ic.d() { // from class: aa.y
            @Override // ic.d
            public final void accept(Object obj) {
                h2.b("Impression store write failure");
            }
        }).d(new ic.a() { // from class: aa.z
            @Override // ic.a
            public final void run() {
                h2.a("Impression store write success");
            }
        });
        return e2.Q(this.f417j) ? this.f411d.m(this.f413f).e(new ic.d() { // from class: aa.a0
            @Override // ic.d
            public final void accept(Object obj) {
                h2.b("Rate limiter client write failure");
            }
        }).d(new ic.a() { // from class: aa.b0
            @Override // ic.a
            public final void run() {
                h2.a("Rate limiter client write success");
            }
        }).i().b(bVarD) : bVarD;
    }

    public final boolean v() {
        return this.f415h.b();
    }

    public final cc.b w() {
        return cc.b.g(new ic.a() { // from class: aa.x
            @Override // ic.a
            public final void run() {
                this.f599a.f418k = true;
            }
        });
    }
}
