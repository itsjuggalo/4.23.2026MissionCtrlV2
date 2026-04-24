package com.google.gson.internal;

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
import n4.AbstractC2425a;
import o4.C2462a;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f16220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f16222c;

    public u(Map map, boolean z7, List list) {
        this.f16220a = map;
        this.f16221b = z7;
        this.f16222c = list;
    }

    public static /* synthetic */ Object A() {
        return new ArrayDeque();
    }

    public static /* synthetic */ Object B() {
        return new ArrayList();
    }

    public static /* synthetic */ Object C() {
        return new ConcurrentSkipListMap();
    }

    public static /* synthetic */ Object D() {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ Object E() {
        return new TreeMap();
    }

    public static /* synthetic */ Object F() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Object G() {
        return new y();
    }

    public static /* synthetic */ Object H() {
        return new TreeSet();
    }

    public static /* synthetic */ Object I(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new com.google.gson.j("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new com.google.gson.j("Invalid EnumSet type: " + type.toString());
    }

    public static /* synthetic */ Object J(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new com.google.gson.j("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new com.google.gson.j("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Object K(Class cls) {
        try {
            return G.f16033a.d(cls);
        } catch (Exception e8) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e8);
        }
    }

    public static /* synthetic */ Object L(String str) {
        throw new com.google.gson.j(str);
    }

    public static A M(Class cls, com.google.gson.r rVar) {
        final String strP;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            com.google.gson.r rVar2 = com.google.gson.r.ALLOW;
            if (rVar == rVar2 || (D.a(declaredConstructor, null) && (rVar != com.google.gson.r.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (rVar != rVar2 || (strP = AbstractC2425a.p(declaredConstructor)) == null) ? new A() { // from class: com.google.gson.internal.k
                    @Override // com.google.gson.internal.A
                    public final Object a() {
                        return u.y(declaredConstructor);
                    }
                } : new A() { // from class: com.google.gson.internal.j
                    @Override // com.google.gson.internal.A
                    public final Object a() {
                        return u.x(strP);
                    }
                };
            }
            final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new A() { // from class: com.google.gson.internal.i
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.w(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static A N(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new A() { // from class: com.google.gson.internal.o
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.H();
                }
            } : Set.class.isAssignableFrom(cls) ? new A() { // from class: com.google.gson.internal.p
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.z();
                }
            } : Queue.class.isAssignableFrom(cls) ? new A() { // from class: com.google.gson.internal.q
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.A();
                }
            } : new A() { // from class: com.google.gson.internal.r
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.B();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new A() { // from class: com.google.gson.internal.s
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.C();
                }
            } : ConcurrentMap.class.isAssignableFrom(cls) ? new A() { // from class: com.google.gson.internal.t
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.D();
                }
            } : SortedMap.class.isAssignableFrom(cls) ? new A() { // from class: com.google.gson.internal.d
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.E();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C2462a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new A() { // from class: com.google.gson.internal.f
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.G();
                }
            } : new A() { // from class: com.google.gson.internal.e
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.F();
                }
            };
        }
        return null;
    }

    public static A O(final Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new A() { // from class: com.google.gson.internal.g
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.I(type);
                }
            };
        }
        if (cls == EnumMap.class) {
            return new A() { // from class: com.google.gson.internal.h
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.J(type);
                }
            };
        }
        return null;
    }

    public static String s(Class cls) {
        StringBuilder sb;
        String strA;
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            sb = new StringBuilder();
            sb.append("Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ");
            strA = cls.getName();
        } else {
            if (!Modifier.isAbstract(modifiers)) {
                return null;
            }
            sb = new StringBuilder();
            sb.append("Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: ");
            sb.append(cls.getName());
            sb.append("\nSee ");
            strA = F.a("r8-abstract-class");
        }
        sb.append(strA);
        return sb.toString();
    }

    public static /* synthetic */ Object u(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object v(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object w(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object x(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object y(Constructor constructor) {
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e8) {
            throw AbstractC2425a.e(e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC2425a.c(constructor) + "' with no args", e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC2425a.c(constructor) + "' with no args", e10.getCause());
        }
    }

    public static /* synthetic */ Object z() {
        return new LinkedHashSet();
    }

    public final A P(final Class cls) {
        if (this.f16221b) {
            return new A() { // from class: com.google.gson.internal.m
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.K(cls);
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new A() { // from class: com.google.gson.internal.n
            @Override // com.google.gson.internal.A
            public final Object a() {
                return u.L(str);
            }
        };
    }

    public A t(C2462a c2462a) {
        Type typeD = c2462a.d();
        Class clsC = c2462a.c();
        android.support.v4.media.session.b.a(this.f16220a.get(typeD));
        android.support.v4.media.session.b.a(this.f16220a.get(clsC));
        A aO = O(typeD, clsC);
        if (aO != null) {
            return aO;
        }
        com.google.gson.r rVarB = D.b(this.f16222c, clsC);
        A aM = M(clsC, rVarB);
        if (aM != null) {
            return aM;
        }
        A aN = N(typeD, clsC);
        if (aN != null) {
            return aN;
        }
        final String strS = s(clsC);
        if (strS != null) {
            return new A() { // from class: com.google.gson.internal.c
                @Override // com.google.gson.internal.A
                public final Object a() {
                    return u.u(strS);
                }
            };
        }
        if (rVarB == com.google.gson.r.ALLOW) {
            return P(clsC);
        }
        final String str = "Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new A() { // from class: com.google.gson.internal.l
            @Override // com.google.gson.internal.A
            public final Object a() {
                return u.v(str);
            }
        };
    }

    public String toString() {
        return this.f16220a.toString();
    }
}
