package com.google.android.gms.common.api.internal;

import u1.C1202d;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0419w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1202d[] f5169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5171c;

    public AbstractC0419w(C1202d[] c1202dArr, boolean z6, int i) {
        this.f5169a = c1202dArr;
        boolean z7 = false;
        if (c1202dArr != null && z6) {
            z7 = true;
        }
        this.f5170b = z7;
        this.f5171c = i;
    }

    public static P3.v a() {
        P3.v vVar = new P3.v();
        vVar.f2603a = true;
        vVar.f2604b = 0;
        return vVar;
    }
}
