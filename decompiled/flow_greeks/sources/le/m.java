package le;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import le.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends e0 implements ve.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f15630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f15631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection f15632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15633e;

    public m(Type reflectType) {
        e0 e0VarA;
        kotlin.jvm.internal.t.f(reflectType, "reflectType");
        this.f15630b = reflectType;
        Type typeQ = Q();
        if (!(typeQ instanceof GenericArrayType)) {
            if (typeQ instanceof Class) {
                Class cls = (Class) typeQ;
                if (cls.isArray()) {
                    e0.a aVar = e0.f15612a;
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.t.e(componentType, "getComponentType(...)");
                    e0VarA = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + Q().getClass() + "): " + Q());
        }
        e0.a aVar2 = e0.f15612a;
        Type genericComponentType = ((GenericArrayType) typeQ).getGenericComponentType();
        kotlin.jvm.internal.t.e(genericComponentType, "getGenericComponentType(...)");
        e0VarA = aVar2.a(genericComponentType);
        this.f15631c = e0VarA;
        this.f15632d = dd.r.k();
    }

    @Override // le.e0
    public Type Q() {
        return this.f15630b;
    }

    @Override // ve.f
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public e0 o() {
        return this.f15631c;
    }

    @Override // ve.d
    public Collection getAnnotations() {
        return this.f15632d;
    }

    @Override // ve.d
    public boolean n() {
        return this.f15633e;
    }
}
