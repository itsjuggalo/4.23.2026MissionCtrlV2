package le;

import dd.o0;
import ef.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f15613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f15614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f15615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f15616d;

    static {
        int i10 = 0;
        List<wd.d> listN = dd.r.n(n0.b(Boolean.TYPE), n0.b(Byte.TYPE), n0.b(Character.TYPE), n0.b(Double.TYPE), n0.b(Float.TYPE), n0.b(Integer.TYPE), n0.b(Long.TYPE), n0.b(Short.TYPE));
        f15613a = listN;
        ArrayList arrayList = new ArrayList(dd.s.u(listN, 10));
        for (wd.d dVar : listN) {
            arrayList.add(cd.w.a(od.a.c(dVar), od.a.d(dVar)));
        }
        f15614b = o0.t(arrayList);
        List<wd.d> list = f15613a;
        ArrayList arrayList2 = new ArrayList(dd.s.u(list, 10));
        for (wd.d dVar2 : list) {
            arrayList2.add(cd.w.a(od.a.d(dVar2), od.a.c(dVar2)));
        }
        f15615c = o0.t(arrayList2);
        List listN2 = dd.r.n(Function0.class, pd.k.class, pd.o.class, pd.p.class, pd.q.class, pd.r.class, pd.s.class, pd.t.class, pd.u.class, pd.v.class, pd.a.class, pd.b.class, pd.c.class, pd.d.class, pd.e.class, pd.f.class, pd.g.class, pd.h.class, pd.i.class, pd.j.class, pd.l.class, pd.m.class, pd.n.class);
        ArrayList arrayList3 = new ArrayList(dd.s.u(listN2, 10));
        for (Object obj : listN2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            arrayList3.add(cd.w.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f15616d = o0.t(arrayList3);
    }

    public static final ParameterizedType a(ParameterizedType it) {
        kotlin.jvm.internal.t.f(it, "it");
        Type ownerType = it.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }

    public static final jg.h b(ParameterizedType it) {
        kotlin.jvm.internal.t.f(it, "it");
        Type[] actualTypeArguments = it.getActualTypeArguments();
        kotlin.jvm.internal.t.e(actualTypeArguments, "getActualTypeArguments(...)");
        return dd.n.t(actualTypeArguments);
    }

    public static final ef.b e(Class cls) {
        ef.b bVarE;
        kotlin.jvm.internal.t.f(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            kotlin.jvm.internal.t.e(simpleName, "getSimpleName(...)");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                if (declaringClass != null && (bVarE = e(declaringClass)) != null) {
                    ef.f fVarK = ef.f.k(cls.getSimpleName());
                    kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
                    ef.b bVarD = bVarE.d(fVarK);
                    if (bVarD != null) {
                        return bVarD;
                    }
                }
                b.a aVar = ef.b.f8779d;
                String name = cls.getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                return aVar.c(new ef.c(name));
            }
        }
        String name2 = cls.getName();
        kotlin.jvm.internal.t.e(name2, "getName(...)");
        ef.c cVar = new ef.c(name2);
        return new ef.b(cVar.d(), ef.c.f8783c.a(cVar.f()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String f(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                return kg.z.E(name, com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('L');
            String name2 = cls.getName();
            kotlin.jvm.internal.t.e(name2, "getName(...)");
            sb2.append(kg.z.E(name2, com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null));
            sb2.append(';');
            return sb2.toString();
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return "V";
                }
                break;
            case 64711720:
                if (name3.equals("boolean")) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals("float")) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return "S";
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported primitive type: " + cls);
    }

    public static final Integer g(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        return (Integer) f15616d.get(cls);
    }

    public static final List h(Type type) {
        kotlin.jvm.internal.t.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return dd.r.k();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return jg.t.M(jg.t.C(jg.q.n(type, d.f15609a), e.f15611a));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.t.e(actualTypeArguments, "getActualTypeArguments(...)");
        return dd.n.z0(actualTypeArguments);
    }

    public static final Class i(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        return (Class) f15614b.get(cls);
    }

    public static final ClassLoader j(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.t.e(systemClassLoader, "getSystemClassLoader(...)");
        return systemClassLoader;
    }

    public static final Class k(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        return (Class) f15615c.get(cls);
    }

    public static final boolean l(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
