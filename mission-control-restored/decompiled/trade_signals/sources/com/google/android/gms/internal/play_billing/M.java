package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class M extends N {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f15180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f15181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ N f15182e;

    public M(N n8, int i8, int i9) {
        Objects.requireNonNull(n8);
        this.f15182e = n8;
        this.f15180c = i8;
        this.f15181d = i9;
    }

    @Override // com.google.android.gms.internal.play_billing.N
    /* JADX INFO: renamed from: C */
    public final N subList(int i8, int i9) {
        A.d(i8, i9, this.f15181d);
        int i10 = this.f15180c;
        return this.f15182e.subList(i8 + i10, i9 + i10);
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final int d() {
        return this.f15182e.e() + this.f15180c + this.f15181d;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final int e() {
        return this.f15182e.e() + this.f15180c;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        A.a(i8, this.f15181d, FirebaseAnalytics.Param.INDEX);
        return this.f15182e.get(i8 + this.f15180c);
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final boolean h() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final Object[] n() {
        return this.f15182e.n();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15181d;
    }

    @Override // com.google.android.gms.internal.play_billing.N, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i8, int i9) {
        return subList(i8, i9);
    }
}
