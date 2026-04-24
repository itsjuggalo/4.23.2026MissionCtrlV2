package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f12885a = H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f12886b = AbstractC1235d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f12887c = q(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f12888d = q(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f12889e = F();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f12890f = X();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f12891g = W();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f12892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f12893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f12894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f12895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f12896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f12897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f12898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f12899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f12900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f12901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f12902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f12903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f12904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f12905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f12906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f12907w;

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

        @Override // com.google.protobuf.z0.e
        public void c(long j7, byte[] bArr, long j8, long j9) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.z0.e
        public boolean d(Object obj, long j7) {
            return z0.f12907w ? z0.u(obj, j7) : z0.v(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public byte e(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.z0.e
        public byte f(Object obj, long j7) {
            return z0.f12907w ? z0.y(obj, j7) : z0.z(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public double g(Object obj, long j7) {
            return Double.longBitsToDouble(k(obj, j7));
        }

        @Override // com.google.protobuf.z0.e
        public float h(Object obj, long j7) {
            return Float.intBitsToFloat(i(obj, j7));
        }

        @Override // com.google.protobuf.z0.e
        public long j(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.z0.e
        public void n(Object obj, long j7, boolean z7) {
            if (z0.f12907w) {
                z0.M(obj, j7, z7);
            } else {
                z0.N(obj, j7, z7);
            }
        }

        @Override // com.google.protobuf.z0.e
        public void o(Object obj, long j7, byte b7) {
            if (z0.f12907w) {
                z0.P(obj, j7, b7);
            } else {
                z0.Q(obj, j7, b7);
            }
        }

        @Override // com.google.protobuf.z0.e
        public void p(Object obj, long j7, double d7) {
            s(obj, j7, Double.doubleToLongBits(d7));
        }

        @Override // com.google.protobuf.z0.e
        public void q(Object obj, long j7, float f7) {
            r(obj, j7, Float.floatToIntBits(f7));
        }

        @Override // com.google.protobuf.z0.e
        public boolean v() {
            return false;
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.z0.e
        public void c(long j7, byte[] bArr, long j8, long j9) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.z0.e
        public boolean d(Object obj, long j7) {
            return z0.f12907w ? z0.u(obj, j7) : z0.v(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public byte e(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.z0.e
        public byte f(Object obj, long j7) {
            return z0.f12907w ? z0.y(obj, j7) : z0.z(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public double g(Object obj, long j7) {
            return Double.longBitsToDouble(k(obj, j7));
        }

        @Override // com.google.protobuf.z0.e
        public float h(Object obj, long j7) {
            return Float.intBitsToFloat(i(obj, j7));
        }

        @Override // com.google.protobuf.z0.e
        public long j(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.z0.e
        public void n(Object obj, long j7, boolean z7) {
            if (z0.f12907w) {
                z0.M(obj, j7, z7);
            } else {
                z0.N(obj, j7, z7);
            }
        }

        @Override // com.google.protobuf.z0.e
        public void o(Object obj, long j7, byte b7) {
            if (z0.f12907w) {
                z0.P(obj, j7, b7);
            } else {
                z0.Q(obj, j7, b7);
            }
        }

        @Override // com.google.protobuf.z0.e
        public void p(Object obj, long j7, double d7) {
            s(obj, j7, Double.doubleToLongBits(d7));
        }

        @Override // com.google.protobuf.z0.e
        public void q(Object obj, long j7, float f7) {
            r(obj, j7, Float.floatToIntBits(f7));
        }

        @Override // com.google.protobuf.z0.e
        public boolean v() {
            return false;
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.z0.e
        public void c(long j7, byte[] bArr, long j8, long j9) {
            this.f12908a.copyMemory((Object) null, j7, bArr, z0.f12892h + j8, j9);
        }

        @Override // com.google.protobuf.z0.e
        public boolean d(Object obj, long j7) {
            return this.f12908a.getBoolean(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public byte e(long j7) {
            return this.f12908a.getByte(j7);
        }

        @Override // com.google.protobuf.z0.e
        public byte f(Object obj, long j7) {
            return this.f12908a.getByte(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public double g(Object obj, long j7) {
            return this.f12908a.getDouble(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public float h(Object obj, long j7) {
            return this.f12908a.getFloat(obj, j7);
        }

        @Override // com.google.protobuf.z0.e
        public long j(long j7) {
            return this.f12908a.getLong(j7);
        }

        @Override // com.google.protobuf.z0.e
        public void n(Object obj, long j7, boolean z7) {
            this.f12908a.putBoolean(obj, j7, z7);
        }

        @Override // com.google.protobuf.z0.e
        public void o(Object obj, long j7, byte b7) {
            this.f12908a.putByte(obj, j7, b7);
        }

        @Override // com.google.protobuf.z0.e
        public void p(Object obj, long j7, double d7) {
            this.f12908a.putDouble(obj, j7, d7);
        }

        @Override // com.google.protobuf.z0.e
        public void q(Object obj, long j7, float f7) {
            this.f12908a.putFloat(obj, j7, f7);
        }

        @Override // com.google.protobuf.z0.e
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f12908a.getClass();
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
                z0.K(th);
                return false;
            }
        }

        @Override // com.google.protobuf.z0.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f12908a.getClass();
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
                z0.K(th);
                return false;
            }
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f12908a;

        public e(Unsafe unsafe) {
            this.f12908a = unsafe;
        }

        public final int a(Class cls) {
            return this.f12908a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f12908a.arrayIndexScale(cls);
        }

        public abstract void c(long j7, byte[] bArr, long j8, long j9);

        public abstract boolean d(Object obj, long j7);

        public abstract byte e(long j7);

        public abstract byte f(Object obj, long j7);

        public abstract double g(Object obj, long j7);

        public abstract float h(Object obj, long j7);

        public final int i(Object obj, long j7) {
            return this.f12908a.getInt(obj, j7);
        }

        public abstract long j(long j7);

        public final long k(Object obj, long j7) {
            return this.f12908a.getLong(obj, j7);
        }

        public final Object l(Object obj, long j7) {
            return this.f12908a.getObject(obj, j7);
        }

        public final long m(Field field) {
            return this.f12908a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j7, boolean z7);

        public abstract void o(Object obj, long j7, byte b7);

        public abstract void p(Object obj, long j7, double d7);

        public abstract void q(Object obj, long j7, float f7);

        public final void r(Object obj, long j7, int i7) {
            this.f12908a.putInt(obj, j7, i7);
        }

        public final void s(Object obj, long j7, long j8) {
            this.f12908a.putLong(obj, j7, j8);
        }

        public final void t(Object obj, long j7, Object obj2) {
            this.f12908a.putObject(obj, j7, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f12908a;
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
                z0.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f12908a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return z0.o() != null;
            } catch (Throwable th) {
                z0.K(th);
                return false;
            }
        }
    }

    static {
        long jM = m(byte[].class);
        f12892h = jM;
        f12893i = m(boolean[].class);
        f12894j = n(boolean[].class);
        f12895k = m(int[].class);
        f12896l = n(int[].class);
        f12897m = m(long[].class);
        f12898n = n(long[].class);
        f12899o = m(float[].class);
        f12900p = n(float[].class);
        f12901q = m(double[].class);
        f12902r = n(double[].class);
        f12903s = m(Object[].class);
        f12904t = n(Object[].class);
        f12905u = s(o());
        f12906v = (int) (jM & 7);
        f12907w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static double A(Object obj, long j7) {
        return f12889e.g(obj, j7);
    }

    public static float B(Object obj, long j7) {
        return f12889e.h(obj, j7);
    }

    public static int C(Object obj, long j7) {
        return f12889e.i(obj, j7);
    }

    public static long D(long j7) {
        return f12889e.j(j7);
    }

    public static long E(Object obj, long j7) {
        return f12889e.k(obj, j7);
    }

    public static e F() {
        Unsafe unsafe = f12885a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC1235d.c()) {
            return new d(unsafe);
        }
        if (f12887c) {
            return new c(unsafe);
        }
        if (f12888d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object G(Object obj, long j7) {
        return f12889e.l(obj, j7);
    }

    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean I() {
        return f12891g;
    }

    public static boolean J() {
        return f12890f;
    }

    public static void K(Throwable th) {
        Logger.getLogger(z0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void L(Object obj, long j7, boolean z7) {
        f12889e.n(obj, j7, z7);
    }

    public static void M(Object obj, long j7, boolean z7) {
        P(obj, j7, z7 ? (byte) 1 : (byte) 0);
    }

    public static void N(Object obj, long j7, boolean z7) {
        Q(obj, j7, z7 ? (byte) 1 : (byte) 0);
    }

    public static void O(byte[] bArr, long j7, byte b7) {
        f12889e.o(bArr, f12892h + j7, b7);
    }

    public static void P(Object obj, long j7, byte b7) {
        long j8 = (-4) & j7;
        int iC = C(obj, j8);
        int i7 = ((~((int) j7)) & 3) << 3;
        T(obj, j8, ((255 & b7) << i7) | (iC & (~(255 << i7))));
    }

    public static void Q(Object obj, long j7, byte b7) {
        long j8 = (-4) & j7;
        int i7 = (((int) j7) & 3) << 3;
        T(obj, j8, ((255 & b7) << i7) | (C(obj, j8) & (~(255 << i7))));
    }

    public static void R(Object obj, long j7, double d7) {
        f12889e.p(obj, j7, d7);
    }

    public static void S(Object obj, long j7, float f7) {
        f12889e.q(obj, j7, f7);
    }

    public static void T(Object obj, long j7, int i7) {
        f12889e.r(obj, j7, i7);
    }

    public static void U(Object obj, long j7, long j8) {
        f12889e.s(obj, j7, j8);
    }

    public static void V(Object obj, long j7, Object obj2) {
        f12889e.t(obj, j7, obj2);
    }

    public static boolean W() {
        e eVar = f12889e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    public static boolean X() {
        e eVar = f12889e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    public static long k(ByteBuffer byteBuffer) {
        return f12889e.k(byteBuffer, f12905u);
    }

    public static Object l(Class cls) {
        try {
            return f12885a.allocateInstance(cls);
        } catch (InstantiationException e7) {
            throw new IllegalStateException(e7);
        }
    }

    public static int m(Class cls) {
        if (f12891g) {
            return f12889e.a(cls);
        }
        return -1;
    }

    public static int n(Class cls) {
        if (f12891g) {
            return f12889e.b(cls);
        }
        return -1;
    }

    public static Field o() {
        Field fieldR;
        if (AbstractC1235d.c() && (fieldR = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldR;
        }
        Field fieldR2 = r(Buffer.class, "address");
        if (fieldR2 == null || fieldR2.getType() != Long.TYPE) {
            return null;
        }
        return fieldR2;
    }

    public static void p(long j7, byte[] bArr, long j8, long j9) {
        f12889e.c(j7, bArr, j8, j9);
    }

    public static boolean q(Class cls) {
        if (!AbstractC1235d.c()) {
            return false;
        }
        try {
            Class cls2 = f12886b;
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

    public static Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long s(Field field) {
        e eVar;
        if (field == null || (eVar = f12889e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    public static boolean t(Object obj, long j7) {
        return f12889e.d(obj, j7);
    }

    public static boolean u(Object obj, long j7) {
        return y(obj, j7) != 0;
    }

    public static boolean v(Object obj, long j7) {
        return z(obj, j7) != 0;
    }

    public static byte w(long j7) {
        return f12889e.e(j7);
    }

    public static byte x(byte[] bArr, long j7) {
        return f12889e.f(bArr, f12892h + j7);
    }

    public static byte y(Object obj, long j7) {
        return (byte) ((C(obj, (-4) & j7) >>> ((int) (((~j7) & 3) << 3))) & 255);
    }

    public static byte z(Object obj, long j7) {
        return (byte) ((C(obj, (-4) & j7) >>> ((int) ((j7 & 3) << 3))) & 255);
    }
}
