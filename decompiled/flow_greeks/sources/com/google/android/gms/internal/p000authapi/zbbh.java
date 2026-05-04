package com.google.android.gms.internal.p000authapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zbbh extends zbbi {
    final transient int zba;
    final transient int zbb;
    final /* synthetic */ zbbi zbc;

    public zbbh(zbbi zbbiVar, int i10, int i11) {
        Objects.requireNonNull(zbbiVar);
        this.zbc = zbbiVar;
        this.zba = i10;
        this.zbb = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zbbc.zba(i10, this.zbb, FirebaseAnalytics.Param.INDEX);
        return this.zbc.get(i10 + this.zba);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbi, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final Object[] zbb() {
        return this.zbc.zbb();
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final int zbc() {
        return this.zbc.zbc() + this.zba;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final int zbd() {
        return this.zbc.zbc() + this.zba + this.zbb;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    public final boolean zbf() {
        return true;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbi
    /* JADX INFO: renamed from: zbh */
    public final zbbi subList(int i10, int i11) {
        zbbc.zbc(i10, i11, this.zbb);
        int i12 = this.zba;
        return this.zbc.subList(i10 + i12, i11 + i12);
    }
}
