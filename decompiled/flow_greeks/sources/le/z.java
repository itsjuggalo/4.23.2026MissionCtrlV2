package le;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import le.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends y implements ve.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f15650a;

    public z(Method member) {
        kotlin.jvm.internal.t.f(member, "member");
        this.f15650a = member;
    }

    @Override // ve.r
    public boolean K() {
        return r() != null;
    }

    @Override // le.y
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Method R() {
        return this.f15650a;
    }

    @Override // ve.r
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public e0 getReturnType() {
        e0.a aVar = e0.f15612a;
        Type genericReturnType = R().getGenericReturnType();
        kotlin.jvm.internal.t.e(genericReturnType, "getGenericReturnType(...)");
        return aVar.a(genericReturnType);
    }

    @Override // ve.z
    public List getTypeParameters() {
        TypeVariable<Method>[] typeParameters = R().getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new f0(typeVariable));
        }
        return arrayList;
    }

    @Override // ve.r
    public List i() {
        Type[] genericParameterTypes = R().getGenericParameterTypes();
        kotlin.jvm.internal.t.e(genericParameterTypes, "getGenericParameterTypes(...)");
        Annotation[][] parameterAnnotations = R().getParameterAnnotations();
        kotlin.jvm.internal.t.e(parameterAnnotations, "getParameterAnnotations(...)");
        return S(genericParameterTypes, parameterAnnotations, R().isVarArgs());
    }

    @Override // ve.r
    public ve.b r() {
        Object defaultValue = R().getDefaultValue();
        if (defaultValue != null) {
            return h.f15623b.a(defaultValue, null);
        }
        return null;
    }
}
