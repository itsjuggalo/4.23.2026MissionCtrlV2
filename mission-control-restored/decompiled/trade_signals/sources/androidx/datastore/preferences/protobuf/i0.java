package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f11268a = A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f11269b = AbstractC1102d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f11270c = m(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f11271d = m(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f11272e = y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f11273f = Q();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f11274g = P();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f11275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f11276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f11277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f11278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f11279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f11280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f11281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f11282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f11283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f11284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f11285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f11286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f11287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f11288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f11289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f11290w;

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

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean c(Object obj, long j8) {
            return i0.f11290w ? i0.q(obj, j8) : i0.r(obj, j8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j8) {
            return Double.longBitsToDouble(g(obj, j8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j8) {
            return Float.intBitsToFloat(f(obj, j8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j8, boolean z7) {
            if (i0.f11290w) {
                i0.F(obj, j8, z7);
            } else {
                i0.G(obj, j8, z7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j8, byte b8) {
            if (i0.f11290w) {
                i0.I(obj, j8, b8);
            } else {
                i0.J(obj, j8, b8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j8, double d8) {
            o(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j8, float f8) {
            n(obj, j8, Float.floatToIntBits(f8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean r() {
            return false;
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean c(Object obj, long j8) {
            return i0.f11290w ? i0.q(obj, j8) : i0.r(obj, j8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j8) {
            return Double.longBitsToDouble(g(obj, j8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j8) {
            return Float.intBitsToFloat(f(obj, j8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j8, boolean z7) {
            if (i0.f11290w) {
                i0.F(obj, j8, z7);
            } else {
                i0.G(obj, j8, z7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j8, byte b8) {
            if (i0.f11290w) {
                i0.I(obj, j8, b8);
            } else {
                i0.J(obj, j8, b8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j8, double d8) {
            o(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j8, float f8) {
            n(obj, j8, Float.floatToIntBits(f8));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean r() {
            return false;
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean c(Object obj, long j8) {
            return this.f11291a.getBoolean(obj, j8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j8) {
            return this.f11291a.getDouble(obj, j8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j8) {
            return this.f11291a.getFloat(obj, j8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j8, boolean z7) {
            this.f11291a.putBoolean(obj, j8, z7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j8, byte b8) {
            this.f11291a.putByte(obj, j8, b8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j8, double d8) {
            this.f11291a.putDouble(obj, j8, d8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j8, float f8) {
            this.f11291a.putFloat(obj, j8, f8);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean q() {
            if (!super.q()) {
                return false;
            }
            try {
                Class<?> cls = this.f11291a.getClass();
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
                i0.D(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.f11291a.getClass();
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
                i0.D(th);
                return false;
            }
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f11291a;

        public e(Unsafe unsafe) {
            this.f11291a = unsafe;
        }

        public final int a(Class cls) {
            return this.f11291a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f11291a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j8);

        public abstract double d(Object obj, long j8);

        public abstract float e(Object obj, long j8);

        public final int f(Object obj, long j8) {
            return this.f11291a.getInt(obj, j8);
        }

        public final long g(Object obj, long j8) {
            return this.f11291a.getLong(obj, j8);
        }

        public final Object h(Object obj, long j8) {
            return this.f11291a.getObject(obj, j8);
        }

        public final long i(Field field) {
            return this.f11291a.objectFieldOffset(field);
        }

        public abstract void j(Object obj, long j8, boolean z7);

        public abstract void k(Object obj, long j8, byte b8);

        public abstract void l(Object obj, long j8, double d8);

        public abstract void m(Object obj, long j8, float f8);

        public final void n(Object obj, long j8, int i8) {
            this.f11291a.putInt(obj, j8, i8);
        }

        public final void o(Object obj, long j8, long j9) {
            this.f11291a.putLong(obj, j8, j9);
        }

        public final void p(Object obj, long j8, Object obj2) {
            this.f11291a.putObject(obj, j8, obj2);
        }

        public boolean q() {
            Unsafe unsafe = this.f11291a;
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
                i0.D(th);
                return false;
            }
        }

        public boolean r() {
            Unsafe unsafe = this.f11291a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return i0.l() != null;
            } catch (Throwable th) {
                i0.D(th);
                return false;
            }
        }
    }

    static {
        long j8 = j(byte[].class);
        f11275h = j8;
        f11276i = j(boolean[].class);
        f11277j = k(boolean[].class);
        f11278k = j(int[].class);
        f11279l = k(int[].class);
        f11280m = j(long[].class);
        f11281n = k(long[].class);
        f11282o = j(float[].class);
        f11283p = k(float[].class);
        f11284q = j(double[].class);
        f11285r = k(double[].class);
        f11286s = j(Object[].class);
        f11287t = k(Object[].class);
        f11288u = o(l());
        f11289v = (int) (j8 & 7);
        f11290w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Unsafe A() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean B() {
        return f11274g;
    }

    public static boolean C() {
        return f11273f;
    }

    public static void D(Throwable th) {
        Logger.getLogger(i0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void E(Object obj, long j8, boolean z7) {
        f11272e.j(obj, j8, z7);
    }

    public static void F(Object obj, long j8, boolean z7) {
        I(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    public static void G(Object obj, long j8, boolean z7) {
        J(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    public static void H(byte[] bArr, long j8, byte b8) {
        f11272e.k(bArr, f11275h + j8, b8);
    }

    public static void I(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int iW = w(obj, j9);
        int i8 = ((~((int) j8)) & 3) << 3;
        M(obj, j9, ((255 & b8) << i8) | (iW & (~(255 << i8))));
    }

    public static void J(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int i8 = (((int) j8) & 3) << 3;
        M(obj, j9, ((255 & b8) << i8) | (w(obj, j9) & (~(255 << i8))));
    }

    public static void K(Object obj, long j8, double d8) {
        f11272e.l(obj, j8, d8);
    }

    public static void L(Object obj, long j8, float f8) {
        f11272e.m(obj, j8, f8);
    }

    public static void M(Object obj, long j8, int i8) {
        f11272e.n(obj, j8, i8);
    }

    public static void N(Object obj, long j8, long j9) {
        f11272e.o(obj, j8, j9);
    }

    public static void O(Object obj, long j8, Object obj2) {
        f11272e.p(obj, j8, obj2);
    }

    public static boolean P() {
        e eVar = f11272e;
        if (eVar == null) {
            return false;
        }
        return eVar.q();
    }

    public static boolean Q() {
        e eVar = f11272e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public static Object i(Class cls) {
        try {
            return f11268a.allocateInstance(cls);
        } catch (InstantiationException e8) {
            throw new IllegalStateException(e8);
        }
    }

    public static int j(Class cls) {
        if (f11274g) {
            return f11272e.a(cls);
        }
        return -1;
    }

    public static int k(Class cls) {
        if (f11274g) {
            return f11272e.b(cls);
        }
        return -1;
    }

    public static Field l() {
        Field fieldN;
        if (AbstractC1102d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, "address");
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    public static boolean m(Class cls) {
        if (!AbstractC1102d.c()) {
            return false;
        }
        try {
            Class cls2 = f11269b;
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

    public static Field n(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long o(Field field) {
        e eVar;
        if (field == null || (eVar = f11272e) == null) {
            return -1L;
        }
        return eVar.i(field);
    }

    public static boolean p(Object obj, long j8) {
        return f11272e.c(obj, j8);
    }

    public static boolean q(Object obj, long j8) {
        return s(obj, j8) != 0;
    }

    public static boolean r(Object obj, long j8) {
        return t(obj, j8) != 0;
    }

    public static byte s(Object obj, long j8) {
        return (byte) ((w(obj, (-4) & j8) >>> ((int) (((~j8) & 3) << 3))) & 255);
    }

    public static byte t(Object obj, long j8) {
        return (byte) ((w(obj, (-4) & j8) >>> ((int) ((j8 & 3) << 3))) & 255);
    }

    public static double u(Object obj, long j8) {
        return f11272e.d(obj, j8);
    }

    public static float v(Object obj, long j8) {
        return f11272e.e(obj, j8);
    }

    public static int w(Object obj, long j8) {
        return f11272e.f(obj, j8);
    }

    public static long x(Object obj, long j8) {
        return f11272e.g(obj, j8);
    }

    public static e y() {
        Unsafe unsafe = f11268a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC1102d.c()) {
            return new d(unsafe);
        }
        if (f11270c) {
            return new c(unsafe);
        }
        if (f11271d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object z(Object obj, long j8) {
        return f11272e.h(obj, j8);
    }
}
