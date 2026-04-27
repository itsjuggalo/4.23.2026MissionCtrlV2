package G4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class A0 implements InterfaceC0527f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f2241b = Logger.getLogger(A0.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f2242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f2243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f2244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RuntimeException f2245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f2246g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2247a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        RuntimeException runtimeException = null;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", null);
                try {
                    Constructor<?>[] constructors = cls.getConstructors();
                    int length = constructors.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            constructor = null;
                            break;
                        }
                        constructor = constructors[i8];
                        if (constructor.getParameterTypes().length == 0) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                    th = null;
                } catch (Throwable th) {
                    th = th;
                    f2241b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                    constructor = null;
                }
            } catch (Throwable th2) {
                th = th2;
                method2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            method = null;
            method2 = null;
        }
        if (th != null || constructor == null) {
            f2242c = null;
            f2243d = null;
            f2244e = null;
            runtimeException = new RuntimeException(th);
        } else {
            f2242c = constructor;
            f2243d = method;
            f2244e = method2;
        }
        f2245f = runtimeException;
        f2246g = new Object[]{1L};
    }

    public A0() {
        RuntimeException runtimeException = f2245f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f2247a = f2242c.newInstance(null);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException(e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static boolean b() {
        return f2245f == null;
    }

    @Override // G4.InterfaceC0527f0
    public void a(long j8) {
        try {
            f2243d.invoke(this.f2247a, j8 == 1 ? f2246g : new Object[]{Long.valueOf(j8)});
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException(e9);
        }
    }
}
