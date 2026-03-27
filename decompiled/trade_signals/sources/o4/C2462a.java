package o4;

import com.amazon.a.a.o.b;
import com.google.gson.internal.AbstractC1456b;
import com.google.gson.internal.F;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: renamed from: o4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2462a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f21939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f21940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21941c;

    public C2462a() {
        Type typeE = e();
        this.f21940b = typeE;
        this.f21939a = AbstractC1456b.k(typeE);
        this.f21941c = typeE.hashCode();
    }

    public static C2462a a(Class cls) {
        return new C2462a(cls);
    }

    public static C2462a b(Type type) {
        return new C2462a(type);
    }

    public static boolean f() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), b.af);
    }

    public static void g(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + F.a("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            g(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i8 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                g(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i8 < length) {
                g(actualTypeArguments[i8]);
                i8++;
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
        while (i8 < length2) {
            g(upperBounds[i8]);
            i8++;
        }
    }

    public final Class c() {
        return this.f21939a;
    }

    public final Type d() {
        return this.f21940b;
    }

    public final Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == C2462a.class) {
                Type typeB = AbstractC1456b.b(parameterizedType.getActualTypeArguments()[0]);
                if (f()) {
                    g(typeB);
                }
                return typeB;
            }
        } else if (genericSuperclass == C2462a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + F.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C2462a) && AbstractC1456b.f(this.f21940b, ((C2462a) obj).f21940b);
    }

    public final int hashCode() {
        return this.f21941c;
    }

    public final String toString() {
        return AbstractC1456b.u(this.f21940b);
    }

    public C2462a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = AbstractC1456b.b(type);
        this.f21940b = typeB;
        this.f21939a = AbstractC1456b.k(typeB);
        this.f21941c = typeB.hashCode();
    }
}
