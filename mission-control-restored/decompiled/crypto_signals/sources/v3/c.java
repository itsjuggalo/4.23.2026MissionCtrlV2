package v3;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c implements WildcardType, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f10606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f10607b;

    public c(Type[] typeArr, Type[] typeArr2) {
        d.b(typeArr2.length <= 1);
        d.b(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            d.c(typeArr[0]);
            this.f10607b = null;
            this.f10606a = d.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        d.c(typeArr2[0]);
        d.b(typeArr[0] == Object.class);
        this.f10607b = d.a(typeArr2[0]);
        this.f10606a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && d.e(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f10607b;
        return type != null ? new Type[]{type} : d.f10608a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f10606a};
    }

    public final int hashCode() {
        Type type = this.f10607b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f10606a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f10607b;
        if (type != null) {
            return "? super " + d.l(type);
        }
        Type type2 = this.f10606a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + d.l(type2);
    }
}
