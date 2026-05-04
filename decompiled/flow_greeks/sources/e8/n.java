package e8;

import com.google.android.gms.tasks.Task;
import e8.e;
import j8.d0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j8.n f8506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j8.l f8507b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8.n f8508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m8.g f8509b;

        public a(r8.n nVar, m8.g gVar) {
            this.f8508a = nVar;
            this.f8509b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f8506a.W(n.this.f8507b, this.f8508a, (e.InterfaceC0157e) this.f8509b.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f8511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m8.g f8512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f8513c;

        public b(Map map, m8.g gVar, Map map2) {
            this.f8511a = map;
            this.f8512b = gVar;
            this.f8513c = map2;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f8506a.X(n.this.f8507b, this.f8511a, (e.InterfaceC0157e) this.f8512b.b(), this.f8513c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m8.g f8515a;

        public c(m8.g gVar) {
            this.f8515a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f8506a.V(n.this.f8507b, (e.InterfaceC0157e) this.f8515a.b());
        }
    }

    public n(j8.n nVar, j8.l lVar) {
        this.f8506a = nVar;
        this.f8507b = lVar;
    }

    public Task c() {
        return d(null);
    }

    public final Task d(e.InterfaceC0157e interfaceC0157e) {
        m8.g gVarL = m8.m.l(interfaceC0157e);
        this.f8506a.k0(new c(gVarL));
        return (Task) gVarL.a();
    }

    public final Task e(Object obj, r8.n nVar, e.InterfaceC0157e interfaceC0157e) {
        m8.n.l(this.f8507b);
        d0.g(this.f8507b, obj);
        Object objB = n8.a.b(obj);
        m8.n.k(objB);
        r8.n nVarB = r8.o.b(objB, nVar);
        m8.g gVarL = m8.m.l(interfaceC0157e);
        this.f8506a.k0(new a(nVarB, gVarL));
        return (Task) gVarL.a();
    }

    public Task f(Object obj) {
        return e(obj, r8.r.a(), null);
    }

    public Task g(Object obj, double d10) {
        return e(obj, r8.r.c(this.f8507b, Double.valueOf(d10)), null);
    }

    public Task h(Object obj, String str) {
        return e(obj, r8.r.c(this.f8507b, str), null);
    }

    public Task i(Map map) {
        return j(map, null);
    }

    public final Task j(Map map, e.InterfaceC0157e interfaceC0157e) {
        Map mapE = m8.n.e(this.f8507b, map);
        m8.g gVarL = m8.m.l(interfaceC0157e);
        this.f8506a.k0(new b(mapE, gVarL, map));
        return (Task) gVarL.a();
    }
}
