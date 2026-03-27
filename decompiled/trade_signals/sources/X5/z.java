package X5;

import X5.E;
import h6.InterfaceC1893b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends y implements h6.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f9451a;

    public z(Method member) {
        AbstractC2304t.f(member, "member");
        this.f9451a = member;
    }

    @Override // h6.r
    public boolean L() {
        return p() != null;
    }

    @Override // X5.y
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Method S() {
        return this.f9451a;
    }

    @Override // h6.r
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public E getReturnType() {
        E.a aVar = E.f9397a;
        Type genericReturnType = S().getGenericReturnType();
        AbstractC2304t.e(genericReturnType, "getGenericReturnType(...)");
        return aVar.a(genericReturnType);
    }

    @Override // h6.z
    public List getTypeParameters() {
        TypeVariable<Method>[] typeParameters = S().getTypeParameters();
        AbstractC2304t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new F(typeVariable));
        }
        return arrayList;
    }

    @Override // h6.r
    public List k() {
        Type[] genericParameterTypes = S().getGenericParameterTypes();
        AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
        Annotation[][] parameterAnnotations = S().getParameterAnnotations();
        AbstractC2304t.e(parameterAnnotations, "getParameterAnnotations(...)");
        return T(genericParameterTypes, parameterAnnotations, S().isVarArgs());
    }

    @Override // h6.r
    public InterfaceC1893b p() {
        Object defaultValue = S().getDefaultValue();
        if (defaultValue != null) {
            return AbstractC0992h.f9427b.a(defaultValue, null);
        }
        return null;
    }
}
