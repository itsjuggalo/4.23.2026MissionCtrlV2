package X5;

import X5.E;
import h6.InterfaceC1897f;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends E implements InterfaceC1897f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f9431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E f9432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection f9433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9434e;

    public m(Type reflectType) {
        E.a aVar;
        Type componentType;
        String str;
        AbstractC2304t.f(reflectType, "reflectType");
        this.f9431b = reflectType;
        Type typeR = R();
        if (!(typeR instanceof GenericArrayType)) {
            if (typeR instanceof Class) {
                Class cls = (Class) typeR;
                if (cls.isArray()) {
                    aVar = E.f9397a;
                    componentType = cls.getComponentType();
                    str = "getComponentType(...)";
                }
            }
            throw new IllegalArgumentException("Not an array type (" + R().getClass() + "): " + R());
        }
        aVar = E.f9397a;
        componentType = ((GenericArrayType) typeR).getGenericComponentType();
        str = "getGenericComponentType(...)";
        AbstractC2304t.e(componentType, str);
        this.f9432c = aVar.a(componentType);
        this.f9433d = AbstractC2595q.i();
    }

    @Override // X5.E
    public Type R() {
        return this.f9431b;
    }

    @Override // h6.InterfaceC1897f
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public E l() {
        return this.f9432c;
    }

    @Override // h6.InterfaceC1895d
    public Collection getAnnotations() {
        return this.f9433d;
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return this.f9434e;
    }
}
