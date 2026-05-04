package xf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import xf.v1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25102f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f25103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w1 f25104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.f f25105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cd.k f25106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.g f25107e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01cf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final xf.r0 a(xf.r0 r17, xf.f2 r18, java.util.Set r19, boolean r20) {
            /*
                Method dump skipped, instruction units count: 500
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xf.z1.a.a(xf.r0, xf.f2, java.util.Set, boolean):xf.r0");
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fe.l1 f25108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g0 f25109b;

        public b(fe.l1 typeParameter, g0 typeAttr) {
            kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
            kotlin.jvm.internal.t.f(typeAttr, "typeAttr");
            this.f25108a = typeParameter;
            this.f25109b = typeAttr;
        }

        public final g0 a() {
            return this.f25109b;
        }

        public final fe.l1 b() {
            return this.f25108a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.t.b(bVar.f25108a, this.f25108a) && kotlin.jvm.internal.t.b(bVar.f25109b, this.f25109b);
        }

        public int hashCode() {
            int iHashCode = this.f25108a.hashCode();
            return iHashCode + (iHashCode * 31) + this.f25109b.hashCode();
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f25108a + ", typeAttr=" + this.f25109b + ')';
        }
    }

    public z1(f0 projectionComputer, w1 options) {
        kotlin.jvm.internal.t.f(projectionComputer, "projectionComputer");
        kotlin.jvm.internal.t.f(options, "options");
        this.f25103a = projectionComputer;
        this.f25104b = options;
        wf.f fVar = new wf.f("Type parameter upper bound erasure results");
        this.f25105c = fVar;
        this.f25106d = cd.l.b(new x1(this));
        wf.g gVarI = fVar.i(new y1(this));
        kotlin.jvm.internal.t.e(gVarI, "createMemoizedFunction(...)");
        this.f25107e = gVarI;
    }

    public static final zf.i c(z1 z1Var) {
        return zf.l.d(zf.k.D0, z1Var.toString());
    }

    public static final r0 f(z1 z1Var, b bVar) {
        return z1Var.g(bVar.b(), bVar.a());
    }

    public final r0 d(g0 g0Var) {
        r0 r0VarD;
        c1 c1VarA = g0Var.a();
        return (c1VarA == null || (r0VarD = cg.d.D(c1VarA)) == null) ? h() : r0VarD;
    }

    public final r0 e(fe.l1 typeParameter, g0 typeAttr) {
        kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.t.f(typeAttr, "typeAttr");
        Object objInvoke = this.f25107e.invoke(new b(typeParameter, typeAttr));
        kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
        return (r0) objInvoke;
    }

    public final r0 g(fe.l1 l1Var, g0 g0Var) {
        a2 a2VarA;
        Set setC = g0Var.c();
        if (setC != null && setC.contains(l1Var.a())) {
            return d(g0Var);
        }
        c1 c1VarS = l1Var.s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        Set<fe.l1> setL = cg.d.l(c1VarS, setC);
        LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(setL, 10)), 16));
        for (fe.l1 l1Var2 : setL) {
            if (setC == null || !setC.contains(l1Var2)) {
                a2VarA = this.f25103a.a(l1Var2, g0Var, this, e(l1Var2, g0Var.d(l1Var)));
            } else {
                a2VarA = i2.t(l1Var2, g0Var);
                kotlin.jvm.internal.t.e(a2VarA, "makeStarProjection(...)");
            }
            cd.q qVarA = cd.w.a(l1Var2.k(), a2VarA);
            linkedHashMap.put(qVarA.c(), qVarA.d());
        }
        f2 f2VarG = f2.g(v1.a.e(v1.f25085c, linkedHashMap, false, 2, null));
        kotlin.jvm.internal.t.e(f2VarG, "create(...)");
        List upperBounds = l1Var.getUpperBounds();
        kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
        Set setI = i(f2VarG, upperBounds, g0Var);
        if (setI.isEmpty()) {
            return d(g0Var);
        }
        if (!this.f25104b.a()) {
            if (setI.size() == 1) {
                return (r0) dd.a0.u0(setI);
            }
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
        }
        List listI0 = dd.a0.I0(setI);
        ArrayList arrayList = new ArrayList(dd.s.u(listI0, 10));
        Iterator it = listI0.iterator();
        while (it.hasNext()) {
            arrayList.add(((r0) it.next()).Q0());
        }
        return yf.d.a(arrayList);
    }

    public final zf.i h() {
        return (zf.i) this.f25106d.getValue();
    }

    public final Set i(f2 f2Var, List list, g0 g0Var) {
        Set setB = dd.t0.b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r0 r0Var = (r0) it.next();
            fe.h hVarB = r0Var.N0().b();
            if (hVarB instanceof fe.e) {
                setB.add(f25102f.a(r0Var, f2Var, g0Var.c(), this.f25104b.b()));
            } else if (hVarB instanceof fe.l1) {
                Set setC = g0Var.c();
                if (setC == null || !setC.contains(hVarB)) {
                    List upperBounds = ((fe.l1) hVarB).getUpperBounds();
                    kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
                    setB.addAll(i(f2Var, upperBounds, g0Var));
                } else {
                    setB.add(d(g0Var));
                }
            }
            if (!this.f25104b.a()) {
                break;
            }
        }
        return dd.t0.a(setB);
    }

    public /* synthetic */ z1(f0 f0Var, w1 w1Var, int i10, kotlin.jvm.internal.k kVar) {
        this(f0Var, (i10 & 2) != 0 ? new w1(false, false) : w1Var);
    }
}
