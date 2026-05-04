package zd;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ke.l;
import lf.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.c f25748a = new ef.c("kotlin.jvm.JvmStatic");

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25749a;

        static {
            int[] iArr = new int[ce.l.values().length];
            try {
                iArr[ce.l.f3919g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ce.l.f3920h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ce.l.f3921i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ce.l.f3922j.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ce.l.f3923k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ce.l.f3924l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ce.l.f3925m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ce.l.f3926n.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f25749a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(lf.b bVar, ClassLoader classLoader) {
        xf.r0 r0VarE;
        Class clsO;
        lf.z zVar = bVar instanceof lf.z ? (lf.z) bVar : null;
        if (zVar == null || (r0VarE = zVar.e()) == null) {
            return null;
        }
        Iterable iterable = (Iterable) bVar.b();
        ArrayList arrayList = new ArrayList(dd.s.u(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(s((lf.g) it.next(), classLoader));
        }
        ce.l lVarO = ce.i.O(r0VarE);
        int i10 = 0;
        switch (lVarO == null ? -1 : a.f25749a[lVarO.ordinal()]) {
            case -1:
                if (!ce.i.d0(r0VarE)) {
                    throw new IllegalStateException(("Not an array type: " + r0VarE).toString());
                }
                xf.r0 type = ((xf.a2) dd.a0.v0(r0VarE.L0())).getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                fe.h hVarB = type.N0().b();
                fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
                if (eVar == null) {
                    throw new IllegalStateException(("Not a class type: " + type).toString());
                }
                if (ce.i.w0(type)) {
                    int size = ((List) bVar.b()).size();
                    String[] strArr = new String[size];
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
                        strArr[i10] = obj;
                        i10++;
                    }
                    return strArr;
                }
                if (ce.i.m0(eVar)) {
                    int size2 = ((List) bVar.b()).size();
                    Class[] clsArr = new Class[size2];
                    while (i10 < size2) {
                        Object obj2 = arrayList.get(i10);
                        kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        clsArr[i10] = obj2;
                        i10++;
                    }
                    return clsArr;
                }
                ef.b bVarN = nf.e.n(eVar);
                if (bVarN == null || (clsO = o(classLoader, bVarN, 0, 4, null)) == null) {
                    return null;
                }
                Object objNewInstance = Array.newInstance((Class<?>) clsO, ((List) bVar.b()).size());
                kotlin.jvm.internal.t.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                Object[] objArr = (Object[]) objNewInstance;
                int size3 = arrayList.size();
                while (i10 < size3) {
                    objArr[i10] = arrayList.get(i10);
                    i10++;
                }
                return objArr;
            case 0:
            default:
                throw new cd.o();
            case 1:
                int size4 = ((List) bVar.b()).size();
                boolean[] zArr = new boolean[size4];
                while (i10 < size4) {
                    Object obj3 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    zArr[i10] = ((Boolean) obj3).booleanValue();
                    i10++;
                }
                return zArr;
            case 2:
                int size5 = ((List) bVar.b()).size();
                char[] cArr = new char[size5];
                while (i10 < size5) {
                    Object obj4 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj4, "null cannot be cast to non-null type kotlin.Char");
                    cArr[i10] = ((Character) obj4).charValue();
                    i10++;
                }
                return cArr;
            case 3:
                int size6 = ((List) bVar.b()).size();
                byte[] bArr = new byte[size6];
                while (i10 < size6) {
                    Object obj5 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    bArr[i10] = ((Byte) obj5).byteValue();
                    i10++;
                }
                return bArr;
            case 4:
                int size7 = ((List) bVar.b()).size();
                short[] sArr = new short[size7];
                while (i10 < size7) {
                    Object obj6 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i10] = ((Short) obj6).shortValue();
                    i10++;
                }
                return sArr;
            case 5:
                int size8 = ((List) bVar.b()).size();
                int[] iArr = new int[size8];
                while (i10 < size8) {
                    Object obj7 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj7, "null cannot be cast to non-null type kotlin.Int");
                    iArr[i10] = ((Integer) obj7).intValue();
                    i10++;
                }
                return iArr;
            case 6:
                int size9 = ((List) bVar.b()).size();
                float[] fArr = new float[size9];
                while (i10 < size9) {
                    Object obj8 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj8, "null cannot be cast to non-null type kotlin.Float");
                    fArr[i10] = ((Float) obj8).floatValue();
                    i10++;
                }
                return fArr;
            case 7:
                int size10 = ((List) bVar.b()).size();
                long[] jArr = new long[size10];
                while (i10 < size10) {
                    Object obj9 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj9, "null cannot be cast to non-null type kotlin.Long");
                    jArr[i10] = ((Long) obj9).longValue();
                    i10++;
                }
                return jArr;
            case 8:
                int size11 = ((List) bVar.b()).size();
                double[] dArr = new double[size11];
                while (i10 < size11) {
                    Object obj10 = arrayList.get(i10);
                    kotlin.jvm.internal.t.d(obj10, "null cannot be cast to non-null type kotlin.Double");
                    dArr[i10] = ((Double) obj10).doubleValue();
                    i10++;
                }
                return dArr;
        }
    }

    public static final a0 b(Object obj) {
        a0 a0Var = obj instanceof a0 ? (a0) obj : null;
        if (a0Var != null) {
            return a0Var;
        }
        h1 h1VarC = c(obj);
        return h1VarC != null ? h1VarC : d(obj);
    }

    public static final h1 c(Object obj) {
        h1 h1Var = obj instanceof h1 ? (h1) obj : null;
        if (h1Var != null) {
            return h1Var;
        }
        kotlin.jvm.internal.p pVar = obj instanceof kotlin.jvm.internal.p ? (kotlin.jvm.internal.p) obj : null;
        wd.c cVarCompute = pVar != null ? pVar.compute() : null;
        if (cVarCompute instanceof h1) {
            return (h1) cVarCompute;
        }
        return null;
    }

    public static final j2 d(Object obj) {
        j2 j2Var = obj instanceof j2 ? (j2) obj : null;
        if (j2Var != null) {
            return j2Var;
        }
        kotlin.jvm.internal.j0 j0Var = obj instanceof kotlin.jvm.internal.j0 ? (kotlin.jvm.internal.j0) obj : null;
        wd.c cVarCompute = j0Var != null ? j0Var.compute() : null;
        if (cVarCompute instanceof j2) {
            return (j2) cVarCompute;
        }
        return null;
    }

    public static final List e(ge.a aVar) {
        Annotation annotationP;
        kotlin.jvm.internal.t.f(aVar, "<this>");
        ge.h<ge.c> annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (ge.c cVar : annotations) {
            fe.g1 g1VarJ = cVar.j();
            if (g1VarJ instanceof ke.b) {
                annotationP = ((ke.b) g1VarJ).d();
            } else if (g1VarJ instanceof l.a) {
                le.u uVarB = ((l.a) g1VarJ).b();
                le.g gVar = uVarB instanceof le.g ? (le.g) uVarB : null;
                annotationP = gVar != null ? gVar.Q() : null;
            } else {
                annotationP = p(cVar);
            }
            if (annotationP != null) {
                arrayList.add(annotationP);
            }
        }
        return t(arrayList);
    }

    public static final Class f(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        return Array.newInstance((Class<?>) cls, 0).getClass();
    }

    public static final Object g(Type type) {
        kotlin.jvm.internal.t.f(type, "type");
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!cls.isPrimitive()) {
            return null;
        }
        if (kotlin.jvm.internal.t.b(cls, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (kotlin.jvm.internal.t.b(cls, Character.TYPE)) {
            return (char) 0;
        }
        if (kotlin.jvm.internal.t.b(cls, Byte.TYPE)) {
            return (byte) 0;
        }
        if (kotlin.jvm.internal.t.b(cls, Short.TYPE)) {
            return (short) 0;
        }
        if (kotlin.jvm.internal.t.b(cls, Integer.TYPE)) {
            return 0;
        }
        if (kotlin.jvm.internal.t.b(cls, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (kotlin.jvm.internal.t.b(cls, Long.TYPE)) {
            return 0L;
        }
        if (kotlin.jvm.internal.t.b(cls, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (kotlin.jvm.internal.t.b(cls, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final fe.a h(Class moduleAnchor, gf.p proto, bf.c nameResolver, bf.g typeTable, bf.a metadataVersion, pd.o createDescriptor) {
        List listM0;
        kotlin.jvm.internal.t.f(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.t.f(createDescriptor, "createDescriptor");
        ke.k kVarA = y2.a(moduleAnchor);
        if (proto instanceof ze.i) {
            listM0 = ((ze.i) proto).l0();
        } else {
            if (!(proto instanceof ze.n)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            listM0 = ((ze.n) proto).m0();
        }
        List list = listM0;
        tf.n nVarA = kVarA.a();
        fe.h0 h0VarB = kVarA.b();
        bf.h hVarB = bf.h.f3348b.b();
        kotlin.jvm.internal.t.c(list);
        return (fe.a) createDescriptor.invoke(new tf.k0(new tf.p(nVarA, nameResolver, h0VarB, typeTable, hVarB, metadataVersion, null, null, list)), proto);
    }

    public static final fe.b1 i(fe.a aVar) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        if (aVar.e0() == null) {
            return null;
        }
        fe.m mVarB = aVar.b();
        kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((fe.e) mVarB).J0();
    }

    public static final ef.c j() {
        return f25748a;
    }

    public static final boolean k(wd.q qVar) {
        xf.r0 r0VarX;
        kotlin.jvm.internal.t.f(qVar, "<this>");
        t2 t2Var = qVar instanceof t2 ? (t2) qVar : null;
        return (t2Var == null || (r0VarX = t2Var.x()) == null || !jf.k.i(r0VarX)) ? false : true;
    }

    public static final boolean l(wd.q qVar) {
        xf.r0 r0VarX;
        kotlin.jvm.internal.t.f(qVar, "<this>");
        t2 t2Var = qVar instanceof t2 ? (t2) qVar : null;
        return (t2Var == null || (r0VarX = t2Var.x()) == null || !jf.k.c(r0VarX)) ? false : true;
    }

    public static final Class m(ClassLoader classLoader, ef.b bVar, int i10) {
        ef.b bVarN = ee.c.f8681a.n(bVar.a().i());
        if (bVarN != null) {
            bVar = bVarN;
        }
        return n(classLoader, bVar.f().a(), bVar.g().a(), i10);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class n(ClassLoader classLoader, String str, String str2, int i10) {
        if (kotlin.jvm.internal.t.b(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append("[");
            }
            sb2.append("L");
        }
        if (str.length() > 0) {
            sb2.append(str + com.amazon.a.a.o.c.a.b.f4610a);
        }
        sb2.append(kg.z.E(str2, com.amazon.a.a.o.c.a.b.f4610a, '$', false, 4, null));
        if (i10 > 0) {
            sb2.append(";");
        }
        return ke.e.a(classLoader, sb2.toString());
    }

    public static /* synthetic */ Class o(ClassLoader classLoader, ef.b bVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return m(classLoader, bVar, i10);
    }

    public static final Annotation p(ge.c cVar) {
        fe.e eVarL = nf.e.l(cVar);
        Class clsQ = eVarL != null ? q(eVarL) : null;
        if (clsQ == null) {
            clsQ = null;
        }
        if (clsQ == null) {
            return null;
        }
        Set<Map.Entry> setEntrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntrySet) {
            ef.f fVar = (ef.f) entry.getKey();
            lf.g gVar = (lf.g) entry.getValue();
            ClassLoader classLoader = clsQ.getClassLoader();
            kotlin.jvm.internal.t.e(classLoader, "getClassLoader(...)");
            Object objS = s(gVar, classLoader);
            cd.q qVarA = objS != null ? cd.w.a(fVar.b(), objS) : null;
            if (qVarA != null) {
                arrayList.add(qVarA);
            }
        }
        return (Annotation) ae.f.h(clsQ, dd.o0.t(arrayList), null, 4, null);
    }

    public static final Class q(fe.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        fe.g1 g1VarJ = eVar.j();
        kotlin.jvm.internal.t.e(g1VarJ, "getSource(...)");
        if (g1VarJ instanceof xe.z) {
            xe.x xVarD = ((xe.z) g1VarJ).d();
            kotlin.jvm.internal.t.d(xVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ke.f) xVarD).e();
        }
        if (g1VarJ instanceof l.a) {
            le.u uVarB = ((l.a) g1VarJ).b();
            kotlin.jvm.internal.t.d(uVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((le.q) uVarB).v();
        }
        ef.b bVarN = nf.e.n(eVar);
        if (bVarN == null) {
            return null;
        }
        return m(le.f.j(eVar.getClass()), bVarN, 0);
    }

    public static final wd.u r(fe.u uVar) {
        kotlin.jvm.internal.t.f(uVar, "<this>");
        if (kotlin.jvm.internal.t.b(uVar, fe.t.f9511e)) {
            return wd.u.f23917a;
        }
        if (kotlin.jvm.internal.t.b(uVar, fe.t.f9509c)) {
            return wd.u.f23918b;
        }
        if (kotlin.jvm.internal.t.b(uVar, fe.t.f9510d)) {
            return wd.u.f23919c;
        }
        if (kotlin.jvm.internal.t.b(uVar, fe.t.f9507a) || kotlin.jvm.internal.t.b(uVar, fe.t.f9508b)) {
            return wd.u.f23920d;
        }
        return null;
    }

    public static final Object s(lf.g gVar, ClassLoader classLoader) {
        if (gVar instanceof lf.a) {
            return p((ge.c) ((lf.a) gVar).b());
        }
        if (gVar instanceof lf.b) {
            return a((lf.b) gVar, classLoader);
        }
        if (gVar instanceof lf.k) {
            cd.q qVar = (cd.q) ((lf.k) gVar).b();
            ef.b bVar = (ef.b) qVar.a();
            ef.f fVar = (ef.f) qVar.b();
            Class clsO = o(classLoader, bVar, 0, 4, null);
            if (clsO != null) {
                return h3.a(clsO, fVar.b());
            }
            return null;
        }
        if (!(gVar instanceof lf.s)) {
            if ((gVar instanceof lf.l) || (gVar instanceof lf.u)) {
                return null;
            }
            return gVar.b();
        }
        s.b bVar2 = (s.b) ((lf.s) gVar).b();
        if (bVar2 instanceof s.b.C0281b) {
            s.b.C0281b c0281b = (s.b.C0281b) bVar2;
            return m(classLoader, c0281b.b(), c0281b.a());
        }
        if (!(bVar2 instanceof s.b.a)) {
            throw new cd.o();
        }
        fe.h hVarB = ((s.b.a) bVar2).a().N0().b();
        fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
        if (eVar != null) {
            return q(eVar);
        }
        return null;
    }

    public static final List t(List list) throws IllegalAccessException, InvocationTargetException {
        List listE;
        if (list != null && list.isEmpty()) {
            return list;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.b(od.a.b(od.a.a((Annotation) it.next())).getSimpleName(), "Container")) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Annotation annotation = (Annotation) it2.next();
                    Class clsB = od.a.b(od.a.a(annotation));
                    if (!kotlin.jvm.internal.t.b(clsB.getSimpleName(), "Container") || clsB.getAnnotation(kotlin.jvm.internal.p0.class) == null) {
                        listE = dd.q.e(annotation);
                    } else {
                        Object objInvoke = clsB.getDeclaredMethod("value", null).invoke(annotation, null);
                        kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                        listE = dd.l.d((Annotation[]) objInvoke);
                    }
                    dd.w.z(arrayList, listE);
                }
                return arrayList;
            }
        }
        return list;
    }
}
