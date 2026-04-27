package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public class zzah<E> extends zzak<E> {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzah(int i4) {
        zzag.zza(4, "initialCapacity");
        this.zza = new Object[4];
        this.zzb = 0;
    }

    public zzah<E> zza(E e4) {
        zzw.zza(e4);
        Object[] objArr = this.zza;
        int iZza = zzak.zza(objArr.length, this.zzb + 1);
        if (iZza > objArr.length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZza);
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i4 = this.zzb;
        this.zzb = i4 + 1;
        objArr2[i4] = e4;
        return this;
    }
}
