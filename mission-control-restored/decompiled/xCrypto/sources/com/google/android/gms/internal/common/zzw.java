package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzw extends zzz {
    final /* synthetic */ zzr zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzw(zzx zzxVar, zzaa zzaaVar, CharSequence charSequence, zzr zzrVar) {
        super(zzaaVar, charSequence);
        this.zza = zzrVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final int zzc(int i4) {
        return i4 + 1;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final int zzd(int i4) {
        CharSequence charSequence = ((zzz) this).zzb;
        int length = charSequence.length();
        zzv.zzb(i4, length, FirebaseAnalytics.Param.INDEX);
        while (i4 < length) {
            if (this.zza.zza(charSequence.charAt(i4))) {
                return i4;
            }
            i4++;
        }
        return -1;
    }
}
