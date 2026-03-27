package M2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class A0 implements InterfaceC0419f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f1649b = Logger.getLogger(A0.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f1650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f1651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f1652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RuntimeException f1653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object[] f1654g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1655a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        int i4;
        try {
            cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                i4 = 0;
                method2 = cls.getMethod("sum", new Class[0]);
            } catch (Throwable th) {
                th = th;
                method2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            method = null;
            method2 = null;
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            while (true) {
                if (i4 >= length) {
                    constructor = null;
                    break;
                }
                constructor = constructors[i4];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                } else {
                    i4++;
                }
            }
            th = null;
        } catch (Throwable th3) {
            th = th3;
            f1649b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            constructor = null;
        }
        if (th != null || constructor == null) {
            f1650c = null;
            f1651d = null;
            f1652e = null;
            f1653f = new RuntimeException(th);
        } else {
            f1650c = constructor;
            f1651d = method;
            f1652e = method2;
            f1653f = null;
        }
        f1654g = new Object[]{1L};
    }

    public A0() {
        RuntimeException runtimeException = f1653f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f1655a = f1650c.newInstance(new Object[0]);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static boolean a() {
        return f1653f == null;
    }

    @Override // M2.InterfaceC0419f0
    public void add(long j4) {
        try {
            f1651d.invoke(this.f1655a, j4 == 1 ? f1654g : new Object[]{Long.valueOf(j4)});
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }
}
