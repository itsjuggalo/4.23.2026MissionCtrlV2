package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class C2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f15094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f15095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f15096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final B2 f15097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f15098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f15099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f15100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f15101h;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C2.<clinit>():void");
    }

    public static boolean A(Class cls) {
        int i8 = AbstractC1318c1.f15401a;
        try {
            Class cls2 = f15095b;
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

    public static boolean B(Object obj, long j8) {
        return f15097d.g(obj, j8);
    }

    public static boolean C() {
        return f15099f;
    }

    public static boolean D() {
        return f15098e;
    }

    public static int E(Class cls) {
        if (f15099f) {
            return f15097d.f15088a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int a(Class cls) {
        if (f15099f) {
            return f15097d.f15088a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field b() {
        int i8 = AbstractC1318c1.f15401a;
        Field fieldC = c(Buffer.class, "effectiveDirectAddress");
        if (fieldC != null) {
            return fieldC;
        }
        Field fieldC2 = c(Buffer.class, "address");
        if (fieldC2 == null || fieldC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldC2;
    }

    public static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(Object obj, long j8, byte b8) {
        Unsafe unsafe = f15097d.f15088a;
        long j9 = (-4) & j8;
        int i8 = unsafe.getInt(obj, j9);
        int i9 = ((~((int) j8)) & 3) << 3;
        unsafe.putInt(obj, j9, ((255 & b8) << i9) | (i8 & (~(255 << i9))));
    }

    public static void e(Object obj, long j8, byte b8) {
        Unsafe unsafe = f15097d.f15088a;
        long j9 = (-4) & j8;
        int i8 = (((int) j8) & 3) << 3;
        unsafe.putInt(obj, j9, ((255 & b8) << i8) | (unsafe.getInt(obj, j9) & (~(255 << i8))));
    }

    public static double f(Object obj, long j8) {
        return f15097d.a(obj, j8);
    }

    public static float g(Object obj, long j8) {
        return f15097d.b(obj, j8);
    }

    public static int h(Object obj, long j8) {
        return f15097d.f15088a.getInt(obj, j8);
    }

    public static long i(Object obj, long j8) {
        return f15097d.f15088a.getLong(obj, j8);
    }

    public static Object j(Class cls) {
        try {
            return f15094a.allocateInstance(cls);
        } catch (InstantiationException e8) {
            throw new IllegalStateException(e8);
        }
    }

    public static Object k(Object obj, long j8) {
        return f15097d.f15088a.getObject(obj, j8);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C1425y2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void m(Throwable th) {
        Logger.getLogger(C2.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void r(Object obj, long j8, boolean z7) {
        f15097d.c(obj, j8, z7);
    }

    public static void s(byte[] bArr, long j8, byte b8) {
        f15097d.d(bArr, f15100g + j8, b8);
    }

    public static void t(Object obj, long j8, double d8) {
        f15097d.e(obj, j8, d8);
    }

    public static void u(Object obj, long j8, float f8) {
        f15097d.f(obj, j8, f8);
    }

    public static void v(Object obj, long j8, int i8) {
        f15097d.f15088a.putInt(obj, j8, i8);
    }

    public static void w(Object obj, long j8, long j9) {
        f15097d.f15088a.putLong(obj, j8, j9);
    }

    public static void x(Object obj, long j8, Object obj2) {
        f15097d.f15088a.putObject(obj, j8, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj, long j8) {
        return ((byte) ((f15097d.f15088a.getInt(obj, (-4) & j8) >>> ((int) (((~j8) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj, long j8) {
        return ((byte) ((f15097d.f15088a.getInt(obj, (-4) & j8) >>> ((int) ((j8 & 3) << 3))) & 255)) != 0;
    }
}
