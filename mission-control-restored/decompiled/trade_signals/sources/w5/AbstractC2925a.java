package w5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: w5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2925a {

    /* JADX INFO: renamed from: w5.a$a, reason: collision with other inner class name */
    public static final class C0425a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0425a f24070a = new C0425a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f24071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f24072c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            AbstractC2304t.c(methods);
            int length = methods.length;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                method = null;
                if (i9 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i9];
                if (AbstractC2304t.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    AbstractC2304t.e(parameterTypes, "getParameterTypes(...)");
                    if (AbstractC2304t.b(AbstractC2592n.Z(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i9++;
            }
            f24071b = method2;
            int length2 = methods.length;
            while (true) {
                if (i8 >= length2) {
                    break;
                }
                Method method3 = methods[i8];
                if (AbstractC2304t.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i8++;
            }
            f24072c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(cause, "cause");
        AbstractC2304t.f(exception, "exception");
        Method method = C0425a.f24071b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public F5.c b() {
        return new F5.b();
    }
}
