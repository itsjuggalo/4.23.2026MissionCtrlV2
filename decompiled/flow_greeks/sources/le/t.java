package le;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends y implements ve.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor f15646a;

    public t(Constructor member) {
        kotlin.jvm.internal.t.f(member, "member");
        this.f15646a = member;
    }

    @Override // le.y
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Constructor R() {
        return this.f15646a;
    }

    @Override // ve.z
    public List getTypeParameters() {
        TypeVariable[] typeParameters = R().getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new f0(typeVariable));
        }
        return arrayList;
    }

    @Override // ve.k
    public List i() {
        Type[] genericParameterTypes = R().getGenericParameterTypes();
        kotlin.jvm.internal.t.c(genericParameterTypes);
        if (genericParameterTypes.length == 0) {
            return dd.r.k();
        }
        Class declaringClass = R().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) dd.l.m(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = R().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + R());
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            kotlin.jvm.internal.t.c(parameterAnnotations);
            parameterAnnotations = (Annotation[][]) dd.l.m(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        kotlin.jvm.internal.t.c(genericParameterTypes);
        kotlin.jvm.internal.t.c(parameterAnnotations);
        return S(genericParameterTypes, parameterAnnotations, R().isVarArgs());
    }
}
