package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f16429a = D();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f16430b = AbstractC1465d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f16431c = o(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f16432d = o(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f16433e = B();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f16434f = T();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f16435g = S();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f16436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f16437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f16438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f16439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f16440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f16441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f16442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f16443o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f16444p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f16445q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f16446r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f16447s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f16448t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f16449u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f16450v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f16451w;

    public class a implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.j0.e
        public boolean c(Object obj, long j8) {
            return j0.f16451w ? j0.s(obj, j8) : j0.t(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public byte d(Object obj, long j8) {
            return j0.f16451w ? j0.v(obj, j8) : j0.w(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public double e(Object obj, long j8) {
            return Double.longBitsToDouble(h(obj, j8));
        }

        @Override // com.google.protobuf.j0.e
        public float f(Object obj, long j8) {
            return Float.intBitsToFloat(g(obj, j8));
        }

        @Override // com.google.protobuf.j0.e
        public void k(Object obj, long j8, boolean z7) {
            if (j0.f16451w) {
                j0.I(obj, j8, z7);
            } else {
                j0.J(obj, j8, z7);
            }
        }

        @Override // com.google.protobuf.j0.e
        public void l(Object obj, long j8, byte b8) {
            if (j0.f16451w) {
                j0.L(obj, j8, b8);
            } else {
                j0.M(obj, j8, b8);
            }
        }

        @Override // com.google.protobuf.j0.e
        public void m(Object obj, long j8, double d8) {
            p(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // com.google.protobuf.j0.e
        public void n(Object obj, long j8, float f8) {
            o(obj, j8, Float.floatToIntBits(f8));
        }

        @Override // com.google.protobuf.j0.e
        public boolean s() {
            return false;
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.j0.e
        public boolean c(Object obj, long j8) {
            return j0.f16451w ? j0.s(obj, j8) : j0.t(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public byte d(Object obj, long j8) {
            return j0.f16451w ? j0.v(obj, j8) : j0.w(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public double e(Object obj, long j8) {
            return Double.longBitsToDouble(h(obj, j8));
        }

        @Override // com.google.protobuf.j0.e
        public float f(Object obj, long j8) {
            return Float.intBitsToFloat(g(obj, j8));
        }

        @Override // com.google.protobuf.j0.e
        public void k(Object obj, long j8, boolean z7) {
            if (j0.f16451w) {
                j0.I(obj, j8, z7);
            } else {
                j0.J(obj, j8, z7);
            }
        }

        @Override // com.google.protobuf.j0.e
        public void l(Object obj, long j8, byte b8) {
            if (j0.f16451w) {
                j0.L(obj, j8, b8);
            } else {
                j0.M(obj, j8, b8);
            }
        }

        @Override // com.google.protobuf.j0.e
        public void m(Object obj, long j8, double d8) {
            p(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // com.google.protobuf.j0.e
        public void n(Object obj, long j8, float f8) {
            o(obj, j8, Float.floatToIntBits(f8));
        }

        @Override // com.google.protobuf.j0.e
        public boolean s() {
            return false;
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.j0.e
        public boolean c(Object obj, long j8) {
            return this.f16452a.getBoolean(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public byte d(Object obj, long j8) {
            return this.f16452a.getByte(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public double e(Object obj, long j8) {
            return this.f16452a.getDouble(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public float f(Object obj, long j8) {
            return this.f16452a.getFloat(obj, j8);
        }

        @Override // com.google.protobuf.j0.e
        public void k(Object obj, long j8, boolean z7) {
            this.f16452a.putBoolean(obj, j8, z7);
        }

        @Override // com.google.protobuf.j0.e
        public void l(Object obj, long j8, byte b8) {
            this.f16452a.putByte(obj, j8, b8);
        }

        @Override // com.google.protobuf.j0.e
        public void m(Object obj, long j8, double d8) {
            this.f16452a.putDouble(obj, j8, d8);
        }

        @Override // com.google.protobuf.j0.e
        public void n(Object obj, long j8, float f8) {
            this.f16452a.putFloat(obj, j8, f8);
        }

        @Override // com.google.protobuf.j0.e
        public boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.f16452a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                j0.G(th);
                return false;
            }
        }

        @Override // com.google.protobuf.j0.e
        public boolean s() {
            if (!super.s()) {
                return false;
            }
            try {
                Class<?> cls = this.f16452a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                j0.G(th);
                return false;
            }
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f16452a;

        public e(Unsafe unsafe) {
            this.f16452a = unsafe;
        }

        public final int a(Class cls) {
            return this.f16452a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f16452a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j8);

        public abstract byte d(Object obj, long j8);

        public abstract double e(Object obj, long j8);

        public abstract float f(Object obj, long j8);

        public final int g(Object obj, long j8) {
            return this.f16452a.getInt(obj, j8);
        }

        public final long h(Object obj, long j8) {
            return this.f16452a.getLong(obj, j8);
        }

        public final Object i(Object obj, long j8) {
            return this.f16452a.getObject(obj, j8);
        }

        public final long j(Field field) {
            return this.f16452a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j8, boolean z7);

        public abstract void l(Object obj, long j8, byte b8);

        public abstract void m(Object obj, long j8, double d8);

        public abstract void n(Object obj, long j8, float f8);

        public final void o(Object obj, long j8, int i8) {
            this.f16452a.putInt(obj, j8, i8);
        }

        public final void p(Object obj, long j8, long j9) {
            this.f16452a.putLong(obj, j8, j9);
        }

        public final void q(Object obj, long j8, Object obj2) {
            this.f16452a.putObject(obj, j8, obj2);
        }

        public boolean r() {
            Unsafe unsafe = this.f16452a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                j0.G(th);
                return false;
            }
        }

        public boolean s() {
            Unsafe unsafe = this.f16452a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return j0.n() != null;
            } catch (Throwable th) {
                j0.G(th);
                return false;
            }
        }
    }

    static {
        long jL = l(byte[].class);
        f16436h = jL;
        f16437i = l(boolean[].class);
        f16438j = m(boolean[].class);
        f16439k = l(int[].class);
        f16440l = m(int[].class);
        f16441m = l(long[].class);
        f16442n = m(long[].class);
        f16443o = l(float[].class);
        f16444p = m(float[].class);
        f16445q = l(double[].class);
        f16446r = m(double[].class);
        f16447s = l(Object[].class);
        f16448t = m(Object[].class);
        f16449u = q(n());
        f16450v = (int) (jL & 7);
        f16451w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static long A(Object obj, long j8) {
        return f16433e.h(obj, j8);
    }

    public static e B() {
        Unsafe unsafe = f16429a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC1465d.c()) {
            return new d(unsafe);
        }
        if (f16431c) {
            return new c(unsafe);
        }
        if (f16432d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object C(Object obj, long j8) {
        return f16433e.i(obj, j8);
    }

    public static Unsafe D() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean E() {
        return f16435g;
    }

    public static boolean F() {
        return f16434f;
    }

    public static void G(Throwable th) {
        Logger.getLogger(j0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void H(Object obj, long j8, boolean z7) {
        f16433e.k(obj, j8, z7);
    }

    public static void I(Object obj, long j8, boolean z7) {
        L(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    public static void J(Object obj, long j8, boolean z7) {
        M(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    public static void K(byte[] bArr, long j8, byte b8) {
        f16433e.l(bArr, f16436h + j8, b8);
    }

    public static void L(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int iZ = z(obj, j9);
        int i8 = ((~((int) j8)) & 3) << 3;
        P(obj, j9, ((255 & b8) << i8) | (iZ & (~(255 << i8))));
    }

    public static void M(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int i8 = (((int) j8) & 3) << 3;
        P(obj, j9, ((255 & b8) << i8) | (z(obj, j9) & (~(255 << i8))));
    }

    public static void N(Object obj, long j8, double d8) {
        f16433e.m(obj, j8, d8);
    }

    public static void O(Object obj, long j8, float f8) {
        f16433e.n(obj, j8, f8);
    }

    public static void P(Object obj, long j8, int i8) {
        f16433e.o(obj, j8, i8);
    }

    public static void Q(Object obj, long j8, long j9) {
        f16433e.p(obj, j8, j9);
    }

    public static void R(Object obj, long j8, Object obj2) {
        f16433e.q(obj, j8, obj2);
    }

    public static boolean S() {
        e eVar = f16433e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public static boolean T() {
        e eVar = f16433e;
        if (eVar == null) {
            return false;
        }
        return eVar.s();
    }

    public static Object k(Class cls) {
        try {
            return f16429a.allocateInstance(cls);
        } catch (InstantiationException e8) {
            throw new IllegalStateException(e8);
        }
    }

    public static int l(Class cls) {
        if (f16435g) {
            return f16433e.a(cls);
        }
        return -1;
    }

    public static int m(Class cls) {
        if (f16435g) {
            return f16433e.b(cls);
        }
        return -1;
    }

    public static Field n() {
        Field fieldP;
        if (AbstractC1465d.c() && (fieldP = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldP;
        }
        Field fieldP2 = p(Buffer.class, "address");
        if (fieldP2 == null || fieldP2.getType() != Long.TYPE) {
            return null;
        }
        return fieldP2;
    }

    public static boolean o(Class cls) {
        if (!AbstractC1465d.c()) {
            return false;
        }
        try {
            Class cls2 = f16430b;
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

    public static Field p(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long q(Field field) {
        e eVar;
        if (field == null || (eVar = f16433e) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    public static boolean r(Object obj, long j8) {
        return f16433e.c(obj, j8);
    }

    public static boolean s(Object obj, long j8) {
        return v(obj, j8) != 0;
    }

    public static boolean t(Object obj, long j8) {
        return w(obj, j8) != 0;
    }

    public static byte u(byte[] bArr, long j8) {
        return f16433e.d(bArr, f16436h + j8);
    }

    public static byte v(Object obj, long j8) {
        return (byte) ((z(obj, (-4) & j8) >>> ((int) (((~j8) & 3) << 3))) & 255);
    }

    public static byte w(Object obj, long j8) {
        return (byte) ((z(obj, (-4) & j8) >>> ((int) ((j8 & 3) << 3))) & 255);
    }

    public static double x(Object obj, long j8) {
        return f16433e.e(obj, j8);
    }

    public static float y(Object obj, long j8) {
        return f16433e.f(obj, j8);
    }

    public static int z(Object obj, long j8) {
        return f16433e.g(obj, j8);
    }
}
