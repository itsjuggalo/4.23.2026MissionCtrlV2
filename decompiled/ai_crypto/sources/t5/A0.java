package t5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class A0 implements InterfaceC2674f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f23204b = Logger.getLogger(A0.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f23205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f23206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f23207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RuntimeException f23208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f23209g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23210a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", null);
                try {
                    Constructor<?>[] constructors = cls.getConstructors();
                    int length = constructors.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            constructor = null;
                            break;
                        }
                        constructor = constructors[i7];
                        if (constructor.getParameterTypes().length == 0) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                    th = null;
                } catch (Throwable th) {
                    th = th;
                    f23204b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
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
            f23205c = null;
            f23206d = null;
            f23207e = null;
            f23208f = new RuntimeException(th);
        } else {
            f23205c = constructor;
            f23206d = method;
            f23207e = method2;
            f23208f = null;
        }
        f23209g = new Object[]{1L};
    }

    public A0() {
        RuntimeException runtimeException = f23208f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f23210a = f23205c.newInstance(null);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException(e7);
        } catch (InstantiationException e8) {
            throw new RuntimeException(e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException(e9);
        }
    }

    public static boolean b() {
        return f23208f == null;
    }

    @Override // t5.InterfaceC2674f0
    public void a(long j7) {
        try {
            f23206d.invoke(this.f23210a, j7 == 1 ? f23209g : new Object[]{Long.valueOf(j7)});
        } catch (IllegalAccessException e7) {
            throw new RuntimeException(e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }
}
