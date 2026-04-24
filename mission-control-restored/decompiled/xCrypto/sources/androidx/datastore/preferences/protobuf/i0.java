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
    public static final Unsafe f7048a = A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f7049b = AbstractC0791d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7050c = m(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7051d = m(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f7052e = y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f7053f = Q();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f7054g = P();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f7055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f7056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f7057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f7058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f7059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f7060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f7061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f7062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f7063p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f7064q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f7065r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f7066s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f7067t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f7068u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7069v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f7070w;

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
        public boolean c(Object obj, long j4) {
            return i0.f7070w ? i0.q(obj, j4) : i0.r(obj, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j4) {
            return Double.longBitsToDouble(g(obj, j4));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j4) {
            return Float.intBitsToFloat(f(obj, j4));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j4, boolean z4) {
            if (i0.f7070w) {
                i0.F(obj, j4, z4);
            } else {
                i0.G(obj, j4, z4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j4, byte b4) {
            if (i0.f7070w) {
                i0.I(obj, j4, b4);
            } else {
                i0.J(obj, j4, b4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j4, double d4) {
            o(obj, j4, Double.doubleToLongBits(d4));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j4, float f4) {
            n(obj, j4, Float.floatToIntBits(f4));
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
        public boolean c(Object obj, long j4) {
            return i0.f7070w ? i0.q(obj, j4) : i0.r(obj, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j4) {
            return Double.longBitsToDouble(g(obj, j4));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j4) {
            return Float.intBitsToFloat(f(obj, j4));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j4, boolean z4) {
            if (i0.f7070w) {
                i0.F(obj, j4, z4);
            } else {
                i0.G(obj, j4, z4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j4, byte b4) {
            if (i0.f7070w) {
                i0.I(obj, j4, b4);
            } else {
                i0.J(obj, j4, b4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j4, double d4) {
            o(obj, j4, Double.doubleToLongBits(d4));
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j4, float f4) {
            n(obj, j4, Float.floatToIntBits(f4));
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
        public boolean c(Object obj, long j4) {
            return this.f7071a.getBoolean(obj, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public double d(Object obj, long j4) {
            return this.f7071a.getDouble(obj, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public float e(Object obj, long j4) {
            return this.f7071a.getFloat(obj, j4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void j(Object obj, long j4, boolean z4) {
            this.f7071a.putBoolean(obj, j4, z4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void k(Object obj, long j4, byte b4) {
            this.f7071a.putByte(obj, j4, b4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void l(Object obj, long j4, double d4) {
            this.f7071a.putDouble(obj, j4, d4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public void m(Object obj, long j4, float f4) {
            this.f7071a.putFloat(obj, j4, f4);
        }

        @Override // androidx.datastore.preferences.protobuf.i0.e
        public boolean q() {
            if (!super.q()) {
                return false;
            }
            try {
                Class<?> cls = this.f7071a.getClass();
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
                Class<?> cls = this.f7071a.getClass();
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
        public Unsafe f7071a;

        public e(Unsafe unsafe) {
            this.f7071a = unsafe;
        }

        public final int a(Class cls) {
            return this.f7071a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f7071a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j4);

        public abstract double d(Object obj, long j4);

        public abstract float e(Object obj, long j4);

        public final int f(Object obj, long j4) {
            return this.f7071a.getInt(obj, j4);
        }

        public final long g(Object obj, long j4) {
            return this.f7071a.getLong(obj, j4);
        }

        public final Object h(Object obj, long j4) {
            return this.f7071a.getObject(obj, j4);
        }

        public final long i(Field field) {
            return this.f7071a.objectFieldOffset(field);
        }

        public abstract void j(Object obj, long j4, boolean z4);

        public abstract void k(Object obj, long j4, byte b4);

        public abstract void l(Object obj, long j4, double d4);

        public abstract void m(Object obj, long j4, float f4);

        public final void n(Object obj, long j4, int i4) {
            this.f7071a.putInt(obj, j4, i4);
        }

        public final void o(Object obj, long j4, long j5) {
            this.f7071a.putLong(obj, j4, j5);
        }

        public final void p(Object obj, long j4, Object obj2) {
            this.f7071a.putObject(obj, j4, obj2);
        }

        public boolean q() {
            Unsafe unsafe = this.f7071a;
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
            Unsafe unsafe = this.f7071a;
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
        long j4 = j(byte[].class);
        f7055h = j4;
        f7056i = j(boolean[].class);
        f7057j = k(boolean[].class);
        f7058k = j(int[].class);
        f7059l = k(int[].class);
        f7060m = j(long[].class);
        f7061n = k(long[].class);
        f7062o = j(float[].class);
        f7063p = k(float[].class);
        f7064q = j(double[].class);
        f7065r = k(double[].class);
        f7066s = j(Object[].class);
        f7067t = k(Object[].class);
        f7068u = o(l());
        f7069v = (int) (j4 & 7);
        f7070w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Unsafe A() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean B() {
        return f7054g;
    }

    public static boolean C() {
        return f7053f;
    }

    public static void D(Throwable th) {
        Logger.getLogger(i0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void E(Object obj, long j4, boolean z4) {
        f7052e.j(obj, j4, z4);
    }

    public static void F(Object obj, long j4, boolean z4) {
        I(obj, j4, z4 ? (byte) 1 : (byte) 0);
    }

    public static void G(Object obj, long j4, boolean z4) {
        J(obj, j4, z4 ? (byte) 1 : (byte) 0);
    }

    public static void H(byte[] bArr, long j4, byte b4) {
        f7052e.k(bArr, f7055h + j4, b4);
    }

    public static void I(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int iW = w(obj, j5);
        int i4 = ((~((int) j4)) & 3) << 3;
        M(obj, j5, ((255 & b4) << i4) | (iW & (~(255 << i4))));
    }

    public static void J(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        M(obj, j5, ((255 & b4) << i4) | (w(obj, j5) & (~(255 << i4))));
    }

    public static void K(Object obj, long j4, double d4) {
        f7052e.l(obj, j4, d4);
    }

    public static void L(Object obj, long j4, float f4) {
        f7052e.m(obj, j4, f4);
    }

    public static void M(Object obj, long j4, int i4) {
        f7052e.n(obj, j4, i4);
    }

    public static void N(Object obj, long j4, long j5) {
        f7052e.o(obj, j4, j5);
    }

    public static void O(Object obj, long j4, Object obj2) {
        f7052e.p(obj, j4, obj2);
    }

    public static boolean P() {
        e eVar = f7052e;
        if (eVar == null) {
            return false;
        }
        return eVar.q();
    }

    public static boolean Q() {
        e eVar = f7052e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public static Object i(Class cls) {
        try {
            return f7048a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int j(Class cls) {
        if (f7054g) {
            return f7052e.a(cls);
        }
        return -1;
    }

    public static int k(Class cls) {
        if (f7054g) {
            return f7052e.b(cls);
        }
        return -1;
    }

    public static Field l() {
        Field fieldN;
        if (AbstractC0791d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, "address");
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    public static boolean m(Class cls) {
        if (!AbstractC0791d.c()) {
            return false;
        }
        try {
            Class cls2 = f7049b;
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
        if (field == null || (eVar = f7052e) == null) {
            return -1L;
        }
        return eVar.i(field);
    }

    public static boolean p(Object obj, long j4) {
        return f7052e.c(obj, j4);
    }

    public static boolean q(Object obj, long j4) {
        return s(obj, j4) != 0;
    }

    public static boolean r(Object obj, long j4) {
        return t(obj, j4) != 0;
    }

    public static byte s(Object obj, long j4) {
        return (byte) ((w(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255);
    }

    public static byte t(Object obj, long j4) {
        return (byte) ((w(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255);
    }

    public static double u(Object obj, long j4) {
        return f7052e.d(obj, j4);
    }

    public static float v(Object obj, long j4) {
        return f7052e.e(obj, j4);
    }

    public static int w(Object obj, long j4) {
        return f7052e.f(obj, j4);
    }

    public static long x(Object obj, long j4) {
        return f7052e.g(obj, j4);
    }

    public static e y() {
        Unsafe unsafe = f7048a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC0791d.c()) {
            return new d(unsafe);
        }
        if (f7050c) {
            return new c(unsafe);
        }
        if (f7051d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object z(Object obj, long j4) {
        return f7052e.h(obj, j4);
    }
}
