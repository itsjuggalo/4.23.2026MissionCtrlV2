package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbv {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzbu zzc;

    public final zzbv zza(Object obj, Object obj2) {
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = i10 + i10;
        if (i11 > length) {
            if (i11 > length) {
                length = length + (length >> 1) + 1;
                if (length < i11) {
                    int iHighestOneBit = Integer.highestOneBit(i11 - 1);
                    length = iHighestOneBit + iHighestOneBit;
                }
                if (length < 0) {
                    length = a.e.API_PRIORITY_OTHER;
                }
            }
            this.zza = Arrays.copyOf(objArr, length);
        }
        zzbo.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i12 = this.zzb;
        int i13 = i12 + i12;
        objArr2[i13] = obj;
        objArr2[i13 + 1] = obj2;
        this.zzb = i12 + 1;
        return this;
    }

    public final zzbw zzb() {
        zzbu zzbuVar = this.zzc;
        if (zzbuVar != null) {
            throw zzbuVar.zza();
        }
        zzcf zzcfVarZzg = zzcf.zzg(this.zzb, this.zza, this);
        zzbu zzbuVar2 = this.zzc;
        if (zzbuVar2 == null) {
            return zzcfVarZzg;
        }
        throw zzbuVar2.zza();
    }
}
