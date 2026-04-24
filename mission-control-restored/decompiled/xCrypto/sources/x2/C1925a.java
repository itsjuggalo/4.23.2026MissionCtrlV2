package x2;

import com.amazon.a.a.o.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import s2.AbstractC1772b;
import s2.G;

/* JADX INFO: renamed from: x2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1925a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f15749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f15750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15751c;

    public C1925a() {
        Type typeE = e();
        this.f15750b = typeE;
        this.f15749a = AbstractC1772b.k(typeE);
        this.f15751c = typeE.hashCode();
    }

    public static C1925a a(Class cls) {
        return new C1925a(cls);
    }

    public static C1925a b(Type type) {
        return new C1925a(type);
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
        int i4 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                g(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i4 < length) {
                g(actualTypeArguments[i4]);
                i4++;
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
        while (i4 < length2) {
            g(upperBounds[i4]);
            i4++;
        }
    }

    public final Class c() {
        return this.f15749a;
    }

    public final Type d() {
        return this.f15750b;
    }

    public final Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == C1925a.class) {
                Type typeB = AbstractC1772b.b(parameterizedType.getActualTypeArguments()[0]);
                if (f()) {
                    g(typeB);
                }
                return typeB;
            }
        } else if (genericSuperclass == C1925a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + G.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1925a) && AbstractC1772b.f(this.f15750b, ((C1925a) obj).f15750b);
    }

    public final int hashCode() {
        return this.f15751c;
    }

    public final String toString() {
        return AbstractC1772b.u(this.f15750b);
    }

    public C1925a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = AbstractC1772b.b(type);
        this.f15750b = typeB;
        this.f15749a = AbstractC1772b.k(typeB);
        this.f15751c = typeB.hashCode();
    }
}
