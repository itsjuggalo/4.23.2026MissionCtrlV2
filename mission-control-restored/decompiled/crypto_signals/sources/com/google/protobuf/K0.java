package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class K0 extends L0 {
    @Override // com.google.protobuf.L0
    public final void c(long j4, byte[] bArr, long j6, long j7) {
        this.f5650a.copyMemory((Object) null, j4, bArr, M0.f5658f + j6, j7);
    }

    @Override // com.google.protobuf.L0
    public final boolean d(Object obj, long j4) {
        return this.f5650a.getBoolean(obj, j4);
    }

    @Override // com.google.protobuf.L0
    public final byte e(long j4) {
        return this.f5650a.getByte(j4);
    }

    @Override // com.google.protobuf.L0
    public final byte f(Object obj, long j4) {
        return this.f5650a.getByte(obj, j4);
    }

    @Override // com.google.protobuf.L0
    public final double g(Object obj, long j4) {
        return this.f5650a.getDouble(obj, j4);
    }

    @Override // com.google.protobuf.L0
    public final float h(Object obj, long j4) {
        return this.f5650a.getFloat(obj, j4);
    }

    @Override // com.google.protobuf.L0
    public final void m(Object obj, long j4, boolean z6) {
        this.f5650a.putBoolean(obj, j4, z6);
    }

    @Override // com.google.protobuf.L0
    public final void n(Object obj, long j4, byte b3) {
        this.f5650a.putByte(obj, j4, b3);
    }

    @Override // com.google.protobuf.L0
    public final void o(Object obj, long j4, double d4) {
        this.f5650a.putDouble(obj, j4, d4);
    }

    @Override // com.google.protobuf.L0
    public final void p(Object obj, long j4, float f6) {
        this.f5650a.putFloat(obj, j4, f6);
    }

    @Override // com.google.protobuf.L0
    public final boolean t() {
        if (!super.t()) {
            return false;
        }
        try {
            Class<?> cls = this.f5650a.getClass();
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
            M0.a(th);
            return false;
        }
    }

    @Override // com.google.protobuf.L0
    public final boolean u() {
        Unsafe unsafe = this.f5650a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (M0.e() != null) {
                    try {
                        Class<?> cls3 = this.f5650a.getClass();
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
                        M0.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                M0.a(th2);
            }
        }
        return false;
    }
}
