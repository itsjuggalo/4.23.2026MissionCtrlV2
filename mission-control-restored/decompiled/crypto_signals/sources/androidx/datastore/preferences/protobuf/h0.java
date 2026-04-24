package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f4559a;

    public h0(Unsafe unsafe) {
        this.f4559a = unsafe;
    }

    public final int a(Class cls) {
        return this.f4559a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f4559a.arrayIndexScale(cls);
    }

    public abstract boolean c(Object obj, long j4);

    public abstract double d(Object obj, long j4);

    public abstract float e(Object obj, long j4);

    public final int f(Object obj, long j4) {
        return this.f4559a.getInt(obj, j4);
    }

    public final long g(Object obj, long j4) {
        return this.f4559a.getLong(obj, j4);
    }

    public final Object h(Object obj, long j4) {
        return this.f4559a.getObject(obj, j4);
    }

    public final long i(Field field) {
        return this.f4559a.objectFieldOffset(field);
    }

    public abstract void j(Object obj, long j4, boolean z6);

    public abstract void k(Object obj, long j4, byte b3);

    public abstract void l(Object obj, long j4, double d4);

    public abstract void m(Object obj, long j4, float f6);

    public final void n(Object obj, long j4, int i) {
        this.f4559a.putInt(obj, j4, i);
    }

    public final void o(Object obj, long j4, long j6) {
        this.f4559a.putLong(obj, j4, j6);
    }

    public final void p(Object obj, long j4, Object obj2) {
        this.f4559a.putObject(obj, j4, obj2);
    }

    public boolean q() {
        Unsafe unsafe = this.f4559a;
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
            i0.a(th);
            return false;
        }
    }

    public abstract boolean r();
}
