package v3;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: v3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1259b implements ParameterizedType, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f10603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f10604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f10605c;

    public C1259b(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            throw new IllegalArgumentException("Must specify owner type for " + cls);
        }
        this.f10603a = type == null ? null : d.a(type);
        this.f10604b = d.a(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f10605c = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Objects.requireNonNull(this.f10605c[i]);
            d.c(this.f10605c[i]);
            Type[] typeArr3 = this.f10605c;
            typeArr3[i] = d.a(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && d.e(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f10605c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f10603a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f10604b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f10605c) ^ this.f10604b.hashCode();
        Type type = this.f10603a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f10605c;
        int length = typeArr.length;
        Type type = this.f10604b;
        if (length == 0) {
            return d.l(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(d.l(type));
        sb.append("<");
        sb.append(d.l(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(d.l(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
