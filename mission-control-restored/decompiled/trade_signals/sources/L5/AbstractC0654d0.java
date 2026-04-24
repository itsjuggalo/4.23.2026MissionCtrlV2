package L5;

import L5.a1;
import R5.AbstractC0862t;
import R5.AbstractC0863u;
import R5.InterfaceC0845b;
import R5.InterfaceC0855l;
import R5.InterfaceC0868z;
import X5.AbstractC0990f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.AbstractC2288c;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2293h;
import o5.C2470H;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: renamed from: L5.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0654d0 implements InterfaceC2293h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5149a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f5150b = AbstractC2296k.class;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final V6.n f5151c = new V6.n("<v#(\\d+)>");

    /* JADX INFO: renamed from: L5.d0$a */
    public static final class a {
        public a() {
        }

        public final V6.n a() {
            return AbstractC0654d0.f5151c;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: L5.d0$b */
    public abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ I5.m[] f5152c = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a1.a f5153a;

        public b() {
            this.f5153a = a1.c(new C0656e0(AbstractC0654d0.this));
        }

        public static final W5.k c(AbstractC0654d0 abstractC0654d0) {
            return Z0.a(abstractC0654d0.e());
        }

        public final W5.k b() {
            Object objB = this.f5153a.b(this, f5152c[0]);
            AbstractC2304t.e(objB, "getValue(...)");
            return (W5.k) objB;
        }
    }

    /* JADX INFO: renamed from: L5.d0$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f5155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f5156b;

        public c(List parameters, Class cls) {
            AbstractC2304t.f(parameters, "parameters");
            this.f5155a = parameters;
            this.f5156b = cls;
        }

        public final List a() {
            return this.f5155a;
        }

        public final Class b() {
            return this.f5156b;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: L5.d0$d */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5157a = new d("DECLARED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f5158b = new d("INHERITED", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ d[] f5159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f5160d;

        static {
            d[] dVarArrA = a();
            f5159c = dVarArrA;
            f5160d = AbstractC2875b.a(dVarArrA);
        }

        public d(String str, int i8) {
        }

        public static final /* synthetic */ d[] a() {
            return new d[]{f5157a, f5158b};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f5159c.clone();
        }

        public final boolean b(InterfaceC0845b member) {
            AbstractC2304t.f(member, "member");
            return member.i().a() == (this == f5157a);
        }
    }

    /* JADX INFO: renamed from: L5.d0$e */
    public static final class e extends C0665j {
        public e(AbstractC0654d0 abstractC0654d0) {
            super(abstractC0654d0);
        }

        @Override // U5.AbstractC0958o, R5.InterfaceC0858o
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public A k(InterfaceC0855l descriptor, C2470H data) {
            AbstractC2304t.f(descriptor, "descriptor");
            AbstractC2304t.f(data, "data");
            throw new IllegalStateException("No constructors should appear here: " + descriptor);
        }
    }

    public static final CharSequence A(InterfaceC0868z descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return t6.n.f23389k.M(descriptor) + " | " + f1.f5170a.g(descriptor).a();
    }

    public static final int D(AbstractC0863u abstractC0863u, AbstractC0863u abstractC0863u2) {
        Integer numD = AbstractC0862t.d(abstractC0863u, abstractC0863u2);
        if (numD != null) {
            return numD.intValue();
        }
        return 0;
    }

    public static final int E(B5.o oVar, Object obj, Object obj2) {
        return ((Number) oVar.invoke(obj, obj2)).intValue();
    }

    public static final CharSequence F(R5.Z descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return t6.n.f23389k.M(descriptor) + " | " + f1.f5170a.f(descriptor).a();
    }

    public final Method B(String name, String desc) {
        Method methodM;
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(desc, "desc");
        if (AbstractC2304t.b(name, "<init>")) {
            return null;
        }
        c cVarN = N(desc, true);
        Class[] clsArr = (Class[]) cVarN.a().toArray(new Class[0]);
        Class clsB = cVarN.b();
        AbstractC2304t.c(clsB);
        Method methodM2 = M(K(), name, clsArr, clsB, false);
        if (methodM2 != null) {
            return methodM2;
        }
        if (!K().isInterface() || (methodM = M(Object.class, name, clsArr, clsB, false)) == null) {
            return null;
        }
        return methodM;
    }

    public final R5.Z C(String name, String signature) {
        Object objU0;
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
        V6.k kVarA = f5151c.a(signature);
        if (kVarA != null) {
            String str = (String) kVarA.a().a().b().get(1);
            R5.Z zI = I(Integer.parseInt(str));
            if (zI != null) {
                return zI;
            }
            throw new Y0("Local property #" + str + " not found in " + e());
        }
        q6.f fVarL = q6.f.l(name);
        AbstractC2304t.e(fVarL, "identifier(...)");
        Collection collectionL = L(fVarL);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionL) {
            if (AbstractC2304t.b(f1.f5170a.f((R5.Z) obj).a(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Y0("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList.size() != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : arrayList) {
                AbstractC0863u visibility = ((R5.Z) obj2).getVisibility();
                Object arrayList2 = linkedHashMap.get(visibility);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(visibility, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            Collection collectionValues = p5.L.g(linkedHashMap, new C0648a0(Z.f5138a)).values();
            AbstractC2304t.e(collectionValues, "<get-values>(...)");
            List list = (List) p5.z.i0(collectionValues);
            if (list.size() != 1) {
                q6.f fVarL2 = q6.f.l(name);
                AbstractC2304t.e(fVarL2, "identifier(...)");
                String strH0 = p5.z.h0(L(fVarL2), "\n", null, null, 0, null, C0650b0.f5144a, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(name);
                sb.append("' (JVM signature: ");
                sb.append(signature);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(':');
                sb.append(strH0.length() == 0 ? " no members found" : '\n' + strH0);
                throw new Y0(sb.toString());
            }
            AbstractC2304t.c(list);
            objU0 = p5.z.Y(list);
        } else {
            objU0 = p5.z.u0(arrayList);
        }
        return (R5.Z) objU0;
    }

    public abstract Collection G();

    public abstract Collection H(q6.f fVar);

    public abstract R5.Z I(int i8);

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection J(B6.k r8, L5.AbstractC0654d0.d r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.AbstractC2304t.f(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.AbstractC2304t.f(r9, r0)
            L5.d0$e r0 = new L5.d0$e
            r0.<init>(r7)
            r1 = 3
            r2 = 0
            java.util.Collection r8 = B6.n.a.a(r8, r2, r2, r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L53
            java.lang.Object r3 = r8.next()
            R5.m r3 = (R5.InterfaceC0856m) r3
            boolean r4 = r3 instanceof R5.InterfaceC0845b
            if (r4 == 0) goto L4c
            r4 = r3
            R5.b r4 = (R5.InterfaceC0845b) r4
            R5.u r5 = r4.getVisibility()
            R5.u r6 = R5.AbstractC0862t.f7264h
            boolean r5 = kotlin.jvm.internal.AbstractC2304t.b(r5, r6)
            if (r5 != 0) goto L4c
            boolean r4 = r9.b(r4)
            if (r4 == 0) goto L4c
            o5.H r4 = o5.C2470H.f21956a
            java.lang.Object r3 = r3.N(r0, r4)
            L5.A r3 = (L5.A) r3
            goto L4d
        L4c:
            r3 = r2
        L4d:
            if (r3 == 0) goto L1e
            r1.add(r3)
            goto L1e
        L53:
            java.util.List r8 = p5.z.G0(r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: L5.AbstractC0654d0.J(B6.k, L5.d0$d):java.util.Collection");
    }

    public Class K() {
        Class clsK = AbstractC0990f.k(e());
        return clsK == null ? e() : clsK;
    }

    public abstract Collection L(q6.f fVar);

    public final Method M(Class cls, String str, Class[] clsArr, Class cls2, boolean z7) {
        Method methodM;
        if (z7) {
            clsArr[0] = cls;
        }
        Method methodQ = Q(cls, str, clsArr, cls2);
        if (methodQ != null) {
            return methodQ;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && (methodM = M(superclass, str, clsArr, cls2, z7)) != null) {
            return methodM;
        }
        Iterator itA = AbstractC2288c.a(cls.getInterfaces());
        while (itA.hasNext()) {
            Class cls3 = (Class) itA.next();
            AbstractC2304t.c(cls3);
            Method methodM2 = M(cls3, str, clsArr, cls2, z7);
            if (methodM2 != null) {
                return methodM2;
            }
            if (z7) {
                Class clsA = W5.e.a(AbstractC0990f.j(cls3), cls3.getName() + "$DefaultImpls");
                if (clsA != null) {
                    clsArr[0] = cls3;
                    Method methodQ2 = Q(clsA, str, clsArr, cls2);
                    if (methodQ2 != null) {
                        return methodQ2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final c N(String str, boolean z7) {
        int iX;
        ArrayList arrayList = new ArrayList();
        int i8 = 1;
        while (true) {
            if (str.charAt(i8) == ')') {
                return new c(arrayList, z7 ? O(str, i8 + 1, str.length()) : null);
            }
            int i9 = i8;
            while (str.charAt(i9) == '[') {
                i9++;
            }
            char cCharAt = str.charAt(i9);
            if (V6.C.K("VZCBSIFJD", cCharAt, false, 2, null)) {
                iX = i9 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new Y0("Unknown type prefix in the method signature: " + str);
                }
                iX = V6.C.X(str, ';', i8, false, 4, null) + 1;
            }
            arrayList.add(O(str, i8, iX));
            i8 = iX;
        }
    }

    public final Class O(String str, int i8, int i9) throws ClassNotFoundException {
        Class<?> clsLoadClass;
        String str2;
        char cCharAt = str.charAt(i8);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader classLoaderJ = AbstractC0990f.j(e());
            String strSubstring = str.substring(i8 + 1, i9 - 1);
            AbstractC2304t.e(strSubstring, "substring(...)");
            clsLoadClass = classLoaderJ.loadClass(V6.A.D(strSubstring, '/', com.amazon.a.a.o.c.a.b.f14112a, false, 4, null));
            str2 = "loadClass(...)";
        } else {
            if (cCharAt == 'S') {
                return Short.TYPE;
            }
            if (cCharAt != 'V') {
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
                    return j1.f(O(str, i8 + 1, i9));
                }
                switch (cCharAt) {
                    case 'B':
                        return Byte.TYPE;
                    case 'C':
                        return Character.TYPE;
                    case 'D':
                        return Double.TYPE;
                    default:
                        throw new Y0("Unknown type prefix in the method signature: " + str);
                }
            }
            clsLoadClass = Void.TYPE;
            str2 = "TYPE";
        }
        AbstractC2304t.e(clsLoadClass, str2);
        return clsLoadClass;
    }

    public final Constructor P(Class cls, List list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method Q(Class cls, String str, Class[] clsArr, Class cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (AbstractC2304t.b(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            AbstractC2304t.e(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                if (AbstractC2304t.b(method.getName(), str) && AbstractC2304t.b(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final void v(List list, List list2, boolean z7) {
        if (AbstractC2304t.b(p5.z.l0(list2), f5150b)) {
            list2 = list2.subList(0, list2.size() - 1);
        }
        list.addAll(list2);
        int size = (list2.size() + 31) / 32;
        for (int i8 = 0; i8 < size; i8++) {
            Class TYPE = Integer.TYPE;
            AbstractC2304t.e(TYPE, "TYPE");
            list.add(TYPE);
        }
        Class cls = z7 ? f5150b : Object.class;
        AbstractC2304t.c(cls);
        list.add(cls);
    }

    public final Constructor w(String desc) {
        AbstractC2304t.f(desc, "desc");
        return P(e(), N(desc, false).a());
    }

    public final Constructor x(String desc) {
        AbstractC2304t.f(desc, "desc");
        Class clsE = e();
        ArrayList arrayList = new ArrayList();
        v(arrayList, N(desc, false).a(), true);
        C2470H c2470h = C2470H.f21956a;
        return P(clsE, arrayList);
    }

    public final Method y(String name, String desc, boolean z7) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(desc, "desc");
        if (AbstractC2304t.b(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z7) {
            arrayList.add(e());
        }
        c cVarN = N(desc, true);
        v(arrayList, cVarN.a(), false);
        Class clsK = K();
        String str = name + "$default";
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class clsB = cVarN.b();
        AbstractC2304t.c(clsB);
        return M(clsK, str, clsArr, clsB, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final R5.InterfaceC0868z z(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L5.AbstractC0654d0.z(java.lang.String, java.lang.String):R5.z");
    }
}
