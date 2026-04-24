package X5;

import R5.w0;
import R5.x0;
import h6.InterfaceC1892a;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y extends u implements j, A, h6.q {
    @Override // X5.A
    public int C() {
        return S().getModifiers();
    }

    @Override // h6.s
    public boolean Q() {
        return Modifier.isStatic(C());
    }

    @Override // h6.q
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public q P() {
        Class<?> declaringClass = S().getDeclaringClass();
        AbstractC2304t.e(declaringClass, "getDeclaringClass(...)");
        return new q(declaringClass);
    }

    public abstract Member S();

    public final List T(Type[] parameterTypes, Annotation[][] parameterAnnotations, boolean z7) throws IllegalAccessException, InvocationTargetException {
        String str;
        AbstractC2304t.f(parameterTypes, "parameterTypes");
        AbstractC2304t.f(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List listB = C0987c.f9416a.b(S());
        int size = listB != null ? listB.size() - parameterTypes.length : 0;
        int length = parameterTypes.length;
        int i8 = 0;
        while (i8 < length) {
            E eA = E.f9397a.a(parameterTypes[i8]);
            if (listB != null) {
                str = (String) p5.z.b0(listB, i8 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i8 + '+' + size + " (name=" + getName() + " type=" + eA + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new G(eA, parameterAnnotations[i8], str, z7 && i8 == AbstractC2592n.G(parameterTypes)));
            i8++;
        }
        return arrayList;
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
        return (obj instanceof y) && AbstractC2304t.b(S(), ((y) obj).S());
    }

    @Override // h6.InterfaceC1895d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // h6.t
    public q6.f getName() {
        q6.f fVarL;
        String name = S().getName();
        return (name == null || (fVarL = q6.f.l(name)) == null) ? q6.h.f22677b : fVarL;
    }

    @Override // h6.s
    public x0 getVisibility() {
        int iC = C();
        return Modifier.isPublic(iC) ? w0.h.f7285c : Modifier.isPrivate(iC) ? w0.e.f7282c : Modifier.isProtected(iC) ? Modifier.isStatic(iC) ? V5.c.f8951c : V5.b.f8950c : V5.a.f8949c;
    }

    public int hashCode() {
        return S().hashCode();
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return false;
    }

    @Override // h6.s
    public boolean isAbstract() {
        return Modifier.isAbstract(C());
    }

    @Override // h6.s
    public boolean isFinal() {
        return Modifier.isFinal(C());
    }

    public String toString() {
        return getClass().getName() + ": " + S();
    }

    @Override // X5.j
    public AnnotatedElement u() {
        Member memberS = S();
        AbstractC2304t.d(memberS, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) memberS;
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
