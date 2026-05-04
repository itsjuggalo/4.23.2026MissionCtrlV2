package tf;

import fe.g1;
import fe.s1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xf.c1;
import ze.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fe.h0 f21955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.m0 f21956b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21957a;

        static {
            int[] iArr = new int[b.C0490b.c.EnumC0493c.values().length];
            try {
                iArr[b.C0490b.c.EnumC0493c.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[b.C0490b.c.EnumC0493c.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f21957a = iArr;
        }
    }

    public g(fe.h0 module, fe.m0 notFoundClasses) {
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        this.f21955a = module;
        this.f21956b = notFoundClasses;
    }

    public final ge.c a(ze.b proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        fe.e eVarE = e(l0.a(nameResolver, proto.A()));
        Map mapH = dd.o0.h();
        if (proto.x() != 0 && !zf.l.m(eVarE) && jf.i.t(eVarE)) {
            Collection collectionM = eVarE.m();
            kotlin.jvm.internal.t.e(collectionM, "getConstructors(...)");
            fe.d dVar = (fe.d) dd.a0.w0(collectionM);
            if (dVar != null) {
                List listI = dVar.i();
                kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
                LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(listI, 10)), 16));
                for (Object obj : listI) {
                    linkedHashMap.put(((s1) obj).getName(), obj);
                }
                List<b.C0490b> listY = proto.y();
                kotlin.jvm.internal.t.e(listY, "getArgumentList(...)");
                ArrayList arrayList = new ArrayList();
                for (b.C0490b c0490b : listY) {
                    kotlin.jvm.internal.t.c(c0490b);
                    cd.q qVarD = d(c0490b, linkedHashMap, nameResolver);
                    if (qVarD != null) {
                        arrayList.add(qVarD);
                    }
                }
                mapH = dd.o0.t(arrayList);
            }
        }
        return new ge.d(eVarE.s(), mapH, g1.f9483a);
    }

    public final boolean b(lf.g gVar, xf.r0 r0Var, b.C0490b.c cVar) {
        b.C0490b.c.EnumC0493c enumC0493cS = cVar.S();
        int i10 = enumC0493cS == null ? -1 : a.f21957a[enumC0493cS.ordinal()];
        if (i10 == 10) {
            fe.h hVarB = r0Var.N0().b();
            fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
            return eVar == null || ce.i.m0(eVar);
        }
        if (i10 != 13) {
            return kotlin.jvm.internal.t.b(gVar.a(this.f21955a), r0Var);
        }
        if (!(gVar instanceof lf.b) || ((List) ((lf.b) gVar).b()).size() != cVar.J().size()) {
            throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
        }
        xf.r0 r0VarL = c().l(r0Var);
        if (r0VarL == null) {
            return false;
        }
        lf.b bVar = (lf.b) gVar;
        Iterable iterableL = dd.r.l((Collection) bVar.b());
        if ((iterableL instanceof Collection) && ((Collection) iterableL).isEmpty()) {
            return true;
        }
        Iterator it = iterableL.iterator();
        while (it.hasNext()) {
            int iNextInt = ((dd.j0) it).nextInt();
            lf.g gVar2 = (lf.g) ((List) bVar.b()).get(iNextInt);
            b.C0490b.c cVarH = cVar.H(iNextInt);
            kotlin.jvm.internal.t.e(cVarH, "getArrayElement(...)");
            if (!b(gVar2, r0VarL, cVarH)) {
                return false;
            }
        }
        return true;
    }

    public final ce.i c() {
        return this.f21955a.p();
    }

    public final cd.q d(b.C0490b c0490b, Map map, bf.c cVar) {
        s1 s1Var = (s1) map.get(l0.b(cVar, c0490b.w()));
        if (s1Var == null) {
            return null;
        }
        ef.f fVarB = l0.b(cVar, c0490b.w());
        xf.r0 type = s1Var.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        b.C0490b.c cVarX = c0490b.x();
        kotlin.jvm.internal.t.e(cVarX, "getValue(...)");
        return new cd.q(fVarB, g(type, cVarX, cVar));
    }

    public final fe.e e(ef.b bVar) {
        return fe.y.d(this.f21955a, bVar, this.f21956b);
    }

    public final lf.g f(xf.r0 expectedType, b.C0490b.c value, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(expectedType, "expectedType");
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        Boolean boolD = bf.b.P.d(value.O());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        boolean zBooleanValue = boolD.booleanValue();
        b.C0490b.c.EnumC0493c enumC0493cS = value.S();
        switch (enumC0493cS == null ? -1 : a.f21957a[enumC0493cS.ordinal()]) {
            case 1:
                byte bQ = (byte) value.Q();
                return zBooleanValue ? new lf.a0(bQ) : new lf.d(bQ);
            case 2:
                return new lf.e((char) value.Q());
            case 3:
                short sQ = (short) value.Q();
                return zBooleanValue ? new lf.d0(sQ) : new lf.w(sQ);
            case 4:
                int iQ = (int) value.Q();
                return zBooleanValue ? new lf.b0(iQ) : new lf.n(iQ);
            case 5:
                long jQ = value.Q();
                return zBooleanValue ? new lf.c0(jQ) : new lf.t(jQ);
            case 6:
                return new lf.m(value.P());
            case 7:
                return new lf.j(value.M());
            case 8:
                return new lf.c(value.Q() != 0);
            case 9:
                return new lf.x(nameResolver.getString(value.R()));
            case 10:
                return new lf.s(l0.a(nameResolver, value.K()), value.G());
            case 11:
                return new lf.k(l0.a(nameResolver, value.K()), l0.b(nameResolver, value.N()));
            case 12:
                ze.b bVarF = value.F();
                kotlin.jvm.internal.t.e(bVarF, "getAnnotation(...)");
                return new lf.a(a(bVarF, nameResolver));
            case 13:
                lf.i iVar = lf.i.f15656a;
                List<b.C0490b.c> listJ = value.J();
                kotlin.jvm.internal.t.e(listJ, "getArrayElementList(...)");
                ArrayList arrayList = new ArrayList(dd.s.u(listJ, 10));
                for (b.C0490b.c cVar : listJ) {
                    c1 c1VarI = c().i();
                    kotlin.jvm.internal.t.e(c1VarI, "getAnyType(...)");
                    kotlin.jvm.internal.t.c(cVar);
                    arrayList.add(f(c1VarI, cVar, nameResolver));
                }
                return iVar.c(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.S() + " (expected " + expectedType + ')').toString());
        }
    }

    public final lf.g g(xf.r0 r0Var, b.C0490b.c cVar, bf.c cVar2) {
        lf.g gVarF = f(r0Var, cVar, cVar2);
        if (!b(gVarF, r0Var, cVar)) {
            gVarF = null;
        }
        if (gVarF != null) {
            return gVarF;
        }
        return lf.l.f15659b.a("Unexpected argument value: actual type " + cVar.S() + " != expected type " + r0Var);
    }
}
