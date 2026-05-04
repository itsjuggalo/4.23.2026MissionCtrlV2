package zd;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g3 {
    public static final CharSequence a(Class cls) {
        kotlin.jvm.internal.t.c(cls);
        return le.f.f(cls);
    }

    public static final String d(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.t.e(parameterTypes, "getParameterTypes(...)");
        sb2.append(dd.n.i0(parameterTypes, "", "(", ")", 0, null, f3.f25722a, 24, null));
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.t.e(returnType, "getReturnType(...)");
        sb2.append(le.f.f(returnType));
        return sb2.toString();
    }
}
