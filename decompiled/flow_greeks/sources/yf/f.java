package yf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import xf.a2;
import xf.c1;
import xf.i0;
import xf.k2;
import xf.l2;
import xf.m2;
import xf.q0;
import xf.r0;
import xf.u0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends xf.q {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25403a = new a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.k {
        public b(Object obj) {
            super(1, obj, f.class, "prepareType", "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final l2 invoke(bg.i p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return ((f) this.receiver).a(p02);
        }
    }

    @Override // xf.q
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l2 a(bg.i type) {
        l2 l2VarE;
        kotlin.jvm.internal.t.f(type, "type");
        if (!(type instanceof r0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        l2 l2VarQ0 = ((r0) type).Q0();
        if (l2VarQ0 instanceof c1) {
            l2VarE = c((c1) l2VarQ0);
        } else {
            if (!(l2VarQ0 instanceof i0)) {
                throw new cd.o();
            }
            i0 i0Var = (i0) l2VarQ0;
            c1 c1VarC = c(i0Var.V0());
            c1 c1VarC2 = c(i0Var.W0());
            l2VarE = (c1VarC == i0Var.V0() && c1VarC2 == i0Var.W0()) ? l2VarQ0 : u0.e(c1VarC, c1VarC2);
        }
        return k2.c(l2VarE, l2VarQ0, new b(this));
    }

    public final c1 c(c1 c1Var) {
        r0 type;
        u1 u1VarN0 = c1Var.N0();
        q0 q0VarS = null;
        l2VarQ0 = null;
        l2 l2VarQ0 = null;
        if (!(u1VarN0 instanceof kf.c)) {
            if (!(u1VarN0 instanceof q0) || !c1Var.O0()) {
                return c1Var;
            }
            q0 q0Var = (q0) u1VarN0;
            Collection collectionC = q0Var.c();
            ArrayList arrayList = new ArrayList(dd.s.u(collectionC, 10));
            Iterator it = collectionC.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                arrayList.add(cg.d.B((r0) it.next()));
                z10 = true;
            }
            if (z10) {
                r0 r0VarL = q0Var.l();
                q0VarS = new q0(arrayList).s(r0VarL != null ? cg.d.B(r0VarL) : null);
            }
            if (q0VarS != null) {
                q0Var = q0VarS;
            }
            return q0Var.j();
        }
        kf.c cVar = (kf.c) u1VarN0;
        a2 a2VarE = cVar.e();
        if (a2VarE.b() != m2.f25016f) {
            a2VarE = null;
        }
        if (a2VarE != null && (type = a2VarE.getType()) != null) {
            l2VarQ0 = type.Q0();
        }
        l2 l2Var = l2VarQ0;
        if (cVar.g() == null) {
            a2 a2VarE2 = cVar.e();
            Collection collectionC2 = cVar.c();
            ArrayList arrayList2 = new ArrayList(dd.s.u(collectionC2, 10));
            Iterator it2 = collectionC2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((r0) it2.next()).Q0());
            }
            cVar.i(new n(a2VarE2, arrayList2, null, 4, null));
        }
        bg.b bVar = bg.b.f3351a;
        n nVarG = cVar.g();
        kotlin.jvm.internal.t.c(nVarG);
        return new i(bVar, nVarG, l2Var, c1Var.M0(), c1Var.O0(), false, 32, null);
    }
}
