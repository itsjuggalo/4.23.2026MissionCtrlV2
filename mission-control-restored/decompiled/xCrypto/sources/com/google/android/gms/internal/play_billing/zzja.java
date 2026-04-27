package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzja extends zzjf {
    public zzja() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjf
    public final void zza() {
        if (!zzj()) {
            for (int i4 = 0; i4 < zzc(); i4++) {
                Map.Entry entryZzg = zzg(i4);
                if (((zzha) ((zzjb) entryZzg).zza()).zze()) {
                    entryZzg.setValue(Collections.unmodifiableList((List) entryZzg.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzha) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
