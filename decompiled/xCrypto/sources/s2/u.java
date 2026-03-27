package s2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import v2.AbstractC1896a;
import x2.C1925a;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14636c;

    public u(Map map, boolean z4, List list) {
        this.f14634a = map;
        this.f14635b = z4;
        this.f14636c = list;
    }

    public static /* synthetic */ Object a() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Object b() {
        return new ArrayList();
    }

    public static /* synthetic */ Object c() {
        return new z();
    }

    public static /* synthetic */ Object d(String str) {
        throw new q2.k(str);
    }

    public static /* synthetic */ Object e() {
        return new TreeMap();
    }

    public static /* synthetic */ Object f() {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ Object g() {
        return new TreeSet();
    }

    public static /* synthetic */ Object h(String str) {
        throw new q2.k(str);
    }

    public static /* synthetic */ Object i(Class cls) {
        try {
            return H.f14612a.d(cls);
        } catch (Exception e4) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e4);
        }
    }

    public static /* synthetic */ Object j(Constructor constructor) {
        try {
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e4) {
            throw AbstractC1896a.e(e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC1896a.c(constructor) + "' with no args", e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC1896a.c(constructor) + "' with no args", e6.getCause());
        }
    }

    public static /* synthetic */ Object k(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new q2.k("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new q2.k("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Object l(String str) {
        throw new q2.k(str);
    }

    public static /* synthetic */ Object m() {
        return new LinkedHashSet();
    }

    public static /* synthetic */ Object n(String str) {
        throw new q2.k(str);
    }

    public static /* synthetic */ Object o(String str) {
        throw new q2.k(str);
    }

    public static /* synthetic */ Object p() {
        return new ConcurrentSkipListMap();
    }

    public static /* synthetic */ Object q() {
        return new ArrayDeque();
    }

    public static /* synthetic */ Object r(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new q2.k("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new q2.k("Invalid EnumSet type: " + type.toString());
    }

    public static String s(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + G.a("r8-abstract-class");
    }

    public static InterfaceC1769B u(Class cls, q2.s sVar) {
        final String strP;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            q2.s sVar2 = q2.s.ALLOW;
            if (sVar == sVar2 || (E.a(declaredConstructor, null) && (sVar != q2.s.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (sVar != sVar2 || (strP = AbstractC1896a.p(declaredConstructor)) == null) ? new InterfaceC1769B() { // from class: s2.k
                    @Override // s2.InterfaceC1769B
                    public final Object a() {
                        return u.j(declaredConstructor);
                    }
                } : new InterfaceC1769B() { // from class: s2.j
                    @Override // s2.InterfaceC1769B
                    public final Object a() {
                        return u.l(strP);
                    }
                };
            }
            final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new InterfaceC1769B() { // from class: s2.i
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.h(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static InterfaceC1769B v(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new InterfaceC1769B() { // from class: s2.o
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.g();
                }
            } : Set.class.isAssignableFrom(cls) ? new InterfaceC1769B() { // from class: s2.p
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.m();
                }
            } : Queue.class.isAssignableFrom(cls) ? new InterfaceC1769B() { // from class: s2.q
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.q();
                }
            } : new InterfaceC1769B() { // from class: s2.r
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.b();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new InterfaceC1769B() { // from class: s2.s
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.p();
                }
            } : ConcurrentMap.class.isAssignableFrom(cls) ? new InterfaceC1769B() { // from class: s2.t
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.f();
                }
            } : SortedMap.class.isAssignableFrom(cls) ? new InterfaceC1769B() { // from class: s2.d
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.e();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C1925a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new InterfaceC1769B() { // from class: s2.f
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.c();
                }
            } : new InterfaceC1769B() { // from class: s2.e
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.a();
                }
            };
        }
        return null;
    }

    public static InterfaceC1769B w(final Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new InterfaceC1769B() { // from class: s2.g
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.r(type);
                }
            };
        }
        if (cls == EnumMap.class) {
            return new InterfaceC1769B() { // from class: s2.h
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.k(type);
                }
            };
        }
        return null;
    }

    public InterfaceC1769B t(C1925a c1925a) {
        Type typeD = c1925a.d();
        Class clsC = c1925a.c();
        android.support.v4.media.session.b.a(this.f14634a.get(typeD));
        android.support.v4.media.session.b.a(this.f14634a.get(clsC));
        InterfaceC1769B interfaceC1769BW = w(typeD, clsC);
        if (interfaceC1769BW != null) {
            return interfaceC1769BW;
        }
        q2.s sVarB = E.b(this.f14636c, clsC);
        InterfaceC1769B interfaceC1769BU = u(clsC, sVarB);
        if (interfaceC1769BU != null) {
            return interfaceC1769BU;
        }
        InterfaceC1769B interfaceC1769BV = v(typeD, clsC);
        if (interfaceC1769BV != null) {
            return interfaceC1769BV;
        }
        final String strS = s(clsC);
        if (strS != null) {
            return new InterfaceC1769B() { // from class: s2.c
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.o(strS);
                }
            };
        }
        if (sVarB == q2.s.ALLOW) {
            return x(clsC);
        }
        final String str = "Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new InterfaceC1769B() { // from class: s2.l
            @Override // s2.InterfaceC1769B
            public final Object a() {
                return u.d(str);
            }
        };
    }

    public String toString() {
        return this.f14634a.toString();
    }

    public final InterfaceC1769B x(final Class cls) {
        if (this.f14635b) {
            return new InterfaceC1769B() { // from class: s2.m
                @Override // s2.InterfaceC1769B
                public final Object a() {
                    return u.i(cls);
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new InterfaceC1769B() { // from class: s2.n
            @Override // s2.InterfaceC1769B
            public final Object a() {
                return u.n(str);
            }
        };
    }
}
