package kd;

import dd.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: kd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0257a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0257a f14821a = new C0257a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f14822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f14823c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            t.c(methods);
            int length = methods.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                method = null;
                if (i11 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i11];
                if (t.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    t.e(parameterTypes, "getParameterTypes(...)");
                    if (t.b(n.o0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i11++;
            }
            f14822b = method2;
            int length2 = methods.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                Method method3 = methods[i10];
                if (t.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i10++;
            }
            f14823c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        t.f(cause, "cause");
        t.f(exception, "exception");
        Method method = C0257a.f14822b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public td.c b() {
        return new td.b();
    }
}
