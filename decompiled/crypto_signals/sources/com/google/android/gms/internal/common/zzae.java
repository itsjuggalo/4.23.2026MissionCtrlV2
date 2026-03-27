package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.f;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class zzae extends zzaf {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzae(int i) {
    }

    public final zzae zza(Object obj) {
        int i;
        obj.getClass();
        int length = this.zza.length;
        int i6 = this.zzb;
        int i7 = i6 + 1;
        if (i7 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i7 <= length) {
            i = length;
        } else {
            i = (length >> 1) + length + 1;
            if (i < i7) {
                int iHighestOneBit = Integer.highestOneBit(i6);
                i = iHighestOneBit + iHighestOneBit;
            }
            if (i < 0) {
                i = f.API_PRIORITY_OTHER;
            }
        }
        if (i > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, i);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i8 = this.zzb;
        this.zzb = i8 + 1;
        objArr[i8] = obj;
        return this;
    }
}
