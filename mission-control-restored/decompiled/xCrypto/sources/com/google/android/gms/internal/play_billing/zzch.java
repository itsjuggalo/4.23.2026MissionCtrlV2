package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class zzch extends zzci {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzch(int i4) {
        zzbw.zza(i4, "initialCapacity");
        this.zza = new Object[i4];
        this.zzb = 0;
    }

    private final void zzd(int i4) {
        int length = this.zza.length;
        int iZzc = zzci.zzc(length, this.zzb + i4);
        if (iZzc > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZzc);
            this.zzc = false;
        }
    }

    public final zzch zza(Object obj) {
        obj.getClass();
        zzd(1);
        Object[] objArr = this.zza;
        int i4 = this.zzb;
        this.zzb = i4 + 1;
        objArr[i4] = obj;
        return this;
    }

    public final void zzb(Object[] objArr, int i4) {
        zzdd.zzb(objArr, i4);
        zzd(i4);
        System.arraycopy(objArr, 0, this.zza, this.zzb, i4);
        this.zzb += i4;
    }
}
