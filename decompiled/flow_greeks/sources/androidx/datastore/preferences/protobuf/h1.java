package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f1728a = A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f1729b = androidx.datastore.preferences.protobuf.d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f1730c = m(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f1731d = m(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f1732e = y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f1733f = Q();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f1734g = P();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f1735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f1736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f1737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f1738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f1739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f1740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f1741n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f1742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f1743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f1744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f1745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f1746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f1747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f1748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f1749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f1750w;

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

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean c(Object obj, long j10) {
            return h1.f1750w ? h1.q(obj, j10) : h1.r(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public double d(Object obj, long j10) {
            return Double.longBitsToDouble(g(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public float e(Object obj, long j10) {
            return Float.intBitsToFloat(f(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void j(Object obj, long j10, boolean z10) {
            if (h1.f1750w) {
                h1.F(obj, j10, z10);
            } else {
                h1.G(obj, j10, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void k(Object obj, long j10, byte b10) {
            if (h1.f1750w) {
                h1.I(obj, j10, b10);
            } else {
                h1.J(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void l(Object obj, long j10, double d10) {
            o(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void m(Object obj, long j10, float f10) {
            n(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean r() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean c(Object obj, long j10) {
            return h1.f1750w ? h1.q(obj, j10) : h1.r(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public double d(Object obj, long j10) {
            return Double.longBitsToDouble(g(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public float e(Object obj, long j10) {
            return Float.intBitsToFloat(f(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void j(Object obj, long j10, boolean z10) {
            if (h1.f1750w) {
                h1.F(obj, j10, z10);
            } else {
                h1.G(obj, j10, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void k(Object obj, long j10, byte b10) {
            if (h1.f1750w) {
                h1.I(obj, j10, b10);
            } else {
                h1.J(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void l(Object obj, long j10, double d10) {
            o(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void m(Object obj, long j10, float f10) {
            n(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean r() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean c(Object obj, long j10) {
            return this.f1751a.getBoolean(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public double d(Object obj, long j10) {
            return this.f1751a.getDouble(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public float e(Object obj, long j10) {
            return this.f1751a.getFloat(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void j(Object obj, long j10, boolean z10) {
            this.f1751a.putBoolean(obj, j10, z10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void k(Object obj, long j10, byte b10) {
            this.f1751a.putByte(obj, j10, b10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void l(Object obj, long j10, double d10) {
            this.f1751a.putDouble(obj, j10, d10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void m(Object obj, long j10, float f10) {
            this.f1751a.putFloat(obj, j10, f10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean q() {
            if (!super.q()) {
                return false;
            }
            try {
                Class<?> cls = this.f1751a.getClass();
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
                h1.D(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.f1751a.getClass();
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
                h1.D(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f1751a;

        public e(Unsafe unsafe) {
            this.f1751a = unsafe;
        }

        public final int a(Class cls) {
            return this.f1751a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f1751a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j10);

        public abstract double d(Object obj, long j10);

        public abstract float e(Object obj, long j10);

        public final int f(Object obj, long j10) {
            return this.f1751a.getInt(obj, j10);
        }

        public final long g(Object obj, long j10) {
            return this.f1751a.getLong(obj, j10);
        }

        public final Object h(Object obj, long j10) {
            return this.f1751a.getObject(obj, j10);
        }

        public final long i(Field field) {
            return this.f1751a.objectFieldOffset(field);
        }

        public abstract void j(Object obj, long j10, boolean z10);

        public abstract void k(Object obj, long j10, byte b10);

        public abstract void l(Object obj, long j10, double d10);

        public abstract void m(Object obj, long j10, float f10);

        public final void n(Object obj, long j10, int i10) {
            this.f1751a.putInt(obj, j10, i10);
        }

        public final void o(Object obj, long j10, long j11) {
            this.f1751a.putLong(obj, j10, j11);
        }

        public final void p(Object obj, long j10, Object obj2) {
            this.f1751a.putObject(obj, j10, obj2);
        }

        public boolean q() {
            Unsafe unsafe = this.f1751a;
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
                h1.D(th);
                return false;
            }
        }

        public boolean r() {
            Unsafe unsafe = this.f1751a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return h1.l() != null;
            } catch (Throwable th) {
                h1.D(th);
                return false;
            }
        }
    }

    static {
        long j10 = j(byte[].class);
        f1735h = j10;
        f1736i = j(boolean[].class);
        f1737j = k(boolean[].class);
        f1738k = j(int[].class);
        f1739l = k(int[].class);
        f1740m = j(long[].class);
        f1741n = k(long[].class);
        f1742o = j(float[].class);
        f1743p = k(float[].class);
        f1744q = j(double[].class);
        f1745r = k(double[].class);
        f1746s = j(Object[].class);
        f1747t = k(Object[].class);
        f1748u = o(l());
        f1749v = (int) (j10 & 7);
        f1750w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Unsafe A() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean B() {
        return f1734g;
    }

    public static boolean C() {
        return f1733f;
    }

    public static void D(Throwable th) {
        Logger.getLogger(h1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void E(Object obj, long j10, boolean z10) {
        f1732e.j(obj, j10, z10);
    }

    public static void F(Object obj, long j10, boolean z10) {
        I(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void G(Object obj, long j10, boolean z10) {
        J(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void H(byte[] bArr, long j10, byte b10) {
        f1732e.k(bArr, f1735h + j10, b10);
    }

    public static void I(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iW = w(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (iW & (~(255 << i10))));
    }

    public static void J(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (w(obj, j11) & (~(255 << i10))));
    }

    public static void K(Object obj, long j10, double d10) {
        f1732e.l(obj, j10, d10);
    }

    public static void L(Object obj, long j10, float f10) {
        f1732e.m(obj, j10, f10);
    }

    public static void M(Object obj, long j10, int i10) {
        f1732e.n(obj, j10, i10);
    }

    public static void N(Object obj, long j10, long j11) {
        f1732e.o(obj, j10, j11);
    }

    public static void O(Object obj, long j10, Object obj2) {
        f1732e.p(obj, j10, obj2);
    }

    public static boolean P() {
        e eVar = f1732e;
        if (eVar == null) {
            return false;
        }
        return eVar.q();
    }

    public static boolean Q() {
        e eVar = f1732e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public static Object i(Class cls) {
        try {
            return f1728a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int j(Class cls) {
        if (f1734g) {
            return f1732e.a(cls);
        }
        return -1;
    }

    public static int k(Class cls) {
        if (f1734g) {
            return f1732e.b(cls);
        }
        return -1;
    }

    public static Field l() {
        Field fieldN;
        if (androidx.datastore.preferences.protobuf.d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, "address");
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    public static boolean m(Class cls) {
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return false;
        }
        try {
            Class cls2 = f1729b;
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
        if (field == null || (eVar = f1732e) == null) {
            return -1L;
        }
        return eVar.i(field);
    }

    public static boolean p(Object obj, long j10) {
        return f1732e.c(obj, j10);
    }

    public static boolean q(Object obj, long j10) {
        return s(obj, j10) != 0;
    }

    public static boolean r(Object obj, long j10) {
        return t(obj, j10) != 0;
    }

    public static byte s(Object obj, long j10) {
        return (byte) ((w(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255);
    }

    public static byte t(Object obj, long j10) {
        return (byte) ((w(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255);
    }

    public static double u(Object obj, long j10) {
        return f1732e.d(obj, j10);
    }

    public static float v(Object obj, long j10) {
        return f1732e.e(obj, j10);
    }

    public static int w(Object obj, long j10) {
        return f1732e.f(obj, j10);
    }

    public static long x(Object obj, long j10) {
        return f1732e.g(obj, j10);
    }

    public static e y() {
        Unsafe unsafe = f1728a;
        if (unsafe == null) {
            return null;
        }
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (f1730c) {
            return new c(unsafe);
        }
        if (f1731d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object z(Object obj, long j10) {
        return f1732e.h(obj, j10);
    }
}
