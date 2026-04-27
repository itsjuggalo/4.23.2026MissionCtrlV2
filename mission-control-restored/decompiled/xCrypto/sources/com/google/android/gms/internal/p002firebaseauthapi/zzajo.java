package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzajo extends zzajq {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzajp zzc;

    public zzajo(zzajp zzajpVar) {
        this.zzc = zzajpVar;
        this.zzb = zzajpVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final byte zza() {
        int i4 = this.zza;
        if (i4 >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i4 + 1;
        return this.zzc.zzb(i4);
    }
}
