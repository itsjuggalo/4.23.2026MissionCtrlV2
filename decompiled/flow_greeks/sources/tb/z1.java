package tb;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z1 implements e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f21870b = Logger.getLogger(z1.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f21871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f21872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f21873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RuntimeException f21874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f21875g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21876a;

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
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            constructor = null;
                            break;
                        }
                        constructor = constructors[i10];
                        if (constructor.getParameterTypes().length == 0) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    th = null;
                } catch (Throwable th) {
                    th = th;
                    f21870b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
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
            f21871c = null;
            f21872d = null;
            f21873e = null;
            f21874f = new RuntimeException(th);
        } else {
            f21871c = constructor;
            f21872d = method;
            f21873e = method2;
            f21874f = null;
        }
        f21875g = new Object[]{1L};
    }

    public z1() {
        RuntimeException runtimeException = f21874f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f21876a = f21871c.newInstance(null);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static boolean a() {
        return f21874f == null;
    }

    @Override // tb.e1
    public void add(long j10) {
        try {
            f21872d.invoke(this.f21876a, j10 == 1 ? f21875g : new Object[]{Long.valueOf(j10)});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
