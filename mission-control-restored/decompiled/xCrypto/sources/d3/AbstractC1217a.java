package d3;

import X2.AbstractC0765l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.r;
import m3.AbstractC1608c;
import m3.C1607b;

/* JADX INFO: renamed from: d3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1217a {

    /* JADX INFO: renamed from: d3.a$a, reason: collision with other inner class name */
    public static final class C0184a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0184a f11428a = new C0184a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f11429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f11430c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            r.c(methods);
            int length = methods.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                method = null;
                if (i5 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i5];
                if (r.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    r.e(parameterTypes, "getParameterTypes(...)");
                    if (r.b(AbstractC0765l.b0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i5++;
            }
            f11429b = method2;
            int length2 = methods.length;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                Method method3 = methods[i4];
                if (r.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i4++;
            }
            f11430c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        r.f(cause, "cause");
        r.f(exception, "exception");
        Method method = C0184a.f11429b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public AbstractC1608c b() {
        return new C1607b();
    }
}
