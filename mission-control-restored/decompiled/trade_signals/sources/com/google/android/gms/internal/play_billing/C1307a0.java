package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1307a0 extends N {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f15391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f15392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient int f15393e;

    public C1307a0(Object[] objArr, int i8, int i9) {
        this.f15391c = objArr;
        this.f15392d = i8;
        this.f15393e = i9;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        A.a(i8, this.f15393e, FirebaseAnalytics.Param.INDEX);
        Object obj = this.f15391c[i8 + i8 + this.f15392d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final boolean h() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15393e;
    }
}
