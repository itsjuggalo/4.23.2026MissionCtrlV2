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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f7258a = H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f7259b = com.google.protobuf.d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7260c = q(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7261d = q(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f7262e = F();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f7263f = X();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f7264g = W();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f7265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f7266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f7267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f7268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f7269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f7270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f7271n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f7272o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f7273p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f7274q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f7275r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f7276s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f7277t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f7278u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7279v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f7280w;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.y1.e
        public void c(long j10, byte[] bArr, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.y1.e
        public boolean d(Object obj, long j10) {
            return y1.f7280w ? y1.u(obj, j10) : y1.v(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public byte e(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.y1.e
        public byte f(Object obj, long j10) {
            return y1.f7280w ? y1.y(obj, j10) : y1.z(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public double g(Object obj, long j10) {
            return Double.longBitsToDouble(k(obj, j10));
        }

        @Override // com.google.protobuf.y1.e
        public float h(Object obj, long j10) {
            return Float.intBitsToFloat(i(obj, j10));
        }

        @Override // com.google.protobuf.y1.e
        public long j(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.y1.e
        public void n(Object obj, long j10, boolean z10) {
            if (y1.f7280w) {
                y1.M(obj, j10, z10);
            } else {
                y1.N(obj, j10, z10);
            }
        }

        @Override // com.google.protobuf.y1.e
        public void o(Object obj, long j10, byte b10) {
            if (y1.f7280w) {
                y1.P(obj, j10, b10);
            } else {
                y1.Q(obj, j10, b10);
            }
        }

        @Override // com.google.protobuf.y1.e
        public void p(Object obj, long j10, double d10) {
            s(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.protobuf.y1.e
        public void q(Object obj, long j10, float f10) {
            r(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.protobuf.y1.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.y1.e
        public void c(long j10, byte[] bArr, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.y1.e
        public boolean d(Object obj, long j10) {
            return y1.f7280w ? y1.u(obj, j10) : y1.v(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public byte e(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.y1.e
        public byte f(Object obj, long j10) {
            return y1.f7280w ? y1.y(obj, j10) : y1.z(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public double g(Object obj, long j10) {
            return Double.longBitsToDouble(k(obj, j10));
        }

        @Override // com.google.protobuf.y1.e
        public float h(Object obj, long j10) {
            return Float.intBitsToFloat(i(obj, j10));
        }

        @Override // com.google.protobuf.y1.e
        public long j(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.y1.e
        public void n(Object obj, long j10, boolean z10) {
            if (y1.f7280w) {
                y1.M(obj, j10, z10);
            } else {
                y1.N(obj, j10, z10);
            }
        }

        @Override // com.google.protobuf.y1.e
        public void o(Object obj, long j10, byte b10) {
            if (y1.f7280w) {
                y1.P(obj, j10, b10);
            } else {
                y1.Q(obj, j10, b10);
            }
        }

        @Override // com.google.protobuf.y1.e
        public void p(Object obj, long j10, double d10) {
            s(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.protobuf.y1.e
        public void q(Object obj, long j10, float f10) {
            r(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.protobuf.y1.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.y1.e
        public void c(long j10, byte[] bArr, long j11, long j12) {
            this.f7281a.copyMemory((Object) null, j10, bArr, y1.f7265h + j11, j12);
        }

        @Override // com.google.protobuf.y1.e
        public boolean d(Object obj, long j10) {
            return this.f7281a.getBoolean(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public byte e(long j10) {
            return this.f7281a.getByte(j10);
        }

        @Override // com.google.protobuf.y1.e
        public byte f(Object obj, long j10) {
            return this.f7281a.getByte(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public double g(Object obj, long j10) {
            return this.f7281a.getDouble(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public float h(Object obj, long j10) {
            return this.f7281a.getFloat(obj, j10);
        }

        @Override // com.google.protobuf.y1.e
        public long j(long j10) {
            return this.f7281a.getLong(j10);
        }

        @Override // com.google.protobuf.y1.e
        public void n(Object obj, long j10, boolean z10) {
            this.f7281a.putBoolean(obj, j10, z10);
        }

        @Override // com.google.protobuf.y1.e
        public void o(Object obj, long j10, byte b10) {
            this.f7281a.putByte(obj, j10, b10);
        }

        @Override // com.google.protobuf.y1.e
        public void p(Object obj, long j10, double d10) {
            this.f7281a.putDouble(obj, j10, d10);
        }

        @Override // com.google.protobuf.y1.e
        public void q(Object obj, long j10, float f10) {
            this.f7281a.putFloat(obj, j10, f10);
        }

        @Override // com.google.protobuf.y1.e
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f7281a.getClass();
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
                y1.K(th);
                return false;
            }
        }

        @Override // com.google.protobuf.y1.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f7281a.getClass();
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
                y1.K(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f7281a;

        public e(Unsafe unsafe) {
            this.f7281a = unsafe;
        }

        public final int a(Class cls) {
            return this.f7281a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f7281a.arrayIndexScale(cls);
        }

        public abstract void c(long j10, byte[] bArr, long j11, long j12);

        public abstract boolean d(Object obj, long j10);

        public abstract byte e(long j10);

        public abstract byte f(Object obj, long j10);

        public abstract double g(Object obj, long j10);

        public abstract float h(Object obj, long j10);

        public final int i(Object obj, long j10) {
            return this.f7281a.getInt(obj, j10);
        }

        public abstract long j(long j10);

        public final long k(Object obj, long j10) {
            return this.f7281a.getLong(obj, j10);
        }

        public final Object l(Object obj, long j10) {
            return this.f7281a.getObject(obj, j10);
        }

        public final long m(Field field) {
            return this.f7281a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j10, boolean z10);

        public abstract void o(Object obj, long j10, byte b10);

        public abstract void p(Object obj, long j10, double d10);

        public abstract void q(Object obj, long j10, float f10);

        public final void r(Object obj, long j10, int i10) {
            this.f7281a.putInt(obj, j10, i10);
        }

        public final void s(Object obj, long j10, long j11) {
            this.f7281a.putLong(obj, j10, j11);
        }

        public final void t(Object obj, long j10, Object obj2) {
            this.f7281a.putObject(obj, j10, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f7281a;
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
                y1.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f7281a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return y1.o() != null;
            } catch (Throwable th) {
                y1.K(th);
                return false;
            }
        }
    }

    static {
        long jM = m(byte[].class);
        f7265h = jM;
        f7266i = m(boolean[].class);
        f7267j = n(boolean[].class);
        f7268k = m(int[].class);
        f7269l = n(int[].class);
        f7270m = m(long[].class);
        f7271n = n(long[].class);
        f7272o = m(float[].class);
        f7273p = n(float[].class);
        f7274q = m(double[].class);
        f7275r = n(double[].class);
        f7276s = m(Object[].class);
        f7277t = n(Object[].class);
        f7278u = s(o());
        f7279v = (int) (jM & 7);
        f7280w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static double A(Object obj, long j10) {
        return f7262e.g(obj, j10);
    }

    public static float B(Object obj, long j10) {
        return f7262e.h(obj, j10);
    }

    public static int C(Object obj, long j10) {
        return f7262e.i(obj, j10);
    }

    public static long D(long j10) {
        return f7262e.j(j10);
    }

    public static long E(Object obj, long j10) {
        return f7262e.k(obj, j10);
    }

    public static e F() {
        Unsafe unsafe = f7258a;
        if (unsafe == null) {
            return null;
        }
        if (!com.google.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (f7260c) {
            return new c(unsafe);
        }
        if (f7261d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object G(Object obj, long j10) {
        return f7262e.l(obj, j10);
    }

    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean I() {
        return f7264g;
    }

    public static boolean J() {
        return f7263f;
    }

    public static void K(Throwable th) {
        Logger.getLogger(y1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void L(Object obj, long j10, boolean z10) {
        f7262e.n(obj, j10, z10);
    }

    public static void M(Object obj, long j10, boolean z10) {
        P(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void N(Object obj, long j10, boolean z10) {
        Q(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void O(byte[] bArr, long j10, byte b10) {
        f7262e.o(bArr, f7265h + j10, b10);
    }

    public static void P(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iC = C(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        T(obj, j11, ((255 & b10) << i10) | (iC & (~(255 << i10))));
    }

    public static void Q(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        T(obj, j11, ((255 & b10) << i10) | (C(obj, j11) & (~(255 << i10))));
    }

    public static void R(Object obj, long j10, double d10) {
        f7262e.p(obj, j10, d10);
    }

    public static void S(Object obj, long j10, float f10) {
        f7262e.q(obj, j10, f10);
    }

    public static void T(Object obj, long j10, int i10) {
        f7262e.r(obj, j10, i10);
    }

    public static void U(Object obj, long j10, long j11) {
        f7262e.s(obj, j10, j11);
    }

    public static void V(Object obj, long j10, Object obj2) {
        f7262e.t(obj, j10, obj2);
    }

    public static boolean W() {
        e eVar = f7262e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    public static boolean X() {
        e eVar = f7262e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    public static long k(ByteBuffer byteBuffer) {
        return f7262e.k(byteBuffer, f7278u);
    }

    public static Object l(Class cls) {
        try {
            return f7258a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int m(Class cls) {
        if (f7264g) {
            return f7262e.a(cls);
        }
        return -1;
    }

    public static int n(Class cls) {
        if (f7264g) {
            return f7262e.b(cls);
        }
        return -1;
    }

    public static Field o() {
        Field fieldR;
        if (com.google.protobuf.d.c() && (fieldR = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldR;
        }
        Field fieldR2 = r(Buffer.class, "address");
        if (fieldR2 == null || fieldR2.getType() != Long.TYPE) {
            return null;
        }
        return fieldR2;
    }

    public static void p(long j10, byte[] bArr, long j11, long j12) {
        f7262e.c(j10, bArr, j11, j12);
    }

    public static boolean q(Class cls) {
        if (!com.google.protobuf.d.c()) {
            return false;
        }
        try {
            Class cls2 = f7259b;
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
        if (field == null || (eVar = f7262e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    public static boolean t(Object obj, long j10) {
        return f7262e.d(obj, j10);
    }

    public static boolean u(Object obj, long j10) {
        return y(obj, j10) != 0;
    }

    public static boolean v(Object obj, long j10) {
        return z(obj, j10) != 0;
    }

    public static byte w(long j10) {
        return f7262e.e(j10);
    }

    public static byte x(byte[] bArr, long j10) {
        return f7262e.f(bArr, f7265h + j10);
    }

    public static byte y(Object obj, long j10) {
        return (byte) ((C(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255);
    }

    public static byte z(Object obj, long j10) {
        return (byte) ((C(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255);
    }
}
