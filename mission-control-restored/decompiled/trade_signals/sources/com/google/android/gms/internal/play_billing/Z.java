package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends S {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Q f15386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient N f15387d;

    public Z(Q q8, N n8) {
        this.f15386c = q8;
        this.f15387d = n8;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final int a(Object[] objArr, int i8) {
        return this.f15387d.a(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.K, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f15386c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.S, com.google.android.gms.internal.play_billing.K
    public final N f() {
        return this.f15387d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f15387d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f15386c.size();
    }
}
