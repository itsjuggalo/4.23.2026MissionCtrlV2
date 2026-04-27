package L5;

import F5.AbstractC0552j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: L5.a$a, reason: collision with other inner class name */
    public static final class C0046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0046a f3699a = new C0046a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f3700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f3701c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            r.c(methods);
            int length = methods.length;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                method = null;
                if (i8 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i8];
                if (r.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    r.e(parameterTypes, "getParameterTypes(...)");
                    if (r.b(AbstractC0552j.a0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i8++;
            }
            f3700b = method2;
            int length2 = methods.length;
            while (true) {
                if (i7 >= length2) {
                    break;
                }
                Method method3 = methods[i7];
                if (r.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i7++;
            }
            f3701c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        r.f(cause, "cause");
        r.f(exception, "exception");
        Method method = C0046a.f3700b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public U5.c b() {
        return new U5.b();
    }
}
