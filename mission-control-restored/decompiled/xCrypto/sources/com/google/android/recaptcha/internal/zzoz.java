package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzoz extends zzpe {
    public zzoz() {
        super(null);
    }

    @Override // com.google.android.recaptcha.internal.zzpe
    public final void zza() {
        if (!zzj()) {
            for (int i4 = 0; i4 < zzc(); i4++) {
                ((zzms) ((zzpa) zzg(i4)).zza()).zzg();
            }
            Iterator it = zzd().iterator();
            while (it.hasNext()) {
                ((zzms) ((Map.Entry) it.next()).getKey()).zzg();
            }
        }
        super.zza();
    }
}
