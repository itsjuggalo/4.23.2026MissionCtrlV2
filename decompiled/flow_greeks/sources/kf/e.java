package kf;

import cd.q;
import dd.s;
import fe.h;
import fe.l1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import wf.f;
import wf.n;
import xf.a2;
import xf.c2;
import xf.d2;
import xf.m0;
import xf.m2;
import xf.r0;
import xf.x0;
import xf.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f14851d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d2 d2Var, boolean z10) {
            super(d2Var);
            this.f14851d = z10;
        }

        @Override // xf.d2
        public boolean b() {
            return this.f14851d;
        }

        @Override // xf.z, xf.d2
        public a2 e(r0 key) {
            t.f(key, "key");
            a2 a2VarE = super.e(key);
            if (a2VarE == null) {
                return null;
            }
            h hVarB = key.N0().b();
            return e.c(a2VarE, hVarB instanceof l1 ? (l1) hVarB : null);
        }
    }

    public static final a2 c(a2 a2Var, l1 l1Var) {
        if (l1Var == null || a2Var.b() == m2.f25015e) {
            return a2Var;
        }
        if (l1Var.o() != a2Var.b()) {
            return new c2(e(a2Var));
        }
        if (!a2Var.c()) {
            return new c2(a2Var.getType());
        }
        n NO_LOCKS = f.f24060e;
        t.e(NO_LOCKS, "NO_LOCKS");
        return new c2(new x0(NO_LOCKS, new d(a2Var)));
    }

    public static final r0 d(a2 a2Var) {
        r0 type = a2Var.getType();
        t.e(type, "getType(...)");
        return type;
    }

    public static final r0 e(a2 typeProjection) {
        t.f(typeProjection, "typeProjection");
        return new kf.a(typeProjection, null, false, null, 14, null);
    }

    public static final boolean f(r0 r0Var) {
        t.f(r0Var, "<this>");
        return r0Var.N0() instanceof b;
    }

    public static final d2 g(d2 d2Var, boolean z10) {
        t.f(d2Var, "<this>");
        if (!(d2Var instanceof m0)) {
            return new a(d2Var, z10);
        }
        m0 m0Var = (m0) d2Var;
        l1[] l1VarArrJ = m0Var.j();
        List<q> listP0 = dd.n.P0(m0Var.i(), m0Var.j());
        ArrayList arrayList = new ArrayList(s.u(listP0, 10));
        for (q qVar : listP0) {
            arrayList.add(c((a2) qVar.c(), (l1) qVar.d()));
        }
        return new m0(l1VarArrJ, (a2[]) arrayList.toArray(new a2[0]), z10);
    }

    public static /* synthetic */ d2 h(d2 d2Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return g(d2Var, z10);
    }
}
