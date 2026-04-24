package s4;

import com.amazon.a.a.o.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import n4.AbstractC2258b;
import n4.G;

/* JADX INFO: renamed from: s4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2645a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f22995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f22996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22997c;

    public C2645a() {
        Type typeE = e();
        this.f22996b = typeE;
        this.f22995a = AbstractC2258b.k(typeE);
        this.f22997c = typeE.hashCode();
    }

    public static C2645a a(Class cls) {
        return new C2645a(cls);
    }

    public static C2645a b(Type type) {
        return new C2645a(type);
    }

    public static boolean f() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), b.af);
    }

    public static void g(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + G.a("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            g(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i7 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                g(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i7 < length) {
                g(actualTypeArguments[i7]);
                i7++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            g(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i7 < length2) {
            g(upperBounds[i7]);
            i7++;
        }
    }

    public final Class c() {
        return this.f22995a;
    }

    public final Type d() {
        return this.f22996b;
    }

    public final Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == C2645a.class) {
                Type typeB = AbstractC2258b.b(parameterizedType.getActualTypeArguments()[0]);
                if (f()) {
                    g(typeB);
                }
                return typeB;
            }
        } else if (genericSuperclass == C2645a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + G.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C2645a) && AbstractC2258b.f(this.f22996b, ((C2645a) obj).f22996b);
    }

    public final int hashCode() {
        return this.f22997c;
    }

    public final String toString() {
        return AbstractC2258b.u(this.f22996b);
    }

    public C2645a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = AbstractC2258b.b(type);
        this.f22996b = typeB;
        this.f22995a = AbstractC2258b.k(typeB);
        this.f22997c = typeB.hashCode();
    }
}
