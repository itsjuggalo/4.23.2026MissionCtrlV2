package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class W extends N {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final N f15368e = new W(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f15369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f15370d;

    public W(Object[] objArr, int i8) {
        this.f15369c = objArr;
        this.f15370d = i8;
    }

    @Override // com.google.android.gms.internal.play_billing.N, com.google.android.gms.internal.play_billing.K
    public final int a(Object[] objArr, int i8) {
        Object[] objArr2 = this.f15369c;
        int i9 = this.f15370d;
        System.arraycopy(objArr2, 0, objArr, 0, i9);
        return i9;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final int d() {
        return this.f15370d;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final int e() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        A.a(i8, this.f15370d, FirebaseAnalytics.Param.INDEX);
        Object obj = this.f15369c[i8];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final boolean h() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final Object[] n() {
        return this.f15369c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15370d;
    }
}
