package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class A2 extends B2 {
    public A2(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final double a(Object obj, long j8) {
        return Double.longBitsToDouble(this.f15088a.getLong(obj, j8));
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final float b(Object obj, long j8) {
        return Float.intBitsToFloat(this.f15088a.getInt(obj, j8));
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final void c(Object obj, long j8, boolean z7) {
        if (C2.f15101h) {
            C2.d(obj, j8, z7 ? (byte) 1 : (byte) 0);
        } else {
            C2.e(obj, j8, z7 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final void d(Object obj, long j8, byte b8) {
        if (C2.f15101h) {
            C2.d(obj, j8, b8);
        } else {
            C2.e(obj, j8, b8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final void e(Object obj, long j8, double d8) {
        this.f15088a.putLong(obj, j8, Double.doubleToLongBits(d8));
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final void f(Object obj, long j8, float f8) {
        this.f15088a.putInt(obj, j8, Float.floatToIntBits(f8));
    }

    @Override // com.google.android.gms.internal.play_billing.B2
    public final boolean g(Object obj, long j8) {
        return C2.f15101h ? C2.y(obj, j8) : C2.z(obj, j8);
    }
}
