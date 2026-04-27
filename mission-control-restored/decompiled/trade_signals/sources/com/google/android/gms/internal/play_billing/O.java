package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f15193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f15195c;

    public O(Object obj, Object obj2, Object obj3) {
        this.f15193a = obj;
        this.f15194b = obj2;
        this.f15195c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f15195c;
        Object obj2 = this.f15194b;
        Object obj3 = this.f15193a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + com.amazon.a.a.o.b.f.f14101b + String.valueOf(obj2) + " and " + String.valueOf(obj3) + com.amazon.a.a.o.b.f.f14101b + String.valueOf(obj));
    }
}
