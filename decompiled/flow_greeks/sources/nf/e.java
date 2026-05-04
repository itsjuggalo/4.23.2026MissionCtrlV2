package nf;

import ce.i;
import dd.r;
import dd.s;
import ef.f;
import fe.a0;
import fe.h0;
import fe.i0;
import fe.m;
import fe.n0;
import fe.q1;
import fe.s1;
import fe.x0;
import fe.y0;
import hg.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jg.h;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import pd.k;
import xf.r0;
import yf.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f17063a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends q implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17064a = new a();

        public a() {
            super(1, s1.class, "declaresDefaultValue", "declaresDefaultValue()Z", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(s1 p02) {
            t.f(p02, "p0");
            return Boolean.valueOf(p02.s0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends b.AbstractC0212b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f17065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f17066b;

        public b(m0 m0Var, k kVar) {
            this.f17065a = m0Var;
            this.f17066b = kVar;
        }

        @Override // hg.b.AbstractC0212b, hg.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(fe.b current) {
            t.f(current, "current");
            if (this.f17065a.f14947a == null && ((Boolean) this.f17066b.invoke(current)).booleanValue()) {
                this.f17065a.f14947a = current;
            }
        }

        @Override // hg.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(fe.b current) {
            t.f(current, "current");
            return this.f17065a.f14947a == null;
        }

        @Override // hg.b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public fe.b a() {
            return (fe.b) this.f17065a.f14947a;
        }
    }

    static {
        f fVarK = f.k("value");
        t.e(fVarK, "identifier(...)");
        f17063a = fVarK;
    }

    public static final h A(boolean z10, fe.b bVar) {
        t.c(bVar);
        return z(bVar, z10);
    }

    public static final fe.e B(h0 h0Var, ef.c topLevelClassFqName, ne.b location) {
        t.f(h0Var, "<this>");
        t.f(topLevelClassFqName, "topLevelClassFqName");
        t.f(location, "location");
        topLevelClassFqName.c();
        fe.h hVarE = h0Var.I0(topLevelClassFqName.d()).q().e(topLevelClassFqName.f(), location);
        if (hVarE instanceof fe.e) {
            return (fe.e) hVarE;
        }
        return null;
    }

    public static final m a(m it) {
        t.f(it, "it");
        return it.b();
    }

    public static final boolean f(s1 s1Var) {
        t.f(s1Var, "<this>");
        Boolean boolE = hg.b.e(dd.q.e(s1Var), nf.a.f17059a, a.f17064a);
        t.e(boolE, "ifAny(...)");
        return boolE.booleanValue();
    }

    public static final Iterable g(s1 s1Var) {
        Collection collectionF = s1Var.f();
        ArrayList arrayList = new ArrayList(s.u(collectionF, 10));
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add(((s1) it.next()).a());
        }
        return arrayList;
    }

    public static final fe.b h(fe.b bVar, boolean z10, k predicate) {
        t.f(bVar, "<this>");
        t.f(predicate, "predicate");
        return (fe.b) hg.b.b(dd.q.e(bVar), new c(z10), new b(new m0(), predicate));
    }

    public static /* synthetic */ fe.b i(fe.b bVar, boolean z10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(bVar, z10, kVar);
    }

    public static final Iterable j(boolean z10, fe.b bVar) {
        Collection collectionF;
        if (z10) {
            bVar = bVar != null ? bVar.a() : null;
        }
        return (bVar == null || (collectionF = bVar.f()) == null) ? r.k() : collectionF;
    }

    public static final ef.c k(m mVar) {
        t.f(mVar, "<this>");
        ef.d dVarP = p(mVar);
        if (!dVarP.f()) {
            dVarP = null;
        }
        if (dVarP != null) {
            return dVarP.m();
        }
        return null;
    }

    public static final fe.e l(ge.c cVar) {
        t.f(cVar, "<this>");
        fe.h hVarB = cVar.getType().N0().b();
        if (hVarB instanceof fe.e) {
            return (fe.e) hVarB;
        }
        return null;
    }

    public static final i m(m mVar) {
        t.f(mVar, "<this>");
        return s(mVar).p();
    }

    public static final ef.b n(fe.h hVar) {
        m mVarB;
        ef.b bVarN;
        if (hVar != null && (mVarB = hVar.b()) != null) {
            if (mVarB instanceof n0) {
                ef.c cVarE = ((n0) mVarB).e();
                f name = hVar.getName();
                t.e(name, "getName(...)");
                return new ef.b(cVarE, name);
            }
            if ((mVarB instanceof fe.i) && (bVarN = n((fe.h) mVarB)) != null) {
                f name2 = hVar.getName();
                t.e(name2, "getName(...)");
                return bVarN.d(name2);
            }
        }
        return null;
    }

    public static final ef.c o(m mVar) {
        t.f(mVar, "<this>");
        ef.c cVarN = jf.i.n(mVar);
        t.e(cVarN, "getFqNameSafe(...)");
        return cVarN;
    }

    public static final ef.d p(m mVar) {
        t.f(mVar, "<this>");
        ef.d dVarM = jf.i.m(mVar);
        t.e(dVarM, "getFqName(...)");
        return dVarM;
    }

    public static final a0 q(fe.e eVar) {
        q1 q1VarY0 = eVar != null ? eVar.y0() : null;
        if (q1VarY0 instanceof a0) {
            return (a0) q1VarY0;
        }
        return null;
    }

    public static final g r(h0 h0Var) {
        t.f(h0Var, "<this>");
        android.support.v4.media.session.b.a(h0Var.B(yf.h.a()));
        return g.a.f25404a;
    }

    public static final h0 s(m mVar) {
        t.f(mVar, "<this>");
        h0 h0VarG = jf.i.g(mVar);
        t.e(h0VarG, "getContainingModule(...)");
        return h0VarG;
    }

    public static final i0 t(fe.e eVar) {
        q1 q1VarY0 = eVar != null ? eVar.y0() : null;
        if (q1VarY0 instanceof i0) {
            return (i0) q1VarY0;
        }
        return null;
    }

    public static final h u(m mVar) {
        t.f(mVar, "<this>");
        return jg.t.w(v(mVar), 1);
    }

    public static final h v(m mVar) {
        t.f(mVar, "<this>");
        return jg.q.n(mVar, nf.b.f17060a);
    }

    public static final fe.b w(fe.b bVar) {
        t.f(bVar, "<this>");
        if (!(bVar instanceof x0)) {
            return bVar;
        }
        y0 y0VarB0 = ((x0) bVar).B0();
        t.e(y0VarB0, "getCorrespondingProperty(...)");
        return y0VarB0;
    }

    public static final fe.e x(fe.e eVar) {
        t.f(eVar, "<this>");
        for (r0 r0Var : eVar.s().N0().c()) {
            if (!i.c0(r0Var)) {
                fe.h hVarB = r0Var.N0().b();
                if (jf.i.w(hVarB)) {
                    t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (fe.e) hVarB;
                }
            }
        }
        return null;
    }

    public static final boolean y(h0 h0Var) {
        t.f(h0Var, "<this>");
        android.support.v4.media.session.b.a(h0Var.B(yf.h.a()));
        return false;
    }

    public static final h z(fe.b bVar, boolean z10) {
        t.f(bVar, "<this>");
        if (z10) {
            bVar = bVar.a();
        }
        h hVarS = jg.q.s(bVar);
        Collection collectionF = bVar.f();
        t.e(collectionF, "getOverriddenDescriptors(...)");
        return jg.t.I(hVarS, jg.t.C(dd.a0.Q(collectionF), new d(z10)));
    }
}
