package wd;

import dd.a0;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kg.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23928a;

        static {
            int[] iArr = new int[t.values().length];
            try {
                iArr[t.f23913b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[t.f23912a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[t.f23914c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f23928a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23929a = new b();

        public b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Class invoke(Class p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return p02.getComponentType();
        }
    }

    public static final Type c(q qVar, boolean z10) {
        f fVarJ = qVar.j();
        if (fVarJ instanceof r) {
            return new w((r) fVarJ);
        }
        if (!(fVarJ instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + qVar);
        }
        d dVar = (d) fVarJ;
        Class clsC = z10 ? od.a.c(dVar) : od.a.b(dVar);
        List listF = qVar.f();
        if (listF.isEmpty()) {
            return clsC;
        }
        if (!clsC.isArray()) {
            return e(clsC, listF);
        }
        if (clsC.getComponentType().isPrimitive()) {
            return clsC;
        }
        s sVar = (s) a0.x0(listF);
        if (sVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + qVar);
        }
        t tVarA = sVar.a();
        q qVarB = sVar.b();
        int i10 = tVarA == null ? -1 : a.f23928a[tVarA.ordinal()];
        if (i10 == -1 || i10 == 1) {
            return clsC;
        }
        if (i10 != 2 && i10 != 3) {
            throw new cd.o();
        }
        kotlin.jvm.internal.t.c(qVarB);
        Type typeD = d(qVarB, false, 1, null);
        return typeD instanceof Class ? clsC : new wd.a(typeD);
    }

    public static /* synthetic */ Type d(q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(qVar, z10);
    }

    public static final Type e(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(dd.s.u(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(g((s) it.next()));
            }
            return new v(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(dd.s.u(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((s) it2.next()));
            }
            return new v(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(dd.s.u(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((s) it3.next()));
        }
        return new v(cls, typeE, arrayList3);
    }

    public static final Type f(q qVar) {
        Type typeK;
        kotlin.jvm.internal.t.f(qVar, "<this>");
        return (!(qVar instanceof kotlin.jvm.internal.u) || (typeK = ((kotlin.jvm.internal.u) qVar).k()) == null) ? d(qVar, false, 1, null) : typeK;
    }

    public static final Type g(s sVar) {
        t tVarD = sVar.d();
        if (tVarD == null) {
            return y.f23930c.a();
        }
        q qVarC = sVar.c();
        kotlin.jvm.internal.t.c(qVarC);
        int i10 = a.f23928a[tVarD.ordinal()];
        if (i10 == 1) {
            return new y(null, c(qVarC, true));
        }
        if (i10 == 2) {
            return c(qVarC, true);
        }
        if (i10 == 3) {
            return new y(c(qVarC, true), null);
        }
        throw new cd.o();
    }

    public static final String h(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            kotlin.jvm.internal.t.e(name, "getName(...)");
            return name;
        }
        jg.h hVarN = jg.q.n(type, b.f23929a);
        return ((Class) jg.t.D(hVarN)).getName() + z.B("[]", jg.t.v(hVarN));
    }
}
