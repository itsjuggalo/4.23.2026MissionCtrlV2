package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1424y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f15540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15541b;

    public C1424y1(Object obj, int i8) {
        this.f15540a = obj;
        this.f15541b = i8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1424y1)) {
            return false;
        }
        C1424y1 c1424y1 = (C1424y1) obj;
        return this.f15540a == c1424y1.f15540a && this.f15541b == c1424y1.f15541b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f15540a) * 65535) + this.f15541b;
    }
}
