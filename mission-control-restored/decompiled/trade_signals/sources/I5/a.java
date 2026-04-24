package I5;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements GenericArrayType, Type {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f4290a;

    public a(Type elementType) {
        AbstractC2304t.f(elementType, "elementType");
        this.f4290a = elementType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && AbstractC2304t.b(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f4290a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return x.h(this.f4290a) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
