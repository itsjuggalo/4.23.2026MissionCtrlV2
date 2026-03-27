package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class zzch extends zzci {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzch(int i7) {
        zzbw.zza(i7, "initialCapacity");
        this.zza = new Object[i7];
        this.zzb = 0;
    }

    private final void zzd(int i7) {
        int length = this.zza.length;
        int iZzc = zzci.zzc(length, this.zzb + i7);
        if (iZzc > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZzc);
            this.zzc = false;
        }
    }

    public final zzch zza(Object obj) {
        obj.getClass();
        zzd(1);
        Object[] objArr = this.zza;
        int i7 = this.zzb;
        this.zzb = i7 + 1;
        objArr[i7] = obj;
        return this;
    }

    public final void zzb(Object[] objArr, int i7) {
        zzdd.zzb(objArr, i7);
        zzd(i7);
        System.arraycopy(objArr, 0, this.zza, this.zzb, i7);
        this.zzb += i7;
    }
}
