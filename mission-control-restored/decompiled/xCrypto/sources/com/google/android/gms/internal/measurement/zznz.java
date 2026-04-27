package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zznz extends zzod {
    public zznz() {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzod
    public final void zza() {
        if (!zzb()) {
            for (int i4 = 0; i4 < zzc(); i4++) {
                Map.Entry entryZzd = zzd(i4);
                if (((zzlu) ((zzoa) entryZzd).zza()).zzd()) {
                    entryZzd.setValue(Collections.unmodifiableList((List) entryZzd.getValue()));
                }
            }
            for (Map.Entry entry : zze()) {
                if (((zzlu) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
