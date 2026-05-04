package de;

import cd.q;
import dd.a0;
import dd.g0;
import dd.r;
import dd.s;
import fe.b;
import fe.b1;
import fe.e0;
import fe.g1;
import fe.l1;
import fe.m;
import fe.s1;
import fe.z;
import ge.h;
import ie.o0;
import ie.s;
import ie.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import xf.c1;
import xf.f2;
import xf.m2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends o0 {
    public static final a E = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final e a(b functionClass, boolean z10) {
            t.f(functionClass, "functionClass");
            List listV = functionClass.v();
            e eVar = new e(functionClass, null, b.a.DECLARATION, z10, null);
            b1 b1VarJ0 = functionClass.J0();
            List listK = r.k();
            List listK2 = r.k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listV) {
                if (((l1) obj).o() != m2.f25016f) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<g0> iterableQ0 = a0.Q0(arrayList);
            ArrayList arrayList2 = new ArrayList(s.u(iterableQ0, 10));
            for (g0 g0Var : iterableQ0) {
                arrayList2.add(e.E.b(eVar, g0Var.c(), (l1) g0Var.d()));
            }
            eVar.R0(null, b1VarJ0, listK, listK2, arrayList2, ((l1) a0.k0(listV)).s(), e0.f9464e, fe.t.f9511e);
            eVar.Z0(true);
            return eVar;
        }

        public final s1 b(e eVar, int i10, l1 l1Var) {
            String lowerCase;
            String strB = l1Var.getName().b();
            t.e(strB, "asString(...)");
            if (t.b(strB, "T")) {
                lowerCase = "instance";
            } else if (t.b(strB, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = strB.toLowerCase(Locale.ROOT);
                t.e(lowerCase, "toLowerCase(...)");
            }
            h hVarB = h.L.b();
            ef.f fVarK = ef.f.k(lowerCase);
            t.e(fVarK, "identifier(...)");
            c1 c1VarS = l1Var.s();
            t.e(c1VarS, "getDefaultType(...)");
            g1 NO_SOURCE = g1.f9483a;
            t.e(NO_SOURCE, "NO_SOURCE");
            return new u0(eVar, null, i10, hVarB, fVarK, c1VarS, false, false, false, null, NO_SOURCE);
        }

        public a() {
        }
    }

    public /* synthetic */ e(m mVar, e eVar, b.a aVar, boolean z10, k kVar) {
        this(mVar, eVar, aVar, z10);
    }

    @Override // ie.o0, ie.s
    public ie.s L0(m newOwner, z zVar, b.a kind, ef.f fVar, h annotations, g1 source) {
        t.f(newOwner, "newOwner");
        t.f(kind, "kind");
        t.f(annotations, "annotations");
        t.f(source, "source");
        return new e(newOwner, (e) zVar, kind, isSuspend());
    }

    @Override // ie.s
    public z M0(s.c configuration) {
        t.f(configuration, "configuration");
        e eVar = (e) super.M0(configuration);
        if (eVar == null) {
            return null;
        }
        List listI = eVar.i();
        t.e(listI, "getValueParameters(...)");
        if (listI != null && listI.isEmpty()) {
            return eVar;
        }
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            r0 type = ((s1) it.next()).getType();
            t.e(type, "getType(...)");
            if (ce.h.d(type) != null) {
                List listI2 = eVar.i();
                t.e(listI2, "getValueParameters(...)");
                ArrayList arrayList = new ArrayList(dd.s.u(listI2, 10));
                Iterator it2 = listI2.iterator();
                while (it2.hasNext()) {
                    r0 type2 = ((s1) it2.next()).getType();
                    t.e(type2, "getType(...)");
                    arrayList.add(ce.h.d(type2));
                }
                return eVar.p1(arrayList);
            }
        }
        return eVar;
    }

    @Override // ie.s, fe.z
    public boolean R() {
        return false;
    }

    @Override // ie.s, fe.d0
    public boolean isExternal() {
        return false;
    }

    @Override // ie.s, fe.z
    public boolean isInline() {
        return false;
    }

    public final z p1(List list) {
        ef.f fVar;
        int size = i().size() - list.size();
        boolean z10 = true;
        if (size == 0) {
            List listI = i();
            t.e(listI, "getValueParameters(...)");
            List<q> listS0 = a0.S0(list, listI);
            if (listS0 != null && listS0.isEmpty()) {
                return this;
            }
            for (q qVar : listS0) {
                if (!t.b((ef.f) qVar.a(), ((s1) qVar.b()).getName())) {
                }
            }
            return this;
        }
        List<s1> listI2 = i();
        t.e(listI2, "getValueParameters(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(listI2, 10));
        for (s1 s1Var : listI2) {
            ef.f name = s1Var.getName();
            t.e(name, "getName(...)");
            int index = s1Var.getIndex();
            int i10 = index - size;
            if (i10 >= 0 && (fVar = (ef.f) list.get(i10)) != null) {
                name = fVar;
            }
            arrayList.add(s1Var.O(this, name, index));
        }
        s.c cVarS0 = S0(f2.f24962b);
        if (list.isEmpty()) {
            z10 = false;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ef.f) it.next()) == null) {
                    break;
                }
            }
            z10 = false;
        }
        s.c cVarR = cVarS0.G(z10).b(arrayList).r(a());
        t.e(cVarR, "setOriginal(...)");
        z zVarM0 = super.M0(cVarR);
        t.c(zVarM0);
        return zVarM0;
    }

    public e(m mVar, e eVar, b.a aVar, boolean z10) {
        super(mVar, eVar, h.L.b(), eg.t.f8933i, aVar, g1.f9483a);
        f1(true);
        h1(z10);
        Y0(false);
    }
}
