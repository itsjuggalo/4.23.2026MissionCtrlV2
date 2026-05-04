package g9;

import android.content.Context;
import i9.l4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.firebase.firestore.g f10235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m9.m0 f10236b = new m9.m0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i9.h1 f10237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i9.k0 f10238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f1 f10239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m9.s0 f10240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f10241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i9.l f10242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l4 f10243i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f10244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n9.g f10245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l f10246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e9.j f10247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f10248e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e9.a f10249f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final e9.a f10250g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final m9.i0 f10251h;

        public a(Context context, n9.g gVar, l lVar, e9.j jVar, int i10, e9.a aVar, e9.a aVar2, m9.i0 i0Var) {
            this.f10244a = context;
            this.f10245b = gVar;
            this.f10246c = lVar;
            this.f10247d = jVar;
            this.f10248e = i10;
            this.f10249f = aVar;
            this.f10250g = aVar2;
            this.f10251h = i0Var;
        }
    }

    public j(com.google.firebase.firestore.g gVar) {
        this.f10235a = gVar;
    }

    public static j h(com.google.firebase.firestore.g gVar) {
        return gVar.i() ? new e1(gVar) : new x0(gVar);
    }

    public abstract o a(a aVar);

    public abstract l4 b(a aVar);

    public abstract i9.l c(a aVar);

    public abstract i9.k0 d(a aVar);

    public abstract i9.h1 e(a aVar);

    public abstract m9.s0 f(a aVar);

    public abstract f1 g(a aVar);

    public m9.n i() {
        return this.f10236b.f();
    }

    public m9.q j() {
        return this.f10236b.g();
    }

    public o k() {
        return (o) n9.b.e(this.f10241g, "eventManager not initialized yet", new Object[0]);
    }

    public l4 l() {
        return this.f10243i;
    }

    public i9.l m() {
        return this.f10242h;
    }

    public i9.k0 n() {
        return (i9.k0) n9.b.e(this.f10238d, "localStore not initialized yet", new Object[0]);
    }

    public i9.h1 o() {
        return (i9.h1) n9.b.e(this.f10237c, "persistence not initialized yet", new Object[0]);
    }

    public m9.o0 p() {
        return this.f10236b.j();
    }

    public m9.s0 q() {
        return (m9.s0) n9.b.e(this.f10240f, "remoteStore not initialized yet", new Object[0]);
    }

    public f1 r() {
        return (f1) n9.b.e(this.f10239e, "syncEngine not initialized yet", new Object[0]);
    }

    public void s(a aVar) {
        this.f10236b.k(aVar);
        i9.h1 h1VarE = e(aVar);
        this.f10237c = h1VarE;
        h1VarE.n();
        this.f10238d = d(aVar);
        this.f10240f = f(aVar);
        this.f10239e = g(aVar);
        this.f10241g = a(aVar);
        this.f10238d.Y();
        this.f10240f.N();
        this.f10243i = b(aVar);
        this.f10242h = c(aVar);
    }
}
