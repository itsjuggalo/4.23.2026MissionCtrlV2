package le;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends u implements j, ve.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeVariable f15617a;

    public f0(TypeVariable typeVariable) {
        kotlin.jvm.internal.t.f(typeVariable, "typeVariable");
        this.f15617a = typeVariable;
    }

    @Override // ve.y
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public List getUpperBounds() {
        Type[] bounds = this.f15617a.getBounds();
        kotlin.jvm.internal.t.e(bounds, "getBounds(...)");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new s(type));
        }
        s sVar = (s) dd.a0.x0(arrayList);
        return kotlin.jvm.internal.t.b(sVar != null ? sVar.Q() : null, Object.class) ? dd.r.k() : arrayList;
    }

    @Override // ve.d
    public /* bridge */ /* synthetic */ ve.a b(ef.c cVar) {
        return b(cVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f0) && kotlin.jvm.internal.t.b(this.f15617a, ((f0) obj).f15617a);
    }

    @Override // ve.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // ve.t
    public ef.f getName() {
        ef.f fVarK = ef.f.k(this.f15617a.getName());
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        return fVarK;
    }

    public int hashCode() {
        return this.f15617a.hashCode();
    }

    @Override // ve.d
    public boolean n() {
        return false;
    }

    public String toString() {
        return f0.class.getName() + ": " + this.f15617a;
    }

    @Override // le.j
    public AnnotatedElement v() {
        TypeVariable typeVariable = this.f15617a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // le.j, ve.d
    public g b(ef.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.t.f(fqName, "fqName");
        AnnotatedElement annotatedElementV = v();
        if (annotatedElementV == null || (declaredAnnotations = annotatedElementV.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    @Override // le.j, ve.d
    public List getAnnotations() {
        Annotation[] declaredAnnotations;
        List listB;
        AnnotatedElement annotatedElementV = v();
        return (annotatedElementV == null || (declaredAnnotations = annotatedElementV.getDeclaredAnnotations()) == null || (listB = k.b(declaredAnnotations)) == null) ? dd.r.k() : listB;
    }
}
