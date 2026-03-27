package X5;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import p5.AbstractC2592n;
import p5.AbstractC2595q;
import p5.M;
import q6.b;

/* JADX INFO: renamed from: X5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0990f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f9422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f9423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f9424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f9425d;

    static {
        int i8 = 0;
        List<I5.d> listL = AbstractC2595q.l(O.b(Boolean.TYPE), O.b(Byte.TYPE), O.b(Character.TYPE), O.b(Double.TYPE), O.b(Float.TYPE), O.b(Integer.TYPE), O.b(Long.TYPE), O.b(Short.TYPE));
        f9422a = listL;
        ArrayList arrayList = new ArrayList(p5.r.s(listL, 10));
        for (I5.d dVar : listL) {
            arrayList.add(o5.w.a(A5.a.c(dVar), A5.a.d(dVar)));
        }
        f9423b = M.u(arrayList);
        List<I5.d> list = f9422a;
        ArrayList arrayList2 = new ArrayList(p5.r.s(list, 10));
        for (I5.d dVar2 : list) {
            arrayList2.add(o5.w.a(A5.a.d(dVar2), A5.a.c(dVar2)));
        }
        f9424c = M.u(arrayList2);
        List listL2 = AbstractC2595q.l(Function0.class, B5.k.class, B5.o.class, B5.p.class, B5.q.class, B5.r.class, B5.s.class, B5.t.class, B5.u.class, B5.v.class, B5.a.class, B5.b.class, B5.c.class, B5.d.class, B5.e.class, B5.f.class, B5.g.class, B5.h.class, B5.i.class, B5.j.class, B5.l.class, B5.m.class, B5.n.class);
        ArrayList arrayList3 = new ArrayList(p5.r.s(listL2, 10));
        for (Object obj : listL2) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                AbstractC2595q.r();
            }
            arrayList3.add(o5.w.a((Class) obj, Integer.valueOf(i8)));
            i8 = i9;
        }
        f9425d = M.u(arrayList3);
    }

    public static final ParameterizedType a(ParameterizedType it) {
        AbstractC2304t.f(it, "it");
        Type ownerType = it.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }

    public static final U6.h b(ParameterizedType it) {
        AbstractC2304t.f(it, "it");
        Type[] actualTypeArguments = it.getActualTypeArguments();
        AbstractC2304t.e(actualTypeArguments, "getActualTypeArguments(...)");
        return AbstractC2592n.t(actualTypeArguments);
    }

    public static final q6.b e(Class cls) {
        q6.b bVarE;
        AbstractC2304t.f(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            AbstractC2304t.e(simpleName, "getSimpleName(...)");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                if (declaringClass != null && (bVarE = e(declaringClass)) != null) {
                    q6.f fVarL = q6.f.l(cls.getSimpleName());
                    AbstractC2304t.e(fVarL, "identifier(...)");
                    q6.b bVarD = bVarE.d(fVarL);
                    if (bVarD != null) {
                        return bVarD;
                    }
                }
                b.a aVar = q6.b.f22655d;
                String name = cls.getName();
                AbstractC2304t.e(name, "getName(...)");
                return aVar.c(new q6.c(name));
            }
        }
        String name2 = cls.getName();
        AbstractC2304t.e(name2, "getName(...)");
        q6.c cVar = new q6.c(name2);
        return new q6.b(cVar.d(), q6.c.f22659c.a(cVar.f()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String f(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                AbstractC2304t.e(name, "getName(...)");
                return V6.A.D(name, com.amazon.a.a.o.c.a.b.f14112a, '/', false, 4, null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            String name2 = cls.getName();
            AbstractC2304t.e(name2, "getName(...)");
            sb.append(V6.A.D(name2, com.amazon.a.a.o.c.a.b.f14112a, '/', false, 4, null));
            sb.append(';');
            return sb.toString();
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
        AbstractC2304t.f(cls, "<this>");
        return (Integer) f9425d.get(cls);
    }

    public static final List h(Type type) {
        AbstractC2304t.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return AbstractC2595q.i();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return U6.r.J(U6.r.z(U6.o.l(type, C0988d.f9420a), C0989e.f9421a));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        AbstractC2304t.e(actualTypeArguments, "getActualTypeArguments(...)");
        return AbstractC2592n.k0(actualTypeArguments);
    }

    public static final Class i(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        return (Class) f9423b.get(cls);
    }

    public static final ClassLoader j(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        AbstractC2304t.e(systemClassLoader, "getSystemClassLoader(...)");
        return systemClassLoader;
    }

    public static final Class k(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        return (Class) f9424c.get(cls);
    }

    public static final boolean l(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
