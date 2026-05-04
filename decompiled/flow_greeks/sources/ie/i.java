package ie;

import fe.b;
import fe.b1;
import fe.g1;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import xf.f2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class i extends s implements fe.d {
    public final boolean E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(fe.e eVar, fe.l lVar, ge.h hVar, boolean z10, b.a aVar, g1 g1Var) {
        super(eVar, lVar, hVar, ef.h.f8809j, aVar, g1Var);
        if (eVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (aVar == null) {
            w(2);
        }
        if (g1Var == null) {
            w(3);
        }
        this.E = z10;
    }

    public static i n1(fe.e eVar, ge.h hVar, boolean z10, g1 g1Var) {
        if (eVar == null) {
            w(4);
        }
        if (hVar == null) {
            w(5);
        }
        if (g1Var == null) {
            w(6);
        }
        return new i(eVar, null, hVar, z10, b.a.DECLARATION, g1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void w(int r8) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.i.w(int):void");
    }

    @Override // fe.l
    public boolean C() {
        return this.E;
    }

    @Override // fe.l
    public fe.e D() {
        fe.e eVarB = b();
        if (eVarB == null) {
            w(18);
        }
        return eVarB;
    }

    @Override // ie.s, fe.z, fe.b, fe.a
    public Collection f() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            w(21);
        }
        return set;
    }

    public final List k1() {
        fe.e eVarB = b();
        if (eVarB.G0().isEmpty()) {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                w(16);
            }
            return list;
        }
        List listG0 = eVarB.G0();
        if (listG0 == null) {
            w(15);
        }
        return listG0;
    }

    public b1 l1() {
        fe.e eVarB = b();
        if (!eVarB.P()) {
            return null;
        }
        fe.m mVarB = eVarB.b();
        if (mVarB instanceof fe.e) {
            return ((fe.e) mVarB).J0();
        }
        return null;
    }

    @Override // fe.b
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public fe.d L(fe.m mVar, fe.e0 e0Var, fe.u uVar, b.a aVar, boolean z10) {
        fe.d dVar = (fe.d) super.K0(mVar, e0Var, uVar, aVar, z10);
        if (dVar == null) {
            w(27);
        }
        return dVar;
    }

    @Override // ie.s
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public i L0(fe.m mVar, fe.z zVar, b.a aVar, ef.f fVar, ge.h hVar, g1 g1Var) {
        if (mVar == null) {
            w(23);
        }
        if (aVar == null) {
            w(24);
        }
        if (hVar == null) {
            w(25);
        }
        if (g1Var == null) {
            w(26);
        }
        b.a aVar2 = b.a.DECLARATION;
        if (aVar == aVar2 || aVar == b.a.SYNTHESIZED) {
            return new i((fe.e) mVar, this, hVar, this.E, aVar2, g1Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // ie.n, fe.m
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public fe.e b() {
        fe.e eVar = (fe.e) super.b();
        if (eVar == null) {
            w(17);
        }
        return eVar;
    }

    public i q1(List list, fe.u uVar) {
        if (list == null) {
            w(13);
        }
        if (uVar == null) {
            w(14);
        }
        r1(list, uVar, b().v());
        return this;
    }

    public i r1(List list, fe.u uVar, List list2) {
        if (list == null) {
            w(10);
        }
        if (uVar == null) {
            w(11);
        }
        if (list2 == null) {
            w(12);
        }
        super.R0(null, l1(), k1(), list2, list, null, fe.e0.f9461b, uVar);
        return this;
    }

    @Override // ie.s, fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.l(this, obj);
    }

    @Override // ie.s, fe.b
    public void w0(Collection collection) {
        if (collection == null) {
            w(22);
        }
    }

    @Override // ie.s, fe.z, fe.i1
    public fe.d c(f2 f2Var) {
        if (f2Var == null) {
            w(20);
        }
        return (fe.d) super.c(f2Var);
    }

    @Override // ie.n
    public fe.d a() {
        fe.d dVar = (fe.d) super.a();
        if (dVar == null) {
            w(19);
        }
        return dVar;
    }
}
