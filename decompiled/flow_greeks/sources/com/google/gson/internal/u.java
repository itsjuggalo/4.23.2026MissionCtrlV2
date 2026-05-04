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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f6844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f6846c;

    public u(Map map, boolean z10, List list) {
        this.f6844a = map;
        this.f6845b = z10;
        this.f6846c = list;
    }

    public static /* synthetic */ Object a() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Object b() {
        return new ArrayList();
    }

    public static /* synthetic */ Object c() {
        return new y();
    }

    public static /* synthetic */ Object d(String str) {
        throw new com.google.gson.j(str);
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
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object i(Class cls) {
        try {
            return g0.f6819a.d(cls);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
        }
    }

    public static /* synthetic */ Object j(Constructor constructor) {
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e10) {
            throw eb.a.e(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Failed to invoke constructor '" + eb.a.c(constructor) + "' with no args", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("Failed to invoke constructor '" + eb.a.c(constructor) + "' with no args", e12.getCause());
        }
    }

    public static /* synthetic */ Object k(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new com.google.gson.j("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new com.google.gson.j("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Object l(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object m() {
        return new LinkedHashSet();
    }

    public static /* synthetic */ Object n(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object o(String str) {
        throw new com.google.gson.j(str);
    }

    public static /* synthetic */ Object p() {
        return new ConcurrentSkipListMap();
    }

    public static /* synthetic */ Object q() {
        return new ArrayDeque();
    }

    public static /* synthetic */ Object r(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new com.google.gson.j("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new com.google.gson.j("Invalid EnumSet type: " + type.toString());
    }

    public static String s(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + f0.a("r8-abstract-class");
    }

    public static a0 u(Class cls, com.google.gson.r rVar) {
        final String strP;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            com.google.gson.r rVar2 = com.google.gson.r.ALLOW;
            if (rVar == rVar2 || (d0.a(declaredConstructor, null) && (rVar != com.google.gson.r.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (rVar != rVar2 || (strP = eb.a.p(declaredConstructor)) == null) ? new a0() { // from class: com.google.gson.internal.k
                    @Override // com.google.gson.internal.a0
                    public final Object a() {
                        return u.j(declaredConstructor);
                    }
                } : new a0() { // from class: com.google.gson.internal.j
                    @Override // com.google.gson.internal.a0
                    public final Object a() {
                        return u.l(strP);
                    }
                };
            }
            final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new a0() { // from class: com.google.gson.internal.i
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.h(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static a0 v(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new a0() { // from class: com.google.gson.internal.o
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.g();
                }
            } : Set.class.isAssignableFrom(cls) ? new a0() { // from class: com.google.gson.internal.p
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.m();
                }
            } : Queue.class.isAssignableFrom(cls) ? new a0() { // from class: com.google.gson.internal.q
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.q();
                }
            } : new a0() { // from class: com.google.gson.internal.r
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.b();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new a0() { // from class: com.google.gson.internal.s
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.p();
                }
            } : ConcurrentMap.class.isAssignableFrom(cls) ? new a0() { // from class: com.google.gson.internal.t
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.f();
                }
            } : SortedMap.class.isAssignableFrom(cls) ? new a0() { // from class: com.google.gson.internal.d
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.e();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(fb.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new a0() { // from class: com.google.gson.internal.f
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.c();
                }
            } : new a0() { // from class: com.google.gson.internal.e
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.a();
                }
            };
        }
        return null;
    }

    public static a0 w(final Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new a0() { // from class: com.google.gson.internal.g
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.r(type);
                }
            };
        }
        if (cls == EnumMap.class) {
            return new a0() { // from class: com.google.gson.internal.h
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.k(type);
                }
            };
        }
        return null;
    }

    public a0 t(fb.a aVar) {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        android.support.v4.media.session.b.a(this.f6844a.get(typeD));
        android.support.v4.media.session.b.a(this.f6844a.get(clsC));
        a0 a0VarW = w(typeD, clsC);
        if (a0VarW != null) {
            return a0VarW;
        }
        com.google.gson.r rVarB = d0.b(this.f6846c, clsC);
        a0 a0VarU = u(clsC, rVarB);
        if (a0VarU != null) {
            return a0VarU;
        }
        a0 a0VarV = v(typeD, clsC);
        if (a0VarV != null) {
            return a0VarV;
        }
        final String strS = s(clsC);
        if (strS != null) {
            return new a0() { // from class: com.google.gson.internal.c
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.o(strS);
                }
            };
        }
        if (rVarB == com.google.gson.r.ALLOW) {
            return x(clsC);
        }
        final String str = "Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new a0() { // from class: com.google.gson.internal.l
            @Override // com.google.gson.internal.a0
            public final Object a() {
                return u.d(str);
            }
        };
    }

    public String toString() {
        return this.f6844a.toString();
    }

    public final a0 x(final Class cls) {
        if (this.f6845b) {
            return new a0() { // from class: com.google.gson.internal.m
                @Override // com.google.gson.internal.a0
                public final Object a() {
                    return u.i(cls);
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new a0() { // from class: com.google.gson.internal.n
            @Override // com.google.gson.internal.a0
            public final Object a() {
                return u.n(str);
            }
        };
    }
}
