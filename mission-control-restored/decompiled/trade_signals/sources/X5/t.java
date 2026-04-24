package X5;

import h6.InterfaceC1902k;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends y implements InterfaceC1902k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor f9447a;

    public t(Constructor member) {
        AbstractC2304t.f(member, "member");
        this.f9447a = member;
    }

    @Override // X5.y
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Constructor S() {
        return this.f9447a;
    }

    @Override // h6.z
    public List getTypeParameters() {
        TypeVariable[] typeParameters = S().getTypeParameters();
        AbstractC2304t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new F(typeVariable));
        }
        return arrayList;
    }

    @Override // h6.InterfaceC1902k
    public List k() {
        Type[] genericParameterTypes = S().getGenericParameterTypes();
        AbstractC2304t.c(genericParameterTypes);
        if (genericParameterTypes.length == 0) {
            return AbstractC2595q.i();
        }
        Class declaringClass = S().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) AbstractC2590l.m(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = S().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + S());
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            AbstractC2304t.c(parameterAnnotations);
            parameterAnnotations = (Annotation[][]) AbstractC2590l.m(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        AbstractC2304t.c(genericParameterTypes);
        AbstractC2304t.c(parameterAnnotations);
        return T(genericParameterTypes, parameterAnnotations, S().isVarArgs());
    }
}
