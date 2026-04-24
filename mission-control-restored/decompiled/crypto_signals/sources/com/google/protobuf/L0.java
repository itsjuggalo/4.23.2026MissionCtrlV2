package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class L0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f5650a;

    public L0(Unsafe unsafe) {
        this.f5650a = unsafe;
    }

    public final int a(Class cls) {
        return this.f5650a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f5650a.arrayIndexScale(cls);
    }

    public abstract void c(long j4, byte[] bArr, long j6, long j7);

    public abstract boolean d(Object obj, long j4);

    public abstract byte e(long j4);

    public abstract byte f(Object obj, long j4);

    public abstract double g(Object obj, long j4);

    public abstract float h(Object obj, long j4);

    public final int i(Object obj, long j4) {
        return this.f5650a.getInt(obj, j4);
    }

    public final long j(Object obj, long j4) {
        return this.f5650a.getLong(obj, j4);
    }

    public final Object k(Object obj, long j4) {
        return this.f5650a.getObject(obj, j4);
    }

    public final long l(Field field) {
        return this.f5650a.objectFieldOffset(field);
    }

    public abstract void m(Object obj, long j4, boolean z6);

    public abstract void n(Object obj, long j4, byte b3);

    public abstract void o(Object obj, long j4, double d4);

    public abstract void p(Object obj, long j4, float f6);

    public final void q(Object obj, long j4, int i) {
        this.f5650a.putInt(obj, j4, i);
    }

    public final void r(Object obj, long j4, long j6) {
        this.f5650a.putLong(obj, j4, j6);
    }

    public final void s(Object obj, long j4, Object obj2) {
        this.f5650a.putObject(obj, j4, obj2);
    }

    public boolean t() {
        Unsafe unsafe = this.f5650a;
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
            M0.a(th);
            return false;
        }
    }

    public abstract boolean u();
}
