package com.google.android.gms.internal.p000authapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zbbj extends zbbi {
    static final zbbi zba = new zbbj(new Object[0], 0);
    final transient Object[] zbb;
    private final transient int zbc;

    public zbbj(Object[] objArr, int i10) {
        this.zbb = objArr;
        this.zbc = i10;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zbbc.zba(i10, this.zbc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zbb[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final Object[] zbb() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final int zbd() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final boolean zbf() {
        return false;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbi, com.google.android.gms.internal.p000authapi.zbbf
    public final int zbg(Object[] objArr, int i10) {
        Object[] objArr2 = this.zbb;
        int i11 = this.zbc;
        System.arraycopy(objArr2, 0, objArr, 0, i11);
        return i11;
    }
}
