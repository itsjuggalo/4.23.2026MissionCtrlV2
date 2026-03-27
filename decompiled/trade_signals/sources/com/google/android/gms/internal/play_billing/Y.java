package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Y extends S {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Q f15375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f15376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient int f15377e;

    public Y(Q q8, Object[] objArr, int i8, int i9) {
        this.f15375c = q8;
        this.f15376d = objArr;
        this.f15377e = i9;
    }

    @Override // com.google.android.gms.internal.play_billing.S
    public final N C() {
        return new X(this);
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final int a(Object[] objArr, int i8) {
        return f().a(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.K, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f15375c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f15377e;
    }
}
