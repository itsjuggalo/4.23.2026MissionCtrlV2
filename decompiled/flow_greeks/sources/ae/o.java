package ae;

import cd.q;
import dd.s;
import dd.w;
import fe.b1;
import fe.i0;
import fe.s1;
import fe.t1;
import fe.y0;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.c1;
import xf.e2;
import xf.i2;
import xf.r0;
import zd.i3;
import zd.x2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public static final boolean a(Member member) {
        if (member.getDeclaringClass() == null) {
            return false;
        }
        return !od.a.e(r0).n();
    }

    public static final void g(h hVar, int i10, fe.b bVar, boolean z10) {
        if (j.a(hVar) == i10) {
            return;
        }
        throw new x2("Inconsistent number of parameters in the descriptor and Java reflection object: " + j.a(hVar) + " != " + i10 + "\nCalling: " + bVar + "\nParameter types: " + hVar.a() + ")\nDefault: " + z10);
    }

    public static final Object h(Object obj, fe.b descriptor) {
        r0 r0VarL;
        Class clsT;
        Method methodM;
        t.f(descriptor, "descriptor");
        return (((descriptor instanceof y0) && jf.k.e((t1) descriptor)) || (r0VarL = l(descriptor)) == null || (clsT = t(r0VarL)) == null || (methodM = m(clsT, descriptor)) == null) ? obj : methodM.invoke(obj, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ae.h i(ae.h r3, fe.b r4, boolean r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.f(r3, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.t.f(r4, r0)
            boolean r0 = jf.k.a(r4)
            if (r0 != 0) goto L88
            java.util.List r0 = r4.p0()
            java.lang.String r1 = "getContextReceiverParameters(...)"
            kotlin.jvm.internal.t.e(r0, r1)
            java.lang.String r1 = "getType(...)"
            if (r0 == 0) goto L24
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L24
            goto L42
        L24:
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L42
            java.lang.Object r2 = r0.next()
            fe.b1 r2 = (fe.b1) r2
            xf.r0 r2 = r2.getType()
            kotlin.jvm.internal.t.e(r2, r1)
            boolean r2 = jf.k.h(r2)
            if (r2 == 0) goto L28
            goto L88
        L42:
            java.util.List r0 = r4.i()
            java.lang.String r2 = "getValueParameters(...)"
            kotlin.jvm.internal.t.e(r0, r2)
            if (r0 == 0) goto L54
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L54
            goto L72
        L54:
            java.util.Iterator r0 = r0.iterator()
        L58:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L72
            java.lang.Object r2 = r0.next()
            fe.s1 r2 = (fe.s1) r2
            xf.r0 r2 = r2.getType()
            kotlin.jvm.internal.t.e(r2, r1)
            boolean r2 = jf.k.h(r2)
            if (r2 == 0) goto L58
            goto L88
        L72:
            xf.r0 r0 = r4.getReturnType()
            if (r0 == 0) goto L80
            boolean r0 = jf.k.c(r0)
            r1 = 1
            if (r0 != r1) goto L80
            goto L88
        L80:
            boolean r0 = q(r4)
            if (r0 == 0) goto L87
            goto L88
        L87:
            return r3
        L88:
            ae.n r0 = new ae.n
            r0.<init>(r4, r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.o.i(ae.h, fe.b, boolean):ae.h");
    }

    public static /* synthetic */ h j(h hVar, fe.b bVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return i(hVar, bVar, z10);
    }

    public static final Method k(Class cls, fe.b bVar) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", m(cls, bVar).getReturnType());
            t.c(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new x2("No box method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    public static final r0 l(fe.b bVar) {
        b1 b1VarK0 = bVar.k0();
        b1 b1VarE0 = bVar.e0();
        if (b1VarK0 != null) {
            return b1VarK0.getType();
        }
        if (b1VarE0 == null) {
            return null;
        }
        if (bVar instanceof fe.l) {
            return b1VarE0.getType();
        }
        fe.m mVarB = bVar.b();
        fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
        if (eVar != null) {
            return eVar.s();
        }
        return null;
    }

    public static final Method m(Class cls, fe.b descriptor) {
        t.f(cls, "<this>");
        t.f(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            t.c(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new x2("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static final List n(c1 type) {
        t.f(type, "type");
        List listO = o(e2.a(type));
        if (listO == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(s.u(listO, 10));
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add("unbox-impl-" + ((String) it.next()));
        }
        fe.h hVarB = type.N0().b();
        t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class clsQ = i3.q((fe.e) hVarB);
        t.c(clsQ);
        ArrayList arrayList2 = new ArrayList(s.u(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(clsQ.getDeclaredMethod((String) it2.next(), null));
        }
        return arrayList2;
    }

    public static final List o(c1 c1Var) {
        Collection collectionE;
        if (!jf.k.i(c1Var)) {
            return null;
        }
        fe.h hVarB = c1Var.N0().b();
        t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        i0 i0VarT = nf.e.t((fe.e) hVarB);
        t.c(i0VarT);
        List<q> listC = i0VarT.c();
        ArrayList arrayList = new ArrayList();
        for (q qVar : listC) {
            ef.f fVar = (ef.f) qVar.a();
            List listO = o((c1) qVar.b());
            if (listO != null) {
                collectionE = new ArrayList(s.u(listO, 10));
                Iterator it = listO.iterator();
                while (it.hasNext()) {
                    collectionE.add(fVar.h() + '-' + ((String) it.next()));
                }
            } else {
                collectionE = dd.q.e(fVar.h());
            }
            w.z(arrayList, collectionE);
        }
        return arrayList;
    }

    public static final List p(c1 c1Var, fe.b bVar) {
        Method methodM;
        List listN = n(c1Var);
        if (listN != null) {
            return listN;
        }
        Class clsT = t(c1Var);
        if (clsT == null || (methodM = m(clsT, bVar)) == null) {
            return null;
        }
        return dd.q.e(methodM);
    }

    public static final boolean q(fe.b bVar) {
        r0 r0VarL = l(bVar);
        return r0VarL != null && jf.k.h(r0VarL);
    }

    public static final List r(fe.b bVar, Member member, pd.k kVar) {
        ArrayList arrayList = new ArrayList();
        b1 b1VarK0 = bVar.k0();
        r0 type = b1VarK0 != null ? b1VarK0.getType() : null;
        if (type != null) {
            arrayList.add(type);
        } else if (bVar instanceof fe.l) {
            fe.e eVarD = ((fe.l) bVar).D();
            t.e(eVarD, "getConstructedClass(...)");
            if (eVarD.P()) {
                fe.m mVarB = eVarD.b();
                t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                arrayList.add(((fe.e) mVarB).s());
            }
        } else {
            fe.m mVarB2 = bVar.b();
            t.e(mVarB2, "getContainingDeclaration(...)");
            if ((mVarB2 instanceof fe.e) && ((Boolean) kVar.invoke(mVarB2)).booleanValue()) {
                if (member == null || !a(member)) {
                    arrayList.add(((fe.e) mVarB2).s());
                } else {
                    c1 c1VarS = ((fe.e) mVarB2).s();
                    t.e(c1VarS, "getDefaultType(...)");
                    arrayList.add(cg.d.B(c1VarS));
                }
            }
        }
        List listI = bVar.i();
        t.e(listI, "getValueParameters(...)");
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(((s1) it.next()).getType());
        }
        return arrayList;
    }

    public static final Class s(fe.m mVar) {
        if (!(mVar instanceof fe.e) || !jf.k.b(mVar)) {
            return null;
        }
        fe.e eVar = (fe.e) mVar;
        Class clsQ = i3.q(eVar);
        if (clsQ != null) {
            return clsQ;
        }
        throw new x2("Class object for the class " + eVar.getName() + " cannot be found (classId=" + nf.e.n((fe.h) mVar) + ')');
    }

    public static final Class t(r0 r0Var) {
        r0 r0VarK;
        Class clsS = s(r0Var.N0().b());
        if (clsS == null) {
            return null;
        }
        if (i2.l(r0Var) && ((r0VarK = jf.k.k(r0Var)) == null || i2.l(r0VarK) || ce.i.t0(r0VarK))) {
            return null;
        }
        return clsS;
    }

    public static final String u(fe.h hVar) {
        t.f(hVar, "<this>");
        ef.b bVarN = nf.e.n(hVar);
        t.c(bVarN);
        return df.b.b(bVarN.b());
    }
}
