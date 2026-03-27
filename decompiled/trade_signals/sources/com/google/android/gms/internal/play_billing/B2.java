package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class B2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f15088a;

    public B2(Unsafe unsafe) {
        this.f15088a = unsafe;
    }

    public abstract double a(Object obj, long j8);

    public abstract float b(Object obj, long j8);

    public abstract void c(Object obj, long j8, boolean z7);

    public abstract void d(Object obj, long j8, byte b8);

    public abstract void e(Object obj, long j8, double d8);

    public abstract void f(Object obj, long j8, float f8);

    public abstract boolean g(Object obj, long j8);
}
