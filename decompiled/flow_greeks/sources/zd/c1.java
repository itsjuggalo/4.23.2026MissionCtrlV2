package zd;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c1 implements kotlin.jvm.internal.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25688a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f25689b = kotlin.jvm.internal.k.class;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kg.n f25690c = new kg.n("<v#(\\d+)>");

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final kg.n a() {
            return c1.f25690c;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f25691c = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z2.a f25692a;

        public b() {
            this.f25692a = z2.c(new d1(c1.this));
        }

        public static final ke.k c(c1 c1Var) {
            return y2.a(c1Var.e());
        }

        public final ke.k b() {
            Object objB = this.f25692a.b(this, f25691c[0]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (ke.k) objB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f25694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f25695b;

        public c(List parameters, Class cls) {
            kotlin.jvm.internal.t.f(parameters, "parameters");
            this.f25694a = parameters;
            this.f25695b = cls;
        }

        public final List a() {
            return this.f25694a;
        }

        public final Class b() {
            return this.f25695b;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f25696a = new d("DECLARED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f25697b = new d("INHERITED", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ d[] f25698c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ jd.a f25699d;

        static {
            d[] dVarArrA = a();
            f25698c = dVarArrA;
            f25699d = jd.b.a(dVarArrA);
        }

        public d(String str, int i10) {
        }

        public static final /* synthetic */ d[] a() {
            return new d[]{f25696a, f25697b};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f25698c.clone();
        }

        public final boolean b(fe.b member) {
            kotlin.jvm.internal.t.f(member, "member");
            return member.h().a() == (this == f25696a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends j {
        public e(c1 c1Var) {
            super(c1Var);
        }

        @Override // ie.o, fe.o
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a0 l(fe.l descriptor, cd.h0 data) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(data, "data");
            throw new IllegalStateException("No constructors should appear here: " + descriptor);
        }
    }

    public static final int C(fe.u uVar, fe.u uVar2) {
        Integer numD = fe.t.d(uVar, uVar2);
        if (numD != null) {
            return numD.intValue();
        }
        return 0;
    }

    public static final int D(pd.o oVar, Object obj, Object obj2) {
        return ((Number) oVar.invoke(obj, obj2)).intValue();
    }

    public static final CharSequence E(fe.y0 descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return hf.n.f11357k.M(descriptor) + " | " + e3.f25716a.f(descriptor).a();
    }

    public static final CharSequence z(fe.z descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return hf.n.f11357k.M(descriptor) + " | " + e3.f25716a.g(descriptor).a();
    }

    public final Method A(String name, String desc) {
        Method methodL;
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(desc, "desc");
        if (kotlin.jvm.internal.t.b(name, "<init>")) {
            return null;
        }
        c cVarM = M(desc, true);
        Class[] clsArr = (Class[]) cVarM.a().toArray(new Class[0]);
        Class clsB = cVarM.b();
        kotlin.jvm.internal.t.c(clsB);
        Method methodL2 = L(J(), name, clsArr, clsB, false);
        if (methodL2 != null) {
            return methodL2;
        }
        if (!J().isInterface() || (methodL = L(Object.class, name, clsArr, clsB, false)) == null) {
            return null;
        }
        return methodL;
    }

    public final fe.y0 B(String name, String signature) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
        kg.k kVarA = f25690c.a(signature);
        if (kVarA != null) {
            String str = (String) kVarA.a().a().b().get(1);
            fe.y0 y0VarH = H(Integer.parseInt(str));
            if (y0VarH != null) {
                return y0VarH;
            }
            throw new x2("Local property #" + str + " not found in " + e());
        }
        ef.f fVarK = ef.f.k(name);
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        Collection collectionK = K(fVarK);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionK) {
            if (kotlin.jvm.internal.t.b(e3.f25716a.f((fe.y0) obj).a(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new x2("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (fe.y0) dd.a0.v0(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            fe.u visibility = ((fe.y0) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = dd.n0.g(linkedHashMap, new z0(y0.f25902a)).values();
        kotlin.jvm.internal.t.e(collectionValues, "<get-values>(...)");
        List list = (List) dd.a0.j0(collectionValues);
        if (list.size() == 1) {
            kotlin.jvm.internal.t.c(list);
            return (fe.y0) dd.a0.Z(list);
        }
        ef.f fVarK2 = ef.f.k(name);
        kotlin.jvm.internal.t.e(fVarK2, "identifier(...)");
        String strI0 = dd.a0.i0(K(fVarK2), "\n", null, null, 0, null, a1.f25678a, 30, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Property '");
        sb2.append(name);
        sb2.append("' (JVM signature: ");
        sb2.append(signature);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(':');
        sb2.append(strI0.length() == 0 ? " no members found" : '\n' + strI0);
        throw new x2(sb2.toString());
    }

    public abstract Collection F();

    public abstract Collection G(ef.f fVar);

    public abstract fe.y0 H(int i10);

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection I(qf.k r8, zd.c1.d r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.t.f(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.t.f(r9, r0)
            zd.c1$e r0 = new zd.c1$e
            r0.<init>(r7)
            r1 = 3
            r2 = 0
            java.util.Collection r8 = qf.n.a.a(r8, r2, r2, r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L53
            java.lang.Object r3 = r8.next()
            fe.m r3 = (fe.m) r3
            boolean r4 = r3 instanceof fe.b
            if (r4 == 0) goto L4c
            r4 = r3
            fe.b r4 = (fe.b) r4
            fe.u r5 = r4.getVisibility()
            fe.u r6 = fe.t.f9514h
            boolean r5 = kotlin.jvm.internal.t.b(r5, r6)
            if (r5 != 0) goto L4c
            boolean r4 = r9.b(r4)
            if (r4 == 0) goto L4c
            cd.h0 r4 = cd.h0.f3852a
            java.lang.Object r3 = r3.t0(r0, r4)
            zd.a0 r3 = (zd.a0) r3
            goto L4d
        L4c:
            r3 = r2
        L4d:
            if (r3 == 0) goto L1e
            r1.add(r3)
            goto L1e
        L53:
            java.util.List r8 = dd.a0.I0(r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zd.c1.I(qf.k, zd.c1$d):java.util.Collection");
    }

    public Class J() {
        Class clsK = le.f.k(e());
        return clsK == null ? e() : clsK;
    }

    public abstract Collection K(ef.f fVar);

    public final Method L(Class cls, String str, Class[] clsArr, Class cls2, boolean z10) {
        String str2;
        Class[] clsArr2;
        Class cls3;
        boolean z11;
        if (z10) {
            clsArr[0] = cls;
        }
        Method methodP = P(cls, str, clsArr, cls2);
        if (methodP != null) {
            return methodP;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            Method methodL = L(superclass, str, clsArr, cls2, z10);
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z11 = z10;
            if (methodL != null) {
                return methodL;
            }
        } else {
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z11 = z10;
        }
        Iterator itA = kotlin.jvm.internal.c.a(cls.getInterfaces());
        while (itA.hasNext()) {
            Class cls4 = (Class) itA.next();
            kotlin.jvm.internal.t.c(cls4);
            Method methodL2 = L(cls4, str2, clsArr2, cls3, z11);
            if (methodL2 != null) {
                return methodL2;
            }
            if (z11) {
                Class clsA = ke.e.a(le.f.j(cls4), cls4.getName() + "$DefaultImpls");
                if (clsA != null) {
                    clsArr2[0] = cls4;
                    Method methodP2 = P(clsA, str2, clsArr2, cls3);
                    if (methodP2 != null) {
                        return methodP2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final c M(String str, boolean z10) {
        String str2;
        int iB0;
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        while (true) {
            if (str.charAt(i10) == ')') {
                String str3 = str;
                return new c(arrayList, z10 ? N(str3, i10 + 1, str3.length()) : null);
            }
            int i11 = i10;
            while (str.charAt(i11) == '[') {
                i11++;
            }
            char cCharAt = str.charAt(i11);
            if (kg.c0.O("VZCBSIFJD", cCharAt, false, 2, null)) {
                int i12 = i11 + 1;
                str2 = str;
                iB0 = i12;
            } else {
                if (cCharAt != 'L') {
                    throw new x2("Unknown type prefix in the method signature: " + str);
                }
                str2 = str;
                iB0 = kg.c0.b0(str2, ';', i10, false, 4, null) + 1;
            }
            arrayList.add(N(str2, i10, iB0));
            i10 = iB0;
            str = str2;
        }
    }

    public final Class N(String str, int i10, int i11) throws ClassNotFoundException {
        char cCharAt = str.charAt(i10);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader classLoaderJ = le.f.j(e());
            String strSubstring = str.substring(i10 + 1, i11 - 1);
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            Class<?> clsLoadClass = classLoaderJ.loadClass(kg.z.E(strSubstring, '/', com.amazon.a.a.o.c.a.b.f4610a, false, 4, null));
            kotlin.jvm.internal.t.e(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class TYPE = Void.TYPE;
            kotlin.jvm.internal.t.e(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return i3.f(N(str, i10 + 1, i11));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new x2("Unknown type prefix in the method signature: " + str);
        }
    }

    public final Constructor O(Class cls, List list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method P(Class cls, String str, Class[] clsArr, Class cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (kotlin.jvm.internal.t.b(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            kotlin.jvm.internal.t.e(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                if (kotlin.jvm.internal.t.b(method.getName(), str) && kotlin.jvm.internal.t.b(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        return null;
    }

    public final void u(List list, List list2, boolean z10) {
        if (kotlin.jvm.internal.t.b(dd.a0.m0(list2), f25689b)) {
            list2 = list2.subList(0, list2.size() - 1);
        }
        list.addAll(list2);
        int size = (list2.size() + 31) / 32;
        for (int i10 = 0; i10 < size; i10++) {
            Class TYPE = Integer.TYPE;
            kotlin.jvm.internal.t.e(TYPE, "TYPE");
            list.add(TYPE);
        }
        Class cls = z10 ? f25689b : Object.class;
        kotlin.jvm.internal.t.c(cls);
        list.add(cls);
    }

    public final Constructor v(String desc) {
        kotlin.jvm.internal.t.f(desc, "desc");
        return O(e(), M(desc, false).a());
    }

    public final Constructor w(String desc) {
        kotlin.jvm.internal.t.f(desc, "desc");
        Class clsE = e();
        ArrayList arrayList = new ArrayList();
        u(arrayList, M(desc, false).a(), true);
        cd.h0 h0Var = cd.h0.f3852a;
        return O(clsE, arrayList);
    }

    public final Method x(String name, String desc, boolean z10) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(desc, "desc");
        if (kotlin.jvm.internal.t.b(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(e());
        }
        c cVarM = M(desc, true);
        u(arrayList, cVarM.a(), false);
        Class clsJ = J();
        String str = name + "$default";
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class clsB = cVarM.b();
        kotlin.jvm.internal.t.c(clsB);
        return L(clsJ, str, clsArr, clsB, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fe.z y(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zd.c1.y(java.lang.String, java.lang.String):fe.z");
    }
}
