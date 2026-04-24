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
    public static final Unsafe f7456a = A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f7457b = AbstractC0933d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7458c = m(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7459d = m(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f7460e = y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f7461f = Q();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f7462g = P();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f7463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f7464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f7465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f7466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f7467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f7468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f7469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f7470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f7471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f7472q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f7473r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f7474s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f7475t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f7476u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7477v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f7478w;

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
        public boolean c(Object obj, long j7) {
            return i0.f7478w ? i0.q(obj, j7) : i0.r(obj, j7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j7) {
            return Double.longBitsToDouble(g(obj, j7));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j7) {
            return Float.intBitsToFloat(f(obj, j7));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j7, boolean z7) {
            if (i0.f7478w) {
                i0.F(obj, j7, z7);
            } else {
                i0.G(obj, j7, z7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j7, byte b7) {
            if (i0.f7478w) {
                i0.I(obj, j7, b7);
            } else {
                i0.J(obj, j7, b7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j7, double d7) {
            o(obj, j7, Double.doubleToLongBits(d7));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j7, float f7) {
            n(obj, j7, Float.floatToIntBits(f7));
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
        public boolean c(Object obj, long j7) {
            return i0.f7478w ? i0.q(obj, j7) : i0.r(obj, j7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j7) {
            return Double.longBitsToDouble(g(obj, j7));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j7) {
            return Float.intBitsToFloat(f(obj, j7));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j7, boolean z7) {
            if (i0.f7478w) {
                i0.F(obj, j7, z7);
            } else {
                i0.G(obj, j7, z7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j7, byte b7) {
            if (i0.f7478w) {
                i0.I(obj, j7, b7);
            } else {
                i0.J(obj, j7, b7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j7, double d7) {
            o(obj, j7, Double.doubleToLongBits(d7));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j7, float f7) {
            n(obj, j7, Float.floatToIntBits(f7));
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
        public boolean c(Object obj, long j7) {
            return this.f7479a.getBoolean(obj, j7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j7) {
            return this.f7479a.getDouble(obj, j7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j7) {
            return this.f7479a.getFloat(obj, j7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j7, boolean z7) {
            this.f7479a.putBoolean(obj, j7, z7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j7, byte b7) {
            this.f7479a.putByte(obj, j7, b7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j7, double d7) {
            this.f7479a.putDouble(obj, j7, d7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j7, float f7) {
            this.f7479a.putFloat(obj, j7, f7);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean q() {
            if (!super.q()) {
                return false;
            }
            try {
                Class<?> cls = this.f7479a.getClass();
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
                Class<?> cls = this.f7479a.getClass();
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
        public Unsafe f7479a;

        public e(Unsafe unsafe) {
            this.f7479a = unsafe;
        }

        public final int a(Class cls) {
            return this.f7479a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f7479a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j7);

        public abstract double d(Object obj, long j7);

        public abstract float e(Object obj, long j7);

        public final int f(Object obj, long j7) {
            return this.f7479a.getInt(obj, j7);
        }

        public final long g(Object obj, long j7) {
            return this.f7479a.getLong(obj, j7);
        }

        public final Object h(Object obj, long j7) {
            return this.f7479a.getObject(obj, j7);
        }

        public final long i(Field field) {
            return this.f7479a.objectFieldOffset(field);
        }

        public abstract void j(Object obj, long j7, boolean z7);

        public abstract void k(Object obj, long j7, byte b7);

        public abstract void l(Object obj, long j7, double d7);

        public abstract void m(Object obj, long j7, float f7);

        public final void n(Object obj, long j7, int i7) {
            this.f7479a.putInt(obj, j7, i7);
        }

        public final void o(Object obj, long j7, long j8) {
            this.f7479a.putLong(obj, j7, j8);
        }

        public final void p(Object obj, long j7, Object obj2) {
            this.f7479a.putObject(obj, j7, obj2);
        }

        public boolean q() {
            Unsafe unsafe = this.f7479a;
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
            Unsafe unsafe = this.f7479a;
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
        long j7 = j(byte[].class);
        f7463h = j7;
        f7464i = j(boolean[].class);
        f7465j = k(boolean[].class);
        f7466k = j(int[].class);
        f7467l = k(int[].class);
        f7468m = j(long[].class);
        f7469n = k(long[].class);
        f7470o = j(float[].class);
        f7471p = k(float[].class);
        f7472q = j(double[].class);
        f7473r = k(double[].class);
        f7474s = j(Object[].class);
        f7475t = k(Object[].class);
        f7476u = o(l());
        f7477v = (int) (j7 & 7);
        f7478w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Unsafe A() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean B() {
        return f7462g;
    }

    public static boolean C() {
        return f7461f;
    }

    public static void D(Throwable th) {
        Logger.getLogger(i0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void E(Object obj, long j7, boolean z7) {
        f7460e.j(obj, j7, z7);
    }

    public static void F(Object obj, long j7, boolean z7) {
        I(obj, j7, z7 ? (byte) 1 : (byte) 0);
    }

    public static void G(Object obj, long j7, boolean z7) {
        J(obj, j7, z7 ? (byte) 1 : (byte) 0);
    }

    public static void H(byte[] bArr, long j7, byte b7) {
        f7460e.k(bArr, f7463h + j7, b7);
    }

    public static void I(Object obj, long j7, byte b7) {
        long j8 = (-4) & j7;
        int iW = w(obj, j8);
        int i7 = ((~((int) j7)) & 3) << 3;
        M(obj, j8, ((255 & b7) << i7) | (iW & (~(255 << i7))));
    }

    public static void J(Object obj, long j7, byte b7) {
        long j8 = (-4) & j7;
        int i7 = (((int) j7) & 3) << 3;
        M(obj, j8, ((255 & b7) << i7) | (w(obj, j8) & (~(255 << i7))));
    }

    public static void K(Object obj, long j7, double d7) {
        f7460e.l(obj, j7, d7);
    }

    public static void L(Object obj, long j7, float f7) {
        f7460e.m(obj, j7, f7);
    }

    public static void M(Object obj, long j7, int i7) {
        f7460e.n(obj, j7, i7);
    }

    public static void N(Object obj, long j7, long j8) {
        f7460e.o(obj, j7, j8);
    }

    public static void O(Object obj, long j7, Object obj2) {
        f7460e.p(obj, j7, obj2);
    }

    public static boolean P() {
        e eVar = f7460e;
        if (eVar == null) {
            return false;
        }
        return eVar.q();
    }

    public static boolean Q() {
        e eVar = f7460e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public static Object i(Class cls) {
        try {
            return f7456a.allocateInstance(cls);
        } catch (InstantiationException e7) {
            throw new IllegalStateException(e7);
        }
    }

    public static int j(Class cls) {
        if (f7462g) {
            return f7460e.a(cls);
        }
        return -1;
    }

    public static int k(Class cls) {
        if (f7462g) {
            return f7460e.b(cls);
        }
        return -1;
    }

    public static Field l() {
        Field fieldN;
        if (AbstractC0933d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, "address");
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    public static boolean m(Class cls) {
        if (!AbstractC0933d.c()) {
            return false;
        }
        try {
            Class cls2 = f7457b;
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
        if (field == null || (eVar = f7460e) == null) {
            return -1L;
        }
        return eVar.i(field);
    }

    public static boolean p(Object obj, long j7) {
        return f7460e.c(obj, j7);
    }

    public static boolean q(Object obj, long j7) {
        return s(obj, j7) != 0;
    }

    public static boolean r(Object obj, long j7) {
        return t(obj, j7) != 0;
    }

    public static byte s(Object obj, long j7) {
        return (byte) ((w(obj, (-4) & j7) >>> ((int) (((~j7) & 3) << 3))) & 255);
    }

    public static byte t(Object obj, long j7) {
        return (byte) ((w(obj, (-4) & j7) >>> ((int) ((j7 & 3) << 3))) & 255);
    }

    public static double u(Object obj, long j7) {
        return f7460e.d(obj, j7);
    }

    public static float v(Object obj, long j7) {
        return f7460e.e(obj, j7);
    }

    public static int w(Object obj, long j7) {
        return f7460e.f(obj, j7);
    }

    public static long x(Object obj, long j7) {
        return f7460e.g(obj, j7);
    }

    public static e y() {
        Unsafe unsafe = f7456a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC0933d.c()) {
            return new d(unsafe);
        }
        if (f7458c) {
            return new c(unsafe);
        }
        if (f7459d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object z(Object obj, long j7) {
        return f7460e.h(obj, j7);
    }
}
