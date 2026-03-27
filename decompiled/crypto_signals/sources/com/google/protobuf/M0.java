package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f5654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f5655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final L0 f5656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f5657d;
    public static final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f5658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f5659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f5660h;

    static {
        Unsafe unsafeJ = j();
        f5654a = unsafeJ;
        f5655b = AbstractC0454c.f5709a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        L0 k02 = null;
        if (unsafeJ != null) {
            if (!AbstractC0454c.a()) {
                k02 = new K0(unsafeJ);
            } else if (zF) {
                k02 = new J0(unsafeJ, 1);
            } else if (zF2) {
                k02 = new J0(unsafeJ, 0);
            }
        }
        f5656c = k02;
        f5657d = k02 == null ? false : k02.u();
        e = k02 == null ? false : k02.t();
        f5658f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field fieldE = e();
        f5659g = (fieldE == null || k02 == null) ? -1L : k02.l(fieldE);
        f5660h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(M0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f5654a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int c(Class cls) {
        if (e) {
            return f5656c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (e) {
            f5656c.b(cls);
        }
    }

    public static Field e() {
        Field declaredField;
        Field declaredField2;
        if (AbstractC0454c.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean f(Class cls) {
        if (!AbstractC0454c.a()) {
            return false;
        }
        try {
            Class cls2 = f5655b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte g(byte[] bArr, long j4) {
        return f5656c.f(bArr, f5658f + j4);
    }

    public static byte h(Object obj, long j4) {
        return (byte) ((f5656c.i(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255);
    }

    public static byte i(Object obj, long j4) {
        return (byte) ((f5656c.i(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new I0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j4, byte b3) {
        f5656c.n(bArr, f5658f + j4, b3);
    }

    public static void l(Object obj, long j4, byte b3) {
        long j6 = (-4) & j4;
        int i = f5656c.i(obj, j6);
        int i6 = ((~((int) j4)) & 3) << 3;
        n(obj, j6, ((255 & b3) << i6) | (i & (~(255 << i6))));
    }

    public static void m(Object obj, long j4, byte b3) {
        long j6 = (-4) & j4;
        int i = (((int) j4) & 3) << 3;
        n(obj, j6, ((255 & b3) << i) | (f5656c.i(obj, j6) & (~(255 << i))));
    }

    public static void n(Object obj, long j4, int i) {
        f5656c.q(obj, j4, i);
    }

    public static void o(Object obj, long j4, long j6) {
        f5656c.r(obj, j4, j6);
    }

    public static void p(Object obj, long j4, Object obj2) {
        f5656c.s(obj, j4, obj2);
    }
}
