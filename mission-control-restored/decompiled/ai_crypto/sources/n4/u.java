package n4;

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
import l4.C2178k;
import q4.AbstractC2561a;
import s4.C2645a;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f19663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f19665c;

    public u(Map map, boolean z7, List list) {
        this.f19663a = map;
        this.f19664b = z7;
        this.f19665c = list;
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
        return new z();
    }

    public static /* synthetic */ Object H() {
        return new TreeSet();
    }

    public static /* synthetic */ Object I(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new C2178k("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new C2178k("Invalid EnumSet type: " + type.toString());
    }

    public static /* synthetic */ Object J(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new C2178k("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new C2178k("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Object K(Class cls) {
        try {
            return H.f19641a.d(cls);
        } catch (Exception e7) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e7);
        }
    }

    public static /* synthetic */ Object L(String str) {
        throw new C2178k(str);
    }

    public static B M(Class cls, l4.s sVar) {
        final String strP;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            l4.s sVar2 = l4.s.ALLOW;
            if (sVar == sVar2 || (E.a(declaredConstructor, null) && (sVar != l4.s.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (sVar != sVar2 || (strP = AbstractC2561a.p(declaredConstructor)) == null) ? new B() { // from class: n4.k
                    @Override // n4.B
                    public final Object a() {
                        return u.y(declaredConstructor);
                    }
                } : new B() { // from class: n4.j
                    @Override // n4.B
                    public final Object a() {
                        return u.x(strP);
                    }
                };
            }
            final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new B() { // from class: n4.i
                @Override // n4.B
                public final Object a() {
                    return u.w(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static B N(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new B() { // from class: n4.o
                @Override // n4.B
                public final Object a() {
                    return u.H();
                }
            } : Set.class.isAssignableFrom(cls) ? new B() { // from class: n4.p
                @Override // n4.B
                public final Object a() {
                    return u.z();
                }
            } : Queue.class.isAssignableFrom(cls) ? new B() { // from class: n4.q
                @Override // n4.B
                public final Object a() {
                    return u.A();
                }
            } : new B() { // from class: n4.r
                @Override // n4.B
                public final Object a() {
                    return u.B();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new B() { // from class: n4.s
                @Override // n4.B
                public final Object a() {
                    return u.C();
                }
            } : ConcurrentMap.class.isAssignableFrom(cls) ? new B() { // from class: n4.t
                @Override // n4.B
                public final Object a() {
                    return u.D();
                }
            } : SortedMap.class.isAssignableFrom(cls) ? new B() { // from class: n4.d
                @Override // n4.B
                public final Object a() {
                    return u.E();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C2645a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new B() { // from class: n4.f
                @Override // n4.B
                public final Object a() {
                    return u.G();
                }
            } : new B() { // from class: n4.e
                @Override // n4.B
                public final Object a() {
                    return u.F();
                }
            };
        }
        return null;
    }

    public static B O(final Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new B() { // from class: n4.g
                @Override // n4.B
                public final Object a() {
                    return u.I(type);
                }
            };
        }
        if (cls == EnumMap.class) {
            return new B() { // from class: n4.h
                @Override // n4.B
                public final Object a() {
                    return u.J(type);
                }
            };
        }
        return null;
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

    public static /* synthetic */ Object u(String str) {
        throw new C2178k(str);
    }

    public static /* synthetic */ Object v(String str) {
        throw new C2178k(str);
    }

    public static /* synthetic */ Object w(String str) {
        throw new C2178k(str);
    }

    public static /* synthetic */ Object x(String str) {
        throw new C2178k(str);
    }

    public static /* synthetic */ Object y(Constructor constructor) {
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e7) {
            throw AbstractC2561a.e(e7);
        } catch (InstantiationException e8) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC2561a.c(constructor) + "' with no args", e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException("Failed to invoke constructor '" + AbstractC2561a.c(constructor) + "' with no args", e9.getCause());
        }
    }

    public static /* synthetic */ Object z() {
        return new LinkedHashSet();
    }

    public final B P(final Class cls) {
        if (this.f19664b) {
            return new B() { // from class: n4.m
                @Override // n4.B
                public final Object a() {
                    return u.K(cls);
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new B() { // from class: n4.n
            @Override // n4.B
            public final Object a() {
                return u.L(str);
            }
        };
    }

    public B t(C2645a c2645a) {
        Type typeD = c2645a.d();
        Class clsC = c2645a.c();
        android.support.v4.media.session.b.a(this.f19663a.get(typeD));
        android.support.v4.media.session.b.a(this.f19663a.get(clsC));
        B bO = O(typeD, clsC);
        if (bO != null) {
            return bO;
        }
        l4.s sVarB = E.b(this.f19665c, clsC);
        B bM = M(clsC, sVarB);
        if (bM != null) {
            return bM;
        }
        B bN = N(typeD, clsC);
        if (bN != null) {
            return bN;
        }
        final String strS = s(clsC);
        if (strS != null) {
            return new B() { // from class: n4.c
                @Override // n4.B
                public final Object a() {
                    return u.u(strS);
                }
            };
        }
        if (sVarB == l4.s.ALLOW) {
            return P(clsC);
        }
        final String str = "Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new B() { // from class: n4.l
            @Override // n4.B
            public final Object a() {
                return u.v(str);
            }
        };
    }

    public String toString() {
        return this.f19663a.toString();
    }
}
