package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class X extends N {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Y f15371c;

    public X(Y y7) {
        Objects.requireNonNull(y7);
        this.f15371c = y7;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        Y y7 = this.f15371c;
        A.a(i8, y7.f15377e, FirebaseAnalytics.Param.INDEX);
        int i9 = i8 + i8;
        Object obj = y7.f15376d[i9];
        Objects.requireNonNull(obj);
        Object obj2 = y7.f15376d[i9 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final boolean h() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15371c.f15377e;
    }
}
