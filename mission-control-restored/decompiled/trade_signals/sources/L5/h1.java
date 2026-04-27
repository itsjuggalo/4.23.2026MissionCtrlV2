package L5;

import X5.AbstractC0990f;
import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h1 {
    public static final CharSequence a(Class cls) {
        AbstractC2304t.c(cls);
        return AbstractC0990f.f(cls);
    }

    public static final String d(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        AbstractC2304t.e(parameterTypes, "getParameterTypes(...)");
        sb.append(AbstractC2592n.U(parameterTypes, "", "(", ")", 0, null, g1.f5174a, 24, null));
        Class<?> returnType = method.getReturnType();
        AbstractC2304t.e(returnType, "getReturnType(...)");
        sb.append(AbstractC0990f.f(returnType));
        return sb.toString();
    }
}
