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
public abstract class A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f10853a = H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f10854b = AbstractC1056d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f10855c = q(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f10856d = q(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f10857e = F();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f10858f = X();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f10859g = W();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f10860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f10861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f10862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f10863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f10864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f10865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f10866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f10867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f10868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f10869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f10870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f10871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f10872t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f10873u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f10874v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f10875w;

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

        @Override // com.google.protobuf.A0.e
        public void c(long j4, byte[] bArr, long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.A0.e
        public boolean d(Object obj, long j4) {
            return A0.f10875w ? A0.u(obj, j4) : A0.v(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public byte e(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.A0.e
        public byte f(Object obj, long j4) {
            return A0.f10875w ? A0.y(obj, j4) : A0.z(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public double g(Object obj, long j4) {
            return Double.longBitsToDouble(k(obj, j4));
        }

        @Override // com.google.protobuf.A0.e
        public float h(Object obj, long j4) {
            return Float.intBitsToFloat(i(obj, j4));
        }

        @Override // com.google.protobuf.A0.e
        public long j(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.A0.e
        public void n(Object obj, long j4, boolean z4) {
            if (A0.f10875w) {
                A0.M(obj, j4, z4);
            } else {
                A0.N(obj, j4, z4);
            }
        }

        @Override // com.google.protobuf.A0.e
        public void o(Object obj, long j4, byte b4) {
            if (A0.f10875w) {
                A0.P(obj, j4, b4);
            } else {
                A0.Q(obj, j4, b4);
            }
        }

        @Override // com.google.protobuf.A0.e
        public void p(Object obj, long j4, double d4) {
            s(obj, j4, Double.doubleToLongBits(d4));
        }

        @Override // com.google.protobuf.A0.e
        public void q(Object obj, long j4, float f4) {
            r(obj, j4, Float.floatToIntBits(f4));
        }

        @Override // com.google.protobuf.A0.e
        public boolean v() {
            return false;
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.A0.e
        public void c(long j4, byte[] bArr, long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.A0.e
        public boolean d(Object obj, long j4) {
            return A0.f10875w ? A0.u(obj, j4) : A0.v(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public byte e(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.A0.e
        public byte f(Object obj, long j4) {
            return A0.f10875w ? A0.y(obj, j4) : A0.z(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public double g(Object obj, long j4) {
            return Double.longBitsToDouble(k(obj, j4));
        }

        @Override // com.google.protobuf.A0.e
        public float h(Object obj, long j4) {
            return Float.intBitsToFloat(i(obj, j4));
        }

        @Override // com.google.protobuf.A0.e
        public long j(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.A0.e
        public void n(Object obj, long j4, boolean z4) {
            if (A0.f10875w) {
                A0.M(obj, j4, z4);
            } else {
                A0.N(obj, j4, z4);
            }
        }

        @Override // com.google.protobuf.A0.e
        public void o(Object obj, long j4, byte b4) {
            if (A0.f10875w) {
                A0.P(obj, j4, b4);
            } else {
                A0.Q(obj, j4, b4);
            }
        }

        @Override // com.google.protobuf.A0.e
        public void p(Object obj, long j4, double d4) {
            s(obj, j4, Double.doubleToLongBits(d4));
        }

        @Override // com.google.protobuf.A0.e
        public void q(Object obj, long j4, float f4) {
            r(obj, j4, Float.floatToIntBits(f4));
        }

        @Override // com.google.protobuf.A0.e
        public boolean v() {
            return false;
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.A0.e
        public void c(long j4, byte[] bArr, long j5, long j6) {
            this.f10876a.copyMemory((Object) null, j4, bArr, A0.f10860h + j5, j6);
        }

        @Override // com.google.protobuf.A0.e
        public boolean d(Object obj, long j4) {
            return this.f10876a.getBoolean(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public byte e(long j4) {
            return this.f10876a.getByte(j4);
        }

        @Override // com.google.protobuf.A0.e
        public byte f(Object obj, long j4) {
            return this.f10876a.getByte(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public double g(Object obj, long j4) {
            return this.f10876a.getDouble(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public float h(Object obj, long j4) {
            return this.f10876a.getFloat(obj, j4);
        }

        @Override // com.google.protobuf.A0.e
        public long j(long j4) {
            return this.f10876a.getLong(j4);
        }

        @Override // com.google.protobuf.A0.e
        public void n(Object obj, long j4, boolean z4) {
            this.f10876a.putBoolean(obj, j4, z4);
        }

        @Override // com.google.protobuf.A0.e
        public void o(Object obj, long j4, byte b4) {
            this.f10876a.putByte(obj, j4, b4);
        }

        @Override // com.google.protobuf.A0.e
        public void p(Object obj, long j4, double d4) {
            this.f10876a.putDouble(obj, j4, d4);
        }

        @Override // com.google.protobuf.A0.e
        public void q(Object obj, long j4, float f4) {
            this.f10876a.putFloat(obj, j4, f4);
        }

        @Override // com.google.protobuf.A0.e
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f10876a.getClass();
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
                A0.K(th);
                return false;
            }
        }

        @Override // com.google.protobuf.A0.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f10876a.getClass();
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
                A0.K(th);
                return false;
            }
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f10876a;

        public e(Unsafe unsafe) {
            this.f10876a = unsafe;
        }

        public final int a(Class cls) {
            return this.f10876a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f10876a.arrayIndexScale(cls);
        }

        public abstract void c(long j4, byte[] bArr, long j5, long j6);

        public abstract boolean d(Object obj, long j4);

        public abstract byte e(long j4);

        public abstract byte f(Object obj, long j4);

        public abstract double g(Object obj, long j4);

        public abstract float h(Object obj, long j4);

        public final int i(Object obj, long j4) {
            return this.f10876a.getInt(obj, j4);
        }

        public abstract long j(long j4);

        public final long k(Object obj, long j4) {
            return this.f10876a.getLong(obj, j4);
        }

        public final Object l(Object obj, long j4) {
            return this.f10876a.getObject(obj, j4);
        }

        public final long m(Field field) {
            return this.f10876a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j4, boolean z4);

        public abstract void o(Object obj, long j4, byte b4);

        public abstract void p(Object obj, long j4, double d4);

        public abstract void q(Object obj, long j4, float f4);

        public final void r(Object obj, long j4, int i4) {
            this.f10876a.putInt(obj, j4, i4);
        }

        public final void s(Object obj, long j4, long j5) {
            this.f10876a.putLong(obj, j4, j5);
        }

        public final void t(Object obj, long j4, Object obj2) {
            this.f10876a.putObject(obj, j4, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f10876a;
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
                A0.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f10876a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return A0.o() != null;
            } catch (Throwable th) {
                A0.K(th);
                return false;
            }
        }
    }

    static {
        long jM = m(byte[].class);
        f10860h = jM;
        f10861i = m(boolean[].class);
        f10862j = n(boolean[].class);
        f10863k = m(int[].class);
        f10864l = n(int[].class);
        f10865m = m(long[].class);
        f10866n = n(long[].class);
        f10867o = m(float[].class);
        f10868p = n(float[].class);
        f10869q = m(double[].class);
        f10870r = n(double[].class);
        f10871s = m(Object[].class);
        f10872t = n(Object[].class);
        f10873u = s(o());
        f10874v = (int) (jM & 7);
        f10875w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static double A(Object obj, long j4) {
        return f10857e.g(obj, j4);
    }

    public static float B(Object obj, long j4) {
        return f10857e.h(obj, j4);
    }

    public static int C(Object obj, long j4) {
        return f10857e.i(obj, j4);
    }

    public static long D(long j4) {
        return f10857e.j(j4);
    }

    public static long E(Object obj, long j4) {
        return f10857e.k(obj, j4);
    }

    public static e F() {
        Unsafe unsafe = f10853a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC1056d.c()) {
            return new d(unsafe);
        }
        if (f10855c) {
            return new c(unsafe);
        }
        if (f10856d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object G(Object obj, long j4) {
        return f10857e.l(obj, j4);
    }

    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean I() {
        return f10859g;
    }

    public static boolean J() {
        return f10858f;
    }

    public static void K(Throwable th) {
        Logger.getLogger(A0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void L(Object obj, long j4, boolean z4) {
        f10857e.n(obj, j4, z4);
    }

    public static void M(Object obj, long j4, boolean z4) {
        P(obj, j4, z4 ? (byte) 1 : (byte) 0);
    }

    public static void N(Object obj, long j4, boolean z4) {
        Q(obj, j4, z4 ? (byte) 1 : (byte) 0);
    }

    public static void O(byte[] bArr, long j4, byte b4) {
        f10857e.o(bArr, f10860h + j4, b4);
    }

    public static void P(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int iC = C(obj, j5);
        int i4 = ((~((int) j4)) & 3) << 3;
        T(obj, j5, ((255 & b4) << i4) | (iC & (~(255 << i4))));
    }

    public static void Q(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        T(obj, j5, ((255 & b4) << i4) | (C(obj, j5) & (~(255 << i4))));
    }

    public static void R(Object obj, long j4, double d4) {
        f10857e.p(obj, j4, d4);
    }

    public static void S(Object obj, long j4, float f4) {
        f10857e.q(obj, j4, f4);
    }

    public static void T(Object obj, long j4, int i4) {
        f10857e.r(obj, j4, i4);
    }

    public static void U(Object obj, long j4, long j5) {
        f10857e.s(obj, j4, j5);
    }

    public static void V(Object obj, long j4, Object obj2) {
        f10857e.t(obj, j4, obj2);
    }

    public static boolean W() {
        e eVar = f10857e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    public static boolean X() {
        e eVar = f10857e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    public static long k(ByteBuffer byteBuffer) {
        return f10857e.k(byteBuffer, f10873u);
    }

    public static Object l(Class cls) {
        try {
            return f10853a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int m(Class cls) {
        if (f10859g) {
            return f10857e.a(cls);
        }
        return -1;
    }

    public static int n(Class cls) {
        if (f10859g) {
            return f10857e.b(cls);
        }
        return -1;
    }

    public static Field o() {
        Field fieldR;
        if (AbstractC1056d.c() && (fieldR = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldR;
        }
        Field fieldR2 = r(Buffer.class, "address");
        if (fieldR2 == null || fieldR2.getType() != Long.TYPE) {
            return null;
        }
        return fieldR2;
    }

    public static void p(long j4, byte[] bArr, long j5, long j6) {
        f10857e.c(j4, bArr, j5, j6);
    }

    public static boolean q(Class cls) {
        if (!AbstractC1056d.c()) {
            return false;
        }
        try {
            Class cls2 = f10854b;
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
        if (field == null || (eVar = f10857e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    public static boolean t(Object obj, long j4) {
        return f10857e.d(obj, j4);
    }

    public static boolean u(Object obj, long j4) {
        return y(obj, j4) != 0;
    }

    public static boolean v(Object obj, long j4) {
        return z(obj, j4) != 0;
    }

    public static byte w(long j4) {
        return f10857e.e(j4);
    }

    public static byte x(byte[] bArr, long j4) {
        return f10857e.f(bArr, f10860h + j4);
    }

    public static byte y(Object obj, long j4) {
        return (byte) ((C(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255);
    }

    public static byte z(Object obj, long j4) {
        return (byte) ((C(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255);
    }
}
