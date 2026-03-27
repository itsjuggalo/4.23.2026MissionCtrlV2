package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends h0 {
    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean c(Object obj, long j4) {
        return this.f4559a.getBoolean(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final double d(Object obj, long j4) {
        return this.f4559a.getDouble(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final float e(Object obj, long j4) {
        return this.f4559a.getFloat(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void j(Object obj, long j4, boolean z6) {
        this.f4559a.putBoolean(obj, j4, z6);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void k(Object obj, long j4, byte b3) {
        this.f4559a.putByte(obj, j4, b3);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void l(Object obj, long j4, double d4) {
        this.f4559a.putDouble(obj, j4, d4);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void m(Object obj, long j4, float f6) {
        this.f4559a.putFloat(obj, j4, f6);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean q() {
        if (!super.q()) {
            return false;
        }
        try {
            Class<?> cls = this.f4559a.getClass();
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
            i0.a(th);
            return false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean r() {
        Unsafe unsafe = this.f4559a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (i0.g() != null) {
                    try {
                        Class<?> cls3 = this.f4559a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        i0.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                i0.a(th2);
            }
        }
        return false;
    }
}
