package d9;

import bb.b;
import bb.d0;
import bb.u;
import d9.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k9.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.f f7976a;

    public x1(j9.f fVar) {
        this.f7976a = fVar;
    }

    public final j9.s a(Object obj, g9.r1 r1Var) {
        if (obj.getClass().isArray()) {
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was an array");
        }
        bb.d0 d0VarD = d(n9.o.c(obj), r1Var);
        if (d0VarD.w0() == d0.c.MAP_VALUE) {
            return new j9.s(d0VarD);
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was of type: " + n9.g0.w(obj));
    }

    public bb.d0 b(Object obj, g9.r1 r1Var) {
        return d(n9.o.c(obj), r1Var);
    }

    public final List c(List list) {
        g9.q1 q1Var = new g9.q1(g9.u1.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(b(list.get(i10), q1Var.f().c(i10)));
        }
        return arrayList;
    }

    public final bb.d0 d(Object obj, g9.r1 r1Var) {
        if (obj instanceof Map) {
            return f((Map) obj, r1Var);
        }
        if (obj instanceof u) {
            k((u) obj, r1Var);
            return null;
        }
        if (r1Var.h() != null) {
            r1Var.a(r1Var.h());
        }
        if (!(obj instanceof List)) {
            return j(obj, r1Var);
        }
        if (!r1Var.i() || r1Var.g() == g9.u1.ArrayArgument) {
            return e((List) obj, r1Var);
        }
        throw r1Var.f("Nested arrays are not supported");
    }

    public final bb.d0 e(List list, g9.r1 r1Var) {
        b.C0055b c0055bJ0 = bb.b.j0();
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bb.d0 d0VarD = d(it.next(), r1Var.c(i10));
            if (d0VarD == null) {
                d0VarD = (bb.d0) bb.d0.y0().H(com.google.protobuf.d1.NULL_VALUE).n();
            }
            c0055bJ0.y(d0VarD);
            i10++;
        }
        return (bb.d0) bb.d0.y0().y(c0055bJ0).n();
    }

    public final bb.d0 f(Map map, g9.r1 r1Var) {
        if (map.isEmpty()) {
            if (r1Var.h() != null && !r1Var.h().isEmpty()) {
                r1Var.a(r1Var.h());
            }
            return (bb.d0) bb.d0.y0().G(bb.u.b0()).n();
        }
        u.b bVarJ0 = bb.u.j0();
        for (Map.Entry entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw r1Var.f(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
            }
            String str = (String) entry.getKey();
            bb.d0 d0VarD = d(entry.getValue(), r1Var.e(str));
            if (d0VarD != null) {
                bVarJ0.z(str, d0VarD);
            }
        }
        return (bb.d0) bb.d0.y0().F(bVarJ0).n();
    }

    public g9.s1 g(Object obj, k9.d dVar) {
        g9.q1 q1Var = new g9.q1(g9.u1.MergeSet);
        j9.s sVarA = a(obj, q1Var.f());
        if (dVar == null) {
            return q1Var.g(sVarA);
        }
        for (j9.q qVar : dVar.c()) {
            if (!q1Var.d(qVar)) {
                throw new IllegalArgumentException("Field '" + qVar.toString() + "' is specified in your field mask but not in your input data.");
            }
        }
        return q1Var.h(sVarA, dVar);
    }

    public bb.d0 h(Object obj) {
        return i(obj, false);
    }

    public bb.d0 i(Object obj, boolean z10) {
        g9.q1 q1Var = new g9.q1(z10 ? g9.u1.ArrayArgument : g9.u1.Argument);
        bb.d0 d0VarB = b(obj, q1Var.f());
        n9.b.d(d0VarB != null, "Parsed data should not be null.", new Object[0]);
        n9.b.d(q1Var.e().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return d0VarB;
    }

    public final bb.d0 j(Object obj, g9.r1 r1Var) {
        if (obj == null) {
            return (bb.d0) bb.d0.y0().H(com.google.protobuf.d1.NULL_VALUE).n();
        }
        if (obj instanceof Integer) {
            return (bb.d0) bb.d0.y0().E(((Integer) obj).intValue()).n();
        }
        if (obj instanceof Long) {
            return (bb.d0) bb.d0.y0().E(((Long) obj).longValue()).n();
        }
        if (obj instanceof Float) {
            return (bb.d0) bb.d0.y0().C(((Float) obj).doubleValue()).n();
        }
        if (obj instanceof Double) {
            return (bb.d0) bb.d0.y0().C(((Double) obj).doubleValue()).n();
        }
        if (obj instanceof Boolean) {
            return (bb.d0) bb.d0.y0().A(((Boolean) obj).booleanValue()).n();
        }
        if (obj instanceof String) {
            return (bb.d0) bb.d0.y0().J((String) obj).n();
        }
        if (obj instanceof Date) {
            return m(new a7.s((Date) obj));
        }
        if (obj instanceof a7.s) {
            return m((a7.s) obj);
        }
        if (obj instanceof q0) {
            q0 q0Var = (q0) obj;
            return (bb.d0) bb.d0.y0().D(kb.a.f0().x(q0Var.b()).y(q0Var.c())).n();
        }
        if (obj instanceof e) {
            return (bb.d0) bb.d0.y0().B(((e) obj).h()).n();
        }
        if (obj instanceof com.google.firebase.firestore.c) {
            com.google.firebase.firestore.c cVar = (com.google.firebase.firestore.c) obj;
            if (cVar.p() != null) {
                j9.f fVarB = cVar.p().B();
                if (!fVarB.equals(this.f7976a)) {
                    throw r1Var.f(String.format("Document reference is for database %s/%s but should be for database %s/%s", fVarB.i(), fVarB.h(), this.f7976a.i(), this.f7976a.h()));
                }
            }
            return (bb.d0) bb.d0.y0().I(String.format("projects/%s/databases/%s/documents/%s", this.f7976a.i(), this.f7976a.h(), cVar.r())).n();
        }
        if (obj instanceof y1) {
            return p((y1) obj, r1Var);
        }
        if (obj.getClass().isArray()) {
            throw r1Var.f("Arrays are not supported; use a List instead");
        }
        throw r1Var.f("Unsupported type: " + n9.g0.w(obj));
    }

    public final void k(u uVar, g9.r1 r1Var) {
        if (!r1Var.j()) {
            throw r1Var.f(String.format("%s() can only be used with set() and update()", uVar.d()));
        }
        if (r1Var.h() == null) {
            throw r1Var.f(String.format("%s() is not currently supported inside arrays", uVar.d()));
        }
        if (uVar instanceof u.c) {
            if (r1Var.g() == g9.u1.MergeSet) {
                r1Var.a(r1Var.h());
                return;
            } else {
                if (r1Var.g() != g9.u1.Update) {
                    throw r1Var.f("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                }
                n9.b.d(r1Var.h().u() > 0, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw r1Var.f("FieldValue.delete() can only appear at the top level of your update data");
            }
        }
        if (uVar instanceof u.e) {
            r1Var.b(r1Var.h(), k9.n.d());
            return;
        }
        if (uVar instanceof u.b) {
            r1Var.b(r1Var.h(), new a.b(c(((u.b) uVar).i())));
        } else if (uVar instanceof u.a) {
            r1Var.b(r1Var.h(), new a.C0254a(c(((u.a) uVar).i())));
        } else {
            if (!(uVar instanceof u.d)) {
                throw n9.b.a("Unknown FieldValue type: %s", n9.g0.w(uVar));
            }
            r1Var.b(r1Var.h(), new k9.j(h(((u.d) uVar).i())));
        }
    }

    public g9.s1 l(Object obj) {
        g9.q1 q1Var = new g9.q1(g9.u1.Set);
        return q1Var.i(a(obj, q1Var.f()));
    }

    public final bb.d0 m(a7.s sVar) {
        return (bb.d0) bb.d0.y0().K(com.google.protobuf.s1.f0().y(sVar.h()).x((sVar.b() / 1000) * 1000)).n();
    }

    public g9.t1 n(List list) {
        n9.b.d(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        g9.q1 q1Var = new g9.q1(g9.u1.Update);
        g9.r1 r1VarF = q1Var.f();
        j9.s sVar = new j9.s();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z10 = next instanceof String;
            n9.b.d(z10 || (next instanceof t), "Expected argument to be String or FieldPath.", new Object[0]);
            j9.q qVarC = z10 ? t.b((String) next).c() : ((t) next).c();
            if (next2 instanceof u.c) {
                r1VarF.a(qVarC);
            } else {
                bb.d0 d0VarB = b(next2, r1VarF.d(qVarC));
                if (d0VarB != null) {
                    r1VarF.a(qVarC);
                    sVar.l(qVarC, d0VarB);
                }
            }
        }
        return q1Var.j(sVar);
    }

    public g9.t1 o(Map map) {
        n9.x.c(map, "Provided update data must not be null.");
        g9.q1 q1Var = new g9.q1(g9.u1.Update);
        g9.r1 r1VarF = q1Var.f();
        j9.s sVar = new j9.s();
        for (Map.Entry entry : map.entrySet()) {
            j9.q qVarC = t.b((String) entry.getKey()).c();
            Object value = entry.getValue();
            if (value instanceof u.c) {
                r1VarF.a(qVarC);
            } else {
                bb.d0 d0VarB = b(value, r1VarF.d(qVarC));
                if (d0VarB != null) {
                    r1VarF.a(qVarC);
                    sVar.l(qVarC, d0VarB);
                }
            }
        }
        return q1Var.j(sVar);
    }

    public final bb.d0 p(y1 y1Var, g9.r1 r1Var) {
        u.b bVarJ0 = bb.u.j0();
        bVarJ0.z("__type__", j9.y.f14289f);
        bVarJ0.z("value", d(y1Var.b(), r1Var));
        return (bb.d0) bb.d0.y0().F(bVarJ0).n();
    }
}
