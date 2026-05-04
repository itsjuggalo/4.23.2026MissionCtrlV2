package j8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m8.i f13997d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j8.b f13998a = j8.b.q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f13999b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f14000c = -1L;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements m8.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f14002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f14003d;

        public a(boolean z10, List list, l lVar) {
            this.f14001b = z10;
            this.f14002c = list;
            this.f14003d = lVar;
        }

        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(c0 c0Var) {
            if ((c0Var.f() || this.f14001b) && !this.f14002c.contains(Long.valueOf(c0Var.d()))) {
                return c0Var.c().y(this.f14003d) || this.f14003d.y(c0Var.c());
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(c0 c0Var) {
            return c0Var.f();
        }
    }

    public static j8.b j(List list, m8.i iVar, l lVar) {
        j8.b bVarQ = j8.b.q();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (iVar.a(c0Var)) {
                l lVarC = c0Var.c();
                if (c0Var.e()) {
                    if (lVar.y(lVarC)) {
                        bVarQ = bVarQ.a(l.R(lVar, lVarC), c0Var.b());
                    } else if (lVarC.y(lVar)) {
                        bVarQ = bVarQ.a(l.G(), c0Var.b().O(l.R(lVarC, lVar)));
                    }
                } else if (lVar.y(lVarC)) {
                    bVarQ = bVarQ.d(l.R(lVar, lVarC), c0Var.a());
                } else if (lVarC.y(lVar)) {
                    l lVarR = l.R(lVarC, lVar);
                    if (lVarR.isEmpty()) {
                        bVarQ = bVarQ.d(l.G(), c0Var.a());
                    } else {
                        r8.n nVarV = c0Var.a().v(lVarR);
                        if (nVarV != null) {
                            bVarQ = bVarQ.a(l.G(), nVarV);
                        }
                    }
                }
            }
        }
        return bVarQ;
    }

    public void a(l lVar, j8.b bVar, Long l10) {
        m8.m.f(l10.longValue() > this.f14000c.longValue());
        this.f13999b.add(new c0(l10.longValue(), lVar, bVar));
        this.f13998a = this.f13998a.d(lVar, bVar);
        this.f14000c = l10;
    }

    public void b(l lVar, r8.n nVar, Long l10, boolean z10) {
        m8.m.f(l10.longValue() > this.f14000c.longValue());
        this.f13999b.add(new c0(l10.longValue(), lVar, nVar, z10));
        if (z10) {
            this.f13998a = this.f13998a.a(lVar, nVar);
        }
        this.f14000c = l10;
    }

    public r8.n c(l lVar, r8.b bVar, o8.a aVar) {
        l lVarV = lVar.v(bVar);
        r8.n nVarV = this.f13998a.v(lVarV);
        if (nVarV != null) {
            return nVarV;
        }
        if (aVar.c(bVar)) {
            return this.f13998a.g(lVarV).e(aVar.b().z(bVar));
        }
        return null;
    }

    public r8.n d(l lVar, r8.n nVar, List list, boolean z10) {
        if (!list.isEmpty() || z10) {
            j8.b bVarG = this.f13998a.g(lVar);
            if (z10 || !bVarG.isEmpty()) {
                if (!z10 && nVar == null && !bVarG.y(l.G())) {
                    return null;
                }
                j8.b bVarJ = j(this.f13999b, new a(z10, list, lVar), lVar);
                if (nVar == null) {
                    nVar = r8.g.y();
                }
                return bVarJ.e(nVar);
            }
        } else {
            r8.n nVarV = this.f13998a.v(lVar);
            if (nVarV != null) {
                return nVarV;
            }
            j8.b bVarG2 = this.f13998a.g(lVar);
            if (!bVarG2.isEmpty()) {
                if (nVar == null && !bVarG2.y(l.G())) {
                    return null;
                }
                if (nVar == null) {
                    nVar = r8.g.y();
                }
                return bVarG2.e(nVar);
            }
        }
        return nVar;
    }

    public r8.n e(l lVar, r8.n nVar) {
        r8.n nVarY = r8.g.y();
        r8.n<r8.m> nVarV = this.f13998a.v(lVar);
        if (nVarV != null) {
            if (!nVarV.J()) {
                for (r8.m mVar : nVarV) {
                    nVarY = nVarY.t(mVar.c(), mVar.d());
                }
            }
            return nVarY;
        }
        j8.b bVarG = this.f13998a.g(lVar);
        Iterator it = nVar.iterator();
        while (it.hasNext()) {
            r8.m mVar2 = (r8.m) it.next();
            nVarY = nVarY.t(mVar2.c(), bVarG.g(new l(mVar2.c())).e(mVar2.d()));
        }
        for (r8.m mVar3 : bVarG.u()) {
            nVarY = nVarY.t(mVar3.c(), mVar3.d());
        }
        return nVarY;
    }

    public r8.n f(l lVar, l lVar2, r8.n nVar, r8.n nVar2) {
        m8.m.g((nVar == null && nVar2 == null) ? false : true, "Either existingEventSnap or existingServerSnap must exist");
        l lVarU = lVar.u(lVar2);
        if (this.f13998a.y(lVarU)) {
            return null;
        }
        j8.b bVarG = this.f13998a.g(lVarU);
        return bVarG.isEmpty() ? nVar2.O(lVar2) : bVarG.e(nVar2.O(lVar2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r8.m g(j8.l r3, r8.n r4, r8.m r5, boolean r6, r8.h r7) {
        /*
            r2 = this;
            j8.b r0 = r2.f13998a
            j8.b r3 = r0.g(r3)
            j8.l r0 = j8.l.G()
            r8.n r0 = r3.v(r0)
            r1 = 0
            if (r0 == 0) goto L12
            goto L18
        L12:
            if (r4 == 0) goto L38
            r8.n r0 = r3.e(r4)
        L18:
            java.util.Iterator r3 = r0.iterator()
        L1c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L38
            java.lang.Object r4 = r3.next()
            r8.m r4 = (r8.m) r4
            int r0 = r7.a(r4, r5, r6)
            if (r0 <= 0) goto L1c
            if (r1 == 0) goto L36
            int r0 = r7.a(r4, r1, r6)
            if (r0 >= 0) goto L1c
        L36:
            r1 = r4
            goto L1c
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j8.g0.g(j8.l, r8.n, r8.m, boolean, r8.h):r8.m");
    }

    public h0 h(l lVar) {
        return new h0(lVar, this);
    }

    public c0 i(long j10) {
        for (c0 c0Var : this.f13999b) {
            if (c0Var.d() == j10) {
                return c0Var;
            }
        }
        return null;
    }

    public List k() {
        ArrayList arrayList = new ArrayList(this.f13999b);
        this.f13998a = j8.b.q();
        this.f13999b = new ArrayList();
        return arrayList;
    }

    public final boolean l(c0 c0Var, l lVar) {
        if (c0Var.e()) {
            return c0Var.c().y(lVar);
        }
        Iterator it = c0Var.a().iterator();
        while (it.hasNext()) {
            if (c0Var.c().u((l) ((Map.Entry) it.next()).getKey()).y(lVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean m(long j10) {
        c0 c0Var;
        Iterator it = this.f13999b.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                c0Var = null;
                break;
            }
            c0Var = (c0) it.next();
            if (c0Var.d() == j10) {
                break;
            }
            i10++;
        }
        m8.m.g(c0Var != null, "removeWrite called with nonexistent writeId");
        this.f13999b.remove(c0Var);
        boolean zF = c0Var.f();
        boolean z10 = false;
        for (int size = this.f13999b.size() - 1; zF && size >= 0; size--) {
            c0 c0Var2 = (c0) this.f13999b.get(size);
            if (c0Var2.f()) {
                if (size >= i10 && l(c0Var2, c0Var.c())) {
                    zF = false;
                } else if (c0Var.c().y(c0Var2.c())) {
                    z10 = true;
                }
            }
        }
        if (!zF) {
            return false;
        }
        if (z10) {
            n();
            return true;
        }
        if (c0Var.e()) {
            this.f13998a = this.f13998a.A(c0Var.c());
        } else {
            Iterator it2 = c0Var.a().iterator();
            while (it2.hasNext()) {
                this.f13998a = this.f13998a.A(c0Var.c().u((l) ((Map.Entry) it2.next()).getKey()));
            }
        }
        return true;
    }

    public final void n() {
        this.f13998a = j(this.f13999b, f13997d, l.G());
        if (this.f13999b.size() <= 0) {
            this.f14000c = -1L;
        } else {
            this.f14000c = Long.valueOf(((c0) this.f13999b.get(r0.size() - 1)).d());
        }
    }

    public r8.n o(l lVar) {
        return this.f13998a.v(lVar);
    }
}
