package bf;

import dd.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import ze.n;
import ze.q;
import ze.r;
import ze.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final q a(q qVar, g typeTable) {
        t.f(qVar, "<this>");
        t.f(typeTable, "typeTable");
        if (qVar.j0()) {
            return qVar.R();
        }
        if (qVar.k0()) {
            return typeTable.a(qVar.S());
        }
        return null;
    }

    public static final List b(ze.c cVar, g typeTable) {
        t.f(cVar, "<this>");
        t.f(typeTable, "typeTable");
        List listX0 = cVar.x0();
        if (listX0.isEmpty()) {
            listX0 = null;
        }
        if (listX0 == null) {
            List<Integer> listW0 = cVar.w0();
            t.e(listW0, "getContextReceiverTypeIdList(...)");
            listX0 = new ArrayList(s.u(listW0, 10));
            for (Integer num : listW0) {
                t.c(num);
                listX0.add(typeTable.a(num.intValue()));
            }
        }
        return listX0;
    }

    public static final List c(ze.i iVar, g typeTable) {
        t.f(iVar, "<this>");
        t.f(typeTable, "typeTable");
        List listY = iVar.Y();
        if (listY.isEmpty()) {
            listY = null;
        }
        if (listY == null) {
            List<Integer> listX = iVar.X();
            t.e(listX, "getContextReceiverTypeIdList(...)");
            listY = new ArrayList(s.u(listX, 10));
            for (Integer num : listX) {
                t.c(num);
                listY.add(typeTable.a(num.intValue()));
            }
        }
        return listY;
    }

    public static final List d(n nVar, g typeTable) {
        t.f(nVar, "<this>");
        t.f(typeTable, "typeTable");
        List listX = nVar.X();
        if (listX.isEmpty()) {
            listX = null;
        }
        if (listX == null) {
            List<Integer> listW = nVar.W();
            t.e(listW, "getContextReceiverTypeIdList(...)");
            listX = new ArrayList(s.u(listW, 10));
            for (Integer num : listW) {
                t.c(num);
                listX.add(typeTable.a(num.intValue()));
            }
        }
        return listX;
    }

    public static final q e(r rVar, g typeTable) {
        t.f(rVar, "<this>");
        t.f(typeTable, "typeTable");
        if (rVar.d0()) {
            q qVarT = rVar.T();
            t.e(qVarT, "getExpandedType(...)");
            return qVarT;
        }
        if (rVar.e0()) {
            return typeTable.a(rVar.U());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
    }

    public static final q f(q qVar, g typeTable) {
        t.f(qVar, "<this>");
        t.f(typeTable, "typeTable");
        if (qVar.o0()) {
            return qVar.b0();
        }
        if (qVar.p0()) {
            return typeTable.a(qVar.c0());
        }
        return null;
    }

    public static final boolean g(ze.i iVar) {
        t.f(iVar, "<this>");
        return iVar.v0() || iVar.w0();
    }

    public static final boolean h(n nVar) {
        t.f(nVar, "<this>");
        return nVar.s0() || nVar.t0();
    }

    public static final q i(ze.c cVar, g typeTable) {
        t.f(cVar, "<this>");
        t.f(typeTable, "typeTable");
        if (cVar.o1()) {
            return cVar.J0();
        }
        if (cVar.p1()) {
            return typeTable.a(cVar.K0());
        }
        return null;
    }

    public static final q j(q qVar, g typeTable) {
        t.f(qVar, "<this>");
        t.f(typeTable, "typeTable");
        if (qVar.r0()) {
            return qVar.e0();
        }
        if (qVar.s0()) {
            return typeTable.a(qVar.f0());
        }
        return null;
    }

    public static final q k(ze.i iVar, g typeTable) {
        t.f(iVar, "<this>");
        t.f(typeTable, "typeTable");
        if (iVar.v0()) {
            return iVar.f0();
        }
        if (iVar.w0()) {
            return typeTable.a(iVar.g0());
        }
        return null;
    }

    public static final q l(n nVar, g typeTable) {
        t.f(nVar, "<this>");
        t.f(typeTable, "typeTable");
        if (nVar.s0()) {
            return nVar.e0();
        }
        if (nVar.t0()) {
            return typeTable.a(nVar.f0());
        }
        return null;
    }

    public static final q m(ze.i iVar, g typeTable) {
        t.f(iVar, "<this>");
        t.f(typeTable, "typeTable");
        if (iVar.x0()) {
            q qVarH0 = iVar.h0();
            t.e(qVarH0, "getReturnType(...)");
            return qVarH0;
        }
        if (iVar.y0()) {
            return typeTable.a(iVar.i0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    public static final q n(n nVar, g typeTable) {
        t.f(nVar, "<this>");
        t.f(typeTable, "typeTable");
        if (nVar.u0()) {
            q qVarG0 = nVar.g0();
            t.e(qVarG0, "getReturnType(...)");
            return qVarG0;
        }
        if (nVar.v0()) {
            return typeTable.a(nVar.h0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    public static final List o(ze.c cVar, g typeTable) {
        t.f(cVar, "<this>");
        t.f(typeTable, "typeTable");
        List listA1 = cVar.a1();
        if (listA1.isEmpty()) {
            listA1 = null;
        }
        if (listA1 == null) {
            List<Integer> listZ0 = cVar.Z0();
            t.e(listZ0, "getSupertypeIdList(...)");
            listA1 = new ArrayList(s.u(listZ0, 10));
            for (Integer num : listZ0) {
                t.c(num);
                listA1.add(typeTable.a(num.intValue()));
            }
        }
        return listA1;
    }

    public static final q p(q.b bVar, g typeTable) {
        t.f(bVar, "<this>");
        t.f(typeTable, "typeTable");
        if (bVar.B()) {
            return bVar.y();
        }
        if (bVar.C()) {
            return typeTable.a(bVar.z());
        }
        return null;
    }

    public static final q q(u uVar, g typeTable) {
        t.f(uVar, "<this>");
        t.f(typeTable, "typeTable");
        if (uVar.S()) {
            q qVarM = uVar.M();
            t.e(qVarM, "getType(...)");
            return qVarM;
        }
        if (uVar.T()) {
            return typeTable.a(uVar.N());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    public static final q r(r rVar, g typeTable) {
        t.f(rVar, "<this>");
        t.f(typeTable, "typeTable");
        if (rVar.h0()) {
            q qVarA0 = rVar.a0();
            t.e(qVarA0, "getUnderlyingType(...)");
            return qVarA0;
        }
        if (rVar.i0()) {
            return typeTable.a(rVar.b0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
    }

    public static final List s(ze.s sVar, g typeTable) {
        t.f(sVar, "<this>");
        t.f(typeTable, "typeTable");
        List listS = sVar.S();
        if (listS.isEmpty()) {
            listS = null;
        }
        if (listS == null) {
            List<Integer> listR = sVar.R();
            t.e(listR, "getUpperBoundIdList(...)");
            listS = new ArrayList(s.u(listR, 10));
            for (Integer num : listR) {
                t.c(num);
                listS.add(typeTable.a(num.intValue()));
            }
        }
        return listS;
    }

    public static final q t(u uVar, g typeTable) {
        t.f(uVar, "<this>");
        t.f(typeTable, "typeTable");
        if (uVar.U()) {
            return uVar.O();
        }
        if (uVar.V()) {
            return typeTable.a(uVar.P());
        }
        return null;
    }
}
