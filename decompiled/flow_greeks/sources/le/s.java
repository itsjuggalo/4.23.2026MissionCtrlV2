package le;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import le.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends e0 implements ve.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f15644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ve.i f15645c;

    public s(Type reflectType) {
        ve.i qVar;
        kotlin.jvm.internal.t.f(reflectType, "reflectType");
        this.f15644b = reflectType;
        Type typeQ = Q();
        if (typeQ instanceof Class) {
            qVar = new q((Class) typeQ);
        } else if (typeQ instanceof TypeVariable) {
            qVar = new f0((TypeVariable) typeQ);
        } else {
            if (!(typeQ instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + typeQ.getClass() + "): " + typeQ);
            }
            Type rawType = ((ParameterizedType) typeQ).getRawType();
            kotlin.jvm.internal.t.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            qVar = new q((Class) rawType);
        }
        this.f15645c = qVar;
    }

    @Override // ve.j
    public List E() {
        List listH = f.h(Q());
        e0.a aVar = e0.f15612a;
        ArrayList arrayList = new ArrayList(dd.s.u(listH, 10));
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // le.e0
    public Type Q() {
        return this.f15644b;
    }

    @Override // le.e0, ve.d
    public ve.a b(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return null;
    }

    @Override // ve.d
    public Collection getAnnotations() {
        return dd.r.k();
    }

    @Override // ve.j
    public ve.i j() {
        return this.f15645c;
    }

    @Override // ve.d
    public boolean n() {
        return false;
    }

    @Override // ve.j
    public String p() {
        return Q().toString();
    }

    @Override // ve.j
    public boolean w() {
        Type typeQ = Q();
        if (typeQ instanceof Class) {
            TypeVariable[] typeParameters = ((Class) typeQ).getTypeParameters();
            kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // ve.j
    public String x() {
        throw new UnsupportedOperationException("Type not found: " + Q());
    }
}
