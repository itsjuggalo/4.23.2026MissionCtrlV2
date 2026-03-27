package X5;

import h6.InterfaceC1892a;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends u implements j, h6.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeVariable f9398a;

    public F(TypeVariable typeVariable) {
        AbstractC2304t.f(typeVariable, "typeVariable");
        this.f9398a = typeVariable;
    }

    @Override // h6.y
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public List getUpperBounds() {
        Type[] bounds = this.f9398a.getBounds();
        AbstractC2304t.e(bounds, "getBounds(...)");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new s(type));
        }
        s sVar = (s) p5.z.w0(arrayList);
        return AbstractC2304t.b(sVar != null ? sVar.R() : null, Object.class) ? AbstractC2595q.i() : arrayList;
    }

    @Override // X5.j, h6.InterfaceC1895d
    public C0991g b(q6.c fqName) {
        Annotation[] declaredAnnotations;
        AbstractC2304t.f(fqName, "fqName");
        AnnotatedElement annotatedElementU = u();
        if (annotatedElementU == null || (declaredAnnotations = annotatedElementU.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    public boolean equals(Object obj) {
        return (obj instanceof F) && AbstractC2304t.b(this.f9398a, ((F) obj).f9398a);
    }

    @Override // h6.InterfaceC1895d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // h6.t
    public q6.f getName() {
        q6.f fVarL = q6.f.l(this.f9398a.getName());
        AbstractC2304t.e(fVarL, "identifier(...)");
        return fVarL;
    }

    public int hashCode() {
        return this.f9398a.hashCode();
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return false;
    }

    public String toString() {
        return F.class.getName() + ": " + this.f9398a;
    }

    @Override // X5.j
    public AnnotatedElement u() {
        TypeVariable typeVariable = this.f9398a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // h6.InterfaceC1895d
    public /* bridge */ /* synthetic */ InterfaceC1892a b(q6.c cVar) {
        return b(cVar);
    }

    @Override // X5.j, h6.InterfaceC1895d
    public List getAnnotations() {
        Annotation[] declaredAnnotations;
        List listB;
        AnnotatedElement annotatedElementU = u();
        return (annotatedElementU == null || (declaredAnnotations = annotatedElementU.getDeclaredAnnotations()) == null || (listB = k.b(declaredAnnotations)) == null) ? AbstractC2595q.i() : listB;
    }
}
