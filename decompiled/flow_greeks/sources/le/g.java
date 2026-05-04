package le;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import le.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends u implements ve.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Annotation f15618a;

    public g(Annotation annotation) {
        kotlin.jvm.internal.t.f(annotation, "annotation");
        this.f15618a = annotation;
    }

    public final Annotation Q() {
        return this.f15618a;
    }

    @Override // ve.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public q y() {
        return new q(od.a.b(od.a.a(this.f15618a)));
    }

    @Override // ve.a
    public boolean d() {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f15618a == ((g) obj).f15618a;
    }

    @Override // ve.a
    public Collection f() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = od.a.b(od.a.a(this.f15618a)).getDeclaredMethods();
        kotlin.jvm.internal.t.e(declaredMethods, "getDeclaredMethods(...)");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            h.a aVar = h.f15623b;
            Object objInvoke = method.invoke(this.f15618a, null);
            kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
            arrayList.add(aVar.a(objInvoke, ef.f.k(method.getName())));
        }
        return arrayList;
    }

    @Override // ve.a
    public ef.b g() {
        return f.e(od.a.b(od.a.a(this.f15618a)));
    }

    public int hashCode() {
        return System.identityHashCode(this.f15618a);
    }

    public String toString() {
        return g.class.getName() + ": " + this.f15618a;
    }

    @Override // ve.a
    public boolean u() {
        return false;
    }
}
