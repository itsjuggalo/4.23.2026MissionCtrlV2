package I5;

import V6.A;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2305u;
import o5.C2487o;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4317a;

        static {
            int[] iArr = new int[t.values().length];
            try {
                iArr[t.f4302b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[t.f4301a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[t.f4303c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4317a = iArr;
        }
    }

    public /* synthetic */ class b extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4318a = new b();

        public b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Class invoke(Class p02) {
            AbstractC2304t.f(p02, "p0");
            return p02.getComponentType();
        }
    }

    public static final Type c(q qVar, boolean z7) {
        f fVarC = qVar.c();
        if (fVarC instanceof r) {
            return new w((r) fVarC);
        }
        if (!(fVarC instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + qVar);
        }
        d dVar = (d) fVarC;
        Class clsC = z7 ? A5.a.c(dVar) : A5.a.b(dVar);
        List listA = qVar.a();
        if (listA.isEmpty()) {
            return clsC;
        }
        if (!clsC.isArray()) {
            return e(clsC, listA);
        }
        if (clsC.getComponentType().isPrimitive()) {
            return clsC;
        }
        s sVar = (s) z.w0(listA);
        if (sVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + qVar);
        }
        t tVarA = sVar.a();
        q qVarB = sVar.b();
        int i8 = tVarA == null ? -1 : a.f4317a[tVarA.ordinal()];
        if (i8 == -1 || i8 == 1) {
            return clsC;
        }
        if (i8 != 2 && i8 != 3) {
            throw new C2487o();
        }
        AbstractC2304t.c(qVarB);
        Type typeD = d(qVarB, false, 1, null);
        return typeD instanceof Class ? clsC : new I5.a(typeD);
    }

    public static /* synthetic */ Type d(q qVar, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return c(qVar, z7);
    }

    public static final Type e(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(p5.r.s(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(g((s) it.next()));
            }
            return new v(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(p5.r.s(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((s) it2.next()));
            }
            return new v(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(p5.r.s(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((s) it3.next()));
        }
        return new v(cls, typeE, arrayList3);
    }

    public static final Type f(q qVar) {
        Type typeB;
        AbstractC2304t.f(qVar, "<this>");
        return (!(qVar instanceof InterfaceC2305u) || (typeB = ((InterfaceC2305u) qVar).b()) == null) ? d(qVar, false, 1, null) : typeB;
    }

    public static final Type g(s sVar) {
        t tVarD = sVar.d();
        if (tVarD == null) {
            return y.f4319c.a();
        }
        q qVarC = sVar.c();
        AbstractC2304t.c(qVarC);
        int i8 = a.f4317a[tVarD.ordinal()];
        if (i8 == 1) {
            return new y(null, c(qVarC, true));
        }
        if (i8 == 2) {
            return c(qVarC, true);
        }
        if (i8 == 3) {
            return new y(c(qVarC, true), null);
        }
        throw new C2487o();
    }

    public static final String h(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            AbstractC2304t.e(name, "getName(...)");
            return name;
        }
        U6.h hVarL = U6.o.l(type, b.f4318a);
        return ((Class) U6.r.A(hVarL)).getName() + A.A("[]", U6.r.s(hVarL));
    }
}
