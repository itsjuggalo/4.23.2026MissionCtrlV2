package w4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: w4.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1383w1 implements B0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f11414b = Logger.getLogger(C1383w1.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f11415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f11416d;
    public static final RuntimeException e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f11417f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11418a;

    static {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
        } catch (Throwable th) {
            th = th;
            method = null;
        }
        try {
            int i = 0;
            cls.getMethod("sum", new Class[0]);
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            while (true) {
                if (i >= length) {
                    constructor = null;
                    break;
                }
                constructor = constructors[i];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                } else {
                    i++;
                }
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
            f11414b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            constructor = null;
        }
        if (th != null || constructor == null) {
            f11415c = null;
            f11416d = null;
            e = new RuntimeException(th);
        } else {
            f11415c = constructor;
            f11416d = method;
            e = null;
        }
        f11417f = new Object[]{1L};
    }

    public C1383w1() {
        RuntimeException runtimeException = e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f11418a = f11415c.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // w4.B0
    public final void a() {
        try {
            f11416d.invoke(this.f11418a, f11417f);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }
}
