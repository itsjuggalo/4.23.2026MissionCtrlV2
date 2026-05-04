package tf;

import bf.h;
import ce.o;
import fe.g1;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f21980c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f21981d = dd.t0.c(ef.b.f8779d.c(o.a.f3979d.m()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f21982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f21983b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ef.b f21984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f21985b;

        public a(ef.b classId, i iVar) {
            kotlin.jvm.internal.t.f(classId, "classId");
            this.f21984a = classId;
            this.f21985b = iVar;
        }

        public final i a() {
            return this.f21985b;
        }

        public final ef.b b() {
            return this.f21984a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.t.b(this.f21984a, ((a) obj).f21984a);
        }

        public int hashCode() {
            return this.f21984a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final Set a() {
            return l.f21981d;
        }

        public b() {
        }
    }

    public l(n components) {
        kotlin.jvm.internal.t.f(components, "components");
        this.f21982a = components;
        this.f21983b = components.u().h(new k(this));
    }

    public static final fe.e c(l lVar, a key) {
        kotlin.jvm.internal.t.f(key, "key");
        return lVar.d(key);
    }

    public static /* synthetic */ fe.e f(l lVar, ef.b bVar, i iVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = null;
        }
        return lVar.e(bVar, iVar);
    }

    public final fe.e d(a aVar) {
        Object next;
        p pVarA;
        ef.b bVarB = aVar.b();
        Iterator it = this.f21982a.l().iterator();
        while (it.hasNext()) {
            fe.e eVarA = ((he.b) it.next()).a(bVarB);
            if (eVarA != null) {
                return eVarA;
            }
        }
        if (f21981d.contains(bVarB)) {
            return null;
        }
        i iVarA = aVar.a();
        if (iVarA == null && (iVarA = this.f21982a.e().a(bVarB)) == null) {
            return null;
        }
        bf.c cVarA = iVarA.a();
        ze.c cVarB = iVarA.b();
        bf.a aVarC = iVarA.c();
        g1 g1VarD = iVarA.d();
        ef.b bVarE = bVarB.e();
        if (bVarE != null) {
            fe.e eVarF = f(this, bVarE, null, 2, null);
            vf.m mVar = eVarF instanceof vf.m ? (vf.m) eVarF : null;
            if (mVar == null || !mVar.k1(bVarB.h())) {
                return null;
            }
            pVarA = mVar.d1();
        } else {
            Iterator it2 = fe.s0.c(this.f21982a.s(), bVarB.f()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                fe.n0 n0Var = (fe.n0) next;
                if (!(n0Var instanceof r) || ((r) n0Var).K0(bVarB.h())) {
                    break;
                }
            }
            fe.n0 n0Var2 = (fe.n0) next;
            if (n0Var2 == null) {
                return null;
            }
            n nVar = this.f21982a;
            ze.t tVarH1 = cVarB.h1();
            kotlin.jvm.internal.t.e(tVarH1, "getTypeTable(...)");
            bf.g gVar = new bf.g(tVarH1);
            h.a aVar2 = bf.h.f3348b;
            ze.w wVarJ1 = cVarB.j1();
            kotlin.jvm.internal.t.e(wVarJ1, "getVersionRequirementTable(...)");
            pVarA = nVar.a(n0Var2, cVarA, gVar, aVar2.a(wVarJ1), aVarC, null);
            aVarC = aVarC;
        }
        return new vf.m(pVarA, cVarB, cVarA, aVarC, g1VarD);
    }

    public final fe.e e(ef.b classId, i iVar) {
        kotlin.jvm.internal.t.f(classId, "classId");
        return (fe.e) this.f21983b.invoke(new a(classId, iVar));
    }
}
