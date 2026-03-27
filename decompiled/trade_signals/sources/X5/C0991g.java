package X5;

import X5.AbstractC0992h;
import h6.InterfaceC1892a;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: X5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0991g extends u implements InterfaceC1892a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Annotation f9426a;

    public C0991g(Annotation annotation) {
        AbstractC2304t.f(annotation, "annotation");
        this.f9426a = annotation;
    }

    public final Annotation R() {
        return this.f9426a;
    }

    @Override // h6.InterfaceC1892a
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public q x() {
        return new q(A5.a.b(A5.a.a(this.f9426a)));
    }

    @Override // h6.InterfaceC1892a
    public Collection a() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = A5.a.b(A5.a.a(this.f9426a)).getDeclaredMethods();
        AbstractC2304t.e(declaredMethods, "getDeclaredMethods(...)");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            AbstractC0992h.a aVar = AbstractC0992h.f9427b;
            Object objInvoke = method.invoke(this.f9426a, null);
            AbstractC2304t.e(objInvoke, "invoke(...)");
            arrayList.add(aVar.a(objInvoke, q6.f.l(method.getName())));
        }
        return arrayList;
    }

    @Override // h6.InterfaceC1892a
    public q6.b d() {
        return AbstractC0990f.e(A5.a.b(A5.a.a(this.f9426a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0991g) && this.f9426a == ((C0991g) obj).f9426a;
    }

    @Override // h6.InterfaceC1892a
    public boolean f() {
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f9426a);
    }

    @Override // h6.InterfaceC1892a
    public boolean t() {
        return false;
    }

    public String toString() {
        return C0991g.class.getName() + ": " + this.f9426a;
    }
}
