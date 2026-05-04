package le;

import fe.v1;
import fe.w1;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends u implements j, a0, ve.q {
    @Override // ve.s
    public boolean P() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // ve.q
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public q O() {
        Class<?> declaringClass = R().getDeclaringClass();
        kotlin.jvm.internal.t.e(declaringClass, "getDeclaringClass(...)");
        return new q(declaringClass);
    }

    public abstract Member R();

    public final List S(Type[] parameterTypes, Annotation[][] parameterAnnotations, boolean z10) throws IllegalAccessException, InvocationTargetException {
        String str;
        kotlin.jvm.internal.t.f(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.t.f(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List listB = c.f15602a.b(R());
        int size = listB != null ? listB.size() - parameterTypes.length : 0;
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            e0 e0VarA = e0.f15612a.a(parameterTypes[i10]);
            if (listB != null) {
                str = (String) dd.a0.c0(listB, i10 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i10 + '+' + size + " (name=" + getName() + " type=" + e0VarA + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new g0(e0VarA, parameterAnnotations[i10], str, z10 && i10 == dd.n.G(parameterTypes)));
            i10++;
        }
        return arrayList;
    }

    @Override // ve.d
    public /* bridge */ /* synthetic */ ve.a b(ef.c cVar) {
        return b(cVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof y) && kotlin.jvm.internal.t.b(R(), ((y) obj).R());
    }

    @Override // ve.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // le.a0
    public int getModifiers() {
        return R().getModifiers();
    }

    @Override // ve.t
    public ef.f getName() {
        ef.f fVarK;
        String name = R().getName();
        return (name == null || (fVarK = ef.f.k(name)) == null) ? ef.h.f8801b : fVarK;
    }

    @Override // ve.s
    public w1 getVisibility() {
        int modifiers = getModifiers();
        return Modifier.isPublic(modifiers) ? v1.h.f9535c : Modifier.isPrivate(modifiers) ? v1.e.f9532c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? je.c.f14313c : je.b.f14312c : je.a.f14311c;
    }

    public int hashCode() {
        return R().hashCode();
    }

    @Override // ve.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // ve.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // ve.d
    public boolean n() {
        return false;
    }

    public String toString() {
        return getClass().getName() + ": " + R();
    }

    @Override // le.j
    public AnnotatedElement v() {
        Member memberR = R();
        kotlin.jvm.internal.t.d(memberR, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) memberR;
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
