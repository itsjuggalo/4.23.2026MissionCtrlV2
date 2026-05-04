package l8;

import j8.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import m8.m;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f15540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f15541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q8.c f15542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f15543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f15544e;

    public b(j8.g gVar, f fVar, a aVar) {
        this(gVar, fVar, aVar, new m8.b());
    }

    @Override // l8.e
    public void a() {
        this.f15540a.a();
    }

    @Override // l8.e
    public void b(long j10) {
        this.f15540a.b(j10);
    }

    @Override // l8.e
    public void c(l lVar, n nVar, long j10) {
        this.f15540a.c(lVar, nVar, j10);
    }

    @Override // l8.e
    public List d() {
        return this.f15540a.d();
    }

    @Override // l8.e
    public void e(l lVar, j8.b bVar, long j10) {
        this.f15540a.e(lVar, bVar, j10);
    }

    @Override // l8.e
    public void f(l lVar, j8.b bVar) {
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            k(lVar.u((l) entry.getKey()), (n) entry.getValue());
        }
    }

    @Override // l8.e
    public void g(l lVar, j8.b bVar) {
        this.f15540a.r(lVar, bVar);
        q();
    }

    @Override // l8.e
    public void h(o8.i iVar, Set set, Set set2) {
        m.g(!iVar.g(), "We should only track keys for filtered queries.");
        h hVarI = this.f15541b.i(iVar);
        m.g(hVarI != null && hVarI.f15558e, "We only expect tracked keys for currently-active queries.");
        this.f15540a.u(hVarI.f15554a, set, set2);
    }

    @Override // l8.e
    public o8.a i(o8.i iVar) {
        Set<r8.b> setJ;
        boolean z10;
        if (this.f15541b.n(iVar)) {
            h hVarI = this.f15541b.i(iVar);
            setJ = (iVar.g() || hVarI == null || !hVarI.f15557d) ? null : this.f15540a.h(hVarI.f15554a);
            z10 = true;
        } else {
            setJ = this.f15541b.j(iVar.e());
            z10 = false;
        }
        n nVarT = this.f15540a.t(iVar.e());
        if (setJ == null) {
            return new o8.a(r8.i.d(nVarT, iVar.c()), z10, false);
        }
        n nVarY = r8.g.y();
        for (r8.b bVar : setJ) {
            nVarY = nVarY.t(bVar, nVarT.z(bVar));
        }
        return new o8.a(r8.i.d(nVarY, iVar.c()), z10, true);
    }

    @Override // l8.e
    public void j(o8.i iVar, Set set) {
        m.g(!iVar.g(), "We should only track keys for filtered queries.");
        h hVarI = this.f15541b.i(iVar);
        m.g(hVarI != null && hVarI.f15558e, "We only expect tracked keys for currently-active queries.");
        this.f15540a.p(hVarI.f15554a, set);
    }

    @Override // l8.e
    public void k(l lVar, n nVar) {
        if (this.f15541b.l(lVar)) {
            return;
        }
        this.f15540a.j(lVar, nVar);
        this.f15541b.g(lVar);
    }

    @Override // l8.e
    public void l(o8.i iVar) {
        this.f15541b.x(iVar);
    }

    @Override // l8.e
    public Object m(Callable callable) {
        this.f15540a.f();
        try {
            Object objCall = callable.call();
            this.f15540a.l();
            return objCall;
        } finally {
        }
    }

    @Override // l8.e
    public void n(o8.i iVar) {
        if (iVar.g()) {
            this.f15541b.t(iVar.e());
        } else {
            this.f15541b.w(iVar);
        }
    }

    @Override // l8.e
    public void o(o8.i iVar) {
        this.f15541b.u(iVar);
    }

    @Override // l8.e
    public void p(o8.i iVar, n nVar) {
        if (iVar.g()) {
            this.f15540a.j(iVar.e(), nVar);
        } else {
            this.f15540a.v(iVar.e(), nVar);
        }
        n(iVar);
        q();
    }

    public final void q() {
        long j10 = this.f15544e + 1;
        this.f15544e = j10;
        if (this.f15543d.d(j10)) {
            if (this.f15542c.f()) {
                this.f15542c.b("Reached prune check threshold.", new Object[0]);
            }
            this.f15544e = 0L;
            long jQ = this.f15540a.q();
            if (this.f15542c.f()) {
                this.f15542c.b("Cache size: " + jQ, new Object[0]);
            }
            boolean z10 = true;
            while (z10 && this.f15543d.a(jQ, this.f15541b.f())) {
                g gVarP = this.f15541b.p(this.f15543d);
                if (gVarP.e()) {
                    this.f15540a.k(l.G(), gVarP);
                } else {
                    z10 = false;
                }
                jQ = this.f15540a.q();
                if (this.f15542c.f()) {
                    this.f15542c.b("Cache size after prune: " + jQ, new Object[0]);
                }
            }
        }
    }

    public b(j8.g gVar, f fVar, a aVar, m8.a aVar2) {
        this.f15544e = 0L;
        this.f15540a = fVar;
        q8.c cVarQ = gVar.q("Persistence");
        this.f15542c = cVarQ;
        this.f15541b = new i(fVar, cVarQ, aVar2);
        this.f15543d = aVar;
    }
}
