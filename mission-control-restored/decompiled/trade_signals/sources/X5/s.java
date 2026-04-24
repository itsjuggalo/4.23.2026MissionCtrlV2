package X5;

import X5.E;
import h6.InterfaceC1892a;
import h6.InterfaceC1900i;
import h6.InterfaceC1901j;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends E implements InterfaceC1901j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f9445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1900i f9446c;

    public s(Type reflectType) {
        InterfaceC1900i qVar;
        AbstractC2304t.f(reflectType, "reflectType");
        this.f9445b = reflectType;
        Type typeR = R();
        if (typeR instanceof Class) {
            qVar = new q((Class) typeR);
        } else if (typeR instanceof TypeVariable) {
            qVar = new F((TypeVariable) typeR);
        } else {
            if (!(typeR instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + typeR.getClass() + "): " + typeR);
            }
            Type rawType = ((ParameterizedType) typeR).getRawType();
            AbstractC2304t.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            qVar = new q((Class) rawType);
        }
        this.f9446c = qVar;
    }

    @Override // h6.InterfaceC1901j
    public List E() {
        List listH = AbstractC0990f.h(R());
        E.a aVar = E.f9397a;
        ArrayList arrayList = new ArrayList(p5.r.s(listH, 10));
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // X5.E
    public Type R() {
        return this.f9445b;
    }

    @Override // X5.E, h6.InterfaceC1895d
    public InterfaceC1892a b(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return null;
    }

    @Override // h6.InterfaceC1901j
    public InterfaceC1900i c() {
        return this.f9446c;
    }

    @Override // h6.InterfaceC1895d
    public Collection getAnnotations() {
        return AbstractC2595q.i();
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return false;
    }

    @Override // h6.InterfaceC1901j
    public String m() {
        return R().toString();
    }

    @Override // h6.InterfaceC1901j
    public boolean v() {
        Type typeR = R();
        if (!(typeR instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) typeR).getTypeParameters();
        AbstractC2304t.e(typeParameters, "getTypeParameters(...)");
        return (typeParameters.length == 0) ^ true;
    }

    @Override // h6.InterfaceC1901j
    public String w() {
        throw new UnsupportedOperationException("Type not found: " + R());
    }
}
